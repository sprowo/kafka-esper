package com.prowo.model;

import java.util.Date;

/**
 * @author prowo
 * @date 2018/2/7
 */
public class Device {
    private Long id;
    private String deviceId;
    private String userId;
    private String ip;
    private Date requestTime;
    private Integer lastMinuteDeviceUsersCounts;
    private Integer lastMinuteDeviceIpCounts;
    private Integer lastHourDeviceUsersCounts;
    private Integer lastHourDeviceIpCounts;
    private Integer lastDayDeviceUsersCounts;
    private Integer lastDayDeviceIpCounts;
    private Integer lastWeekDeviceUsersCounts;
    private Integer lastWeekDeviceIpCounts;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Integer getLastMinuteDeviceUsersCounts() {
        return lastMinuteDeviceUsersCounts;
    }

    public void setLastMinuteDeviceUsersCounts(Integer lastMinuteDeviceUsersCounts) {
        this.lastMinuteDeviceUsersCounts = lastMinuteDeviceUsersCounts;
    }

    public Integer getLastMinuteDeviceIpCounts() {
        return lastMinuteDeviceIpCounts;
    }

    public void setLastMinuteDeviceIpCounts(Integer lastMinuteDeviceIpCounts) {
        this.lastMinuteDeviceIpCounts = lastMinuteDeviceIpCounts;
    }

    public Integer getLastHourDeviceUsersCounts() {
        return lastHourDeviceUsersCounts;
    }

    public void setLastHourDeviceUsersCounts(Integer lastHourDeviceUsersCounts) {
        this.lastHourDeviceUsersCounts = lastHourDeviceUsersCounts;
    }

    public Integer getLastHourDeviceIpCounts() {
        return lastHourDeviceIpCounts;
    }

    public void setLastHourDeviceIpCounts(Integer lastHourDeviceIpCounts) {
        this.lastHourDeviceIpCounts = lastHourDeviceIpCounts;
    }

    public Integer getLastDayDeviceUsersCounts() {
        return lastDayDeviceUsersCounts;
    }

    public void setLastDayDeviceUsersCounts(Integer lastDayDeviceUsersCounts) {
        this.lastDayDeviceUsersCounts = lastDayDeviceUsersCounts;
    }

    public Integer getLastDayDeviceIpCounts() {
        return lastDayDeviceIpCounts;
    }

    public void setLastDayDeviceIpCounts(Integer lastDayDeviceIpCounts) {
        this.lastDayDeviceIpCounts = lastDayDeviceIpCounts;
    }

    public Integer getLastWeekDeviceUsersCounts() {
        return lastWeekDeviceUsersCounts;
    }

    public void setLastWeekDeviceUsersCounts(Integer lastWeekDeviceUsersCounts) {
        this.lastWeekDeviceUsersCounts = lastWeekDeviceUsersCounts;
    }

    public Integer getLastWeekDeviceIpCounts() {
        return lastWeekDeviceIpCounts;
    }

    public void setLastWeekDeviceIpCounts(Integer lastWeekDeviceIpCounts) {
        this.lastWeekDeviceIpCounts = lastWeekDeviceIpCounts;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
