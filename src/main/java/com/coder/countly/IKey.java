package com.coder.countly;

/**
 * @author LGZ
 * @package com.coder.countly
 * @className IKey
 * @description countly IKey
 * @date 2019/12/31 11:04:43
 */
public interface IKey {
    /**
     * app_key，countly请求基础参数，用户区分统计的应用
     */
    final static String param_app_key = "app_key";
    /**
     * sdk_version，countly请求基础参数，sdk版本号
     */
    final static String param_sdk_version = "sdk_version";
    /**
     * session_duration，（可选）提供会话持续时间（秒），可用作检测信号以更新当前会话的持续时间，推荐时间是每 30 秒
     */
    final static String param_session_duration = "session_duration";
    /**
     * device_id 已生成的或设备特定的独特设备 ID，用于确定用户
     */
    final static String param_device_id = "device_id";
    /**
     * begin_session (可选）应该提供值 1 表示会话开始
     */
    final static String param_begin_session = "begin_session";
    /**
     * end_session （可选）应该提供值 1 表示会话结束
     */
    final static String param_end_session = "end_session";
    /**
     * ip_address（可选，只可以与 begin_session 一起使用）用于确定用户位置的 IP 地址，如果未提供，countly 会尝试基于连接数据建立 ip 地址
     */
    final static String param_ip_address = "ip_address";
    /**
     * timestamp（可选）用于记录过去数据的 10 位 UTC 时戳
     */
    final static String param_timestamp = "timestamp";
    /**
     * metrics （可选，只可以与 begin_session 一起使用）作为字符串的 JSON 对象，提供了跟踪用户的指标
     */
    final static String param_metrics = "metrics";
    /**
     * user_details （可选）作为字符串的 JSON 对象，包含用户信息
     */
    final static String param_user_details = "user_details";
    /**
     * country_code （可选）用户国家的 ISO 国家代码
     */
    final static String param_country_code = "country_code";
    /**
     * city （可选）用户城市的名称
     */
    final static String param_city = "city";
    /**
     * location （可选）用户 lat，lng
     */
    final static String param_location = "location";
    /**
     * old_device_id （可选）更改设备 ID 时提供，便于服务器合并数据
     */
    final static String param_old_device_id = "old_device_id";

    /**
     * app_key，countly请求基础参数，自定义事件
     */
    final static String param_events = "events";

    final static String events_key = "key";
    final static String events_count = "count";
    final static String events_sum = "sum";
    final static String events_segmentation = "segmentation";

    /**
     * 问号，用于拼接http请求参数
     */
    final static String question_mark = "?";
    /**
     * 等号，用于拼接http请求参数值
     */
    final static String equals_sign = "=";
    /**
     * &符合，用户拼接http请求参数
     */
    final static String and_sign = "&";

}
