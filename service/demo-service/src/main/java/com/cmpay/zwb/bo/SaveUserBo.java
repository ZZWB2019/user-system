package com.cmpay.zwb.bo;

import lombok.Data;


/**
 * @author zhouwb
 */
@Data
public class SaveUserBo {
    private String name;
    private String passwd;
    private String phnumber;
    private String email;
    private String userName;
}
