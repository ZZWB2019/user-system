package com.cmpay.zwb.bo;

import lombok.Data;

import java.util.List;

/**
 * @author zhouwb
 */
@Data
public class SaveUserRoleBo {
    private Long id;
    private Long uid;
    private List<Long> rids;
}
