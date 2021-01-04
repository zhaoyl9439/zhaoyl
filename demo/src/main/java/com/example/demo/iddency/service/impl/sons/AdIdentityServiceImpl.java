package com.example.demo.iddency.service.impl.sons;

import com.example.demo.iddency.intf.sons.AdIdentityService;
import com.example.demo.iddency.vo.IdentityAuth;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 广告认证
 */
@Service("AdIdentityServiceImpl")
public class AdIdentityServiceImpl implements AdIdentityService {
    @Override
    public Map<String, String> toAuth(IdentityAuth identityAuth) {
        Map<String, String> map= new HashMap<String, String>();
        System.out.println("我是广告认证！");
        return map;
    }

    @Override
    public void addAuth(IdentityAuth identityAuth) {

    }
}
