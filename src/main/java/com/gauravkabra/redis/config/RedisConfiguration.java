package com.gauravkabra.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {

    @Bean
    public RedisConnectionFactory getRedisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        // KEY, HASH
        // HASH = <key, value>
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // Lettuce is Advanced Java Redis client - a scalable thread-safe Redis client for synchronous, asynchronous and reactive usage
        redisTemplate.setConnectionFactory(getRedisConnectionFactory());
        // String <-> bytes
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // Object <-> JSON
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }
}
