package Task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {

    static class QuizQuestion {
        String question;
        String optionA;
        String optionB;
        String optionC;
        String optionD;
        char correctAnswer;

        public QuizQuestion(String question, String optionA, String optionB, String optionC, String optionD,
                char correctAnswer) {
            this.question = question;
            this.optionA = optionA;
            this.optionB = optionB;
            this.optionC = optionC;
            this.optionD = optionD;
            this.correctAnswer = correctAnswer;
        }
    }

    static List<QuizQuestion> questions = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize quiz questions and options here
        questions.add(new QuizQuestion("What is the capital of France?", "Paris", "Berlin", "Rome", "London", 'A'));

        int correctAnswers = 0;
        Timer timer = new Timer();

        for (QuizQuestion question : questions) {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Times up!");
                    System.exit(0);
                }
            }, 5000); // 5 seconds per question

            char answer = displayQuestion(question);

            if (answer == question.correctAnswer) {
                correctAnswers++;
            }

            timer.cancel();
        }

        System.out.println("Quiz completed!");
        System.out.println("Correct answers: " + correctAnswers);
        System.out.println("Total questions: " + questions.size());
    }

    public static char displayQuestion(QuizQuestion question) {
        System.out.println(question.question);
        System.out.println("A) " + question.optionA);
        System.out.println("B) " + question.optionB);
        System.out.println("C) " + question.optionC);
        System.out.println("D) " + question.optionD);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your answer: ");
            char answer = scanner.next().charAt(0);
            return answer;
        }
    }
}
