package com.norawit.springfinal.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Pattern> {
	public Pattern mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pattern pattern = new Pattern();
		pattern.setId(rs.getInt("id"));
		pattern.setName(rs.getString("name"));
		pattern.setImplementation(rs.getString("implementation"));
//		pattern.setAmbition(rs.getCharacterStream("ambition").toString());
		pattern.setGroup(rs.getString("group"));
		return pattern;
	}
}
