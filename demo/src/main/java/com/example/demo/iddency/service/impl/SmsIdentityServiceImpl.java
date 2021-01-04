package com.example.demo.iddency.service.impl;

import com.example.demo.iddency.intf.BaseIdentityService;
import com.example.demo.iddency.vo.IdentityAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("SmsIdentityServiceImpl")
public class SmsIdentityServiceImpl implements BaseIdentityService {


    @Override
    public Map<String, String> toAuth(IdentityAuth identityAuth) {
        return null;
    }

    @Override
    public void addAuth(IdentityAuth identityAuth) {

    }
}
