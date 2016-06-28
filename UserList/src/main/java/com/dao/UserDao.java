package com.dao;

import java.util.List;

import com.dto.UserDto;

public interface UserDao {
	public List<UserDto> list();
	public void remove(int id);
	public UserDto getById(int id);
	public int update (UserDto dto);
	

}
