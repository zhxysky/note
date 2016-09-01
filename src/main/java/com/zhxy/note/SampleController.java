package com.zhxy.note;

import com.zhxy.note.entities.Users;
import com.zhxy.note.repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

/**
 * Created by zhxy on 2016/8/16.
 */
@Controller
@EnableAutoConfiguration
@ComponentScan
public class SampleController {
    private static final Logger log = LoggerFactory.getLogger(SampleController.class);

    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }

    @Bean
    public CommandLineRunner demo(final UsersRepository repository) {
        return (args) -> {
            repository.save(new Users("zhxy"));
            repository.save(new Users("zhxy"));
            repository.save(new Users("www"));
            repository.save(new Users("www"));
            repository.save(new Users("www"));

            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for(Users user:repository.findAll()) {
                log.info(user.toString());
            }
            Users user = repository.findOne(1);
            log.info("User found with findOne():");
            log.info("-------------------------");
            log.info(user.toString());

            log.info("Users found with findByName():");
            log.info("--------------------------------");
            for(Users user2:repository.findByName("www")) {
                log.info(user2.toString());
            }
        };
    }
}
