package com.cmpay.zwb.dto;

import com.cmpay.framework.data.response.PageableRspDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InitRsUserDto extends PageableRspDTO {
    private List<UserDto>  userDtos;
}
