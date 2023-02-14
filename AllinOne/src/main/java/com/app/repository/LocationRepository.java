package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Location;
import com.app.model.User;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

	@Query(value = "SELECT * from location where loc_name=:locName",nativeQuery = true)
	public Location getLocationName(String locName);
	
//	@Query(value = "SELECT * from user where loc_name=:locName",nativeQuery = true)
//	public User getUserWithLocationName(String locName);

}
