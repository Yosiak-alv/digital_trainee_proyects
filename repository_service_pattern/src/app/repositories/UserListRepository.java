package app.repositories;

import app.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserListRepository extends AbstractListRepositoryImp<User, Integer>{

    @Override
    public List<User> findAllSortedBy(String field, boolean isAscending) {
        List<User> filterUsers = new ArrayList<>(data);
        filterUsers.sort((a, b) -> {
            if (isAscending) {
                return compare(field, a, b);
            } else {
                return compare(field, b, a);
            }
        });
        return filterUsers;
    }

    private int compare(String field, User a, User b) {
        switch (field.toLowerCase()) {
            case "email" -> {return a.getEmail().compareTo(b.getEmail());}
            case "isactive" -> {return a.getActive().compareTo(b.getActive());}
            case "id" -> {return a.getId().compareTo(b.getId());}
            default -> {return 0;}
        }
    }
}
