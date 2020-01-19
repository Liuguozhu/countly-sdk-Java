package com.coder.countly;

import com.alibaba.fastjson.JSONObject;

/**
 * @author LGZ
 * @package com.coder.countly
 * @className CountlyApps
 * @description countly CountlyApps
 * @date 2020/1/16 10:12:29
 */
public class CountlyApps extends CountlyBase {
    private String args;//JSON object as string with app data.
    private String callback;//(optional) name of callback function for JSONP output

    /*
 args 示例：{"name":"Test App","type":"mobile"}

'name': { 'required': true, 'type': 'String' }, //name of the app
'country': { 'required': false, 'type': 'String' }, //your country
'type': { 'required': false, 'type': 'String' }, // type of the app, mobile, web, et
'category': { 'required': false, 'type': 'String' },// ID of app category
'timezone': { 'required': false, 'type': 'String' }// timezone in which to display statistics
     */
    public static class Args {
        private String name;
        private String country;
        private String type;
        private String category;
        private String timezone;

        public Args() {
        }

        public Args(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
        param.put(param_args, this.args);
    }

    public void setArgs(Args args) {
        this.args = JSONObject.toJSONString(args);
        param.put(param_args, this.args);
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
        param.put(param_callback, this.args);
    }

    public CountlyApps(String deviceId) {
        instance(deviceId);
    }
}
