package ru.sarrz.lan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.sarrz.lan.dao.UserRepository;
import ru.sarrz.lan.model.User;
import ru.sarrz.lan.to.UserTo;
import ru.sarrz.lan.util.UserUtil;
import ru.sarrz.lan.web.AuthorizedUser;

import java.util.List;

import static ru.sarrz.lan.util.ValidationUtil.checkNotFound;
import static ru.sarrz.lan.util.ValidationUtil.checkNotFoundWithId;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public User create(User user) {
        Assert.notNull(user,"user must not be null");
        return userRepository.save(user);
    }

    @CacheEvict(value = "users", allEntries = true)
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

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void update(User user) {
        Assert.notNull(user,"user must not be null");
        checkNotFoundWithId(userRepository.save(user),user.getId());

    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    @Transactional
    public void update(UserTo userTo) {
        User user = get(userTo.getId());
        userRepository.save(UserUtil.updateFromTo(user,userTo));
    }

    @Cacheable("users")
    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getByEmail(email.toLowerCase());
        if (user==null){
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(user);
    }
}
