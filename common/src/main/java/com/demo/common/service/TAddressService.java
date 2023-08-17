package com.demo.common.service;

import java.util.List;
import com.demo.common.pojo.domain.TAddress;
import com.baomidou.mybatisplus.extension.service.IService;
    /**
 * @Author csh
 * @Description: TODO
 * @Date 2023-3-1 9:55
 */
public interface TAddressService extends IService<TAddress>{


    int updateBatch(List<TAddress> list);

    int batchInsert(List<TAddress> list);

    int insertOrUpdate(TAddress record);

    int insertOrUpdateSelective(TAddress record);

}
