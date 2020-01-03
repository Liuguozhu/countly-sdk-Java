package com.coder.countly;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author LGZ
 * @package com.coder.countly
 * @className Result
 * @description countly Result
 * @date 2019/12/31 10:49:32
 */
public class Result implements Serializable {

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result1 = (Result) o;
        return Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return "Result{" +
                "result='" + result + '\'' +
                '}';
    }
}
