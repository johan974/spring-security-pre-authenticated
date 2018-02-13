package com.oreilly.security.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/*
 * localhost:8080 ==> foutmelding
 * GET localhost:8080 + header: key = SM_USER, value =  'demo' ==> welcome
 * GET localhost:8080/users + header: key = SM_USER, value =  'demo' ==> welcome
 */

@Controller
@RequestMapping("/users")
public class DemoController
{
    @RequestMapping(method = RequestMethod.GET, value="/{id}", headers="Accept=application/xml")
    public @ResponseBody User getUserById(@PathVariable String id)
    {
        User user = new User();
        user.setFirstName("john");
        user.setLastName("adward");
        return user;
    }

    @RequestMapping(method = RequestMethod.GET,  headers="Accept=application/xml")
    public @ResponseBody
    Users getAllUsers()
    {
        User user1 = new User();
        user1.setFirstName("john");
        user1.setLastName("adward");

        User user2 = new User();
        user2.setFirstName("tom");
        user2.setLastName("hanks");

        Users users = new Users();
        users.setUsers(new ArrayList<User>());
        users.getUsers().add(user1);
        users.getUsers().add(user2);

        return users;
    }
}
