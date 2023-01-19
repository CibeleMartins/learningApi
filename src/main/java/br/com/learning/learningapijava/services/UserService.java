package br.com.learning.learningapijava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.learning.learningapijava.model.User;
import br.com.learning.learningapijava.repository.UserRepository;
import br.com.learning.learningapijava.repository.UserRepository_old;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }


    public Optional<User> getUserById(Integer id) {

       return userRepository.findById(id);

    }

    public String registerUser(User user) {

        user.setId(null);
        userRepository.save(user);

        return "Usuário cadastrado com sucesso.";
    }

    public String updateUser(Integer id,User user) {

        user.setId(id);

        userRepository.save(user);
        return "Usuário atualizado com sucesso.";
    }

    public String deleteUser(Integer id) {

        userRepository.deleteById(id);

        return "Usuário deletado com sucesso.";
    }


}
