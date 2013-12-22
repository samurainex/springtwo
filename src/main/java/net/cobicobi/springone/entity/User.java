package net.cobicobi.springone.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "user_data")
@NamedQuery(name = "User.findByUsername", query = "select u from User u where username = :username")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Basic(optional=false)
	@Column(length=32, unique=true, nullable=false)
	private String username;
	
	@Basic(optional=false)
	@Column(length=40, nullable=false)
	private String password;
	
	@Basic(optional=false)
	@Column(length=100, nullable=false)
	private String name;
	
	@Basic(optional=false)
	@Column(length=100, nullable=false)
	private String email;
	
}
