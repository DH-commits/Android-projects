package com.battlequiz.battlequizjava;

import java.util.Random;

public enum QuestionAnswers {
    QUESTION1(1, "Grand Central Terminal, Park Avenue, New York is the world's", "largest railway station", "highest railway station", "longest railway station", "None of the above", "A" ),
    QUESTION2(2, "Entomology is the science that studies", "Behavior of human beings", "Insects", "\tThe origin and history of technical and scientific terms", "The formation of rocks", "B"),
    QUESTION3(3, "Eritrea, which became the 182nd member of the UN in 1993, is in the continent of", "Asia", "Africa", "Europe", "Australia", "B");

    QuestionAnswers(int questionNumber, String question, String answerA, String answerB, String answerC, String answerD, String correctAnswer) {
        this.questionNumber = questionNumber;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
    }
    QuestionAnswers(){

    }
    public static QuestionAnswers initialiseQuestion(){
        return QuestionAnswers.values()[new Random().nextInt(QuestionAnswers.values().length)];
    }
    public int getQuestionNumber() {
        return questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    private int questionNumber;
    private String question;
    private String answerA, answerB, answerC, answerD;
    private String correctAnswer;



}
