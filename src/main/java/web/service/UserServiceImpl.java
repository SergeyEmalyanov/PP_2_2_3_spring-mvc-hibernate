package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final List<User> users;

    @Autowired
    public UserServiceImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public List<User> getAll() {
        System.err.println("1");
        return users;
    }

    @Override
    public void add(User user) {
        users.add(new User(user.getName(), user.getAge()));
    }

    @Override
    public User getUser(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void update(int id, User user) {
        User updateUser = getUser(id);
        updateUser.setName(user.getName());
        updateUser.setAge(user.getAge());
    }

    @Override
    public void delete(int id) {
        users.remove(getUser(id));
    }
}
