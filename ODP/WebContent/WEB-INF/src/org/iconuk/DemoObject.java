package org.iconuk;

import java.io.Serializable;

public class DemoObject implements Serializable {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String city;
	private int age;

	public DemoObject() {

	}

	public DemoObject(String fname, String lname, String city, int age) {
		setFirstName(fname);
		setLastName(lname);
		setCity(city);
		setAge(age);
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
