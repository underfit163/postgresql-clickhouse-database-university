package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Subject {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "subjectid", nullable = false)
    private int subjectid;
    @Basic
    @Column(name = "subjectname", nullable = false, length = 50)
    private String subjectname;
    @OneToMany(mappedBy = "subjectBySubjectidfk")
    private Collection<Exam> examsBySubjectid;
    @ManyToOne
    @JoinColumn(name = "specialtyidfk", referencedColumnName = "specialtyid")
    private Specialty specialtyBySpecialtyidfk;

    public Subject(String subjectname, Specialty specialtyBySpecialtyidfk) {
        this.subjectname = subjectname;
        this.specialtyBySpecialtyidfk = specialtyBySpecialtyidfk;
    }

    public Subject() {

    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return subjectid == subject.subjectid && Objects.equals(subjectname, subject.subjectname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectid, subjectname);
    }

    public Collection<Exam> getExamsBySubjectid() {
        return examsBySubjectid;
    }

    public void setExamsBySubjectid(Collection<Exam> examsBySubjectid) {
        this.examsBySubjectid = examsBySubjectid;
    }

    public Specialty getSpecialtyBySpecialtyidfk() {
        return specialtyBySpecialtyidfk;
    }

    public void setSpecialtyBySpecialtyidfk(Specialty specialtyBySpecialtyidfk) {
        this.specialtyBySpecialtyidfk = specialtyBySpecialtyidfk;
    }

}
