package com.app.service;

import java.util.List;

import com.app.model.Location;
import com.app.model.User;

public interface UserService {

	User saveUser(User user);

	Location saveLocation(Location location);

	List<User> getUser();

	List<Location> getlocation();

	User saveUserWithLocation(User user);

	Location getLocationByName(String locName);

	String deleteData(int userid, String locName);

	List<User> getUser(int userid);

	public String deleteData1(int userid);
//	User getUserByLocationName(String locName);

}
