package br.com.learning.learningapijava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.learning.learningapijava.model.User;
import br.com.learning.learningapijava.repository.UserRepository_old;


@Service
public class UserService {

    @Autowired
    private UserRepository_old userRepository;
    
    public List<User> getAllUsers() {

        return userRepository.getAllUsers();
    }


    public Optional<User> getUserById(Integer id) {

       return userRepository.getUserById(id);

    }

    public String registerUser(User user) {

        userRepository.registerUser(user);

        return "Usuário cadastrado com sucesso.";
    }

    public String updateUser(Integer id,User user) {

        user.setId(id);

        userRepository.updateUser(user);
        return "Usuário atualizado com sucesso.";
    }

    public String deleteUser(Integer id) {

        userRepository.deleteUser(id);

        return "Usuário deletado com sucesso.";
    }


}
