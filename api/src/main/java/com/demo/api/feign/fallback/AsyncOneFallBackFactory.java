package com.demo.api.feign.fallback;

import com.demo.api.feign.AsyncOneFeign;
import com.demo.common.pojo.domain.TAddress;
import com.demo.common.pojo.dto.AsyncOneDto;
import com.demo.common.pojo.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author csh
 * @Description: TODO
 * @Date 2023-2-9 14:33
 */
@Component
@Slf4j
public class AsyncOneFallBackFactory implements FallbackFactory<AsyncOneFeign> {

    @Override
    public AsyncOneFeign create(Throwable cause) {
        return new AsyncOneFeign() {
            @Override
            public R method1(AsyncOneDto asyncOneDto) {
                log.error("AsyncOneFeign-method1 调用失败");
                return R.error("AsyncOneFeign-method1 调用失败");
            }

            @Override
            public R method7(TAddress address) {
                log.error("AsyncOneFeign-method7 调用失败");
                return R.error("AsyncOneFeign-method7 调用失败");
            }
        };
    }
}
