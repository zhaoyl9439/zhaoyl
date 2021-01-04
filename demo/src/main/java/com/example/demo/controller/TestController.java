package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@ResponseBody
public class TestController {



    @GetMapping("/testGet")
    public String testGet(){

        return "hello";
    }


    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(format.parse("2020-07-16 23:59:59").getTime());
        cal.add(Calendar.DAY_OF_MONTH, 16);
        Date end = cal.getTime();//保险止期+宽限期
        Date now = new Date();
        if(now.getTime()<end.getTime()){
            System.out.println("true");
        }else {
            System.out.println("false");
        }

    }
}
