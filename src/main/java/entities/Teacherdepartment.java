package entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Teacherdepartment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "teacherdepartmentid", nullable = false)
    private int teacherdepartmentid;
    @Basic
    @Column(name = "indate", nullable = false)
    private Date indate;
    @Basic
    @Column(name = "outdate", nullable = true)
    private Date outdate;
    @Basic
    @Column(name = "positionteacher", nullable = true, length = 50)
    private String positionteacher;
    @ManyToOne
    @JoinColumn(name = "departmentidfk", referencedColumnName = "departmentid")
    private Department departmentByDepartmentidfk;
    @ManyToOne
    @JoinColumn(name = "teacheridfk", referencedColumnName = "teacherid")
    private Teacher teacherByTeacheridfk;

    public Teacherdepartment(Date indate, Date outdate, String positionteacher, Department departmentByDepartmentidfk, Teacher teacherByTeacheridfk) {
        this.indate = indate;
        this.outdate = outdate;
        this.positionteacher = positionteacher;
        this.departmentByDepartmentidfk = departmentByDepartmentidfk;
        this.teacherByTeacheridfk = teacherByTeacheridfk;
    }

    public Teacherdepartment() {

    }

    public int getTeacherdepartmentid() {
        return teacherdepartmentid;
    }

    public void setTeacherdepartmentid(int teacherdepartmentid) {
        this.teacherdepartmentid = teacherdepartmentid;
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

    public String getPositionteacher() {
        return positionteacher;
    }

    public void setPositionteacher(String positionteacher) {
        this.positionteacher = positionteacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacherdepartment that = (Teacherdepartment) o;
        return teacherdepartmentid == that.teacherdepartmentid && Objects.equals(indate, that.indate) && Objects.equals(outdate, that.outdate) && Objects.equals(positionteacher, that.positionteacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherdepartmentid, indate, outdate, positionteacher);
    }

    public Department getDepartmentByDepartmentidfk() {
        return departmentByDepartmentidfk;
    }

    public void setDepartmentByDepartmentidfk(Department departmentByDepartmentidfk) {
        this.departmentByDepartmentidfk = departmentByDepartmentidfk;
    }

    public Teacher getTeacherByTeacheridfk() {
        return teacherByTeacheridfk;
    }

    public void setTeacherByTeacheridfk(Teacher teacherByTeacheridfk) {
        this.teacherByTeacheridfk = teacherByTeacheridfk;
    }
}
