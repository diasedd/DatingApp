package com.iiht.training.datingapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dislikes")
public class Dislike {

	@Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;    
	private Long userId;
	private Long dislikedUserId;

	public Dislike() {
	}

	public Dislike(Long userId, Long dislikedUserId) {
		this.userId = userId;
		this.dislikedUserId = dislikedUserId;
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

	public Long getDislikedUserId() {
		return dislikedUserId;
	}

	public void setDislikedUserId(Long dislikedUserId) {
		this.dislikedUserId = dislikedUserId;
	}

}
