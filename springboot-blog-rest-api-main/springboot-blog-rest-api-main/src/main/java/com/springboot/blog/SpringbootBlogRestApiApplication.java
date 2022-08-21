package com.springboot.blog;


import org.modelmapper.ModelMapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringbootBlogRestApiApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/*
	 * @Autowired private RoleRepository roleRepository;
	 * 
	 * @Override public void run(String... args) throws Exception {
	 * 
	 * Role adminRole = new Role(); adminRole.setName("ROLE_ADMIN");
	 * roleRepository.save(adminRole);
	 * 
	 * Role userRole = new Role(); userRole.setName("ROLE_USER");
	 * roleRepository.save(userRole);
	 * 
	 * }
	 */
}
