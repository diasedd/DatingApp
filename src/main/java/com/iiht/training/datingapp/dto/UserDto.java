package com.iiht.training.datingapp.dto;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UserDto {

	@NotNull
	private Long userId;
	@NotBlank
	@Length(min = 3, max = 100)
	private String name;
	@NotNull
	@Min(18)
	@Max(60)
	private Integer age;
	@NotNull
	@Min(1000000000)
	@Max(9999999999L)
	private Long phoneNumber;
	@NotBlank
	private String gender;
	@NotBlank
    @Email
    @Length(min = 3, max = 100)
	private String email;
	@NotBlank
	private String city;
	@NotBlank
	private String country;

	public UserDto() {
	}

	public UserDto(Long userId, String name, Integer age, Long phoneNumber, String gender, String email, String city,
			String country) {
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.email = email;
		this.city = city;
		this.country = country;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, city, country, email, gender, name, phoneNumber, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return Objects.equals(age, other.age) && Objects.equals(city, other.city)
				&& Objects.equals(country, other.country) && Objects.equals(email, other.email)
				&& Objects.equals(gender, other.gender) && Objects.equals(name, other.name)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(userId, other.userId);
	}

}
