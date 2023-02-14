package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.DateFormate;

@Repository
public interface DateRepository extends JpaRepository<DateFormate, Integer>{

}
