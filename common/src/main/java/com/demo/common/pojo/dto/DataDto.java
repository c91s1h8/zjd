package com.demo.common.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author csh
 * @Description: TODO
 * @Date 2023-2-22 16:19
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataDto {

    private String a;
    private String b;
    private String c;
}
