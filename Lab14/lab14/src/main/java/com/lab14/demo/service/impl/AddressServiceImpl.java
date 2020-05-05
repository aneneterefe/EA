package com.lab14.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lab14.demo.domain.Actor;
import com.lab14.demo.repository.ActorRepository;
import com.lab14.demo.service.ActorService;

@Service
public class AddressServiceImpl implements ActorService {

	private ActorRepository actorRepository;

	@Autowired
	public AddressServiceImpl(ActorRepository actorRepository) {
		// TODO Auto-generated constructor stub
		this.actorRepository = actorRepository;
	}

	@Override
	public Actor saveActor(Actor actor) {
		// TODO Auto-generated method stub
		return actorRepository.save(actor);
	}

	@Override
	public List<Actor> getAllActor() {
		// TODO Auto-generated method stub
		return actorRepository.findAll();
	}

	@Override
	public Actor updateActor(Integer Id, Actor actor) {
		// TODO Auto-generated method stub
		return actorRepository.findById(Id)
                .map(actorToUpdate -> {
                	actorToUpdate.setFirst_name(actor.getFirst_name());
                	actorToUpdate.setLast_name(actor.getLast_name());
                return actorRepository.save(actorToUpdate);
               }).orElseGet(() -> {
                    return actorRepository.save(actor);
                });
	}

	@Override
	public void deleteActor(Integer id) {
		// TODO Auto-generated method stub
		actorRepository.deleteById(id);
	}

	
}
