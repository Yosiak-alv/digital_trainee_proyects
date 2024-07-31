package app.services;

import app.models.User;
import app.repositories.UserListRepository;

import java.util.List;

public class UserService {

    private UserListRepository userListRepository = new UserListRepository();

    public List<User> findAll() {
        return userListRepository.findAll();
    }

    public List<User> findAll(int fromIndex, int toIndex) {
        return userListRepository.findAll(fromIndex, toIndex);
    }

    public List<User> findAllSortedBy(String field, boolean isAscending) {
        return userListRepository.findAllSortedBy(field, isAscending);
    }

    public User findById(Integer id) {
        return userListRepository.findById(id).orElseThrow( () -> new RuntimeException("User not found"));
    }

    public void create(User user) {
        userListRepository.save(user);
    }

    public void update(Integer id, User user) {
       User result = this.findById(id);
       result.setId(id);
       result.setEmail(user.getEmail());
       result.setActive(user.getActive());
       userListRepository.update(id,result);
    }

    public void delete(Integer id) {
        userListRepository.deleteById(id);
    }

    public long count() {
        return userListRepository.count();
    }
}
