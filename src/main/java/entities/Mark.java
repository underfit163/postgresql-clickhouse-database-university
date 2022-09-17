package entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Mark {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "markid", nullable = false)
    private int markid;
    @Basic
    @Column(name = "evaluation", length = 10)
    private String evaluation;
    @Basic
    @Column(name = "passdate", nullable = false)
    private Date passdate;

    @ManyToOne
    @JoinColumn(name = "studentidfk", referencedColumnName = "studentid")
    private Student studentByStudentidfk;

    @ManyToOne
    @JoinColumn(name = "examidfk", referencedColumnName = "examid")
    private Exam examByExamidfk;


    public Mark(String evaluation, Date passdate, Student studentByStudentidfk, Exam examByExamidfk) {
        this.evaluation = evaluation;
        this.passdate = passdate;
        this.studentByStudentidfk = studentByStudentidfk;
        this.examByExamidfk = examByExamidfk;
    }

    public Mark() {

    }

    public int getMarkid() {
        return markid;
    }

    public void setMarkid(int markid) {
        this.markid = markid;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public Date getPassdate() {
        return passdate;
    }

    public void setPassdate(Date passdate) {
        this.passdate = passdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        return markid == mark.markid && Objects.equals(evaluation, mark.evaluation) && Objects.equals(passdate, mark.passdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(markid, evaluation, passdate);
    }

    public Student getStudentByStudentidfk() {
        return studentByStudentidfk;
    }

    public void setStudentByStudentidfk(Student studentByStudentidfk) {
        this.studentByStudentidfk = studentByStudentidfk;
    }

    public Exam getExamByExamidfk() {
        return examByExamidfk;
    }

    public void setExamByExamidfk(Exam examByExamidfk) {
        this.examByExamidfk = examByExamidfk;
    }

}
