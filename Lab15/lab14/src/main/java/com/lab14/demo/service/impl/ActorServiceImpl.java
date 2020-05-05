package com.lab14.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab14.demo.domain.Actor;
import com.lab14.demo.response.ActorResponse;

import edu.miu.common.service.BaseReadServiceImpl;

@Service
@Transactional
public class ActorServiceImpl extends BaseReadServiceImpl<ActorResponse, Actor, Short> {
		
}
