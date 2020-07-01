package com.cmpay.zwb.dto;

import com.cmpay.framework.data.request.GenericDTO;
import lombok.Data;

import java.util.List;

/**
 * @author zhouwb
 */
@Data
public class SaveUserDto extends GenericDTO {
    private Long uid;
    private String name;
    private String passwd;
    private String phnumber;
    private String email;
    private byte is_delete;
    List<Long> roleIds;
}
