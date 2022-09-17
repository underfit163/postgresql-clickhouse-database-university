package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Department {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "departmentid", nullable = false)
    private int departmentid;
    @Basic
    @Column(name = "departmentname", nullable = false, length = 50)
    private String departmentname;
    @Basic
    @Column(name = "headname", nullable = true, length = 50)
    private String headname;
    @Basic
    @Column(name = "phone", nullable = true, length = 15)
    private String phone;
    @ManyToOne
    @JoinColumn(name = "specialtyidfk", referencedColumnName = "specialtyid")
    private Specialty specialtyBySpecialtyidfk;
    @OneToMany(mappedBy = "departmentByDepartmentidfk")
    private Collection<Teacherdepartment> teacherdepartmentsByDepartmentid;

    public Department(String departmentname, String headname, String phone, Specialty specialtyBySpecialtyidfk) {
        this.departmentname = departmentname;
        this.headname = headname;
        this.phone = phone;
        this.specialtyBySpecialtyidfk = specialtyBySpecialtyidfk;
    }

    public Department() {

    }

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getHeadname() {
        return headname;
    }

    public void setHeadname(String headname) {
        this.headname = headname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return departmentid == that.departmentid && Objects.equals(departmentname, that.departmentname) && Objects.equals(headname, that.headname) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentid, departmentname, headname, phone);
    }

    public Specialty getSpecialtyBySpecialtyidfk() {
        return specialtyBySpecialtyidfk;
    }

    public void setSpecialtyBySpecialtyidfk(Specialty specialtyBySpecialtyidfk) {
        this.specialtyBySpecialtyidfk = specialtyBySpecialtyidfk;
    }

    public Collection<Teacherdepartment> getTeacherdepartmentsByDepartmentid() {
        return teacherdepartmentsByDepartmentid;
    }

    public void setTeacherdepartmentsByDepartmentid(Collection<Teacherdepartment> teacherdepartmentsByDepartmentid) {
        this.teacherdepartmentsByDepartmentid = teacherdepartmentsByDepartmentid;
    }
}
