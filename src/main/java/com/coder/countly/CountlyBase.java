package com.coder.countly;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author LGZ
 * @package com.coder.countly
 * @className CountlyBase
 * @description countly CountlyBase
 * @date 2019/12/31 10:09:58
 */
public abstract class CountlyBase implements IKey {
    private String deviceId;//用户|设备标识
    protected Map<String, String> param = new HashMap<>();

    CountlyBase() {
    }

    public void instance(String deviceId) {
        //清空请求参数
        param.clear();
        this.deviceId = deviceId;
        param.put(param_device_id, deviceId);
    }


    public Map<String, String> getParam() {
        return param;
    }

    public void addParam(String key, String value) {
        param.put(key, value);
    }

    public String getDeviceId() {
        return deviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountlyBase that = (CountlyBase) o;
        return Objects.equals(param, that.param);
    }

    @Override
    public int hashCode() {
        return Objects.hash(param);
    }

    @Override
    public String toString() {
        return "CountlyBase{" +
                "param=" + param +
                '}';
    }
}
