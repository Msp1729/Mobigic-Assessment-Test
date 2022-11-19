package com.metiit.mobigic.Service;

import java.util.List;

import com.metiit.mobigic.Dto.LoginRequest;
import com.metiit.mobigic.Entity.Users;



public interface IUserService {

	Users registerOrEditUser(Users user);// R

	Users findByEmail(String email);// R

	Users findById(Integer id);// R
//
	Users edit(Users user, int userId);// R
//
	String deleteUserById(Integer uid);// R
//
	List<Users> getUserByName(String fname);
//
	Users getUserByEmail(String Email);

	int countUsers();

	List<Users> fetchUsers();

	public Users findByEmailAndPassword(String email, String password);

	public Users disableUser(Users user, int id);
//
	public Users enableUser(Users user, int id);
	
	public void updateUser(Users user);

	public int findByNewEmailandPassword(LoginRequest request);

	
}
