package com.example.demo.iddency.intf;

import com.example.demo.iddency.vo.IdentityAuth;

import java.util.Map;

/**
 * 认证
 */
public interface IdentityFacade {
    /**添加验证数据*/
    public void addAuth(IdentityAuth identityAuth);

    public Map<String, String> toAuth(IdentityAuth identityAuth);


}
