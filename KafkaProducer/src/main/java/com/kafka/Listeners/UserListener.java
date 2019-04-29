package com.kafka.Listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.model.User;

@RestController
@RequestMapping("kafka")
public class UserListener {

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	private static final String TOPIC = "livan_test";

	@GetMapping("/publish/{name}")
	private String postTheData(@PathVariable("name") final String name) {

		kafkaTemplate.send(TOPIC, new User(name, "ASD", "livan@CTS.com"));

		return "produce Successfully";

	}
}
