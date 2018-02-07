package com.prowo.esper.event;

import java.util.Date;

/**
 * @author prowo
 * @date 2018/2/7
 */
public class DeviceEvent {
    private String deviceId;
    private String userId;
    private String ip;
    private Date requestTime;

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
