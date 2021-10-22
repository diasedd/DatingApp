package com.iiht.training.datingapp.dto;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class InterestsDto {

	private Long interestId;
	
	private Long userId;
    
    @NotNull
    @Length(min = 3, max = 100)
	private String interestedIn;

    @NotNull
    @Length(min = 3, max = 100)    
	private String notInterestedIn;
    
    @NotNull
	private List<String> hobbies;
    
    @NotNull
	private String profileUrl;
    
    @Length(min = 3, max = 100)
    @NotNull
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

	@Override
	public int hashCode() {
		return Objects.hash(about, hobbies, interestId, interestedIn, notInterestedIn, profileUrl, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InterestsDto other = (InterestsDto) obj;
		return Objects.equals(about, other.about) && Objects.equals(hobbies, other.hobbies)
				&& Objects.equals(interestId, other.interestId) && Objects.equals(interestedIn, other.interestedIn)
				&& Objects.equals(notInterestedIn, other.notInterestedIn)
				&& Objects.equals(profileUrl, other.profileUrl) && Objects.equals(userId, other.userId);
	}

}
