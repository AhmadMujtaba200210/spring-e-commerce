package com.shopme.admin.user;

import com.shopme.shopmecommon.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

}
