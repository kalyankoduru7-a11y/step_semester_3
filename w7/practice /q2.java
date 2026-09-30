class Scorecard {

    private boolean[] results;
    private int answerCount;

    // Constructor
    Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        answerCount = 0;
    }

    // Record answer
    void recordAnswer(boolean correct) {

        if (answerCount < results.length) {
            results[answerCount] = correct;
            answerCount++;
        } else {
            System.out.println("Cannot record more answers");
        }
    }

    // Calculate score
    int getScore() {

        int score = 0;

        for (int i = 0; i < answerCount; i++) {
            if (results[i] == true) {
                score++;
            }
        }

        return score;
    }
}

public class Main {
    public static void main(String[] args) {

        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}
