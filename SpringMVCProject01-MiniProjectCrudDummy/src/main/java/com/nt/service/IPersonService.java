package com.nt.service;

import com.nt.entity.User;

public interface IPersonService {

	public Iterable<User> findAllpersons();
	
	public void savedata(User user);
	
	public User getUserForUpdate(int id);
	
	public void DeleteUserById(int id);

}
