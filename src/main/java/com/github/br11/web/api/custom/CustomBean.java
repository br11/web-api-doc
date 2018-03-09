package com.github.br11.web.api.custom;

import java.io.Serializable;
import java.util.Date;

public class CustomBean implements Serializable {

	private static final long serialVersionUID = 5007294747405350870L;

	private Long id;
	private String name;
	private Date adimission;
	private Double salary;

	public Long getId() {
		return id;
	}

	public CustomBean setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public CustomBean setName(String name) {
		this.name = name;
		return this;
	}

	public Date getAdimission() {
		return adimission;
	}

	public CustomBean setAdimission(Date adimission) {
		this.adimission = adimission;
		return this;
	}

	public Double getSalary() {
		return salary;
	}

	public CustomBean setSalary(Double salary) {
		this.salary = salary;
		return this;
	}
}
