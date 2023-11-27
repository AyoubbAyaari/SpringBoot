package com.ayoub.users.service;

import com.ayoub.users.entities.Role;
import com.ayoub.users.entities.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ayoub.users.entities.Role;
import com.ayoub.users.entities.User;
import com.ayoub.users.repos.RoleRepository;
import com.ayoub.users.repos.UserRepository;
@Transactional
@Service

public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRep;
	@Autowired
	RoleRepository roleRep;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRep.save(user);

	}
	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRep.findByUsername(username);

	}
	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return roleRep.save(role);

	}
	@Override
	public User addRoleToUser(String username, String rolename) {
		// TODO Auto-generated method stub
		User usr = userRep.findByUsername(username);
		Role r = roleRep.findByRole(rolename);
		usr.getRoles().add(r);
		return usr;
	}
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRep.findAll();
	}


}
