package OneToManymapping;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int collegecode;
    private String CollegeName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Departmentt department;

    public College(String s, int i) {
    }

    public College() {

    }

    public int getCollegecode() {

        return collegecode;
    }

    public void setCollegecode(int collegecode) {

        this.collegecode = collegecode;
    }

    public String getCollegeName() {
        return CollegeName;
    }

    public void setCollegeName(String collegeName) {

        CollegeName = collegeName;
    }

    public Departmentt getDepartment() {
        return department;
    }

    public void setDepartment(Departmentt department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "College{" +
                "collegecode=" + collegecode +
                ", CollegeName='" + CollegeName + '\'' +
                ", department=" + department +
                '}';
    }
}
