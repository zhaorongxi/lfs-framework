package com.lfs.interfaces.dao;

import com.lfs.interfaces.model.LogFileEntity;
import com.lfs.interfaces.model.vo.LogFileVO;

import java.util.List;

public interface LogFileDao {

	List<LogFileEntity> getLogFileList(LogFileVO logFileVO);
	
	int insertLogFile(LogFileVO logFile);
}
