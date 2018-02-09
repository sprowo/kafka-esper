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
    private long requestTime;
    private long beforeMinuteTime;
    private long beforeHourTime;
    private long beforeDayTime;
    private long beforeWeekTime;

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

    public long getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(long requestTime) {
        this.requestTime = requestTime;
    }

    public long getBeforeMinuteTime() {
        return beforeMinuteTime;
    }

    public void setBeforeMinuteTime(long beforeMinuteTime) {
        this.beforeMinuteTime = beforeMinuteTime;
    }

    public long getBeforeHourTime() {
        return beforeHourTime;
    }

    public void setBeforeHourTime(long beforeHourTime) {
        this.beforeHourTime = beforeHourTime;
    }

    public long getBeforeDayTime() {
        return beforeDayTime;
    }

    public void setBeforeDayTime(long beforeDayTime) {
        this.beforeDayTime = beforeDayTime;
    }

    public long getBeforeWeekTime() {
        return beforeWeekTime;
    }

    public void setBeforeWeekTime(long beforeWeekTime) {
        this.beforeWeekTime = beforeWeekTime;
    }
}
