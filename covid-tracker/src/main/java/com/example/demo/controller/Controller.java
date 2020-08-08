package com.example.demo.controller;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Covid;
import com.example.demo.model.UserInfo;
import com.example.demo.repository.CovidRepository;
import com.example.demo.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Covid Controller")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/covid")
public class Controller {
	public UserInfo user;
	public byte[] code;
	public String key;
	
	
	@Autowired
	 CovidRepository repo ;
	@Autowired
	 UserRepository userrepo;
	

	@ApiOperation(value = "Login Api")
	@PostMapping("/login")
	public String login( @RequestBody UserInfo info ) {
		user=info;
		Optional<UserInfo> optionaluser;
		optionaluser=userrepo.findByUsernameAndPassword(info.getUsername(),info.getPassword());
		if(optionaluser.isEmpty()) {
			return "WRONG";
		}
		else {
				key=user.getUsername()+user.getPassword();
				code = Base64.getEncoder().encode(key.getBytes());
				return new String(code);
		}
			
	}
	
	
	@ApiOperation(value = "Data service Api")
	@GetMapping("/{id1}/{id2}")
	public String getinfo( @PathVariable int id1, @PathVariable int id2, @RequestHeader("Authorization") String secure )
	{ 
		byte[] byteArray = secure.getBytes();
		byte[] decodedBytes = Base64.getDecoder().decode(byteArray);
		String decrypt= new String(decodedBytes);
		
		
		if (decrypt.equals(key)) {
		Optional<Covid> optionalCovid;
		
		optionalCovid=repo.findById(id1);
		
		Covid covid = optionalCovid.get();
		
		switch (id2) {
		case 1: 
			return covid.getLastOneDay();
		case 2: 
			return covid.getLastTwoDays();
		case 3: 
			return covid.getLastThreeDays();
		case 4: 
			return covid.getLastFourDays();
		case 5: 
			return covid.getLastFiveDays();
		case 6: 
			return covid.getLastSixDays();
		case 7: 
			return covid.getLastWeek();
		case 10: 
			return covid.getLastTenDays();
		case 15: 
			return covid.getLastFifteenDays();
		case 20:
			return covid.getLastTwentyDays();
		case 30:
			return covid.getLastMonth();
		default:
			return "ID  not found";
			
		}
		}
		else {
			return "Unauthorized Access";

		}
		
	}
}
