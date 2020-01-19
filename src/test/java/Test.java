import com.coder.countly.*;

import java.sql.Timestamp;
import java.util.*;

/**
 * @author LGZ
 * @package com.coder.countly
 * @className Test
 * @description countly Test
 * @date 2019/12/31 10:38:19
 */
public class Test {
    private static String url = "http://192.168.0.100/i";//请改为自己部署的countly地址
    private static String apiKey = "xxxxxxxxx";//请改为自己在countly的api秘钥
    private static String appKey = "xxxxxxxxx";//请改为自己在countly创建的应用appKey
    private static IAbstractCountlyTemplate template;//countly操作模板

    public static void main(String[] args) {

//        String deviceId = "张三"; //用户设备标识，不同的deviceId就是不同的登录用户
//
//        template = IAbstractCountlyTemplate.get(url, apiKey, appKey);//初始化模板
//
//        //提交用户每日登录统计，同一个deviceId如果提交多次登录请求，每日只统计为一人次
//        CountlyLogin countly = new CountlyLogin(deviceId);
//        countly.setIp_address("49.7.42.120");
//        countly.setBegin_session(1);
//        countly.setSession_duration(30);
//        countly.setCountry_code("China");
//        template.executeBoolean(countly);
////
//        //自定义事件，可一次性提交多个事件的统计
//        CountlyEvent countlyEvent = new CountlyEvent(deviceId);
//        List<CountlyEvent.Event> events = new ArrayList<>();
////        //自定义事件1
////        events.add(new CountlyEvent.Event("sleep", 1));
//        //自定义事件2
//        //自定义事件2子属性
//        Map<String, String> segmentation = new HashMap<>();
//        segmentation.put("userId", "001");
//        segmentation.put("username", "张三");
//        segmentation.put("userSex", "男");
//        int times = (int) (System.currentTimeMillis() / 1000);
//        CountlyEvent.Event event = new CountlyEvent.Event("eat", 1, segmentation);
//        event.setTimestamp(times);
//        events.add(event);
//        //自定义事件3
//        events.add(new CountlyEvent.Event("pay", 1, 10.00f));
//
//        countlyEvent.setEvents(events);
//        template.executeBoolean(countlyEvent);


        template = IAbstractCountlyTemplate.get(url + "/apps/create", apiKey);
        CountlyApps countlyApps = new CountlyApps(null);
        String appName = "新建应用";
        CountlyApps.Args args1 = new CountlyApps.Args(appName);
        args1.setType("web");
        args1.setCountry("CH");
        args1.setTimezone("Asia/Shanghai");
        countlyApps.setArgs(args1);
        String result = template.executeString(countlyApps);
        System.out.println("创建结果：" + result);

    }
}
