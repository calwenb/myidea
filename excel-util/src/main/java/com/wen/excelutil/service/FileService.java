package com.wen.excelutil.service;

import com.wen.excelutil.entity.MyFile;

import java.util.List;

/**
 * @author calwen
 * @since 2022/9/5
 */
public interface FileService {
    List<MyFile> listAll();
}
