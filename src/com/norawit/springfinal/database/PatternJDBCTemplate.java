package com.norawit.springfinal.database;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class PatternJDBCTemplate implements PatternDAO {

	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	public void create(String name, String group, String implementation) {
		String SQL = "INSERT INTO `pattern`( `NAME`, `GROUP`, `IMPLEMENTATION`) VALUES (?, ?, ?)";
		jdbcTemplateObject.update( SQL, name, group, implementation);
		System.out.println("Created Record Name = " + name + " Group = " + group + " Implementation = " + implementation);
		return;
	}
	public Pattern getPattern(Integer id) {
		String SQL = "select * from pattern where id = ?";
		Pattern pattern = jdbcTemplateObject.queryForObject(SQL,
				new Object[]{id}, new StudentMapper());
		return pattern;
	}
	public List<Pattern> listPatterns() {
		String SQL = "select * from pattern";
		List <Pattern> patterns = jdbcTemplateObject.query(SQL,
				new StudentMapper());
		return patterns;
	}
	public void delete(Integer id){
		String SQL = "delete from pattern where id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id );
		return;
	}
	public void update(Integer id, String name, String group, String implementation ){
		String SQL = "update pattern set `NAME` = ?, `GROUP` = ?, `IMPLEMENTATION` = ? where id = ?";
		jdbcTemplateObject.update(SQL, name, group, implementation, id);
		System.out.println("Updated Record with ID = " + id );
		return;
	}
}