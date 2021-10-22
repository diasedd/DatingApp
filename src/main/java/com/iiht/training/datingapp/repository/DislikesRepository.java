package com.iiht.training.datingapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.iiht.training.datingapp.entity.Dislike;


@Repository
public interface DislikesRepository extends CrudRepository<Dislike, Long> {

    @Modifying
    @Query("SELECT d FROM Dislike d WHERE d.dislikedUserId = :userId")
    List<Dislike> getAllDislikedUsers(@Param("userId") Long userId);
}