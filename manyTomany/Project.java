package manyTomany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Project {
    @Id
    private int pid;
    @Column(name = "project_name")
    private String projectname;
    @ManyToMany(mappedBy = "projects")
    private List<emp>emps;

    public int getPid() {

        return pid;
    }

    public void setPid(int pid) {

        this.pid = pid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {

        this.projectname = projectname;
    }

    public List<emp> getEmps() {

        return emps;
    }

    public void setEmps(List<emp> emps) {

        this.emps = emps;
    }

    public Project(int pid,String projectname,List<emp>emps) {
        this.pid = pid;
        this.projectname=projectname;
        this.emps=emps;
    }

    public Project (){
        super();
    }
}
