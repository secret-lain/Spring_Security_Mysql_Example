package main.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import main.dto.UserDto;

@Repository
public class MysqlDao {
	@Autowired
	@Qualifier("sqlSessionTemplate")
	SqlSessionTemplate session;
	
	public UserDto getUserById(String id) {
		UserDto user = session.selectOne("user.userSelect", id);
		return user;
	}

}
