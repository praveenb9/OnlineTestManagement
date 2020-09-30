package com.capg.otms.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.otms.user.model.User;

public interface IUserRepo extends JpaRepository<User, Long> {
	
	public User getByUserName(String userName);

}
