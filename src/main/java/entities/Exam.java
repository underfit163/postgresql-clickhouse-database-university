package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Exam {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "examid", nullable = false)
    private int examid;
    @Basic
    @Column(name = "passtype", nullable = false, length = 50)
    private String passtype;
    @Basic
    @Column(name = "totalhours", nullable = true)
    private Integer totalhours;
    @Basic
    @Column(name = "semester", nullable = false)
    private int semester;
    @ManyToOne
    @JoinColumn(name = "subjectidfk", referencedColumnName = "subjectid")
    private Subject subjectBySubjectidfk;
    @ManyToOne
    @JoinColumn(name = "teacheridfk", referencedColumnName = "teacherid")
    private Teacher teacherByTeacheridfk;
    @OneToMany(mappedBy = "examByExamidfk")
    private Collection<Mark> marksByExamid;

    public Exam(String passtype, Integer totalhours, int semester, Subject subjectBySubjectidfk, Teacher teacherByTeacheridfk) {
        this.passtype = passtype;
        this.totalhours = totalhours;
        this.semester = semester;
        this.subjectBySubjectidfk = subjectBySubjectidfk;
        this.teacherByTeacheridfk = teacherByTeacheridfk;
    }

    public Exam() {

    }

    public int getExamid() {
        return examid;
    }

    public void setExamid(int examid) {
        this.examid = examid;
    }

    public String getPasstype() {
        return passtype;
    }

    public void setPasstype(String passtype) {
        this.passtype = passtype;
    }

    public Integer getTotalhours() {
        return totalhours;
    }

    public void setTotalhours(Integer totalhours) {
        this.totalhours = totalhours;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return examid == exam.examid && semester == exam.semester && Objects.equals(passtype, exam.passtype) && Objects.equals(totalhours, exam.totalhours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examid, passtype, totalhours, semester);
    }

    public Subject getSubjectBySubjectidfk() {
        return subjectBySubjectidfk;
    }

    public void setSubjectBySubjectidfk(Subject subjectBySubjectidfk) {
        this.subjectBySubjectidfk = subjectBySubjectidfk;
    }

    public Teacher getTeacherByTeacheridfk() {
        return teacherByTeacheridfk;
    }

    public void setTeacherByTeacheridfk(Teacher teacherByTeacheridfk) {
        this.teacherByTeacheridfk = teacherByTeacheridfk;
    }

    public Collection<Mark> getMarksByExamid() {
        return marksByExamid;
    }

    public void setMarksByExamid(Collection<Mark> marksByExamid) {
        this.marksByExamid = marksByExamid;
    }
}
