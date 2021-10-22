package com.iiht.training.datingapp.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;

public class LikeDto {


	private Long id;
	@NotNull
	private Long userId;
    @NotNull
	private Long likedUserId;

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

	public Long getLikedUserId() {
		return likedUserId;
	}

	public void setLikedUserId(Long likedUserId) {
		this.likedUserId = likedUserId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, likedUserId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LikeDto other = (LikeDto) obj;
		return Objects.equals(id, other.id) && Objects.equals(likedUserId, other.likedUserId)
				&& Objects.equals(userId, other.userId);
	}
	
	
}
