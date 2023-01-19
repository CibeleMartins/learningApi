package br.com.learning.learningapijava.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.learning.learningapijava.model.User;
import br.com.learning.learningapijava.model.exception.ResourceNotFoundException;

@Repository
public class UserRepository_old {
    

    List<User> userBd = new ArrayList<User>(); 
    Integer userId = 0;


    public List<User> getAllUsers() {

        return userBd;
    }


    public Optional<User> getUserById(Integer id) {

        Optional<User> haveUserId = userBd.stream().filter(user -> user.getId() == id).findFirst();

        if(haveUserId.isEmpty()) {

            throw new ResourceNotFoundException("Usuário não encontrado.");
        }

        return haveUserId;

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

            throw new ResourceNotFoundException("Não é possível atualizar um usuário não existente.");
        }

        deleteUser(user.getId());

        userBd.add(user);
        return user;
    }

    public void deleteUser(Integer id) {

        // userBd.removeIf(user -> user.getId() == id);

        Optional<User> haveUser = userBd.stream().filter(user -> user.getId() == id).findFirst();

        if (haveUser.isEmpty()){

            throw new ResourceNotFoundException("Não é possível deletar um usuário não existente.");
        }
    }
}
