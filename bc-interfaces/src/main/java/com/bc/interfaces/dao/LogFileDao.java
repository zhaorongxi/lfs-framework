package com.bc.interfaces.dao;

import com.bc.interfaces.model.LogFileEntity;
import com.bc.interfaces.model.vo.LogFileVO;

import java.util.List;

public interface LogFileDao {

	List<LogFileEntity> getLogFileList(LogFileVO logFileVO);
	
	int insertLogFile(LogFileVO logFile);
}
