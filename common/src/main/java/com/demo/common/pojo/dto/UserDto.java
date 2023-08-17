package com.demo.common.pojo.dto;

import com.demo.common.pojo.domain.TAddress;
import com.demo.common.pojo.domain.TUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author csh
 * @Description: TODO
 * @Date 2023-2-22 16:17
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private TUser user;
    private TAddress address;
}
