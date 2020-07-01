package com.cmpay.zwb.dto;

import com.cmpay.framework.data.request.GenericDTO;
import com.cmpay.framework.data.response.PageableRspDTO;
import lombok.Data;

/**
 * @author zhouwb
 * 用于查询用户信息的Dto
 * 封装的是用户查询信息
 */
@Data
public class SelectUserDto extends PageableRspDTO {
    private String userName;
}
