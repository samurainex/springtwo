package net.cobicobi.springone.service;

import net.cobicobi.springone.entity.User;

public interface UserService extends BaseService<User>{
	
	public User getByUsername(String username);
	
	public User getByEmail(String email);
	
}
