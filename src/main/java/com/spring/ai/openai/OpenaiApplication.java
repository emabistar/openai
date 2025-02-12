package com.spring.ai.openai;

import com.spring.ai.openai.entities.Transaction;
import com.spring.ai.openai.entities.TransactionStatus;
import com.spring.ai.openai.entities.TransactionType;
import com.spring.ai.openai.repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class OpenaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenaiApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(TransactionRepository transactionRepository){
		return args -> {
			List<Long> accounts = List.of(Long.valueOf(11),Long.valueOf(22),Long.valueOf(33));
			accounts.forEach(accountId->{
				for (TransactionType type : TransactionType.values()){
					for (int i = 0; i <3 ; i++) {
						Transaction transaction = Transaction.builder()
								.accountId(accountId)
								.type(type)
								.amount(1000+ Math.random()*70000)
								.date(new Date())
								.status(TransactionStatus.PENDING)
								.build();
						transactionRepository.save(transaction);
					}
				}
			});
		};
	}
}
