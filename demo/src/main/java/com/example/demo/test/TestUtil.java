package com.example.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class TestUtil {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.parse("2020-10-10 23:59:59").before(sdf.parse("2020-10-10 23:59:59")));
        /*try {
            HashMap<String, Object> map = new HashMap<>();
            map.put("NResvNum1", 30);
            map.put("NRenewalDays", 1);
            //续保等待期校验
            Date bgnTm = addDay(sdf.parse("2020-10-14 23:59:59"),-(((Integer) map.get("NResvNum1")+4)));
            System.out.println(sdf.format(bgnTm));
            Date endTm = addDay(sdf.parse("2020-10-14 23:59:59"),(Integer) map.get("NRenewalDays"));
            System.out.println(sdf.format(endTm));
            boolean renewalTime = belongCalendar(sdf.parse("2020-10-19 16:09:17"), bgnTm, endTm);
            System.out.println(renewalTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
    }

    public static boolean getRenewalTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        cal.add(Calendar.DAY_OF_MONTH, 4);
        Date end = cal.getTime();//保险止期+宽限期
        System.out.println(sdf.format(end));
        Date now = new Date();
        System.out.println(sdf.format(now));
        if(end.getTime() > now.getTime()){
            return true;
        }else {
            return false;
        }
    }

    /**
     *
     * @param date
     * @param dayNum
     * @return
     */
    public static Date addDay(Date date, int dayNum){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        cal.add(Calendar.DAY_OF_MONTH, dayNum);
        return cal.getTime();
    }

    /**
     * 判断时间在时间段内
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        //设置当前时间
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        //设置开始时间
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);
        //设置结束时间
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        //处于开始时间之后，和结束时间之前的判断
        if (date.after(begin) && date.before(end)) {
            return false;
        } else {
            return true;
        }
    }
}
