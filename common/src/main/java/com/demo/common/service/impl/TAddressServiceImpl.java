package com.demo.common.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.demo.common.mapper.TAddressMapper;
import com.demo.common.pojo.domain.TAddress;
import com.demo.common.service.TAddressService;
/**
 * @Author csh
 * @Description: TODO
 * @Date 2023-3-1 9:55
 */
@Service
public class TAddressServiceImpl extends ServiceImpl<TAddressMapper, TAddress> implements TAddressService{

    @Override
    public int updateBatch(List<TAddress> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<TAddress> list) {
        return baseMapper.batchInsert(list);
    }
    @Override
    public int insertOrUpdate(TAddress record) {
        return baseMapper.insertOrUpdate(record);
    }
    @Override
    public int insertOrUpdateSelective(TAddress record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
