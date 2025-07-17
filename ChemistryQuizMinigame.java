/**
 * Example minigame for the chemistry classroom - Simple math quiz
 * 
 * German Color Reference for Engine Alpha:
 * - "rot" = red
 * - "blau" = blue  
 * - "gruen" = green
 * - "gelb" = yellow
 * - "schwarz" = black
 * - "weiss" = white
 * - "grau" = gray
 * - "orange" = orange
 * - "violett" = purple
 * - "hellblau" = light blue
 * - "dunkelblau" = dark blue
 * - "hellgruen" = light green
 * - "dunkelgruen" = dark green
 */
public class ChemistryQuizMinigame implements Minigame {
    private boolean active = false;
    private TEXT questionText;
    private TEXT answerText;
    private RECHTECK background;
    private int currentQuestion = 0;
    private String[] questions = {
        "What is H2O?",
        "What is the symbol for Gold? (German: Gold)",
        "How many electrons does Carbon have? (German: Kohlenstoff)"
    };
    private String[] answers = {"water", "au", "6"};
    private String userAnswer = "";
    
    public ChemistryQuizMinigame() {
        // Initialize UI elements
        questionText = new TEXT(0, 10, 12, "");
        answerText = new TEXT(0, -10, 10, "");
        background = new RECHTECK();
        background.setzeGroesse(100.0, 60.0);
        background.setzeMittelpunkt(0, 0);
        background.setzeFarbe("hellblau"); // German for light blue
        background.setzeTransparenz(0.8f);
        
        // Start with all UI elements hidden
        background.setzeSichtbar(false);
        questionText.setzeSichtbar(false);
        answerText.setzeSichtbar(false);
    }
    
    @Override
    public void start() {
        active = true;
        currentQuestion = 0;
        userAnswer = "";
        showQuestion();
        
        // Show minigame UI
        background.setzeSichtbar(true);
        questionText.setzeSichtbar(true);
        answerText.setzeSichtbar(true);
        
        System.out.println("Chemistry Quiz started! Type your answer and press Enter.");
        System.out.println("Chemie-Quiz gestartet! Antwort eingeben und Enter drücken.");
    }
    
    @Override
    public void stop() {
        active = false;
        
        // Hide minigame UI
        background.setzeSichtbar(false);
        questionText.setzeSichtbar(false);
        answerText.setzeSichtbar(false);
        
        // Clear any text displays
        Main.displayText.setzeInhalt("");
        
        System.out.println("Chemistry Quiz stopped.");
    }
    
    @Override
    public void update() {
        if (!active) return;
        
        // Update display
        answerText.setzeInhalt("Your answer: " + userAnswer);
        answerText.setzeMittelpunkt(0, -10);
    }
    
    @Override
    public void handleClick(double x, double y) {
        // For this quiz, we mainly use keyboard input
        // Could add clickable answer buttons here
    }
    
    @Override
    public void handleKeyPress(int keyCode) {
        if (!active) return;
        
        // Handle typing
        if (keyCode >= 65 && keyCode <= 90) { // A-Z
            userAnswer += (char) (keyCode + 32); // Convert to lowercase
        } else if (keyCode >= 97 && keyCode <= 122) { // a-z
            userAnswer += (char) keyCode;
        } else if (keyCode >= 48 && keyCode <= 57) { // 0-9
            userAnswer += (char) keyCode;
        } else if (keyCode == 8 && userAnswer.length() > 0) { // Backspace
            userAnswer = userAnswer.substring(0, userAnswer.length() - 1);
        } else if (keyCode == 10 || keyCode == 13) { // Enter
            checkAnswer();
        }
    }
    
    @Override
    public boolean isActive() {
        return active;
    }
    
    @Override
    public String getName() {
        return "Chemistry Quiz";
    }
    
    @Override
    public void onComplete() {
        Main.displayText.setzeInhalt("Congratulations! You completed the Chemistry Quiz! Gut gemacht!");
        Main.displayText.setzeMittelpunkt(0, 0);
        
        // Could award points, unlock content, etc.
        System.out.println("Chemistry Quiz completed successfully! Chemie-Quiz erfolgreich abgeschlossen!");
        
        // Auto-stop after a delay or wait for player input
        stop();
    }
    
    private void showQuestion() {
        if (currentQuestion < questions.length) {
            questionText.setzeInhalt(questions[currentQuestion]);
            questionText.setzeMittelpunkt(0, 10);
        }
    }
    
    private void checkAnswer() {
        if (currentQuestion < questions.length) {
            if (userAnswer.toLowerCase().trim().equals(answers[currentQuestion])) {
                System.out.println("Correct! Richtig!");
                currentQuestion++;
                userAnswer = "";
                
                if (currentQuestion >= questions.length) {
                    onComplete();
                } else {
                    showQuestion();
                }
            } else {
                System.out.println("Incorrect. Try again! Falsch. Versuche es nochmal!");
                userAnswer = "";
            }
        }
    }
}
