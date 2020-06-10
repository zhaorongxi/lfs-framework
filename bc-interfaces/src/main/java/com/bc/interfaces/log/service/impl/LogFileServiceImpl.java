package com.bc.interfaces.log.service.impl;

import com.bc.dao.entity.PageBean;
import com.bc.interfaces.dao.LogFileDao;
import com.bc.interfaces.log.service.LogFileService;
import com.bc.interfaces.model.LogFileEntity;
import com.bc.interfaces.model.vo.LogFileVO;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class LogFileServiceImpl implements LogFileService {

	private static final Logger log = LoggerFactory.getLogger(LogFileService.class);

    @Resource
    private LogFileDao logFileDao;

	@Override
	public PageBean<LogFileEntity> getLogFileList(LogFileVO logFile) {
		List<LogFileEntity> logList = new ArrayList<>();
        try {
			PageHelper.startPage(logFile.getCurrentPage(), logFile.getPageSize());
			logList = logFileDao.getLogFileList(logFile);
            return new PageBean<LogFileEntity>(logList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new PageBean<LogFileEntity>(logList);
        }
        
	}


	@Override
	public HashMap<String, String> insertLogFile(LogFileVO logFile) {
		HashMap<String, String> rs = new HashMap<String, String>();
		try {
			int a = logFileDao.insertLogFile(logFile);
			if (a >= 1) {
				rs.put("code", "0");
				rs.put("errorMsg", "新增操作日志成功");
			} else {
				rs.put("code", "1");
				rs.put("errorMsg", "新增操作日志失败");
				log.info("新增操作日志失败!");
			}
		} catch (Exception ex) {
			rs.put("code", "1");
			rs.put("errorMsg", "新增操作日志异常:" + ex.toString());
			log.info("新增操作日志异常:" + ex);
		}
		return rs;
	}

}
