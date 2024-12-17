import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public ResponseEntity<String> startQuizSession() {
        quizService.startNewSession();
        return ResponseEntity.ok("New quiz session started.");
    }

    @GetMapping("/question")
    public ResponseEntity<Question> getRandomQuestion() {
        return ResponseEntity.ok(quizService.getRandomQuestion());
    }
    @PostMapping("/submit")
        public ResponseEntity<String> submitAnswer(@RequestParam Long questionId, @RequestParam String answer) {
            quizService.submitAnswer(questionId, answer);
            return ResponseEntity.ok("Answer submitted.");
        }

        @GetMapping("/summary")
        public ResponseEntity<UserSession> getQuizSummary() {
            return ResponseEntity.ok(quizService.getSummary());
        }
    }