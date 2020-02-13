/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.greglturnquist.payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@Component
// marked with Spring’s @Component annotation so that it is automatically picked up by @SpringBootApplication
public class DatabaseLoader implements CommandLineRunner {
	//implements Spring Boot’s CommandLineRunner so that it gets run after all the beans are created and registered.
	private final EmployeeRepository repository;

	@Autowired
	public DatabaseLoader(EmployeeRepository repository) {
		this.repository = repository;
	}
	// uses constructor injection and autowiring to get Spring Data’s automatically created EmployeeRepository

	@Override
	public void run(String... strings) throws Exception {
		//varargs--zero or more String objects (or an array of them) may be passed as the argument(s)
		this.repository.save(new Employee("Frodo", "Baggins", "ring bearer"));
	}
}
// end::code[]