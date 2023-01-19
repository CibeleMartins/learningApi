package br.com.learning.learningapijava.repository;

import java.util.ArrayList;
// import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.learning.learningapijava.model.UserLearner;
import br.com.learning.learningapijava.model.exception.ResourceNotFoundException;

@Repository
public class UserLearnerRepository_old {
    

    List<UserLearner> UserrBd = new ArrayList<UserLearner>(); 
    Integer UserrId = 0;


    public List<UserLearner> getAllUserrs() {

        return UserrBd;
    }


    public Optional<UserLearner> getUserrById(Integer id) {

        Optional<UserLearner> haveUserrId = UserrBd.stream().filter(Userr -> Userr.getId() == id).findFirst();

        if(haveUserrId.isEmpty()) {

            throw new ResourceNotFoundException("Usuário não encontrado.");
        }

        return haveUserrId;

    }

    public UserLearner registerUserr(UserLearner Userr) {

        UserrId++;

        Userr.setId(UserrId);

        UserrBd.add(Userr);

        return Userr;
    }

    public UserLearner updateUserr(UserLearner Userr) {

        Optional<UserLearner> haveUserr = getUserrById(Userr.getId());

        if (haveUserr.isEmpty()) {

            throw new ResourceNotFoundException("Não é possível atualizar um usuário não existente.");
        }

        deleteUserr(Userr.getId());

        UserrBd.add(Userr);
        return Userr;
    }

    public void deleteUserr(Integer id) {

        // UserrBd.removeIf(Userr -> Userr.getId() == id);

        Optional<UserLearner> haveUserr = UserrBd.stream().filter(Userr -> Userr.getId() == id).findFirst();

        if (haveUserr.isEmpty()){

            throw new ResourceNotFoundException("Não é possível deletar um usuário não existente.");
        }
    }
}
