package com.cmpay.zwb.bo;

import lombok.Data;

import java.util.List;

/**
 * @author zhouwb
 */
@Data
public class SaveRoleMenuBo {
    private Long id;
    private Long rid;
    private List<Long> mids;
}
