package br.com.learning.learningapijava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.learning.learningapijava.model.UserLearner;


@Repository
public interface UserLearnerRepository extends JpaRepository<UserLearner, Integer> {
    
}
