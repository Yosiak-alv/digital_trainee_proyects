package repositories;

import models.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio implements OrdenablePaginableCrudRepositorio{

    private List<Cliente> datasource;

    public ClienteListRepositorio() {
        this.datasource = new ArrayList<>();
    }
    @Override
    public List<Cliente> listar() {
        return datasource;
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente result = null;
        for(Cliente cliente : datasource){
            if(cliente.getId().equals(id)){
                result = cliente;
                break;
            }
        }
        return result;
    }

    @Override
    public void guardar(Cliente cliente) {
        datasource.add(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente result = this.porId(cliente.getId());
        if(result != null){
            result.setNombre(cliente.getNombre());
            result.setApellido(cliente.getApellido());
        }
    }

    @Override
    public void eliminar(Integer id) {
        datasource.remove(this.porId(id));
    }

    @Override
    public int total() {
        return datasource.size();
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> lista = new ArrayList<>(datasource);
        lista.sort((a, b) -> {
            int result = 0;
            if(dir == Direccion.ASC){
                result = ordenar(campo, a, b);
            }else if(dir == Direccion.DESC){
                result = ordenar(campo, b, a);
            }
            return result;
        });
        return lista;
    }

    @Override
    public List<Cliente> listar(int inicio, int hasta) {return datasource.subList(inicio, hasta);}

    private static int ordenar(String campo, Cliente a, Cliente b){
        int result = 0;
        switch (campo){
            case "id":
                result = a.getId().compareTo(b.getId());
                break;
            case "nombre":
                result = a.getNombre().compareTo(b.getNombre());
                break;
            case "apellido":
                result = a.getApellido().compareTo(b.getApellido());
                break;
        }
        return result;
    }
}
