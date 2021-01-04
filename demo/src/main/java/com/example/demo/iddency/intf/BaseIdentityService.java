package com.example.demo.iddency.intf;

import com.example.demo.iddency.vo.IdentityAuth;

import java.util.Map;

public interface BaseIdentityService {

    public Map<String, String> toAuth(IdentityAuth identityAuth);

    public void addAuth(IdentityAuth identityAuth);

}
