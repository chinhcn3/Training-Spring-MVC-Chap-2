package demo.web.service;

import org.springframework.stereotype.Component;
import demo.web.model.User;

import java.util.List;

/**
 * Created by ChinhVD on 11/1/17.
 */
@Component
public interface UserService {

    public User getUserByLogin(String name, String pass);

    public void updateUser(User user);

    public List<User> listUser();
}
