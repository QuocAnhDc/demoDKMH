package com.example.demodkmh.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name =  "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Users {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String email;
	
	private String password;

	private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(
		            name = "user_id"),
			inverseJoinColumns = @JoinColumn(
				            name = "role_id"))
	private Set<Roles> roles = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "dkmh",
			joinColumns = @JoinColumn(
					name = "user_id"),
			inverseJoinColumns = @JoinColumn(
					name = "subject_id"))
	private Set<Subjects> subjects = new HashSet<>();

	public Users() {
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public Set<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subjects> subjects) {
		this.subjects = subjects;
	}

	public void addRole(Roles roles){
		this.roles.add(roles);
	}
	public void addSubject(Subjects subjects){
		this.subjects.add(subjects);
	}
	public void deleteSubject(Subjects subjects){this.subjects.remove(subjects);}
}
