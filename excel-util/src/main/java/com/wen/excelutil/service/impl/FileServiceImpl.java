package com.wen.excelutil.service.impl;

import com.wen.excelutil.entity.MyFile;
import com.wen.excelutil.service.FileService;
import com.wen.releasedao.core.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author calwen
 * @since 2022/9/5
 */
@Service
public class FileServiceImpl implements FileService {
    @Resource
    BaseMapper baseMapper;

    @Override
    public List<MyFile> listAll() {
        return baseMapper.getList(MyFile.class);
    }
}
