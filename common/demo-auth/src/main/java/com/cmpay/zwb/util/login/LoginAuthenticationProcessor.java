package com.cmpay.zwb.util.login;

import com.cmpay.lemon.common.exception.LemonException;
import com.cmpay.lemon.framework.security.SimpleUserInfo;
import com.cmpay.lemon.framework.security.UserInfoBase;
import com.cmpay.lemon.framework.security.auth.AbstractGenericMatchableAuthenticationProcessor;
import com.cmpay.lemon.framework.security.auth.GenericAuthenticationToken;
import com.cmpay.zwb.bo.SimpUserInfoBo;
import com.cmpay.zwb.enums.MsgEnum;
import com.cmpay.zwb.service.UserService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhouwb
 */
public class LoginAuthenticationProcessor  extends AbstractGenericMatchableAuthenticationProcessor<GenericAuthenticationToken> {



   @Autowired
   private UserService Service;

    /**
     * @param filterProcessesUrl 认证Url, 前缀必须与GenericAuthenticationFilter拦截的Url前缀一致
    */
    public LoginAuthenticationProcessor(String filterProcessesUrl) {
        super(filterProcessesUrl);
    }

    @Override
    protected UserInfoBase doProcessAuthentication(GenericAuthenticationToken genericAuthenticationToken) throws AuthenticationException {
        HttpServletRequest request = genericAuthenticationToken.getAuthenticationRequest().getHttpServletRequest();
        SimpUserInfoBo userInfoBO = bindLoginData(request);
        SimpUserInfoBo login = Service.login(userInfoBO);
        //return new SimpUserInfoBo(login.getUid(),login.getName(),login.getPasswd());;
        return null;
    }

    private SimpUserInfoBo bindLoginData(HttpServletRequest request) {
        SimpUserInfoBo simpUserInfoBo = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            InputStream is = request.getInputStream();
            simpUserInfoBo = objectMapper.readValue(is, SimpUserInfoBo.class);
        } catch (IOException e) {
            throw LemonException.create(e);
        } catch (Exception e) {
            LemonException.throwLemonException(MsgEnum.FAIL, e.getMessage());
        }
        return simpUserInfoBo;
    }

   /* @Override
    protected UserInfoBase doProcessAuthentication(GenericAuthenticationToken genericAuthenticationToken) throws AuthenticationException {
        HttpServletRequest request = genericAuthenticationToken.getAuthenticationRequest().getHttpServletRequest();
        SimpUserInfoBo userInfoBO = bindLoginData(request);
        SimpUserInfoBo login = Service.login(userInfoBO);
        //return new SimpUserInfoBo(login.getUid(),login.getName(),login.getPasswd());
        return null;
    }


    private SimpUserInfoBo bindLoginData(HttpServletRequest request) {
        SimpUserInfoBo simpUserInfoBo = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            InputStream is = request.getInputStream();
            simpUserInfoBo = objectMapper.readValue(is, SimpUserInfoBo.class);
        } catch (IOException e) {
            throw LemonException.create(e);
        } catch (Exception e) {
            LemonException.throwLemonException(MsgEnum.FAIL, e.getMessage());
        }
        return simpUserInfoBo;
    }*/
}
