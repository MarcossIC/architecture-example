package com.architecture.mvc.controller;

import com.architecture.mvc.model.ServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContextController {
    public ServicePort service;

    @Autowired
    public ContextController(ServicePort service){
        this.service = service;
    }

    @GetMapping(value = "/")
    public String index(){
        var context = service.getContext();

        return "index.html";
    }

}
