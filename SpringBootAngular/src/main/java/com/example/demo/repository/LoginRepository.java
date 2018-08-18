package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{

	@Query("select count(*) from Login where userName = :userName and password = :password")
	public Integer findByUserNameAndPassword(@Param("userName") String userName,@Param("password") String password);
}
