import models.Cliente;
import repositories.ClienteListRepositorio;
import repositories.Direccion;
import repositories.OrdenablePaginableCrudRepositorio;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        OrdenablePaginableCrudRepositorio repo = new ClienteListRepositorio();

        repo.guardar(new Cliente( "Juan", "Perez"));
        repo.guardar(new Cliente("Carlos", "Gonzalez"));
        repo.guardar(new Cliente("Lucas", "Fernandez"));
        repo.guardar(new Cliente("Ana", "Gomez"));
        repo.guardar(new Cliente("Lucas", "Hernandez"));


        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);
        //paginable
        System.out.println("Paginable");
        List<Cliente> paginable = repo.listar(1, 4);
        paginable.forEach(System.out::println);

        //ordenar
        System.out.println("Ordenar");
        List<Cliente> ordenar = repo.listar("nombre", Direccion.ASC);
        ordenar.forEach(System.out::println);

        //editar
        System.out.println("Editar");
        Cliente editable = repo.porId(3);
        editable.setNombre("Lucas edit");
        editable.setApellido("Hernandez edit");
        repo.editar(editable);


        //eliminar
        System.out.println("Eliminar");
        repo.eliminar(2);

        repo.listar().forEach(System.out::println);


        System.out.println("Total: " + repo.total());
    }
}