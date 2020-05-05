package com.lab14.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lab14.demo.domain.Actor;

public interface ActorService {

	public abstract Actor saveActor(Actor actor);
	public abstract List<Actor> getAllActor();
	public abstract Actor updateActor(Integer Id, Actor actor);
	public abstract void deleteActor(Integer id);
}
