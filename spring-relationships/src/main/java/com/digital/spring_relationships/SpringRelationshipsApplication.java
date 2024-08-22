package com.digital.spring_relationships;

import com.digital.spring_relationships.models.Address;
import com.digital.spring_relationships.models.Client;
import com.digital.spring_relationships.models.ClientDetails;
import com.digital.spring_relationships.models.Invoice;
import com.digital.spring_relationships.repositories.ClientDetailRepository;
import com.digital.spring_relationships.repositories.ClientRepository;
import com.digital.spring_relationships.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringRelationshipsApplication implements CommandLineRunner {

	@Autowired
	public ClientRepository clientRepository;

	@Autowired
	public InvoiceRepository invoiceRepository;

	@Autowired
	public ClientDetailRepository clientDetailRepository;

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
		oneToOne();
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
			System.out.println("Client: " + c);
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
