package com.iiht.training.datingapp.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;

public class MatchDto {

	@NotNull
	private Long id;
	@NotNull
	private Long userId;
	@NotNull
	private Long matchedUserId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMatchedUserId() {
		return matchedUserId;
	}

	public void setMatchedUserId(Long matchedUserId) {
		this.matchedUserId = matchedUserId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, matchedUserId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatchDto other = (MatchDto) obj;
		return Objects.equals(id, other.id) && Objects.equals(matchedUserId, other.matchedUserId)
				&& Objects.equals(userId, other.userId);
	}
	
	
}
