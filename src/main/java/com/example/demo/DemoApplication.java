package com.example.demo;

import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // Controller 로 실행 시켜야지 getMapping 이 가능
public class DemoApplication {

	// Member Field
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class); // log 찍는 곳이 DemoApplication

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello") // 이 주소로 이동하라는 의미
	public String hello() {
		return "Hello";
	}

	// 의존성 주입
	@Bean
	public CommandLineRunner deMo(CustomerRepository repository) {
		return args -> {
			repository.save(new Customer("leo", "aa")); // 등록
			repository.save(new Customer("yui", "bb")); // 등록
			repository.save(new Customer("judy", "cc")); // 등록
			repository.save(new Customer("leo2", "aa")); // 등록

			log.info("FindAll----------------"); // log -> FindAll

			for (Customer customer : repository.findAll()) { // 보여주는 작업
				log.info(customer.toString());
			}
			log.info("");

			log.info("FindById----------------"); // log -> FindById
			Customer customer = repository.findById(1L); // 첫번째 아이디 값을 가지고 검색한다는 의미
			log.info(customer.toString());
			log.info("");

			log.info("FindByLastName----------------"); // log -> FindByLastName
			repository.findByLastName("aa").forEach(c -> {log.info(c.toString());}); // 찾고자 하는 LastName을 forEach 문으로 확인
			log.info("");
		};
	}
}
