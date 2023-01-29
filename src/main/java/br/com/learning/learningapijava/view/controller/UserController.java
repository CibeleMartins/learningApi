package br.com.learning.learningapijava.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.print.DocFlavor.STRING;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.learning.learningapijava.services.UserService;
import br.com.learning.learningapijava.shared.UserDTO;
import br.com.learning.learningapijava.view.model.UserLearnerRequest;
import br.com.learning.learningapijava.view.model.UserLearnerResponse;
import br.com.learning.learningapijava.model.UserLearner;



@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper mapper;
    
    @GetMapping
    public ResponseEntity<List<UserLearnerResponse>> getAllUsers() {

        List<UserDTO> usersDtos = userService.getAllUsers();

        ModelMapper mapper = new ModelMapper();

        List<UserLearnerResponse> usersResponse = usersDtos.stream().map(uDto -> mapper.map(uDto,UserLearnerResponse.class)).collect(Collectors.toList());

        return new ResponseEntity<>(usersResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserLearnerResponse>> getUserById(@PathVariable Integer id) {

      Optional<UserDTO> userDtoExists = userService.getUserById(id);

      UserLearnerResponse userResponse = new ModelMapper().map(userDtoExists.get(), UserLearnerResponse.class);
        
      return new ResponseEntity<>(Optional.of(userResponse), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserLearnerResponse> registerUser(@RequestBody UserLearnerRequest userReq) {
        ModelMapper mapper = new ModelMapper();

        UserDTO userDto = mapper.map(userReq, UserDTO.class);

        userDto =  userService.registerUser(userDto);

        UserLearnerResponse userResponse = mapper.map(userDto, UserLearnerResponse.class);

        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserLearnerResponse> updateUser(@PathVariable Integer id, @RequestBody UserLearnerRequest userReq) {
        
        ModelMapper mapper = new ModelMapper();

        UserDTO userDto =  mapper.map(userReq, UserDTO.class);    

        userDto = userService.updateUser(id, userDto);

        UserLearnerResponse userResponse = mapper.map(userDto,UserLearnerResponse.class);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {

        userService.deleteUser(id);

        return new ResponseEntity<String>("Usuário deletado com sucesso", HttpStatus.OK);
    }


}
