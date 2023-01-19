package br.com.learning.learningapijava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.learning.learningapijava.model.UserLearner;
import br.com.learning.learningapijava.repository.UserLearnerRepository;
// import br.com.learning.learningapijava.repository.UserRepository_old;


@Service
public class UserService {

    @Autowired
    private UserLearnerRepository userRepository;
    
    public List<UserLearner> getAllUsers() {

        return userRepository.findAll();
    }


    public Optional<UserLearner> getUserById(Integer id) {

       return userRepository.findById(id);

    }

    public String registerUser(UserLearner user) {

        user.setId(null);
        userRepository.save(user);

        return "Usuário cadastrado com sucesso.";
    }

    public String updateUser(Integer id,UserLearner user) {

        user.setId(id);

        userRepository.save(user);
        return "Usuário atualizado com sucesso.";
    }

    public String deleteUser(Integer id) {

        userRepository.deleteById(id);

        return "Usuário deletado com sucesso.";
    }


}
