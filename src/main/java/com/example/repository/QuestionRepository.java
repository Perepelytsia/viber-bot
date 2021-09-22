package com.example.repository;

import com.example.model.admin.UserModel;
import com.example.model.admin.IUserModel;
import com.example.model.postgre.Question;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    
    List<Question> findByToken(Long token);
    
    List<Question> findByUid(String uid);
    
    @Query("SELECT new com.example.model.admin.UserModel(q.name, q.uid, COUNT(q.name)) " + "FROM Question AS q GROUP BY q.name, q.uid")
    List<UserModel> groupAndCountByName();
    
    // Spring Data JPA Projections
    @Query("SELECT q.name AS name, COUNT(q.name) as messages FROM Question AS q GROUP BY q.name")
    List<IUserModel> groupAndCountByName2();
}
