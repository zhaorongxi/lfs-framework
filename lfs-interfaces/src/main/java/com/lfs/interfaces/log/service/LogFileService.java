package com.lfs.interfaces.log.service;

import com.lfs.dao.entity.PageBean;
import com.lfs.interfaces.model.LogFileEntity;
import com.lfs.interfaces.model.vo.LogFileVO;

import java.util.HashMap;

public interface LogFileService {

	PageBean<LogFileEntity> getLogFileList(LogFileVO logFileVO);

	HashMap<String, String> insertLogFile(LogFileVO logFileVO);

}
