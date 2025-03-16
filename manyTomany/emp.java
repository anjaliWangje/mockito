package manyTomany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class emp {
    @Id
    private int eid;
    private String name;
    @ManyToMany
    private List<Project> projects;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {

        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public List<Project> getProjects() {

        return projects;
    }

    public void setProjects(List<Project> projects) {

        this.projects = projects;
    }

    public emp(int eid, String name, List<Project> projects) {
        this.eid = eid;
        this.name = name;
        this.projects = projects;
    }

    public emp() {
        super();
    }
}
