package com.cmpay.zwb.bo;

import lombok.Data;

/**
 * @author zhouwb
 */
@Data
public class SelectRoleBo {
    /**
     * 角色
     */
    private String name;
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 每页记录数
     */
    private Integer pageSize;
}
