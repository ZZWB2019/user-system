package com.cmpay.zwb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhouwb
 * 用于初始化角色管理页面
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InitRsRoleDto {
    private List<RoleDto> list;

}
