package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Faculty {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "facultyid", nullable = false)
    private int facultyid;
    @Basic
    @Column(name = "facultyname", nullable = false, length = 50)
    private String facultyname;
    @OneToMany(mappedBy = "facultyByFacultyidfk")
    private Collection<Specialty> specialtiesByFacultyid;

    public Faculty(String facultyname) {
        this.facultyname = facultyname;
    }

    public Faculty() {

    }

    public int getFacultyid() {
        return facultyid;
    }

    public void setFacultyid(int facultyid) {
        this.facultyid = facultyid;
    }

    public String getFacultyname() {
        return facultyname;
    }

    public void setFacultyname(String facultyname) {
        this.facultyname = facultyname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return facultyid == faculty.facultyid && Objects.equals(facultyname, faculty.facultyname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyid, facultyname);
    }

    public Collection<Specialty> getSpecialtiesByFacultyid() {
        return specialtiesByFacultyid;
    }

    public void setSpecialtiesByFacultyid(Collection<Specialty> specialtiesByFacultyid) {
        this.specialtiesByFacultyid = specialtiesByFacultyid;
    }
}
