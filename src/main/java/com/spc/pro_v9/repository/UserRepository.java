package com.spc.pro_v9.repository;

import com.spc.pro_v9.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository - built-in Spring interface that provides all CRUD (Create, Read, Update, Delete) operations automatically
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameAndPassword(String username, String password);
}

