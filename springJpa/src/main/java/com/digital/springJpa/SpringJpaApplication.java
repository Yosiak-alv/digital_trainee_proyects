package com.digital.springJpa;

import com.digital.springJpa.models.Person;
import com.digital.springJpa.models.Product;
import com.digital.springJpa.repositories.PersonRepository;
import com.digital.springJpa.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//list();
		productsList();
		activeProductsList(true);
		activeProductsList(false);
		findByNameLike("Smart");
		findById(10L);
		findByNameAndIsActive("Smartphone", true);
		findByName("Laptop");

		//others
		//createProduct(new Product("Budokai Tenkaichi 3", 100, 30.0, true));
		//updateProduct(11L);
		//deleteProduct(11L);
	}

	private void productsList(){
		System.out.println("Products list ALL");
		List<Product> products = productService.findAll();
		products.forEach(System.out::println);
	}

	private void activeProductsList(boolean isActive){
		System.out.println("Products list ACTIVE: " + isActive);
		List<Product> products = productService.findActiveProducts(isActive);
		products.forEach(System.out::println);
	}

	private void findById(Long id){
		System.out.println("Product by id: " + id);
		Product product = productService.findById(id);
		System.out.println(product);
	}

	private void findByName(String name){
		System.out.println("Products by name: " + name);
		Product product = productService.findByName(name);
		System.out.println(product);
	}

	private void findByNameLike(String name){
		System.out.println("Products list by name like: " + name);
		List<Product> products = productService.findByNameLike(name);
		products.forEach(System.out::println);
	}

	private void findByNameAndIsActive(String name, boolean isActive){
		System.out.println("Products list by name: " + name+" and isActive: " + isActive);
		List<Product> products = productService.findByNameAndIsActive(name, isActive);
		products.forEach(System.out::println);
	}

	private void createProduct(Product product) {
		Product result = productService.create(product);
		System.out.println("Product created: " + result);
	}
	private void updateProduct(Long id) {
		Product product = productService.findById(id);
		product.setPrice(1500.0);
		Product result = productService.update(product);
		System.out.println("Product updated: " + result);
	}

	private void deleteProduct(Long id) {
		productService.delete(id);
		System.out.println("Product deleted with id: " + id);
	}


	/*private void findOne() {
		Person person = null;
		Optional<Person> optional = repository.findOne(1L);
		if (optional.isPresent() && !optional.isEmpty()) {
			person = optional.get();
		}
		System.out.println(person);
		repository.findOneLikeName("hn").ifPresent(System.out::println);
	}

	private void list(){
		//List<Person> persons = (List<Person>) repository.findAll();
		//List<Person> persons = (List<Person>) repository.searchByProgrammingLanguage("Java", "John");

		List<Person> persons = (List<Person>) repository.findByProgrammingLanguageAndName("Java", "Josefa");

		persons.forEach(System.out::println);

		List<Object[]> data = repository.oftenerPersonDataByProgrammingLanguage("Java");

		data.stream().forEach( p -> {
					System.out.println("Name: " + p[0] + " Programming Language: " + p[1]);
				}
		);
	}*/
}
