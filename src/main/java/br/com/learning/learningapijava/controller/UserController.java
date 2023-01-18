package br.com.learning.learningapijava.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.learning.learningapijava.services.UserService;
import br.com.learning.learningapijava.model.User;



@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {

       return userService.getUserById(id);

    }

    @PostMapping
    public String registerUser(@RequestBody User user) {

        userService.registerUser(user);

        return "Usuário cadastrado com sucesso.";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody User user) {

        userService.updateUser(id,user);
        return "Usuário atualizado com sucesso.";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {

        userService.deleteUser(id);

        return "Usuário deletado com sucesso.";
    }


}
