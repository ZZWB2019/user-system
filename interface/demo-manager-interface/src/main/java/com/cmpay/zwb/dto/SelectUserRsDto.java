package com.cmpay.zwb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhouwb
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectUserRsDto {
    private List<UserDto> userDtos;
    private Integer pageNum;
    private Integer pageSize;
}
