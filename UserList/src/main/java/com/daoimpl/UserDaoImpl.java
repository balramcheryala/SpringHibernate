package com.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.dto.UserDto;
@Repository("listuser")
public class UserDaoImpl implements UserDao{

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Resource(name="sessionFactory")
	private SessionFactory factory;
	
	public List<UserDto> list() {
		System.out.println("printing list");
		Session session=this.factory.openSession();
		
		@SuppressWarnings("unchecked")
		List<UserDto> list=session.createQuery("from UserDto").list();
		System.out.println("list of user"+list);
		
		for(UserDto d:list)
		{
			logger.info("list of user"+d);
		}
		return list;
	}
	
	public void remove(int id) {
	
		Session session=this.factory.openSession();
		
		session.beginTransaction();
		UserDto dto=(UserDto)session.load(UserDto.class, new Integer(id));
		
		if(null!=dto)
		{
			System.out.println("in if");
			session.delete(dto);
		}
		
		logger.info("successfully deleted"+dto);
		session.getTransaction().commit();
		
	}

	public UserDto getById(int id) {
		Session session=factory.openSession();
		UserDto dto=(UserDto)session.load(UserDto.class, new Integer (id));
		return dto;
	}
	
	public int update(UserDto dto) {
		
		Session session=factory.openSession();
		System.out.println("update session "+session);
		session.beginTransaction();
		session.update(dto);
	
		Serializable ser=session.getIdentifier(dto);
		System.out.println("update serializable"+ser);
		session.getTransaction().commit();
		return (Integer) ser;
		
	}

}
