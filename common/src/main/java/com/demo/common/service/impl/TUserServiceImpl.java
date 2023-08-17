package com.demo.common.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.common.mapper.TUserMapper;
import java.util.List;
import com.demo.common.pojo.domain.TUser;
import com.demo.common.service.TUserService;
/**
 * @Author csh
 * @Description: TODO
 * @Date 2023-3-1 9:55
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService{

    @Override
    public int updateBatch(List<TUser> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<TUser> list) {
        return baseMapper.batchInsert(list);
    }
    @Override
    public int insertOrUpdate(TUser record) {
        return baseMapper.insertOrUpdate(record);
    }
    @Override
    public int insertOrUpdateSelective(TUser record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
