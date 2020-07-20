package com.sform.databse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.sform.model.User;

@Component
public class Database {
	
	//connecting Database class with the bean which we created in the srvlet.xml
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired		//auto wired is used for DataSource which is send as a parameter
	public void setDataSource(DataSource dataSource) {
		jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public int insertUser(User user) {
		//for preventing sql injections we send data to the query using hash maps
		Map <String,Object> map = new HashMap<>();
		map.put("name", user.getName());
		map.put("username", user.getUsername());
		map.put("password", user.getPassword());
		
		String sql = "insert into user(name,username,password) values(:name,:username,:password)";
		
		return jdbc.update(sql, map);
	}
	
	public int updateUser(User user) {
		Map<String,Object> map = new HashMap<>();
		map.put("id", user.getId());
		map.put("password",user.getPassword());
		String sql = "update user set password=:password where id=:id";
		return jdbc.update(sql, map);
	}
	
	public int deleteUser(User user) {
		Map<String,Object> map = new HashMap<>();
		map.put("id", user.getId());
		String sql = "delete from user where id=:id";
		return jdbc.update(sql, map);
	}
	
	public List<User> fetchUsers() {
		RowMapper<User> mapper = new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
			
		};
		String sql = "select * from user";
		return jdbc.query(sql, mapper);
	}

}
