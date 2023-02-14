package com.niuzj.model;

import java.io.Serializable;

/**
 * @author niuzheju
 * @date 17:42 2020/12/25
 */
public class AliPay implements Serializable {

    private static final long serialVersionUID = 5401489403101433843L;

    private static String url;
    private String appId;
    private String appAuthToken;
    private Integer version;

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        AliPay.url = url;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppAuthToken() {
        return appAuthToken;
    }

    public void setAppAuthToken(String appAuthToken) {
        this.appAuthToken = appAuthToken;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
