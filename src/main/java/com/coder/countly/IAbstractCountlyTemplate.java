package com.coder.countly;

/**
 * @author LGZ
 * @package com.coder.countly
 * @className IAbstractCountlyTemplate
 * @description countly IAbstractCountlyTemplate countly操作模板方法
 * @date 2019/12/31 10:22:55
 */
public abstract class IAbstractCountlyTemplate {
    static CountlyConfig config;

    //实例化操作对象
    static public IAbstractCountlyTemplate get(String url, String apiKey, String appKey) {
        return AbstractCountlyTemplate.getInstance(url, apiKey, appKey);
    }

    //实例化操作对象
    static public IAbstractCountlyTemplate get(String url, String apiKey) {
        return AbstractCountlyTemplate.getInstance(url, apiKey);
    }

    public static CountlyConfig getConfig() {
        return config;
    }

    abstract public <T extends CountlyBase> String executeString(T t);

    abstract public <T extends CountlyBase> boolean executeBoolean(T t);


}
