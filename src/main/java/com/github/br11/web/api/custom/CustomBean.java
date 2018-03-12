package com.github.br11.web.api.custom;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomBean implements Serializable {

	private static final long serialVersionUID = 5007294747405350870L;

	private Long id;
	private String name;
	private Date admission;
	private Double salary;

	public CustomBean() {
		this(null, null, null);
	}

	public CustomBean(String name, Date admission, Double salary) {
		this(null, name, admission, salary);
	}

	public CustomBean(Long id, String name, Date adimission, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.admission = adimission;
		this.salary = salary;
	}

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

	public Date getAdmission() {
		return admission;
	}

	public CustomBean setAdmission(Date adimission) {
		this.admission = adimission;
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
