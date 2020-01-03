package com.coder.countly;

import java.util.Objects;

/**
 * @author LGZ
 * @package com.coder.countly
 * @className CountlyLogin
 * @description countly CountlyLogin 登录
 * @date 2019/12/31 10:33:34
 */
public class CountlyLogin extends CountlyBase {
    private int begin_session;//（可选）应该提供值 1 表示会话开始
    private int session_duration;//（可选）提供会话持续时间（秒），可用作检测信号以更新当前会话的持续时间，推荐时间是每 30 秒
    private int end_session;//（可选）应该提供值 1 表示会话结束
    private String ip_address;//（可选，只可以与 begin_session 一起使用）用于确定用户位置的 IP 地址，如果未提供，countly 会尝试基于连接数据建立 ip 地址
    private int timestamp;// （可选）用于记录过去数据的 10 位 UTC 时戳。
    /*
    目前，以下预定义的 metrics 有效：
    metrics={
      "_os": "Android",
      "_os_version": "4.1",
      "_device": "Samsung Galaxy",
      "_resolution": "1200x800",
      "_carrier": "Vodafone",
      "_app_version": "1.2",
      "_density": "200dpi",
   		"_locale": "en_US",
      "_store": "com.android.vending"
    }
     */
    private String metrics;//（可选，只可以与 begin_session 一起使用）作为字符串的 JSON 对象，提供了跟踪用户的指标
    /*
    所有值都是可选的，目前您可以传输用户的此信息。
    user_details={
      "name": "Arturs Sosins",
      "username": "ar2rsawseen",
      "email": "test@test.com",
      "organization": "Countly",
      "phone": "+37112345678",
       //Web URL to picture
      "picture": "https://pbs.twimg.com/profile_images/1442562237/012_n_400x400.jpg",
      "gender": "M",
      "byear": 1987, //birth year
  	  "custom":{
        "key1":"value1",
        "key2":"value2",
         ...
      }
    }
     */
    private String user_details;//（可选）作为字符串的 JSON 对象，包含用户信息
    private String country_code;//（可选）用户国家的 ISO 国家代码
    private String city;//（可选）用户城市的名称
   /*
    location=lat,lng
    location=56.42345,123.45325
    */
    private String location;//（可选）用户 lat，lng
    private String old_device_id;//（可选）更改设备 ID 时提供，便于服务器合并数据

    public CountlyLogin() {
        instance();
    }


    public int getBegin_session() {
        return begin_session;
    }

    public void setBegin_session(int begin_session) {
        this.begin_session = begin_session;
        param.put(param_begin_session, Integer.toString(begin_session));
    }

    public int getSession_duration() {
        return session_duration;
    }

    public void setSession_duration(int session_duration) {
        this.session_duration = session_duration;
        param.put(param_session_duration, Integer.toString(session_duration));
    }

    public int getEnd_session() {
        return end_session;
    }

    public void setEnd_session(int end_session) {
        this.end_session = end_session;
        param.put(param_end_session, Integer.toString(end_session));
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
        param.put(param_ip_address, ip_address);
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
        param.put(param_timestamp, Integer.toString(timestamp));
    }

    public String getMetrics() {
        return metrics;
    }

    public void setMetrics(String metrics) {
        this.metrics = metrics;
        param.put(param_metrics, metrics);
    }

    public String getUser_details() {
        return user_details;
    }

    public void setUser_details(String user_details) {
        this.user_details = user_details;
        param.put(param_user_details, user_details);
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
        param.put(param_country_code, country_code);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        param.put(param_city, city);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        param.put(param_location, location);
    }

    public String getOld_device_id() {
        return old_device_id;
    }

    public void setOld_device_id(String old_device_id) {
        this.old_device_id = old_device_id;
        param.put(param_old_device_id, old_device_id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CountlyLogin that = (CountlyLogin) o;
        return begin_session == that.begin_session &&
                session_duration == that.session_duration &&
                end_session == that.end_session &&
                timestamp == that.timestamp &&
                Objects.equals(ip_address, that.ip_address) &&
                Objects.equals(metrics, that.metrics) &&
                Objects.equals(user_details, that.user_details) &&
                Objects.equals(country_code, that.country_code) &&
                Objects.equals(city, that.city) &&
                Objects.equals(location, that.location) &&
                Objects.equals(old_device_id, that.old_device_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),  begin_session, session_duration, end_session, ip_address, timestamp, metrics, user_details, country_code, city, location, old_device_id);
    }
}
