package com.song.api.controller;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 宋利军
 */
@RestController
@RequestMapping(value = "/security", produces = MediaType.APPLICATION_JSON_VALUE)
public class SecurityController {

    @GetMapping(value = "/test")
    public Map test() {
        Map result = new HashMap(2);
        result.put("result", "test用户");
        return result;
    }

    @GetMapping(value = "/logout")
    public Map logout(HttpServletRequest request, HttpServletResponse response) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        Map result = new HashMap(2);
        result.put("result", "退出成功");
        return result;
    }

    @GetMapping(value = "/user")
    @PreAuthorize("hasRole('USER')")
    public Map user() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Map result = new HashMap(2);
        result.put("result", "user用户");
        return result;
    }

    @GetMapping(value = "/root")
    @PreAuthorize("hasRole('ROOT')")
    public Map root() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Map result = new HashMap(2);
        result.put("result", "root用户");
        return result;
    }

}
