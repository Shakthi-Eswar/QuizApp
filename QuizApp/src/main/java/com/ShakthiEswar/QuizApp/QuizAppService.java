import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserSessionRepository userSessionRepository;

    private static final Long USER_ID = 1L; // Static single user for simplicity
    public void startNewSession() {
        UserSession session = userSessionRepository.findByUserId(USER_ID);
        if (session == null) {
            session = new UserSession();
            session.setUserId(USER_ID);
        }
        session.setTotalQuestionsAnswered(0);
        session.setCorrectAnswers(0);
        session.setIncorrectAnswers(0);
        userSessionRepository.save(session);
    }

    public Question getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        if (questions.isEmpty()) throw new RuntimeException("No questions available.");
        return questions.get(new Random().nextInt(questions.size()));
    }
    public void submitAnswer(Long questionId, String answer) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found."));
        UserSession session = userSessionRepository.findByUserId(USER_ID);

        if (session == null) throw new RuntimeException("Session not started.");
        session.setTotalQuestionsAnswered(session.getTotalQuestionsAnswered() + 1);

        if (question.getCorrectAnswer().equalsIgnoreCase(answer)) {
            session.setCorrectAnswers(session.getCorrectAnswers() + 1);
        } else {
            session.setIncorrectAnswers(session.getIncorrectAnswers() + 1);
        }

        userSessionRepository.save(session);
    }

    public UserSession getSummary() {
        return userSessionRepository.findByUserId(USER_ID);
    }
}
