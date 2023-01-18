package br.com.learning.learningapijava.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.learning.learningapijava.model.User;

@Repository
public class UserRepository {
    

    List<User> userBd = new ArrayList<User>(); 
    Integer userId = 0;


    public List<User> getAllUsers() {

        return userBd;
    }


    public Optional<User> getUserById(Integer id) {

       return userBd.stream().filter(user -> user.getId() == id).findFirst();

    }

    public User registerUser(User user) {

        userId++;

        user.setId(userId);

        userBd.add(user);

        return user;
    }

    public User updateUser(User user) {

        Optional<User> haveUser = getUserById(user.getId());

        if (haveUser.isEmpty()) {

            throw new InputMismatchException("Usuário não encontrado.");
        }

        deleteUser(user.getId());

        userBd.add(user);
        return user;
    }

    public void deleteUser(Integer id) {

        userBd.removeIf(user -> user.getId() == id);
    }
}
