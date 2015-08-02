package com.tq.converter;

import java.sql.Clob;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
import org.hibernate.Session;

public class ClobConverter extends StrutsTypeConverter {
	private Session session;

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		Clob clob = null;
		// clob =
		return clob;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		String str = "";
		if (arg1 instanceof Clob) {
			Clob clob = (Clob) arg1;
			try {
				str = clob.getSubString(1, (int) clob.length());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return str;
	}

}
