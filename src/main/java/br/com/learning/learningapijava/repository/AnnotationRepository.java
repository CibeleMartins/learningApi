package br.com.learning.learningapijava.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.learning.learningapijava.model.AnnotationUser;

@Repository
public class AnnotationRepository {

    List<AnnotationUser> annotationBd = new ArrayList<AnnotationUser>(); 
    Integer annotationUserId = 0;


    public List<AnnotationUser> getAllAnnotations() {

        return annotationBd;
    }


    public Optional<AnnotationUser> getAnnotationById(Integer id) {

       return annotationBd.stream().filter(annotation -> annotation.getId() == id).findFirst();

    }

    public AnnotationUser registerAnnotation(AnnotationUser annotation) {

        annotationUserId++;
        // mudar para o id do usuario

        annotation.setId(annotationUserId);

        annotationBd.add(annotation);

        return annotation;
    }

    public AnnotationUser updateAnnotation(AnnotationUser annotation) {

        Optional<AnnotationUser> haveUser = getAnnotationById(annotation.getId());

        if (haveUser.isEmpty()) {

            throw new InputMismatchException("Usuário não encontrado.");
        }

        deleteAnnotation(annotation.getId());

        annotationBd.add(annotation);
        return annotation;
    }

    public void deleteAnnotation(Integer id) {

        annotationBd.removeIf(annotation -> annotation.getId() == id);
    }
}
