package ru.sarrz.lan.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.sarrz.lan.model.User;

@Controller
//@RequestMapping(ProfileRestController.REST_URL)
public class ProfileRestController extends AbstractUserController {
    //static final String REST_URL = "/rest/profile";

//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(){return super.get(AuthorizedUser.id());}

//    @DeleteMapping
    public void delete(){
        super.delete(AuthorizedUser.id());
    }
//    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user){
        super.update(user, AuthorizedUser.id());
    }
//    @GetMapping(value = "/text")
//    public String testUtf(){
//        return "Русский текст";
//    }
}
