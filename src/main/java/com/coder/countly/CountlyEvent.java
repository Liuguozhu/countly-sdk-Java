package com.coder.countly;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author LGZ
 * @package com.coder.countly
 * @className CountlyEvent
 * @description countly CountlyEvent 自定义事件
 * @date 2019/12/31 10:42:04
 */
public class CountlyEvent extends CountlyBase {

    public static class Event {
        String key;//自定义事件key
        int count;//自定义事件计数A，
        float sum;//自定义事件计数B，
        long timestamp;//用于记录过去数据的 10 位 UTC 时戳。
        Map<String, String> segmentation;//自定义事件子属性

        public Event(String key, int count) {
            this.key = key;
            this.count = count;
        }

        public Event(String key, int count, float sum) {
            this.key = key;
            this.count = count;
            this.sum = sum;
        }

        public Event(String key, int count, Map<String, String> segmentation) {
            if (segmentation != null && !segmentation.isEmpty()) {
                this.segmentation = segmentation;
            }
            this.key = key;
            this.count = count;
        }

        public Event(String key, int count, float sum, Map<String, String> segmentation) {
            this.key = key;
            this.count = count;
            this.sum = sum;
            if (segmentation != null && !segmentation.isEmpty()) {
                this.segmentation = segmentation;
            }
        }


        public String getKey() {
            return key;
        }


        public int getCount() {
            return count;
        }


        public float getSum() {
            return sum;
        }

        public void setSum(float sum) {
            this.sum = sum;
        }

        public Map<String, String> getSegmentation() {
            return segmentation;
        }

        public void setSegmentation(Map<String, String> segmentation) {
            this.segmentation = segmentation;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Event event = (Event) o;
            return count == event.count &&
                    Float.compare(event.sum, sum) == 0 &&
                    timestamp == event.timestamp &&
                    Objects.equals(key, event.key) &&
                    Objects.equals(segmentation, event.segmentation);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, count, sum, timestamp, segmentation);
        }

        @Override
        public String toString() {
            return "Event{" +
                    "key='" + key + '\'' +
                    ", count=" + count +
                    ", sum=" + sum +
                    ", timestamp=" + timestamp +
                    ", segmentation=" + segmentation +
                    '}';
        }
    }

//    public static class Segmentation {
//        String app_version;
//        String country;
//        String item;
//
//        public Segmentation() {
//        }
//        public Segmentation(String item) {
//            this.item = item;
//        }
//        public Segmentation(String app_version, String country) {
//            this.app_version = app_version;
//            this.country = country;
//        }
//
//        public Segmentation(String app_version, String country, String item) {
//            this.app_version = app_version;
//            this.country = country;
//            this.item = item;
//        }
//
//        public String getApp_version() {
//            return app_version;
//        }
//
//        public void setApp_version(String app_version) {
//            this.app_version = app_version;
//        }
//
//        public String getCountry() {
//            return country;
//        }
//
//        public void setCountry(String country) {
//            this.country = country;
//        }
//
//        public String getItem() {
//            return item;
//        }
//
//        public void setItem(String item) {
//            this.item = item;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Segmentation that = (Segmentation) o;
//            return Objects.equals(app_version, that.app_version) &&
//                    Objects.equals(country, that.country);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(app_version, country);
//        }
//
//        @Override
//        public String toString() {
//            return "Segmentation{" +
//                    "app_version='" + app_version + '\'' +
//                    ", country='" + country + '\'' +
//                    '}';
//        }
//    }

    /*
    包含事件对象的 JSON 阵列。每个事件对象都可以有以下属性；
    • 键值（强制，字符串）
    • 计数（强制，整数）
    • 总数（可选，双倍）
    • 分段（可选，字典对象）
    • 时戳（可选）
    示例事件阵列如下：
     [
          {
              "key": "level_success",
              "count": 4
          },
          {
              "key": "level_fail",
              "count": 2
          },
          {
              "key": "in_app_purchase",
              "count": 3,
              "sum": 2.97,
              "segmentation": {
                  "app_version": "1.0",
                  "country": "Turkey"
              }
          }
    ]
     */
    private String events;//作为字符串的 JSON 阵列，包含事件对象

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
        param.put(param_events, this.events);
    }

    public void setEvents(List<Event> events) {
        this.events = JSONArray.toJSONString(events);
        param.put(param_events, this.events);
    }


}
