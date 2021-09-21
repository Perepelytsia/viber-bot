package com.example;

import com.example.model.postgre.AnswerModel;
import com.example.repository.AnswerRepository;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
public class AnswerRepositoryIntegrationTest {
    @Autowired
    protected AnswerRepository repoAnswer;
    
    @Test
    public void correctNumberOfAnswers() {
        repoAnswer.save(new AnswerModel("test", "testing"));
        List<AnswerModel> answers = (List<AnswerModel>) repoAnswer.findAll();
        assertEquals(1, answers.size());
    }
}
