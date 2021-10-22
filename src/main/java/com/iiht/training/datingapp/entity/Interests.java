package com.iiht.training.datingapp.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "interests")
public class Interests {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long interestId;
	private Long userId;
	private String interestedIn;
	private String notInterestedIn;
	@ElementCollection
	private List<String> hobbies;
	private String profileUrl;
	private String about;

	public Long getInterestId() {
		return interestId;
	}

	public void setInterestId(Long interestId) {
		this.interestId = interestId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getInterestedIn() {
		return interestedIn;
	}

	public void setInterestedIn(String interestedIn) {
		this.interestedIn = interestedIn;
	}

	public String getNotInterestedIn() {
		return notInterestedIn;
	}

	public void setNotInterestedIn(String notInterestedIn) {
		this.notInterestedIn = notInterestedIn;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

}
