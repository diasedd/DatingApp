package com.iiht.training.datingapp.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.iiht.training.datingapp.entity.Interests;

@Repository
public interface InterestsRepository extends CrudRepository<Interests, Long> {

	@Modifying
    @Query("SELECT i FROM Interests i WHERE i.userId = :userId")
	List<Interests> findByUserId(@Param("userId") Long userId);
}
