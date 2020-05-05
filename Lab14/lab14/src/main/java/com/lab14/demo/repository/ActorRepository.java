package com.lab14.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab14.demo.domain.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
