package com.calwen;

import com.calwen.service.ExcelService;

/**
 * @author calwen
 * @since ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        ExcelService service = new ExcelService();
//        service.readResource();
//        service.readTarget();
        service.handle();
    }


}