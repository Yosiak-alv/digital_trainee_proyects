package app.repositories;

import app.models.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository extends AbstractListRepository<Client, Integer>{

    @Override
    public List<Client> findAllSortedBy(String field, boolean isAscending) {
        List<Client> filterClients = new ArrayList<>(datasource);
        filterClients.sort((a, b) -> {
            if (isAscending) {
                return compare(field, a, b);
            } else {
                return compare(field, b, a);
            }
        });
        return filterClients;
    }

    private int compare(String field, Client a, Client b) {
        return switch (field) {
            case "id" -> a.getId().compareTo(b.getId());
            case "name" -> a.getName().compareTo(b.getName());
            case "type" -> a.getType().compareTo(b.getType());
            default -> 0;
        };
    }

}
