package ru.sarrz.lan.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.sarrz.lan.model.User;
import ru.sarrz.lan.service.UserService;

import java.util.List;

import static ru.sarrz.lan.util.ValidationUtil.assureIdConsistent;
import static ru.sarrz.lan.util.ValidationUtil.checkNew;

@Controller
public class AbstractUserController {


    private final UserService service;
    @Autowired
    public AbstractUserController(UserService service) {
        this.service=service;

    }

    public List<User> getAll() {
        return service.getAll();
    }

    public User get(int id) {
        return service.get(id);
    }

    public User create(User user) {
        checkNew(user);
        return service.create(user);
    }

    public void delete(int id) {
        service.delete(id);
    }

    public void update(User user, int id) {
        assureIdConsistent(user, id);
        service.update(user);
    }

    public User getByMail(String email) {
        return service.getByEmail(email);
    }
}
