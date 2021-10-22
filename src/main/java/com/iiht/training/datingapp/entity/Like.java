package com.iiht.training.datingapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="likes")
public class Like {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
	private Long userId;
	private Long likedUserId; 

	public Like() {
	}

	public Like(Long userId, Long likedUserId) {
		this.userId = userId;
		this.likedUserId = likedUserId;
	}

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
}