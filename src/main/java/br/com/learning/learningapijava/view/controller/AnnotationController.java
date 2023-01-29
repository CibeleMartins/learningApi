package br.com.learning.learningapijava.view.controller;

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

import br.com.learning.learningapijava.services.AnnotationService;
import br.com.learning.learningapijava.model.AnnotationUser;

@RestController
@RequestMapping("/api/annotations")
public class AnnotationController {
    
    @Autowired
    private AnnotationService annotationService;
    
    @GetMapping
    public List<AnnotationUser> getAllUsers() {

        return annotationService.getAllAnnotationUsers();
    }

    @GetMapping("/{id}")
    public Optional<AnnotationUser> getUserById(@PathVariable Integer id) {

       return annotationService.getAnnotationUserById(id);

    }

    @PostMapping
    public String registerUser(@RequestBody AnnotationUser user) {

        annotationService.registerAnnotationUser(user);

        return "Anotação cadastrada com sucesso.";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody AnnotationUser user) {

        annotationService.updateAnnotationUser(id,user);
        return "Anotação atualizada com sucesso.";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {

        annotationService.deleteAnnotationUser(id);

        return "Anotação deletada com sucesso.";
    }

}
