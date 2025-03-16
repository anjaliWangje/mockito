package OneToManymapping;
import jakarta.persistence.*;

import java.util.Set;

@Entity

public class Departmentt {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int DepartentId;
        private String DepartmentName;
        @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)

        private Set<College>colleges;
    public Departmentt() {

    }

    public Departmentt(int i, String electricalEngineering) {
    }

    public int getDepartentId() {
            return DepartentId;
        }

        public void setDepartentId(int departentId) {
            DepartentId = departentId;
        }

        public String getDepartmentName() {
            return DepartmentName;
        }

        public void setDepartmentName(String departmentName) {
            DepartmentName = departmentName;
        }

    public Set<College> getColleges() {
        return colleges;
    }

    public void setColleges(Set<College> colleges) {
        this.colleges = colleges;
    }

    public Departmentt(int departentId, String Departmentname, College college) {
            this. DepartentId = departentId;
            this.DepartmentName=Departmentname;
        }

        @Override
        public String toString() {
            return "College{" +
                    "DepartentId=" + DepartentId +
                    ", DepartmentName='" + DepartmentName + '\'' +
                    '}';
        }


}


