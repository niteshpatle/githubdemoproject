package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findByUserid(int userid);
}
