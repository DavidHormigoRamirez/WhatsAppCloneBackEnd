package com.turing.alan.whatsappclone;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.turing.alan.whatsappclone.message.domain.MessageEntity;
import com.turing.alan.whatsappclone.message.service.MessageService;
import com.turing.alan.whatsappclone.user.domain.UserEntity;
import com.turing.alan.whatsappclone.user.service.UserService;

@SpringBootApplication
public class WhatsappcloneApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	public static void main(String[] args) {
		SpringApplication.run(WhatsappcloneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		this.messageService.deleteAll();
		this.userService.deleteAll();

		UserEntity david = new UserEntity("626121934");
		UserEntity eva = new UserEntity("616743036");
		this.userService.create(david);
		this.userService.create(eva);

		
		this.messageService.create(new MessageEntity("Hola Eva", Instant.now(),david, eva));
		this.messageService.create(new MessageEntity("Hola David!", Instant.now(),eva, david));
		this.messageService.create(new MessageEntity("Como estas?", Instant.now(),eva, david));
		this.messageService.create(new MessageEntity("Tirando", Instant.now(),david, eva));
	}

}
