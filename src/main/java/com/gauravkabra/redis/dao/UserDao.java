package com.gauravkabra.redis.dao;

import com.gauravkabra.redis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // C
    public void save(User user) {
        redisTemplate.opsForHash().put(User.class.getName(), user.getId(), user);
    }

    // R
    public User getById(String id) {
        return (User) redisTemplate.opsForHash().get(User.class.getName(), id);
    }

    public Map<Object, Object> getAll() {
        return redisTemplate.opsForHash().entries(User.class.getName());
    }

    // U
    public void update(String id, User user) {
        redisTemplate.opsForHash().put(User.class.getName(), id, user);
    }

    // D
    public void deleteByIds(List<String> ids) {
        redisTemplate.opsForHash().delete(User.class.getName(), ids.toArray());
    }

    public void deleteById(String id) {
        redisTemplate.opsForHash().delete(User.class.getName(), id);
    }
}
