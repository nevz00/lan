package ru.sarrz.lan.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.sarrz.lan.model.User;

import java.util.List;

@Controller
//@RequestMapping(AdminRestController.REST_URL)
public class AdminRestController extends AbstractUserController{
//    static final String REST_URL="/rest/admin/users";

    @Override
   // @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return super.getAll();
    }

    @Override
    public User create(User user) {
        return super.create(user);
    }

    @Override
//    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(/*@PathVariable("id")*/ int id) {
        return super.get(id);
    }

    @Override
//    @DeleteMapping(value = "/{id}")
    public void delete(/*@PathVariable("id")*/ int id) {
        super.delete(id);
    }

    @Override
//    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(/*@RequestBody*/ User user,/*@PathVariable("id")*/ int id) {
        super.update(user, id);
    }

    @Override
//    @GetMapping(value = "/by",produces = MediaType.APPLICATION_JSON_VALUE)
    public User getByMail(/*@RequestParam("email")*/ String email) {
        return super.getByMail(email);
    }
}
