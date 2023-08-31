package com.shopme.admin.user;

import com.shopme.shopmecommon.entity.Role;
import com.shopme.shopmecommon.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;
    private final RoleRepository roleRepository;
    public UserService(UserRepository repo, RoleRepository roleRepository) {
        this.repo = repo;
        this.roleRepository = roleRepository;
    }

    public List<User> listAll(){
        return  (List<User>)  repo.findAll();
    }
    public List<Role> listRoles(){
        return  (List<Role>)  roleRepository.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }
}
