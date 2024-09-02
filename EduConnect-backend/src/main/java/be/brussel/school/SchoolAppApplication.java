package be.brussel.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "be.brussel.school.repository")
public class SchoolAppApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(SchoolAppApplication.class, args);
	}


}

