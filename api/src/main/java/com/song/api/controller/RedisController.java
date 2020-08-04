package com.song.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 宋利军
 */
@RestController
@RequestMapping(value = "/")
@Api(value = "redis相关接口", tags = "redis相关接口")
public class RedisController {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @GetMapping(value = "/setKey")
    @ApiOperation(value = "存储数据", httpMethod = "GET")
    public Map setKey(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        redisTemplate.opsForValue().set(key, value);
        Map result = new HashMap(2);
        result.put("result", "test用户");
        return result;

    }

    @GetMapping(value = "/getKey")
    @ApiOperation(value = "获取数据", httpMethod = "GET", notes = "获取数据")
    public Object getKey(@RequestParam(value = "key") String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public boolean existsKey(String key) {
        return redisTemplate.hasKey(key);
    }

}
