package com.hans.srs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hans.srs.model.menu.MenuItem;
import com.hans.srs.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;

	@GetMapping
	public ResponseEntity<List<MenuItem>> getMenuByRole(HttpServletRequest request) {
		String roleName = request.getHeader("x-role-name");
		return ResponseEntity.ok(menuService.getMenuByRoleName(roleName));
	}
}
