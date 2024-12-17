import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private int totalQuestionsAnswered = 0;
    private int correctAnswers = 0;
    private int incorrectAnswers = 0;
}