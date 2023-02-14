package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Location;
import com.app.model.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired UserService userService;
	
	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		System.out.println("Hii Nitesh");
		User u=userService.saveUser(user);
		
		return new ResponseEntity<>(u,HttpStatus.CREATED);
	}
	
	@PostMapping("/saveLocation")
	public ResponseEntity<Location> saveLocation(@RequestBody Location location){
		Location u=userService.saveLocation(location);
		
		return new ResponseEntity<>(u,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getUser(){
		return new ResponseEntity<List<User>>(userService.getUser(),HttpStatus.OK);
	}
	
	@GetMapping("/getAlllocation")
	public ResponseEntity<List<Location>> getlocation(){
		return new ResponseEntity<List<Location>>(userService.getlocation(),HttpStatus.OK);
	}
	
	@GetMapping("/getLocationByName")
	public ResponseEntity<Location> getLocationByName(@RequestParam ("locName") String locName){
		System.out.println("In Controller"+locName);
		Location l=userService.getLocationByName(locName);
		return new ResponseEntity<Location>(l,HttpStatus.FOUND);
	}
	
//	@GetMapping("/getLocationByName/{locName}")
//	public ResponseEntity<Location> getLocationByName(@PathVariable String locName){
//		System.out.println("In Controller"+locName);
//		Location l=userService.getLocationByName(locName);
//		return new ResponseEntity<Location>(l,HttpStatus.FOUND);
//	}
	
	@PostMapping("/saveUserWithLocation/{locName}")
	public ResponseEntity<User> saveUserWithLocation(@RequestBody User user,@PathVariable String locName){
		
		List<Location> list=userService.getlocation();
		System.out.println(list);
		
		for(Location l:list) {
//			List<Location> local=new ArrayList<>();
			if(l.getLocName().equals(locName)) {			
				
				user.setLocation(l);
			}
		}
		User u=userService.saveUserWithLocation(user);
		return new ResponseEntity<User>(u,HttpStatus.CREATED);
	}
	
//	@GetMapping("/getUserByLocationName/{locName}")
//	public ResponseEntity<User> getUserByLocationName(@PathVariable String locName){
//		Location l=userService.getLocationByName(locName);
//		
//			return new ResponseEntity<User>(userService.getUser(),HttpStatus.OK);
//
//	}
	
//	@GetMapping("/getUserByLocationName/{locName}")
//	public ResponseEntity<User> getUserByLocationName(@PathVariable String locName){
//		User l=userService.getUserByLocationName(locName);
//		return new ResponseEntity<User>(l,HttpStatus.FOUND);
//	}

	@GetMapping("/getUserByLocationName/{locName}")
	public ResponseEntity<List<User>> getUserByLocationId(@PathVariable String locName){
		
		List<User> user=userService.getUser();
		System.out.println("user in method: "+user);
		
		List<User> local=new ArrayList<>();
		for(User u:user) {
			System.out.println(u);
				if(u.getLocation().getLocName().equalsIgnoreCase(locName)) {
					System.out.println("in condition : "+u);
					local.add(u);					
				}
				
			}
		return new ResponseEntity<>(local,HttpStatus.FOUND);
	}
	
	@GetMapping("/byId")
	public List<User> getUser(@RequestParam int userid){
		List<User> list=userService.getUser(userid);
		return list;
	}
	
	@DeleteMapping("/delete")
	public String deleteData(@RequestParam("userid") int userid,@RequestParam("locName") String locName) {
		List<User> list=userService.getUser(userid);
		for(User l:list) {
			if(l.getLocation().getLocName().equals(locName)) {
				userService.deleteData1(userid);
				return "deleted successfully";
				}
			else {
				System.out.println("enter valid location name");
			}			
		}
		return "provide valid location name";
	}
	
	@DeleteMapping("/delete1")
	public String deleteData1(@RequestParam("userid") int userid) {
		userService.deleteData1(userid);
		return "deleted controller class";
	}
	
	
	
	
	
	
	
	
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFile(@RequestParam("fileName") String fileName,
//            @RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
//
//        String message = "";
//        try {
//            String entityType = request.getParameter(ENTITY_TYPE);
//            String id = request.getParameter("id");
//            String path = getPathV2(entityType, id);
//            fileStoreManager.save(file, path, fileName);
//
//            message = "Uploaded the file successfully: " + file.getOriginalFilename();
//            return ResponseEntity.status(HttpStatus.OK).body(message);
//        } catch (Exception e) {
//            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
//        }
//    }

}
