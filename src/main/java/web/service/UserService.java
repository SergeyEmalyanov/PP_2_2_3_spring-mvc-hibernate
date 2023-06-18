package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void add (User user);
    User getUser(int id);
    void update (int id,User user);
    void delete (int id);

}
