package com.te.carapplication.dao;

import org.springframework.data.repository.CrudRepository;
import com.te.carapplication.dto.UserApp;

public interface UserDao extends CrudRepository<UserApp, Integer> {

	public UserApp findByUsername(String username);
}
