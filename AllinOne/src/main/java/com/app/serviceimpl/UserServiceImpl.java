package com.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Location;
import com.app.model.User;
import com.app.repository.LocationRepository;
import com.app.repository.UserRepository;
import com.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired UserRepository userRepository;
	@Autowired LocationRepository locationRepository;
	
	@Override
	public User saveUser(User user) {		
		return userRepository.save(user);
	}

	@Override
	public Location saveLocation(Location location) {
		
		return locationRepository.save(location) ;
	}

	@Override
	public List<User> getUser() {
		
		return userRepository.findAll();
	}

	@Override
	public List<Location> getlocation() {
		
		return locationRepository.findAll();
	}

	@Override
	public User saveUserWithLocation(User user) {
		return userRepository.save(user);
	}

	@Override
	public Location getLocationByName(String locName) {
			System.out.println(locName);
		return locationRepository.getLocationName(locName);
	}

	@Override
	public List<User> getUser(int userid) {
		return userRepository.findByUserid(userid);	
	}
	
	@Override
	public String deleteData(int userid, String locName) {

		return "deleted";		
	}
	
	@Override
	public String deleteData1(int userid) {		
		userRepository.deleteById(userid);	
		return "deleted";
	}


}
