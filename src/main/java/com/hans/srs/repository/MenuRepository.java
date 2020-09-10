package com.hans.srs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hans.srs.entity.MenuEntity;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

	public List<MenuEntity> findMenuByRoleName(String roleName);
}
