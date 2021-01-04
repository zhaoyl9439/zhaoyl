package com.example.demo.iddency.service.impl.sons;

import com.example.demo.iddency.intf.sons.AccIdentityService;
import com.example.demo.iddency.vo.IdentityAuth;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 账号认证
 */
@Service("AccIdentityServiceImpl")
public class AccIdentityServiceImpl implements AccIdentityService {
    @Override
    public Map<String, String> toAuth(IdentityAuth identityAuth) {
        Map<String, String> map= new HashMap<String, String>();
        System.out.println("我是账号认证！");
        return map;
    }

    @Override
    public void addAuth(IdentityAuth identityAuth) {
        System.out.println("我是账号认证！");
    }
}
