package com.demo.async.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.demo.async.controller.feign.ApiOneFeign;
import com.demo.common.pojo.domain.TAddress;
import com.demo.common.pojo.domain.TUser;
import com.demo.common.pojo.dto.AsyncOneDto;
import com.demo.common.pojo.vo.R;
import com.demo.common.service.TAddressService;
import io.seata.core.context.RootContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author csh
 * @Description: TODO
 * @Date 2023-1-30 10:09
 */
@Slf4j
@Api(value = "测试接口1", tags = "测试接口1")
@RequestMapping("/aysncOne")
@RestController
public class AsyncOneController {

    @Autowired
    private TAddressService addressService;

    @Autowired
    private ApiOneFeign apiOneFeign;

    @PostMapping("/method1")
    @ApiOperation(value = "method1")
    public R method1(AsyncOneDto asyncOneDto) throws InterruptedException {
//        Thread.sleep(10000);
        log.info(asyncOneDto.toString());
        return R.ok();
    }

    @PostMapping("/method7")
    @ApiOperation(value = "method7")
    public R method7(@RequestBody TAddress tAddress)  {
        log.info("seata XID为："+RootContext.getXID());
        addressService.save(tAddress);
        apiOneFeign.method9(TUser.builder().id(1).name(UUID.randomUUID().toString()).build());
        return R.ok();
    }


}
