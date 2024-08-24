package com.digital.spring_relationships;

import com.digital.spring_relationships.models.*;
import com.digital.spring_relationships.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class SpringRelationshipsApplication implements CommandLineRunner {

	@Autowired
	public ClientRepository clientRepository;

	@Autowired
	public InvoiceRepository invoiceRepository;

	@Autowired
	public ClientDetailRepository clientDetailRepository;

	@Autowired
	public StudentRepository studentRepository;

	@Autowired
	public CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringRelationshipsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//oneToManyFindById();
		//oneToMany();
		//manyToOneFindByIdClient();
		//removeAddressFindById();
		//removeAddress();
		//oneToManyInvoiceBidirectionalFindById();
		//oneToManyInvoiceBidirectional();
		//removeInvoiceBidirectional();
		//oneToOne();
		//oneToOneFindById();
		//manyToManyBidireccionalFind();
		//manyToMany();
		//manyToManyBidireccionalRemove();
		manyToManyFind();
	}

	@Transactional
	public void manyToManyRemoveBidireccionalFind() {

		Optional<Student> studentOptional1 = studentRepository.findOneWithCourses(1L);
		Optional<Student> studentOptional2 = studentRepository.findOneWithCourses(2L);

		Student student1 = studentOptional1.get();
		Student student2 = studentOptional2.get();

		Course course1 = courseRepository.findOneWithStudents(1L).get();
		Course course2 = courseRepository.findOneWithStudents(2L).get();

		// student1.setCourses(Set.of(course1, course2));
		// student2.setCourses(Set.of(course2));
		student1.addCourse(course1);
		student1.addCourse(course2);
		student2.addCourse(course2);

		studentRepository.saveAll(List.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);

		Optional<Student> studentOptionalDb = studentRepository.findOneWithCourses(1L);
		if (studentOptionalDb.isPresent()) {

			Student studentDb = studentOptionalDb.get();
			Optional<Course> courseOptionalDb = courseRepository.findOneWithStudents(1L);

			if (courseOptionalDb.isPresent()) {
				Course courseDb = courseOptionalDb.get();
				studentDb.removeCourse(courseDb);

				studentRepository.save(studentDb);
				System.out.println(studentDb);
			}
		}
	}

	@Transactional
	public void manyToManyBidireccionalFind() {

		Optional<Student> studentOptional1 = studentRepository.findOneWithCourses(1L);
		Optional<Student> studentOptional2 = studentRepository.findOneWithCourses(2L);

		Student student1 = studentOptional1.get();
		Student student2 = studentOptional2.get();

		Course course1 = courseRepository.findOneWithStudents(1L).get();
		Course course2 = courseRepository.findOneWithStudents(2L).get();

		// student1.setCourses(Set.of(course1, course2));
		// student2.setCourses(Set.of(course2));
		student1.addCourse(course1);
		student1.addCourse(course2);
		student2.addCourse(course2);

		studentRepository.saveAll(List.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);
	}

	@Transactional
	public void manyToManyBidireccionalRemove() {

		Student student1 = new Student("Jano", "Pura");
		Student student2 = new Student("Erba", "Doe");

		Course course1 = new Course("Curso de java master", "Andres");
		Course course2 = new Course("Curso de Spring Boot", "Andres");

		// student1.setCourses(Set.of(course1, course2));
		// student2.setCourses(Set.of(course2));

		student1.addCourse(course1);
		student1.addCourse(course2);
		student2.addCourse(course2);

		studentRepository.saveAll(List.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);

		Optional<Student> studentOptionalDb = studentRepository.findOneWithCourses(3L);
		if (studentOptionalDb.isPresent()) {

			Student studentDb = studentOptionalDb.get();
			Optional<Course> courseOptionalDb = courseRepository.findOneWithStudents(3L);

			if (courseOptionalDb.isPresent()) {
				Course courseDb = courseOptionalDb.get();
				studentDb.removeCourse(courseDb);

				studentRepository.save(studentDb);
				System.out.println(studentDb);
			}
		}
	}

	@Transactional
	public void manyToManyBidireccional() {

		Student student1 = new Student("Jano", "Pura");
		Student student2 = new Student("Erba", "Doe");

		Course course1 = new Course("Curso de java master", "Andres");
		Course course2 = new Course("Curso de Spring Boot", "Andres");

		// student1.setCourses(Set.of(course1, course2));
		// student2.setCourses(Set.of(course2));

		student1.addCourse(course1);
		student1.addCourse(course2);
		student2.addCourse(course2);

		studentRepository.saveAll(List.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);
	}

	@Transactional
	public void manyToManyRemove() {

		Student student1 = new Student("Jano", "Pura");
		Student student2 = new Student("Erba", "Doe");

		Course course1 = new Course("Curso de java master", "Andres");
		Course course2 = new Course("Curso de Spring Boot", "Andres");

		student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(List.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);

		Optional<Student> studentOptionalDb = studentRepository.findOneWithCourses(3L);
		if (studentOptionalDb.isPresent()) {

			Student studentDb = studentOptionalDb.get();
			Optional<Course> courseOptionalDb = courseRepository.findById(3L);

			if (courseOptionalDb.isPresent()) {
				Course courseDb = courseOptionalDb.get();
				studentDb.getCourses().remove(courseDb);

				studentRepository.save(studentDb);
				System.out.println(studentDb);
			}
		}

	}

	@Transactional
	public void manyToManyRemoveFind() {

		Optional<Student> studentOptional1 = studentRepository.findById(1L);
		Optional<Student> studentOptional2 = studentRepository.findById(2L);

		Student student1 = studentOptional1.get();
		Student student2 = studentOptional2.get();

		Course course1 = courseRepository.findById(1L).get();
		Course course2 = courseRepository.findById(2L).get();

		student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(List.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);

		Optional<Student> studentOptionalDb = studentRepository.findOneWithCourses(1L);
		if (studentOptionalDb.isPresent()) {

			Student studentDb = studentOptionalDb.get();
			Optional<Course> courseOptionalDb = courseRepository.findById(2L);

			if (courseOptionalDb.isPresent()) {
				Course courseDb = courseOptionalDb.get();
				studentDb.getCourses().remove(courseDb);

				studentRepository.save(studentDb);
				System.out.println(studentDb);
			}
		}
	}

	@Transactional
	public void manyToManyFind() {

		Optional<Student> studentOptional1 = studentRepository.findById(1L);
		Optional<Student> studentOptional2 = studentRepository.findById(2L);

		Student student1 = studentOptional1.get();
		Student student2 = studentOptional2.get();

		Course course1 = courseRepository.findById(1L).get();
		Course course2 = courseRepository.findById(2L).get();

		student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(List.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);
	}

	@Transactional
	public void manyToMany() {

		Student student1 = new Student("Jano", "Pura");
		Student student2 = new Student("Erba", "Doe");

		Course course1 = new Course("Curso de java master", "Andres");
		Course course2 = new Course("Curso de Spring Boot", "Andres");

		student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(List.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);
	}

	@Transactional
	public void oneToManyInvoiceBidirectionalFindById(){
		Optional<Client> client = clientRepository.findOneJoinWithInvoicesAndAddresses(1L);
		System.out.println("Client: " + client);
		client.ifPresent(c -> {
			Invoice invoice = new Invoice("Compra de computadora", 1000.0);
			Invoice invoice2 = new Invoice("Compra de impresora", 800.0);

			c.addInvoice(invoice);
			c.addInvoice(invoice2);

			clientRepository.save(c);
			System.out.println("Client: " + c);
		});
	}
	@Transactional
	public void oneToManyInvoiceBidirectional(){
		Client client = new Client("Jonathan", "Alvarenga");

		Invoice invoice = new Invoice("compras de la Casa", 1000.0);
		Invoice invoice2 = new Invoice("compras de oficina", 8000.0);

		client.addInvoice(invoice).addInvoice(invoice2);

		clientRepository.save(client);
		System.out.println("Client: " + client);
	}

	@Transactional
	public void oneToOne(){
		Client client = new Client("Juan", "Romeo");
		Client result = clientRepository.save(new Client("Juan", "Romeo"));
		ClientDetails clientDetails = new ClientDetails(true, 100);
		clientDetails.setClient(result);
		clientDetailRepository.save(clientDetails);
		System.out.println("Client: " + result);
	}
	@Transactional
	public void oneToOneFindById() {
		Optional<Client> client = clientRepository.findById(1L);
		client.ifPresent(c -> {
			ClientDetails clientDetails = new ClientDetails(true, 100);
			clientDetails.setClient(c);
			clientDetailRepository.save(clientDetails);
		});
	}
	@Transactional
	public void removeInvoiceBidirectional(){
		Client client = new Client("Sebastian", "Alvarenga");
		Invoice invoice1 = new Invoice("compras de la Casa", 1000.0);
		Invoice invoice2 = new Invoice("compras de oficina", 8000.0);

		client.addInvoice(invoice1).addInvoice(invoice2);

		clientRepository.save(client);

		System.out.println("Client: " + client);

		Optional<Client> opClient = clientRepository.findOneJoinWithInvoicesAndAddresses(3L);

		opClient.ifPresent(clientDb -> {
			Optional<Invoice> opInvoice = invoiceRepository.findById(2L);
			opInvoice.ifPresent(invoice -> {

				clientDb.removeInvoice(invoice);
				clientRepository.save(clientDb);
				System.out.println("Client: " + clientDb);
			});
		});
	}

	@Transactional
	public void oneToManyFindById(){
		Optional<Client> client = clientRepository.findById(1L);
		client.ifPresent(c -> {
			Address address = new Address("Calle 1", 123);
			Address address2 = new Address("Calle 2", 456);

			//c.setAddresses(List.of(address, address2));

			clientRepository.save(c);
			System.out.println("Client: " + c);
		});
	}

	@Transactional
	public void oneToMany(){
		Client client = new Client("Juan", "Perez");

		Address address = new Address("Calle El Trapiche", 12);
		Address address2 = new Address("Calle Las Colinas", 36);

		client.getAddresses().add(address);
		client.getAddresses().add(address2);

		clientRepository.save(client);
		System.out.println("Client: " + client);

		/*Optional<Client> client = clientRepository.findById(3L);
		client.ifPresent(c -> {
			Address address = new Address("Al puerto", "12-3");
			Address address2 = new Address("Loma Linda", "36-4");

			c.getAddresses().add(address);
			c.getAddresses().add(address2);

			clientRepository.save(c);
			System.out.println("Client: " + c);
		});*/
	}

	@Transactional
	public void manyToOneFindByIdClient(){
		Optional<Client> client = clientRepository.findById(1L);
		/*client.ifPresent(c -> {
			Invoice invoice = new Invoice("Compra de computadora", 1000.0);
			invoice.setClient(c);
			Invoice result = invoiceRepository.save(invoice);
			System.out.println("Invoice: " + result);
		});*/
		if(client.isPresent()){
			Client c = client.orElseThrow();

			Invoice invoice = new Invoice("Compra de computadora", 1000.0);
			invoice.setClient(c);
			Invoice result = invoiceRepository.save(invoice);
			System.out.println("Invoice: " + result);
		}
	}

	@Transactional
	public void removeAddressFindById(){
		Optional<Client> client = clientRepository.findById(2L);
		client.ifPresent(c -> {
			Address address1 = new Address("El verjal", 123);
			Address address2 = new Address("Vasco de Gama", 456);

			/*c.setAddresses(List.of(address1, address2));

			clientRepository.save(c);
			System.out.println("Client: " + c);*/

			Optional<Client> opClient = clientRepository.findOneJoinWithAddresses(2L);
			opClient.ifPresent(client1 -> {


				//address2.setId(11L);

				/*client1.getAddresses().remove(address2);
				clientRepository.save(client1);
				System.out.println("Client: " + client1);*/
			});
		});


	}

	@Transactional
	public void removeAddress(){
		Client client = new Client("Josias", "Alvarenga");

		Address address1 = new Address("El verjal Gama", 123);
		Address address2 = new Address("Vasco de Gama", 456);

		/*client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		clientRepository.save(client);
		System.out.println("Client: " + client);*/

		Optional<Client> opClient = clientRepository.findOneJoinWithAddresses(6L);

		opClient.ifPresent(c -> {
			address2.setId(15L);
			c.getAddresses().remove(address2);
			clientRepository.save(c);
			System.out.println("Client: " + c);
		});
	}


}
