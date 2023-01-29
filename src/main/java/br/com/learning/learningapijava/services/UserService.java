package br.com.learning.learningapijava.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.learning.learningapijava.model.UserLearner;
import br.com.learning.learningapijava.model.exception.ResourceNotFoundException;
import br.com.learning.learningapijava.repository.UserLearnerRepository;
// import br.com.learning.learningapijava.repository.UserRepository_old;
import br.com.learning.learningapijava.shared.UserDTO;


@Service
public class UserService {

    @Autowired
    private UserLearnerRepository userRepository;
    
    public List<UserDTO> getAllUsers() {

        // return a list of users
        List<UserLearner> users = userRepository.findAll();

        return users.stream().map(u -> new ModelMapper().map(u, UserDTO.class)).collect(Collectors.toList());
    }


    public Optional<UserDTO> getUserById(Integer id) {

    //    get optional user model in BD
       Optional<UserLearner> user = userRepository.findById(id);

    //    verify if user model is empty
       if(user.isEmpty()) {
        throw new ResourceNotFoundException("O usuário solicitado não existe");
       }

    //    transform user model in DTO (get user model optional with method get())
       UserDTO userDto = new ModelMapper().map(user.get(), UserDTO.class);

    //    return a optional of() -> userDto
       return Optional.of(userDto);

    }

    public UserDTO registerUser(UserDTO userDto) {

        // remove id of user DTO
        userDto.setId(null);

        // create object mapping
        ModelMapper mapper = new ModelMapper();

        // convert user DTO in user model
        UserLearner userModel = mapper.map(userDto, UserLearner.class);

        // saver user model in BD
        userModel =  userRepository.save(userModel);

        userDto.setId(userModel.getId());

        // return user DTO updated with id of user model saved in BD
        return userDto;
    }

    public UserDTO updateUser(Integer id,UserDTO userDto) {

        // pass id in user DTO
        userDto.setId(id);

        // create object mapping
        ModelMapper mapper = new ModelMapper();

        // convert user DTO em user Model
        UserLearner userModel = mapper.map(userDto, UserLearner.class);
        // update user in BD
        userRepository.save(userModel);

        // return user DTO updated
       return userDto;
    }

    public String deleteUser(Integer id) {

        // verify if user exists
        Optional<UserLearner> userModelExistis = userRepository.findById(id);

        if(userModelExistis.isEmpty()) {
            throw new ResourceNotFoundException("O usuário que você quer deletar não foi encontrado.");
        }

        userRepository.deleteById(id);

        return "Usuário deletado com sucesso.";
    }


}
