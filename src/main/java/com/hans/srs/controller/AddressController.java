package com.hans.srs.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

	
	@GetMapping
	public ResponseEntity<Object> getAllAddress() {
		Map<String, String> addressMap = new HashMap<String, String>();
		addressMap.put("street", "YX ST");
		return ResponseEntity.ok(addressMap);
	}
}
