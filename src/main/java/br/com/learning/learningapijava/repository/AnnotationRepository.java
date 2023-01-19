package br.com.learning.learningapijava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.learning.learningapijava.model.AnnotationUser;

@Repository
public interface AnnotationRepository extends JpaRepository<AnnotationUser, Integer> {
    
}
