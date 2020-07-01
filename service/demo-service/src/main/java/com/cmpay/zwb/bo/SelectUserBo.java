package com.cmpay.zwb.bo;

import lombok.Data;

/**
 * @author zhouwb
 */
@Data
public class SelectUserBo {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 每页记录数
     */
    private Integer pageSize;
}
