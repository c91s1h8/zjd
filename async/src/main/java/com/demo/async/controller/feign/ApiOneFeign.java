package com.demo.async.controller.feign;

import com.demo.common.pojo.domain.TAddress;
import com.demo.common.pojo.domain.TUser;
import com.demo.common.pojo.dto.AsyncOneDto;
import com.demo.common.pojo.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author csh
 * @Description: TODO
 * @Date 2023-2-9 13:49
 */
@FeignClient(value = "api-service")
public interface ApiOneFeign {

    @PostMapping(value = "/apiOne/method9")
    R method9(TUser user);

}
