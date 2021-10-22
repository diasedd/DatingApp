package com.iiht.training.datingapp.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;

public class DislikeDto {

	private Long id;
	@NotNull
	private Long userId;
	@NotNull
	private Long dislikedUserId;

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

	public Long getDislikedUserId() {
		return dislikedUserId;
	}

	public void setDislikedUserId(Long dislikedUserId) {
		this.dislikedUserId = dislikedUserId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dislikedUserId, id, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DislikeDto other = (DislikeDto) obj;
		return Objects.equals(dislikedUserId, other.dislikedUserId) && Objects.equals(id, other.id)
				&& Objects.equals(userId, other.userId);
	}

	
}
