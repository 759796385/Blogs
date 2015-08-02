package com.tq.DAO.impl;

import java.util.List;

import com.tq.DAO.ILogDAO;
import com.tq.entity.Log;

public class LogDAOImpl extends BaseDAOHibernate4<Log> implements ILogDAO {

	@Override
	public int LoginLogSum() {
		List<Log> logs = find("from Log l where l.object=?0", "µÇÂ½");
		if (logs != null) {
			return logs.size();
		} else {
			return 0;
		}
	}

	@Override
	public List<Log> findLogLog(int pageNo, int pageSize) {
		List<Log> logs = findByPage(
				"from Log l where l.object=?0 order by l.date desc", pageNo,
				pageSize, "µÇÂ½");
		return logs;
	}

	@Override
	public int DoLogSum() {
		List<Log> logs = find("from Log l where l.user!=null");
		if (logs != null) {
			return logs.size();
		} else {
			return 0;
		}
	}

	@Override
	public List<Log> findDoLog(int pageNo, int pageSize) {
		return findByPage("from Log l where l.user!=null order by l.date desc",
				pageNo, pageSize);
	}
}
