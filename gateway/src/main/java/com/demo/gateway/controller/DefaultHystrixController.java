package com.demo.gateway.controller;

import com.demo.common.pojo.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author csh
 * @Description: TODO
 * @Date 2023-2-14 15:56
 */
@Slf4j
@RestController
public class DefaultHystrixController {

    @RequestMapping("/fallback")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public R defaultfallback() {

        log.info("DefaultHystrixController降级操作...defaultfallback");

        return R.error("接口繁忙，降级处理");
    }

}
