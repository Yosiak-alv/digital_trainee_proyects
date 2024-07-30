package repositories;

import models.Cliente;

import java.util.List;

public interface PaginableRepositorio {
    List<Cliente> listar(int inicio, int hasta);
}
