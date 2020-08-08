package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo,Integer> {
	
	public Optional<UserInfo> findByUsernameAndPassword( String Username, String Password ) ;

}
