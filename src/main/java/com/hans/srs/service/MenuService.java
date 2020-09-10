package com.hans.srs.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hans.srs.entity.MenuEntity;
import com.hans.srs.exception.SRSException;
import com.hans.srs.model.menu.MenuItem;
import com.hans.srs.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private MenuRepository repository;
	
	public List<MenuItem> getMenuByRoleName(String roleName) {
		List<MenuEntity> menuEntities = repository.findMenuByRoleName(roleName);
		return prepareMenuItems(menuEntities, roleName);
	}
	
	private List<MenuItem> prepareMenuItems(List<MenuEntity> menuEntities, String roleName) {
		if(menuEntities != null && menuEntities.size() > 0) {
			Map<Long, MenuItem> menuMap = menuEntities.stream().map(entity -> {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(entity.getId());
				menuItem.setParentId(entity.getParentId());
				menuItem.setLink(entity.getLink());
				menuItem.setLabel(entity.getLabel());
				menuItem.setTarget(entity.getTarget());
				return menuItem;
			}).collect(LinkedHashMap<Long, MenuItem>::new,
					(Map<Long, MenuItem> map1, MenuItem item) -> map1.put(item.getId(), item),
					Map<Long, MenuItem>::putAll);
			System.out.println("Menu Map :: " + menuMap);
			menuMap.values().stream().forEach(item -> {
				if(item.getParentId() != null) {
					if(menuMap.get(item.getParentId()) != null && menuMap.get(item.getParentId()).getMenu() != null) {
						menuMap.get(item.getParentId()).getMenu().add(item);
					} else if(menuMap.get(item.getParentId()) != null) {
						List<MenuItem> subMenu = new ArrayList<>();
						subMenu.add(item);
						menuMap.get(item.getParentId()).setMenu(subMenu);
					}
				}
			});
			List<MenuItem> mainMenu = menuMap.values().stream().filter(item -> item.getParentId() == null)
					.collect(Collectors.toList());
			System.out.println("Final main menu list :: " + mainMenu);
			System.out.println("After preparing the hirearchy map :: " + menuMap);
			return mainMenu;
			
		} else {
			throw new SRSException("No menu data found for the role " + roleName, HttpStatus.BAD_REQUEST);
		}
	}
}
