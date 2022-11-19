package com.metiit.mobigic.Service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metiit.mobigic.Custom_excs.CustomerHandlingException;
import com.metiit.mobigic.Dto.LoginRequest;
import com.metiit.mobigic.Entity.Users;
import com.metiit.mobigic.Repositery.UserDao;



@Service
@Transactional

public class UserServiceImpl implements IUserService{

	@Autowired
	private UserDao userRepo;
	
	@Autowired
	EmailService emailService;
	

	
	public UserServiceImpl() {
		System.out.println("---------- CTOR: "+ getClass().getName() +" -----------");
	}
	
	@Override
	public Users registerOrEditUser(Users user) {
		try
		{
		emailService.sendEmailForNewRegistration(user.getEmail());
		return userRepo.save(user);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			
;		}
		return user;
	}
	
	@Override
	public Users edit(Users user, int userId) {
		user.setPassword(userRepo.findById(userId).get().getPassword());
		user.setId(userId);
		return userRepo.save(user);
	}
		
	
	public Users findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public Users findById(Integer id) {
		return userRepo.findById(id).get();
	}

	@Override
	public String deleteUserById(Integer uid) {
		userRepo.deleteById(uid);
		return "Deleted User with ID: " + uid + " successfully!";
	}
	
	@Override
	public Users getUserByEmail(String email) {
		return userRepo.getUserByEmail(email);
	}
//	
	@Override
	public List<Users> getUserByName(String fname) {
		return userRepo.findByFirstName(fname);
	}
//    
//	
	@Override
	public int countUsers() {
		return (int) userRepo.count();
	}
//
	@Override
	public List<Users> fetchUsers() {
		return userRepo.findAll();
		
	}

	@Override
	public Users findByEmailAndPassword(String email, String password) {
		return userRepo.findByEmailAndPassword(email, password);

	}
	
	@Override
	public Users disableUser(Users user, int id) {
		Users us = userRepo.findById(id).orElseThrow( () -> new CustomerHandlingException("User not found"));
		us.setStatus(user.getStatus());
		userRepo.save(us);
		return us;
	}
	@Override
	public Users enableUser(Users user, int id) {
		Users us = userRepo.findById(id).orElseThrow( () -> new CustomerHandlingException("User not found")); 
		us.setStatus(user.getStatus());
		userRepo.save(us);
		return us;
	}
	
	@Transactional
	public int findByNewEmailandPassword(LoginRequest request) {
	
		try {
			Users user = userRepo.findByEmailAndPassword(request.getEmail(), request.getPassword());
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 5;
		}
		return 0;

	}
	
	public void updateUser(Users user) {
		userRepo.save(user);
	}

	
	
	
	

	
	
		
}
