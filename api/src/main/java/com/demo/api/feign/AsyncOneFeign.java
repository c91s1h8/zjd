package com.demo.api.feign;

import com.demo.api.feign.fallback.AsyncOneFallBackFactory;
import com.demo.common.pojo.domain.TAddress;
import com.demo.common.pojo.dto.AsyncOneDto;
import com.demo.common.pojo.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author csh
 * @Description: TODO
 * @Date 2023-2-9 13:49
 */
@FeignClient(value = "async-service")
public interface AsyncOneFeign {

    @PostMapping(value = "/aysncOne/method1")
    R method1(AsyncOneDto asyncOneDto);

    @PostMapping(value = "/aysncOne/method7")
    R method7(TAddress address);
}
