package com.hans.srs.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hans.srs.entity.CodeSet;

public interface CodeSetRepository extends CrudRepository<CodeSet, Long> {

	public Optional<CodeSet> findByName(String name);
}
