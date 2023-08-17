package com.demo.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.common.pojo.domain.TAddress;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author csh
 * @Description: TODO
 * @Date 2023-3-1 9:55
 */
@Mapper
public interface TAddressMapper extends BaseMapper<TAddress> {
    int updateBatch(List<TAddress> list);

    int batchInsert(@Param("list") List<TAddress> list);

    int insertOrUpdate(TAddress record);

    int insertOrUpdateSelective(TAddress record);
}