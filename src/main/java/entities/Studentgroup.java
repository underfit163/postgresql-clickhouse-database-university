package entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Studentgroup {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "sudentgroupid", nullable = false)
    private int sudentgroupid;
    @Basic
    @Column(name = "indate", nullable = false)
    private Date indate;
    @Basic
    @Column(name = "outdate", nullable = true)
    private Date outdate;
    @ManyToOne
    @JoinColumn(name = "groupidfk", referencedColumnName = "groupid")
    private Ugroup ugroupByGroupidfk;
    @ManyToOne
    @JoinColumn(name = "studentidfk", referencedColumnName = "studentid")
    private Student studentByStudentidfk;

    public Studentgroup(Date indate, Date outdate, Ugroup ugroupByGroupidfk, Student studentByStudentidfk) {
        this.indate = indate;
        this.outdate = outdate;
        this.ugroupByGroupidfk = ugroupByGroupidfk;
        this.studentByStudentidfk = studentByStudentidfk;
    }

    public Studentgroup() {

    }

    public int getSudentgroupid() {
        return sudentgroupid;
    }

    public void setSudentgroupid(int sudentgroupid) {
        this.sudentgroupid = sudentgroupid;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getOutdate() {
        return outdate;
    }

    public void setOutdate(Date outdate) {
        this.outdate = outdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studentgroup that = (Studentgroup) o;
        return sudentgroupid == that.sudentgroupid && Objects.equals(indate, that.indate) && Objects.equals(outdate, that.outdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sudentgroupid, indate, outdate);
    }

    public Ugroup getUgroupByGroupidfk() {
        return ugroupByGroupidfk;
    }

    public void setUgroupByGroupidfk(Ugroup ugroupByGroupidfk) {
        this.ugroupByGroupidfk = ugroupByGroupidfk;
    }

    public Student getStudentByStudentidfk() {
        return studentByStudentidfk;
    }

    public void setStudentByStudentidfk(Student studentByStudentidfk) {
        this.studentByStudentidfk = studentByStudentidfk;
    }
}
