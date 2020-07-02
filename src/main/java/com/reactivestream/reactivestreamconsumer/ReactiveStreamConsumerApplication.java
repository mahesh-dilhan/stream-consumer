package com.reactivestream.reactivestreamconsumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;


@Log4j2
@EnableBinding(Sink.class)
@SpringBootApplication
public class ReactiveStreamConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveStreamConsumerApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void handle(Person person){
		log.info("{}"+ person );
	}
}
