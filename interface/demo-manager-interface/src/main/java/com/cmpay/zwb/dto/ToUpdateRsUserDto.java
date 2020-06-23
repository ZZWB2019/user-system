package com.cmpay.zwb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhouwb
 * 这个dto用于装载用户的信息，以及角色信息，还有用户的一些关联信息要进行查询
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToUpdateRsUserDto {

    //用户信息
    private UserDto userDo;
    //角色信息

}
