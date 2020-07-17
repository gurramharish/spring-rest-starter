package com.hans.srs.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hans.srs.exception.SRSException;
import com.hans.srs.model.UserResponse;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/{emailId}/{userId}")
	public ResponseEntity<UserResponse> getUserByEmailAndId(@PathVariable String userId, @PathVariable String emailId,
			HttpServletRequest request) {
		if (!"ghk@gmail.com".equals(emailId)) {
			throw new SRSException("User not found", HttpStatus.NOT_FOUND, "1000");
		}
		System.out.println("Email id :: " + emailId);
		System.out.println("User id :: " + userId);
		String email = emailId.toUpperCase();
		UserResponse userResponse = new UserResponse("Harish Kumar", 30, "+13322992938", email);
		return ResponseEntity.ok(userResponse);

	}

	@DeleteMapping("/{userName}")
	public ResponseEntity<Object> deleteUser(@PathVariable String userName) {
		List<String> userNames = new ArrayList<String>(5);
		userNames.addAll(Arrays.asList("Harish", "Sai", "Kiran", "Karthik", "Anand"));
		if (userNames.contains(userName)) {
			userNames.remove(userName);
			Map<String, String> deleteResponse = new HashMap<String, String>(2);
			deleteResponse.put("userName", userName);
			deleteResponse.put("statusMessage", "Deleted successfully");
			deleteResponse.put("statusCode", "0000");
			return ResponseEntity.ok(deleteResponse);
		} else {
			throw new SRSException("User name not in the list", HttpStatus.NOT_FOUND, "1001");
		}
	}

}
