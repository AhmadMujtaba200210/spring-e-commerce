package com.shopme.admin.user;

import com.shopme.shopmecommon.entity.Role;
import com.shopme.shopmecommon.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;
    @Autowired
    private TestEntityManager testEntityManager;
    @Test
    public void testCreateUser(){
        Role roleAdmin=testEntityManager.find(Role.class,1);
        User userNameHM=new User("ahmad@codejava.net","ahmad2020","ahmad","mujtaba");
        userNameHM.addRole(roleAdmin);
        User savedUser=repository.save(userNameHM);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateNewUserWithTwoRoles(){
        User userMujtaba=new User("mujtaba@gmail.com","mujtaba200","Ahmad","Mujtaba");
        Role roleEditor=new Role(3);
        Role roleAssistant=new Role(5);

        userMujtaba.addRole(roleEditor);
        userMujtaba.addRole(roleAssistant);

        User savedUser = repository.save(userMujtaba);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAllUsers(){
        Iterable<User> listUsers=repository.findAll();
        listUsers.forEach(System.out::println);
    }

    @Test
    public void testGetUserById(){
        User userName=repository.findById(1).get();
        System.out.println(userName);
        assertThat(userName).isNotNull();
    }

    public void testUpdateUserDetails(){

    }
}
