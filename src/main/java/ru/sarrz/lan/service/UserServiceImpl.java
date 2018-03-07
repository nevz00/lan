package ru.sarrz.lan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.sarrz.lan.dao.UserRepository;
import ru.sarrz.lan.model.User;

import java.util.List;

import static ru.sarrz.lan.util.ValidationUtil.checkNotFound;
import static ru.sarrz.lan.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @Override
    public User create(User user) {
        Assert.notNull(user,"user must not be null");
        return userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        checkNotFoundWithId(userRepository.delete(id),id);
    }

    @Override
    public User get(int id) {
        return checkNotFoundWithId(userRepository.get(id),id);
    }

    @Override
    public User getByEmail(String email) {
        Assert.notNull(email, "email must not be null");
        return checkNotFound(userRepository.getByEmail(email),"email="+ email);
    }

    @Override
    public void update(User user) {
        Assert.notNull(user,"user must not be null");
        checkNotFoundWithId(userRepository.save(user),user.getId());

    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }
}
