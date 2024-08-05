package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.User;
import com.nt.repo.IPersonRepo;

@Service
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private IPersonRepo person;

	@Override
	public Iterable<User> findAllpersons() {
		Iterable<User> user=person.findAll();
		return user;
	}

	@Override
	public void savedata(User user) {
		person.save(user);
		
	}

	@Override
	public User getUserForUpdate(int id) {
		User user=person.findById(id).orElseThrow(()->new IllegalArgumentException());
		return user;
	}

	@Override
	public void DeleteUserById(int id) {
		person.deleteById(id);
	}

}
