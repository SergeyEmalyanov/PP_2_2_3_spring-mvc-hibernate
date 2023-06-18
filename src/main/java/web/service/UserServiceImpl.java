package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAll() {
        System.err.println("1");
        List <User> list = new ArrayList<>();
        list.add(new User("A",1));
        list.add(new User("B",2));
        return list;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public void update(int id, User user) {

    }

    @Override
    public void delete(int id) {

    }
}
