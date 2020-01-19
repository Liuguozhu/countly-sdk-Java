package com.coder.countly;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coder.util.HttpRequestUtil;

import java.util.Map;

/**
 * @author LGZ
 * @package com.coder.countly
 * @className AbstractCountlyTemplate
 * @description countly AbstractCountlyTemplate
 * @date 2019/12/31 10:55:44
 */
public class AbstractCountlyTemplate extends IAbstractCountlyTemplate {

    private static AbstractCountlyTemplate template = new AbstractCountlyTemplate();
//
//    static IAbstractCountlyTemplate getInstance(String url, String appKey, String deviceId) {
//        if (config == null || !config.getDeviceId().equals(deviceId))
//            config = new CountlyConfig(url, appKey, deviceId);
//
//        return template;
//    }

    static IAbstractCountlyTemplate getInstance(String url, String apiKey, String appKey) {
        if (config == null)
            config = new CountlyConfig(url, apiKey, appKey);

        return template;
    }

    static IAbstractCountlyTemplate getInstance(String url, String apiKey) {
        if (config == null || !config.getApiKey().equals(apiKey))
            config = new CountlyConfig(url, apiKey);

        return template;
    }

    @Override
    public <T extends CountlyBase> boolean executeBoolean(T t) {
        String requestString = config.getRequestString();
        String response = HttpRequestUtil.get(requestString, t.param);
        System.out.println(response);
        if (!"".equals(response)) {
            Result result = JSONObject.parseObject(response, Result.class);
            return "Success".equals(result.getResult());
        }
        return false;
    }

    @Override
    public <T extends CountlyBase> String executeString(T t) {
        String requestString = config.getRequestString();
        String response = HttpRequestUtil.get(requestString, t.param);
        System.out.println(response);
        return response;
    }

}
