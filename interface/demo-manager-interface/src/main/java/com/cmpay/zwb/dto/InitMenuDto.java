package com.cmpay.zwb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhouwb
 * 用于存放初始化菜单管理页面的数据
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InitMenuDto {

    //菜单信息
    private List<MenuDto> menuDtos;
}
