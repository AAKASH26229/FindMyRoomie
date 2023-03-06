package com.springrest.roommateapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.roommateapp.dao.UserDao;
import com.springrest.roommateapp.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	 
	
//	List<User> list;
	
	public UserServiceImpl() {
		
//		list=new ArrayList<>();
//		list.add(new User(101, "Akash", "Parate", "Male", "16-07-1998", "996436943217", "Bhilai",
//				"Chhattisgarh", "Working", "domain@gmail.com", "9928892221", "admin", "admin@123"));
//		list.add(new User(102, "Chirag", "Goyal", "Male", "16-08-1994", "996436942317", "Noida",
//				"UP", "Working", "domain@gmail.com", "8828892221", "chirag", "chirag@123"));
	}
	
	
	@Override
	public List<User> getUsers() {
		return userDao.findAll();
	}


	@Override
	public User getUser(long userId) {
		
		
		
//		User u=null;
//		for(User user:list)
//		{
//			if(user.getUserid()==userId)
//			{
//				u=user;
//				break;
//			}
//		}
//		
		return userDao.getOne(userId);
	}


	@Override
	public User addUser(User user) {
//		list.add(user);
		userDao.save(user);
		return user;
	}


	@Override
	public User updateUser(User user) {
		
//		list.forEach(e -> {
//			if(e.getUserid()==user.getUserid()) {
//				e.setFname(user.getFname());
//				e.setLname(user.getLname());
//				e.setGender(user.getGender());
//				e.setDob(user.getDob());
//				e.setAadhar(user.getAadhar());
//				e.setCity(user.getCity());
//				e.setState(user.getState());
//				e.setRole(user.getRole());
//				e.setEmail(user.getEmail());
//				e.setMobile(user.getMobile());
//				e.setUsername(user.getUsername());
//				e.setPassword(user.getPassword());
//				
//			}
//		});
		
		userDao.save(user);
		
		return user;
	}


	@Override
	public void deleteUser(long parseLong) {
		
//		list=this.list.stream().filter(e->e.getUserid()!=parseLong).collect(Collectors.toList());
	
		User entity = userDao.getOne(parseLong);
		userDao.delete(entity);
	}

}
