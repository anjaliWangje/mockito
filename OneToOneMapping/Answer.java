package OneToOneMapping;

import jakarta.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="answer_id")
    private int AnswerId;
    private  String Answer;


    public int getAnswerId() {
        return AnswerId;
    }

    public void setAnswerId(int answerId) {
        AnswerId = answerId;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }


    public Answer(int answerId,String Answer) {
        AnswerId = answerId;
        this.Answer=Answer;



    }
    public Answer(){
        super();
    }

    @Override
    public String toString() {
        return "Answer{" +
                "AnswerId=" + AnswerId +
                ", Answer='" + Answer + '\'' +
                '}';
    }
}
