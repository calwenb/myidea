package com.calwen;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.calwen.service.ExcelService;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author calwen
 * @since ${DATE}
 */
public class Main {
    public static void main(String[] args) {
//        ExcelService service = new ExcelService();
////        service.readResource();
////        service.readTarget();
//        service.handle();
//        Timestamp beginTime = new Timestamp(DateUtil.beginOfDay(DateUtil.offsetDay(new Date(), 8)).getTime());
//        Timestamp endTime = new Timestamp(DateUtil.endOfDay(DateUtil.offsetDay(new Date(), 8)).getTime());
//        System.out.println(beginTime);
//        System.out.println(endTime);
        DateTime t1 = DateUtil.parse("2022-11-15 00:01:00");
        DateTime t2 = DateUtil.parse("2022-11-18 12:00:00");
        long off = DateUtil.between(t2, t1, DateUnit.DAY);
        System.out.println(off);


    }


}