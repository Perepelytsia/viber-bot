package com.example.repository;


import com.example.model.postgre.Answer;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
     List<Answer> findByUid(String uid);
}
