package com.example;

import com.example.model.postgre.Answer;
import com.example.repository.AnswerRepository;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class AnswerRepositoryIntegrationTest {
    @Autowired
    protected AnswerRepository repoAnswer;
    
    @Test
    public void correctNumberOfAnswers() {
        repoAnswer.save(new Answer("test", "testing"));
        List<Answer> answers = (List<Answer>) repoAnswer.findAll();
        assertEquals(1, answers.size());
    }
}
