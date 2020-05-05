package com.lab14.demo.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lab14.demo.domain.Actor;
import com.lab14.demo.response.ActorResponse;

import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;

@Component
public class ActorResponseMapper extends BaseMapper<Actor, ActorResponse> {

	@Autowired
	public ActorResponseMapper(MapperFactory mapperFactory) {
		super(mapperFactory, Actor.class, ActorResponse.class);
		// TODO Auto-generated constructor stub
	}

}
