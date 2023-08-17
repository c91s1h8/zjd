package com.demo.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.common.pojo.domain.TUser;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author csh
 * @Description: TODO
 * @Date 2023-3-1 9:55
 */
@Mapper
public interface TUserMapper extends BaseMapper<TUser> {
    int updateBatch(List<TUser> list);

    int batchInsert(@Param("list") List<TUser> list);

    int insertOrUpdate(TUser record);

    int insertOrUpdateSelective(TUser record);
}