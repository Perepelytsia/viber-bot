package com.example.model.admin;

import com.example.model.postgre.Answer;
import com.example.model.postgre.Question;
import java.util.List;

public class ChatModel {
    protected List<Answer> answers;
    protected List<Question> questions;

    public ChatModel(List<Answer> answers, List<Question> questions) {
        this.answers = answers;
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}