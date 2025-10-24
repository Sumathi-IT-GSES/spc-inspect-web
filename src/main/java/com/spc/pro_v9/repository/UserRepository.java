package com.spc.pro_v9.repository;

import com.spc.pro_v9.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository - built-in Spring interface that provides all CRUD (Create, Read, Update, Delete) operations automatically
//User → The entity class
//Integer → The type of your primary key
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameAndPassword(String username, String password);
}


//@Repository
//public class UserRepository {
//
//    private final List<User> users = new ArrayList<>();
//
////    public void save(User user){
////        users.add(user);
////    }
////
////    public List<User> findAll(){
////        return users;
////    }
//
//    public UserRepository() {
//        users.add(new User(1, "admin", "123"));
//        users.add(new User(2, "user", "abc"));
//    }
//
//    // Find user by username and password
//    public User findByUsernameAndPassword(String username, String password) {
//
//        System.out.println("Check the validity of username & password --------");
//
//        return users.stream()
//                // filters down to the user who has both the same username and password
//                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
//                // After filtering, it takes the first matching user
//                .findFirst()
//                .orElse(null);
//    }
//
//
//
//}
