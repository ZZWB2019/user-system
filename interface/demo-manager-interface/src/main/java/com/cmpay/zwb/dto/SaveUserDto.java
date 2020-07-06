package com.cmpay.zwb.dto;

import com.cmpay.framework.data.request.GenericDTO;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * @author zhouwb
 */
@Data
public class SaveUserDto extends GenericDTO {
    private Long uid;
    @NotBlank
    private String name;
    @NotBlank
    private String passwd;
    private String phnumber;
    @Email
    private String email;
    private byte is_delete;
    List<Long> roleIds;
}
