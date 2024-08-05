package com.nt.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Users")
@Data
public class User {

	@Column(name="id")
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "emp_id_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1" ,strategy =  GenerationType.SEQUENCE)
	private Integer id;

	@Column(name="name", length=20)
	@NonNull
	private String name;

	@Column(name="email", length=20)
	@NonNull
	private String email;

	@Column(name="contact", length=20)
	@NonNull
	private String contact;

	@Column(name="addrs", length=20)
	@NonNull
	private String addrs;



}
