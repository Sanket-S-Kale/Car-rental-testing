package com.gomavs.rental.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gomavs.rental.models.Users;

public interface UsersRepo extends CrudRepository<Users, String>{
	
	List<Users> findAll();
}
