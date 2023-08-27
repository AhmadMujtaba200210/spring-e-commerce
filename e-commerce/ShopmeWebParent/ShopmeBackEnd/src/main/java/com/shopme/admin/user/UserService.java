package com.shopme.admin.user;

import com.shopme.shopmecommon.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> listAll(){
        return  (List<User>)  repo.findAll();
    }
}
