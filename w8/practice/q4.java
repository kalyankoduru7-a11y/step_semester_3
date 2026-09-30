abstract class Question {
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    Question(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();
}

class MCQ extends Question {

    MCQ(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class TF extends Question {

    TF(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class Essay extends Question {

    Essay(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double calculateScore() {

        String[] keywords = correctAnswer.split(",");
        int count = 0;

        String answer = studentAnswer.toLowerCase();

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Question[] questions = {
            new MCQ("Paris", "Paris", 10),
            new TF("False", "True", 5),
            new Essay(
                "Inheritance, Polymorphism, Encapsulation",
                "Polymorphism is one.",
                20
            ),
            new Essay(
                "Abstraction, Composition",
                "I talked about abstraction.",
                15
            )
        };

        double total = 0;

        for (Question q : questions) {

            double score = q.calculateScore();

            if (q instanceof MCQ) {
                System.out.printf("MCQ: %.2f%n", score);
            } else if (q instanceof TF) {
                System.out.printf("TF: %.2f%n", score);
            } else {
                System.out.printf("ESSAY: %.2f%n", score);
            }

            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}
