package com.hans.srs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "REF_MENU")
@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "MenuEntity.findMenuByRoleName",
				query = "SELECT rm.* FROM SRS.REF_MENU rm INNER JOIN SRS.REF_ROLES_MENU rrm " + 
						"on rm.id = rrm.menu_id INNER JOIN SRS.REF_ROLES rr on rr.id = rrm.role_id " + 
						"where rr.role_name = ?1 and rm.active = 'Y' ORDER BY rm.link_level, rm.link_order",
						resultClass = MenuEntity.class)
})
public class MenuEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String label;
	private String link;
	private Character active;
	@Column(name = "LINK_TARGET")
	private String target;
	@Column(name = "LINK_LEVEL")
	private Integer level;
	@Column(name = "LINK_ORDER")
	private Integer order;
	@Column(name = "PARENT_ID")
	private Long parentId;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Character getActive() {
		return active;
	}

	public void setActive(Character active) {
		this.active = active;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
