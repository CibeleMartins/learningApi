package br.com.learning.learningapijava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.learning.learningapijava.repository.AnnotationRepository;
// import br.com.learning.learningapijava.repository.AnnotationRepository_old;

import br.com.learning.learningapijava.model.AnnotationUser;
@Service
public class AnnotationService {

    @Autowired
    private AnnotationRepository annotationUserRepository;

    public List<AnnotationUser> getAllAnnotationUsers() {

        return annotationUserRepository.findAll();
    }

    public Optional<AnnotationUser> getAnnotationUserById(Integer id) {

        return annotationUserRepository.findById(id);

    }

    public String registerAnnotationUser(AnnotationUser AnnotationUser) {

        AnnotationUser.setId(null);
        annotationUserRepository.save(AnnotationUser);

        return "Anotação cadastrada com sucesso.";
    }

    public String updateAnnotationUser(Integer id, AnnotationUser AnnotationUser) {

        AnnotationUser.setId(id);

        annotationUserRepository.save(AnnotationUser);
        return "Anotação atualizada com sucesso.";
    }

    public String deleteAnnotationUser(Integer id) {

        annotationUserRepository.deleteById(id);

        return "Anotação deletada com sucesso.";
    }
}
