package com.demo.api.controller;

import cn.hutool.http.HttpRequest;
import com.demo.api.feign.AsyncOneFeign;
import com.demo.common.pojo.domain.TUser;
import com.demo.common.pojo.dto.AsyncOneDto;
import com.demo.common.pojo.dto.UserDto;
import com.demo.common.pojo.vo.R;
import com.demo.common.service.TUserService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransactionContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


/**
 * @Author csh
 * @Description: TODO
 * @Date 2023-1-30 10:09
 */
@Slf4j
@Api(value = "测试接口1", tags = "测试接口1")
@RequestMapping("/apiOne")
@RestController
public class ApiOneController {
    @Autowired
    private AsyncOneFeign asyncOneFeign;
//

    @Autowired
    private TUserService userService;

    @Autowired
    private RedissonClient redissonClient;


    public static final String ACCOUNT_SID = "AC3e0ea1b2f5967f2685e6442f99798166";
    public static final String AUTH_TOKEN = "9be83983a07a07033a873eb789c1e440";


    @PostMapping("/method1")
    @ApiOperation(value = "method1")
    public R method1() {
        return asyncOneFeign.method1(AsyncOneDto.builder().field1("1").field2("2").field3("3").build());
    }

    @PostMapping("/method2")
    @ApiOperation(value = "method2")
    public R method2() {
        String result = HttpRequest.post("https://api.releans.com/v2/message")
                .header("Authorization", "Bearer Your_API_Key")
                .contentType("text/plain")
                .body("sender=SenderName&mobile=+14155550101&content=Hello")
                .execute().body();
        return R.ok(result);
    }

    @PostMapping("/method3")
    @ApiOperation(value = "method3")
    public R method3() throws InterruptedException {
//        Thread.sleep(10000);
        log.info("=================");
        return R.ok();
    }


    @PostMapping("/method4")
    @ApiOperation(value = "method4")
    public R method4(String mobile) throws InterruptedException {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Verification verification = Verification.creator(
                "VA8238bb5b5431ab857975f6e17c01aec1",
                mobile,
                "sms")
                .create();

        System.out.println(verification.toString());
        return R.ok();
    }

    @PostMapping("/method5")
    @ApiOperation(value = "method5")
    public R method5(String mobile, String code) throws InterruptedException {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        VerificationCheck verificationCheck = VerificationCheck.creator(
                "VA8238bb5b5431ab857975f6e17c01aec1")
                .setTo(mobile)
                .setCode(code)
                .create();

        System.out.println(verificationCheck.toString());
        return R.ok();
    }

    @PostMapping("/method6")
    @ApiOperation(value = "method6")
    public R method6(String mobile) throws InterruptedException {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(mobile),
                "MGfb89c259ecb8db4e037b8aec30363840",
                "【Uniigym】 Your verification code is：3333. Uniigym Test MSG")
                .create();
        System.out.println(message.toString());
        return R.ok();
    }

    @PostMapping("/method7")
    @ApiOperation(value = "method7")
    @GlobalTransactional(rollbackFor = Exception.class)
    public R method7(@RequestBody UserDto user) throws InterruptedException, TransactionException {
        R r = null;
        RSemaphore semaphore = redissonClient.getSemaphore("xinhaoliang");
        try {
            // 商品可以秒杀的数量作为信号量
            boolean acquire = semaphore.tryAcquire(1);
            if (acquire) {
                userService.save(user.getUser());
                r = asyncOneFeign.method7(user.getAddress());

            } else {
              r =R.error("秒杀失败");
            }
        } finally {
            semaphore.release();
        }
        return r;
    }

    @PostMapping("/method8")
    @ApiOperation(value = "method8")
    public R method8(@RequestBody UserDto user) {
        // 使用库存作为分布式信号量
        RSemaphore semaphore = redissonClient.getSemaphore("xinhaoliang");
        // 商品可以秒杀的数量作为信号量
        semaphore.trySetPermits(2);
        return R.ok();
    }


    @PostMapping("/method9")
    @ApiOperation(value = "method9")
    @GlobalTransactional(rollbackFor = Exception.class)
    public R method9(@RequestBody TUser user) {
        userService.save(user);
        return R.ok();
    }


}
