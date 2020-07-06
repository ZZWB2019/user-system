package com.cmpay.zwb.bo;

import lombok.Data;

import java.util.List;

/**
 * @author zhouwb
 */
@Data
public class UpdateRoleMenuBO {

    private Long rid;
    private List<Long> mids;
}
