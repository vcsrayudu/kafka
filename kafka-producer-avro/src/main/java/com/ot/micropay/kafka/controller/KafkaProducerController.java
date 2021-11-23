package com.ot.micropay.kafka.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.github.pnpninja.nsetools.NSETools;
import com.ot.micropay.kafka.model.*;
import com.ot.micropay.kafka.service.ProducerService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {
	@Autowired
    ProducerService producerService;

	@PostMapping(value = "/publish")
	public String sendMessageToKafkaTopic(@RequestBody Student message){
		producerService.sendMessage(message);
		return "Success";
	}
	@GetMapping(value = "/quote")
	public String getQuote(@RequestParam String quote){
		RestTemplate restTemplate =new RestTemplate();
		System.out.println("quote:   "+quote);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Access-Control-Allow-Origin", "*");  
		 headers.set(HttpHeaders.ACCEPT, "*");
		System.setProperty("proxy_host", "10.194.10.21");
	System.setProperty("proxy_port", "3128");
		HttpEntity requestEntity = new HttpEntity<>( headers);
		
		NSETools nse=new NSETools();
		
		ResponseEntity<String> results=restTemplate.exchange("https://www1.nseindia.com/live_market/dynaContent/live_watch/get_quote/GetQuote.jsp?symbol="+quote, HttpMethod.GET, requestEntity, String.class);
		//WebClient webClient=WebClient.builder()
	  //         	            .build();
		
		//ResponseEntity<String> results=webClient.get().uri("http://www.nseindia.com/api/quote-equity?symbol="+quote).exchange().flatMap(r -> r.toEntity(String.class)).block();
        System.out.print(results.getBody());
     //   System.out.print(results.getStatusCodeValue());
		return results.getBody();
		
	}
	
}
