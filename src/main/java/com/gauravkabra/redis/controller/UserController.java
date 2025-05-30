package com.gauravkabra.redis.controller;

import com.gauravkabra.redis.dao.UserDao;
import com.gauravkabra.redis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    // C
    @PostMapping
    public void create(@RequestBody User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.save(user);
    }

    // R
    @GetMapping("/{id}")
    public User getById(@PathVariable String id) {
        return userDao.getById(id);
    }

    @GetMapping
    public Map<Object, Object> getAll() {
        return userDao.getAll();
    }

    // U
    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody User user) {
        user.setId(id);
        userDao.update(id, user);
    }

    // D
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        userDao.deleteById(id);
    }

    @DeleteMapping
    public void deleteByIds(@RequestParam List<String> ids) {
        userDao.deleteByIds(ids);
    }
}
