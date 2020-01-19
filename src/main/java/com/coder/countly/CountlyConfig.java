package com.coder.countly;

import java.util.Objects;

/**
 * @author LGZ
 * @package com.coder.countly
 * @className CountlyConfig
 * @description countly CountlyConfig
 * @date 2019/12/31 11:50:27
 */
public class CountlyConfig implements IKey {
    private String url;
    private String apiKey;
    private String appKey;
    private String sdkVersion;//可选参数

    private static StringBuilder requestBuild = new StringBuilder();

    public CountlyConfig() {
        //清空 请求字符串和 请求参数
        requestBuild.delete(0, requestBuild.length());
    }

    CountlyConfig(String url, String apiKey) {
        this.url = url;
        this.apiKey = apiKey;
        //清空 请求字符串和 请求参数
        requestBuild.delete(0, requestBuild.length());
        requestBuild.append(this.getUrl());
        requestBuild.append(question_mark).append(param_api_key).append(equals_sign).append(this.getApiKey());
    }

    //    CountlyConfig(String url, String appKey, String deviceId) {
//        this.url = url;
//        this.appKey = appKey;
////        this.deviceId = deviceId;
//        //清空 请求字符串和 请求参数
//        requestBuild.delete(0, requestBuild.length());
//        requestBuild.append(this.getUrl());
//        requestBuild.append(question_mark).append(param_app_key).append(equals_sign).append(this.getAppKey());
////        requestBuild.append(and_sign).append(param_device_id).append(equals_sign).append(this.getDeviceId());
//    }
    CountlyConfig(String url, String apiKey, String appKey) {
        this.url = url;
        this.apiKey = apiKey;
        this.appKey = appKey;
        //清空 请求字符串和 请求参数
        requestBuild.delete(0, requestBuild.length());
        requestBuild.append(this.getUrl());
        requestBuild.append(question_mark);
        requestBuild.append(and_sign);
        requestBuild.append(param_api_key).append(equals_sign).append(this.getApiKey());
        requestBuild.append(and_sign);
        requestBuild.append(param_app_key).append(equals_sign).append(this.getAppKey());
    }

    String getRequestString() {
        if (requestBuild.length() == 0) {
            requestBuild.append(this.getUrl());
            requestBuild.append(question_mark).append(param_app_key).append(equals_sign).append(this.getAppKey());
            requestBuild.append(and_sign).append(param_api_key).append(equals_sign).append(this.getApiKey());
        }
        return requestBuild.toString();
    }

//    String getDeviceId() {
//        return deviceId;
//    }

    public String getUrl() {
        return url;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getAppKey() {
        return appKey;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountlyConfig that = (CountlyConfig) o;
        return Objects.equals(url, that.url) &&
                Objects.equals(appKey, that.appKey) &&
                Objects.equals(sdkVersion, that.sdkVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, appKey, sdkVersion);
    }

    @Override
    public String toString() {
        return "CountlyConfig{" +
                "url='" + url + '\'' +
                ", appKey='" + appKey + '\'' +
                ", sdkVersion='" + sdkVersion + '\'' +
                '}';
    }
}
