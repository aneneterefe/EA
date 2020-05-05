package com.lab14.demo.repository;

import org.springframework.stereotype.Repository;

import com.lab14.demo.domain.Actor;

import edu.miu.common.repository.BaseRepository;

@Repository
public interface ActorRepository extends BaseRepository<Actor, Short> {

}
