package com.system.danp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.system.danp.model.PushNotificationRequest;
import com.system.danp.service.PushNotificationService;

@Controller
public class MainController {
	
	private PushNotificationService pushNotificationService;
	
	//Aperturamos indice
	@GetMapping({"/","/index"})
	public String index() {
		return "index.html";
	}
	
	//Enviamos el mensaje
	@PostMapping({"/result"})
	public String result(@ModelAttribute("request")PushNotificationRequest request) {
		System.out.println(request.getTitle());
		pushNotificationService.sendPushNotificationToToken(request);
		return "result.html";
	}

}
