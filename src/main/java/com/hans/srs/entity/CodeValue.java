package com.hans.srs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "SRS_CODE_VALUES", uniqueConstraints = {
		@UniqueConstraint(name="UNQ_CODE_NAME_SET_KEY", columnNames = { "CODE_NAME", "CODE_SET_ID" }) })
public class CodeValue {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CODE_NAME", length = 150)
	private String name;

	@Column(name = "CODE_VALUE", length = 50)
	private String value;

	@Column(name = "CV_DESCRIPTION")
	private String description;

	@ManyToOne
	@JoinColumn(name = "CODE_SET_ID")
	private CodeSet codeSet;

	public CodeValue() {

	}

	public CodeValue(String name, String value, String description, CodeSet codeSet) {
		super();
		this.name = name;
		this.value = value;
		this.description = description;
		this.codeSet = codeSet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CodeSet getCodeSet() {
		return codeSet;
	}

	public void setCodeSet(CodeSet codeSet) {
		this.codeSet = codeSet;
	}
}
