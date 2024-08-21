package com.digital.springJpa;

import com.digital.springJpa.dto.PersonDto;
import com.digital.springJpa.models.Person;
import com.digital.springJpa.models.Product;
import com.digital.springJpa.repositories.PersonRepository;
import com.digital.springJpa.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;

	@Autowired
	private ProductServiceImpl productServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//list();

//		whereIn();
//		subQueries();
//		queriesAggregations();
//		personalizedQueriesBetween();
//		personalizedQueriesConcatUpperAndLowerCase();
//		personalizedQueriesDistinct();
//		personalizedQueries2();
//		personalizedQueries();

		//create();
		//update();
		delete2();



		//products tests
		//createProduct(new Product("Budokai Tenkaichi 3", 100, 30.0, true));
		//updateProduct(11L);
		//deleteProduct(11L);
		//		productsList();
		//		activeProductsList(true);
		//		activeProductsList(false);
		//		findByNameLike("Smart");
		//		findById(10L);
		//		findByNameAndIsActive("Smartphone", true);
		//		findByName("Laptop");
	}

	@Transactional(readOnly = true)
	public void whereIn(){
		System.out.println("-------------------------Where in------------------");
		List<Person> persons = repository.findAllByIds(List.of(1L, 2L, 3L));
		persons.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void subQueries(){
		System.out.println("-------------------------Subqueries------------------");
		List<Object[]> registers = repository.findShortestName();
		registers.forEach(r -> {
			String name = (String) r[0];
			Integer length = (Integer) r[1];
			System.out.println("Name: " + name + " Length: " + length);
		});

		System.out.println("------------- last person registered -----------");
		Optional<Person> optionalPerson = repository.findLastPerson();
		optionalPerson.ifPresent(System.out::println);
	}

	@Transactional(readOnly = true)
	public void queriesAggregations(){
		System.out.println("-------------------------Queries Aggregations------------------");
		System.out.println("------------- total -----------");
		Long count = repository.getTotalPersons();
		System.out.println("Total persons: " + count);

		System.out.println("------------- min id -----------");
		Long minId = repository.getMinId();
		System.out.println("Min id: " + minId);

		System.out.println("------------- max id -----------");
		Long maxId = repository.getMaxId();
		System.out.println("Max id: " + maxId);

		System.out.println("------------- name and length -----------");
		List<Object[]> data = repository.getPersonNameLength();
		data.forEach( p -> {
					System.out.println("Name: " + (String) p[0] + " Length: " + (Integer) p[1]);
				}
		);

		System.out.println("------------- shortestName -----------");
		Integer minLength = repository.getMinLengthName();
		System.out.println("Shortest name: " + minLength);

		System.out.println("------------- longestName -----------");
		Integer maxLength = repository.getMaxLengthName();
		System.out.println("Longest name: " + maxLength);

		System.out.println("------------- consultas  -----------");
		Object [] resume = (Object[]) repository.getResumeAggregation();
		//System.out.println("Min id: " + resume[0] + "Max id: " + resume[1] + "Sum id: " + resume[2] + "Avg length name: " + resume[3] + "Count id: " + resume[4]);
	}

	@Transactional(readOnly = true)
	public void personalizedQueriesBetween(){
		System.out.println("-------------------------Personalized Queries Between------------------");
		List<Person> persons = repository.findByIdBetweenOrderByNameAsc(1L, 3L);
		persons.forEach(System.out::println);

		persons = repository.findByNameBetweenOrderByNameDescLastnameDesc("John", "Josefa");
		persons.forEach(System.out::println);

		persons = repository.findAllByOrderByNameAscLastnameDesc();
		persons.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void personalizedQueriesConcatUpperAndLowerCase(){
		System.out.println("-------------------------full name------------------");
		List<String> names = repository.findAllFullNameConcat();
		names.forEach(System.out::println);

		System.out.println("-------------------------upper names------------------");
		List<String> upperNames = repository.findAllFullNameConcatUpper();
		upperNames.forEach(System.out::println);

		System.out.println("-------------------------lower names------------------");
		List<String> lowerNames = repository.findAllFullNameConcatLower();
		lowerNames.forEach(System.out::println);

		System.out.println("-------------------------person upper and lower case------------------");
		List<Object[]> persons = repository.findAllPersonDataListCase();
		persons.forEach( p -> {
					System.out.println("Name: " + p[1] + " Lastname: " + p[2] + " Programming Language: " + p[3]);
				}
		);
	}

	@Transactional(readOnly = true)
	public void personalizedQueriesDistinct(){
		System.out.println("-------------------------Distinct------------------");
		List<String> names = repository.findAllNames();
		names.forEach(System.out::println);


		System.out.println("-------------------------Distinct Programming Language------------------");
		Long count = repository.countDistinctProgrammingLanguage();
		System.out.println("Distinct Programming Language: " + count);
	}

	@Transactional(readOnly = true)
	public void personalizedQueries2(){
		System.out.println("-------------------------object and programming language------------------");
		List<Person> persons = repository.findAllObjectPersonPersonalized();
		persons.forEach(System.out::println);

		System.out.println("-------------------------person dto------------------");
		List<PersonDto> personDtos = repository.findAllPersonDto();
		personDtos.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void personalizedQueries(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("consulta solo el nombre ");
		System.out.println("Enter the id: ");
		Long id = scanner.nextLong();
		scanner.close();

		System.out.println("consulta solo el nombre ");
		String name = repository.getNameById(id);
		System.out.println("Name: " + name);

		System.out.println("consulta solo el id ");
		Long id2 = repository.getIdById(id);
		System.out.println("Id: " + id2);

		System.out.println("consulta nombre completo ");
		String fullname = repository.getFullNameById(id);
		System.out.println("Fullname: " + fullname);

		System.out.println("consulta campos personalizados por id ");
		Optional<Person> optionalPerson = repository.oftenerPersonDataById(id);
		if (optionalPerson.isPresent()) {
			Person person = optionalPerson.orElseThrow();
			System.out.println("Id: "+ person.getId() + " Name: " + person.getName() + " LastName "+ person.getLastname()+  " Programming Language: " + person.getProgrammingLanguage());
		}

		System.out.println("consulta campos personalizados LISTA");
		List<Object[]> persons = repository.oftenerPersonData();
		persons.forEach( p -> {
					System.out.println("Name: " + p[0] + " Programming Language: " + p[1]);
				}
		);

	}

	@Transactional()
	public void delete2(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id to delete: ");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);
		optionalPerson.ifPresentOrElse(repository::delete, () -> System.out.println("Person not found"));


		repository.findAll().forEach(System.out::println);
		scanner.close();
	}

	@Transactional()
	public void delete(){
		repository.findAll().forEach(System.out::println);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id to delete: ");
		Long id = scanner.nextLong();

		repository.deleteById(id);
		repository.findAll().forEach(System.out::println);
		scanner.close();
	}

	@Transactional()
	public void update(){
		repository.findAll().forEach(System.out::println);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id to update: ");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);
		if (optionalPerson.isPresent()) {
			Person person = optionalPerson.orElseThrow();
			System.out.println("Enter the programming language: ");
			String programmingLanguage = scanner.next();
			person.setProgrammingLanguage(programmingLanguage);

			Person updated = repository.save(person);
			System.out.println("Person updated: " + updated);
		} else {
			System.out.println("Person not found");
		}


		scanner.close();
	}

	@Transactional()
	public void create(){
		repository.findAll().forEach(System.out::println);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name: ");
		String name = scanner.next();
		System.out.println("Enter the lastname: ");
		String lastname = scanner.next();
		System.out.println("Enter the programming language: ");
		String programmingLanguage = scanner.next();

		Person person = new Person(null, name, lastname, programmingLanguage);
		Person saved = repository.save(person);
		System.out.println("Person saved: " + saved);

		repository.findAll().forEach(System.out::println);
		scanner.close();
	}

	private void findOne() {
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
	}

	private void productsList(){
		System.out.println("Products list ALL");
		List<Product> products = productServiceImpl.findAll();
		products.forEach(System.out::println);
	}

	private void activeProductsList(boolean isActive){
		System.out.println("Products list ACTIVE: " + isActive);
		List<Product> products = productServiceImpl.findActiveProducts(isActive);
		products.forEach(System.out::println);
	}

	private void findById(Long id){
		System.out.println("Product by id: " + id);
		Product product = productServiceImpl.findById(id);
		System.out.println(product);
	}

	private void findByName(String name){
		System.out.println("Products by name: " + name);
		Product product = productServiceImpl.findByName(name);
		System.out.println(product);
	}

	private void findByNameLike(String name){
		System.out.println("Products list by name like: " + name);
		List<Product> products = productServiceImpl.findByNameLike(name);
		products.forEach(System.out::println);
	}

	private void findByNameAndIsActive(String name, boolean isActive){
		System.out.println("Products list by name: " + name+" and isActive: " + isActive);
		List<Product> products = productServiceImpl.findByNameAndIsActive(name, isActive);
		products.forEach(System.out::println);
	}

	private void createProduct(Product product) {
		Product result = productServiceImpl.create(product);
		System.out.println("Product created: " + result);
	}
	private void updateProduct(Long id) {
		Product product = productServiceImpl.findById(id);
		product.setPrice(1500.0);
		Product result = productServiceImpl.update(product);
		System.out.println("Product updated: " + result);
	}

	private void deleteProduct(Long id) {
		productServiceImpl.delete(id);
		System.out.println("Product deleted with id: " + id);
	}
}
