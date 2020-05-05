package com.lab14.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab14.demo.domain.Actor;
import com.lab14.demo.service.ActorService;

@RestController
@RequestMapping(value = {"/"})
public class ActorController {

	private ActorService actorService;
	
	@Autowired
	public ActorController(ActorService actorService) {
		// TODO Auto-generated constructor stub
		this.actorService=actorService;
	}
	
	@GetMapping(value = "/")
	public List<Actor> getActors() {	
		return actorService.getAllActor();
	}	
	
	@PostMapping(value="/save")
	public Actor addActor(@RequestBody Actor actor) {
		return actorService.saveActor(actor);
	}
	
	@PutMapping(value="/update/{actorId}")
	public Actor update(@RequestBody Actor actor, @PathVariable Integer actorId) {
		return actorService.updateActor(actorId, actor);
	}
	
	@DeleteMapping("/delete/{actorId}")
	public void delete(@PathVariable Integer actorId) {
		actorService.deleteActor(actorId);
	}
}
