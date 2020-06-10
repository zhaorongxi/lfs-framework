package com.bc.interfaces.log.service;

import com.bc.dao.entity.PageBean;
import com.bc.interfaces.model.LogFileEntity;
import com.bc.interfaces.model.vo.LogFileVO;

import java.util.HashMap;

public interface LogFileService {

	PageBean<LogFileEntity> getLogFileList(LogFileVO logFileVO);

	HashMap<String, String> insertLogFile(LogFileVO logFileVO);

}
