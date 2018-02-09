package com.prowo.esper.service;

import com.alibaba.fastjson.JSONObject;
import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPOnDemandPreparedQueryParameterized;
import com.espertech.esper.client.EPOnDemandQueryResult;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EventBean;
import com.prowo.esper.event.DeviceEvent;
import com.prowo.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author prowo
 * @date 2018/2/7
 */
public class ComputeService {
    protected static Logger logger = LoggerFactory.getLogger(ComputeService.class);
    private static EPServiceProvider epServiceProvider = null;
    private static EPAdministrator admin = null;
    private static EPRuntime runtime = null;

    static {
        Configuration config = new Configuration();
        config.addEventTypeAutoName("com.prowo.esper.event");
        epServiceProvider = EPServiceProviderManager.getDefaultProvider(config);
        admin = epServiceProvider.getEPAdministrator();
        runtime = epServiceProvider.getEPRuntime();
        /**
         * 同一台机器，共用一个event即可
         */
        String DeviceEventBean = DeviceEvent.class.getName();

        String epl1 = "create window mDeviceWindow.win:time(1 min) as  " + DeviceEventBean;
        String epl2 = "create window hDeviceWindow.win:time(1 hour) as  " + DeviceEventBean;
        String epl3 = "create window dDeviceWindow.win:time(1 day) as  " + DeviceEventBean;
        String epl4 = "create window wDeviceWindow.win:time(7 day) as  " + DeviceEventBean;

        String epl11 = "insert into mDeviceWindow select * from " + DeviceEventBean;
        String epl12 = "insert into hDeviceWindow select * from " + DeviceEventBean;
        String epl13 = "insert into dDeviceWindow select * from " + DeviceEventBean;
        String epl14 = "insert into wDeviceWindow select * from " + DeviceEventBean;
        admin.createEPL(epl1);
        admin.createEPL(epl2);
        admin.createEPL(epl3);
        admin.createEPL(epl4);
        admin.createEPL(epl11);
        admin.createEPL(epl12);
        admin.createEPL(epl13);
        admin.createEPL(epl14);
    }

    public static void sendDeviceEvent(Object eventBean, JSONObject jsonObj, String deviceId) {
        runtime.sendEvent(eventBean);

        Date date = jsonObj.getDate("requestTime");
        Date minute = DateUtil.getDateBeforeByMinute(date, 1);
        Date hour = DateUtil.getDateBeforeByHour(date, 1);
        Date day = DateUtil.getDateBeforeByDay(date, 1);
        Date week = DateUtil.getDateBeforeByWeek(date, 1);

        //deviceId1分钟
        String deviceM = "select deviceId,count(userId) userCount,count(ip)  ipCount  from mDeviceWindow where deviceId=? and requestTime>?";
        //1小时
        String deviceH = "select deviceId, count(userId) userCount,count(ip)  ipCount  from hDeviceWindow where deviceId=? and requestTime>?";
        //1天
        String deviceD = "select deviceId, count(userId) userCount,count(ip)  ipCount  from dDeviceWindow where deviceId=? and requestTime>?";
        //1周
        String deviceW = "select deviceId, count(userId) userCount,count(ip)  ipCount  from wDeviceWindow where deviceId=? and requestTime>?";

        EventBean e1 = executeQuery(deviceM, deviceId, minute);
        EventBean e2 = executeQuery(deviceH, deviceId, hour);
        EventBean e3 = executeQuery(deviceD, deviceId, day);
        EventBean e4 = executeQuery(deviceW, deviceId, week);

        if (e1 != null) {
            String userCountM = String.valueOf(e1.get("userCount"));
            String ipCountM = String.valueOf(e1.get("ipCount"));
            jsonObj.put("lastMinuteDeviceUsersCounts", userCountM);
            jsonObj.put("lastMinuteDeviceIpCounts", ipCountM);
        }
        if (e2 != null) {
            String userCountH = String.valueOf(e2.get("userCount"));
            String ipCountH = String.valueOf(e2.get("ipCount"));
            jsonObj.put("lastHourDeviceUsersCounts", userCountH);
            jsonObj.put("lastHourDeviceIpCounts", ipCountH);
        }
        if (e3 != null) {
            String userCountD = String.valueOf(e3.get("userCount"));
            String ipCountD = String.valueOf(e3.get("ipCount"));
            jsonObj.put("lastDayDeviceUsersCounts", userCountD);
            jsonObj.put("lastDayDeviceIpCounts", ipCountD);
        }
        if (e4 != null) {
            String userCountW = String.valueOf(e4.get("userCount"));
            String ipCountW = String.valueOf(e4.get("ipCount"));
            jsonObj.put("lastWeekDeviceUsersCounts", userCountW);
            jsonObj.put("lastWeekDeviceIpCounts", ipCountW);
        }
    }


    public static EventBean executeQuery(String epl, String targetId, Date date) {

        EPOnDemandPreparedQueryParameterized prepared = runtime.prepareQueryWithParameters(epl);
        prepared.setObject(1, targetId);
        prepared.setObject(2, date.getTime());
        EPOnDemandQueryResult result = runtime.executeQuery(prepared);
        EventBean[] events = result.getArray();

        if (events.length > 0) {
            return events[0];
        } else {
            return null;
        }

    }

}