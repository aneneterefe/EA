package com.lab14.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab14.demo.domain.Actor;
import com.lab14.demo.response.ActorResponse;

import edu.miu.common.controller.BaseReadController;

@RestController
@RequestMapping(value = {"/"})
public class ActorController extends BaseReadController<ActorResponse, Actor, Short> {

}
