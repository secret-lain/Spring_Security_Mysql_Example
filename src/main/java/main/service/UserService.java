package main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import main.dao.MysqlDao;
import main.dto.UserDto;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	MysqlDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto user = dao.getUserById(username);
		
		if(null == user) {
			throw new UsernameNotFoundException("User Not Found");
		}
		
		return user;
	}
	
}
