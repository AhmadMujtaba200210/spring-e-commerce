package com.shopme.admin.user;

import com.shopme.shopmecommon.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;
    @Test
    public void testCreateFirstRole(){
        Role roleAdmin = new Role("Admin","manage everything");
        Role savedRole=roleRepository.save(roleAdmin);
        assertThat(savedRole.getId()).isGreaterThan(0);
    }

    @Test
    public void testRestRoles(){
        Role roleSalesPerson=new Role("Salesperson","manage product price");
        Role roleEditor=new Role("Editor","manage categories, brands, "+"products, articles and menus");
        Role roleShipper=new Role("Shipper","view products, view orders "+"and update order status");
        Role roleAssistant=new Role("Assistant","manage questions and reviews");
        roleRepository.saveAll(List.of(roleSalesPerson,roleEditor,roleShipper,roleAssistant));
    }

}
