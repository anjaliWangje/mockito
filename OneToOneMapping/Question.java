package OneToOneMapping;

import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(name = "question_id")
    private int questionId;
    private String question;
    @OneToOne
    @JoinColumn(name = "question_id")

    private Answer Answer;





    public Question() {
        super();
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public OneToOneMapping.Answer getAnswer() {
        return Answer;
    }

    public void setAnswer(OneToOneMapping.Answer answer) {
        Answer = answer;
    }

    public Question(int questionId, String question, Answer Answer) {
        this.questionId = questionId;
        this.question = question;
        this.Answer=Answer;


    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", Answer='" + Answer + '\'' +
                '}';
    }
}