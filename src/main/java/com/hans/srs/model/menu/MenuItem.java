package com.hans.srs.model.menu;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class MenuItem {

	private String label;
	private Long id;
	private Boolean isActive;
	private String target;
	private String link;
	@JsonIgnore
	private Long parentId;
	private List<MenuItem> menu;
	
	/*
	 * { label: "Home", id: 900, isActive: true, target: "_self", link: "#", menu:
	 * [{ label: "Sub Home", id: 900, isActive: true, target: "_self", link:
	 * "/sub-home", menu: [{ label: "Sub Sub Home", id: 900, isActive: true, target:
	 * "_self", link: "#", }] }] }
	 */

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public List<MenuItem> getMenu() {
		return menu;
	}

	public void setMenu(List<MenuItem> menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{id :" + id + ", label: " + label + ", link: " +link + ", parentId: " + parentId + ", menu: " + menu +"}";
	}
}
