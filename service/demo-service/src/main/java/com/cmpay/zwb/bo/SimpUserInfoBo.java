package com.cmpay.zwb.bo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhouwb
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpUserInfoBo {
    private Long uid;
    private String name;
    private String passwd;

}
