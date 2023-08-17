package com.demo.common.service;

import java.util.List;
import com.demo.common.pojo.domain.TUser;
import com.baomidou.mybatisplus.extension.service.IService;
    /**
 * @Author csh
 * @Description: TODO
 * @Date 2023-3-1 9:55
 */
public interface TUserService extends IService<TUser>{


    int updateBatch(List<TUser> list);

    int batchInsert(List<TUser> list);

    int insertOrUpdate(TUser record);

    int insertOrUpdateSelective(TUser record);

}
