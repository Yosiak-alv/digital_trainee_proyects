package poo.repositories.customrepo;

import poo.models.Client;
import poo.repositories.AbstractListRepository;
import poo.repositories.OrderType;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository extends AbstractListRepository<Client> {

    @Override
    public void update(Client client) {
        Client entity = getById(client.getId());
        if (entity != null) {
           entity.setName(client.getName());
           entity.setLastname(client.getLastName());
        }
    }

    @Override
    public List<Client> list(String field, OrderType order) {
        List<Client> clients = new ArrayList<>(this.data);
        clients.sort((a, b) -> {
            int result = 0;
            if (order == OrderType.ASC) {
                result =  order(field, a, b);
            } else if (order == OrderType.DESC) {
                result = order(field, b, a);
            }
            return result;
        });
        return clients;
    }


    private static int order(String field, Client a, Client b) {
        return switch (field) {
            case "name" -> a.getName().compareTo(b.getName());
            case "lastname" -> a.getLastName().compareTo(b.getLastName());
            case "id" -> a.getId().compareTo(b.getId());
            default -> 0;
        };
    }
}
