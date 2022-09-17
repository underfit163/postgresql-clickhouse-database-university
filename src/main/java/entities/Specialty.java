package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Specialty {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "specialtyid", nullable = false)
    private int specialtyid;
    @Basic
    @Column(name = "specialtyname", nullable = false, length = 50)
    private String specialtyname;
    @Basic
    @Column(name = "educationtype", nullable = false, length = 20)
    private String educationtype;
    @OneToMany(mappedBy = "specialtyBySpecialtyidfk")
    private Collection<Department> departmentsBySpecialtyid;
    @ManyToOne
    @JoinColumn(name = "facultyidfk", referencedColumnName = "facultyid")
    private Faculty facultyByFacultyidfk;
    @OneToMany(mappedBy = "specialtyBySpecialtyidfk")
    private Collection<Subject> subjectsBySpecialtyid;
    @OneToMany(mappedBy = "specialtyBySpecialtyidfk")
    private Collection<Ugroup> ugroupsBySpecialtyid;

    public Specialty(String specialtyname, String educationtype, Faculty facultyByFacultyidfk) {
        this.specialtyname = specialtyname;
        this.educationtype = educationtype;
        this.facultyByFacultyidfk = facultyByFacultyidfk;
    }

    public Specialty() {

    }

    public int getSpecialtyid() {
        return specialtyid;
    }

    public void setSpecialtyid(int specialtyid) {
        this.specialtyid = specialtyid;
    }

    public String getSpecialtyname() {
        return specialtyname;
    }

    public void setSpecialtyname(String specialtyname) {
        this.specialtyname = specialtyname;
    }

    public String getEducationtype() {
        return educationtype;
    }

    public void setEducationtype(String educationtype) {
        this.educationtype = educationtype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialty specialty = (Specialty) o;
        return specialtyid == specialty.specialtyid && Objects.equals(specialtyname, specialty.specialtyname) && Objects.equals(educationtype, specialty.educationtype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialtyid, specialtyname, educationtype);
    }

    public Collection<Department> getDepartmentsBySpecialtyid() {
        return departmentsBySpecialtyid;
    }

    public void setDepartmentsBySpecialtyid(Collection<Department> departmentsBySpecialtyid) {
        this.departmentsBySpecialtyid = departmentsBySpecialtyid;
    }

    public Faculty getFacultyByFacultyidfk() {
        return facultyByFacultyidfk;
    }

    public void setFacultyByFacultyidfk(Faculty facultyByFacultyidfk) {
        this.facultyByFacultyidfk = facultyByFacultyidfk;
    }

    public Collection<Subject> getSubjectsBySpecialtyid() {
        return subjectsBySpecialtyid;
    }

    public void setSubjectsBySpecialtyid(Collection<Subject> subjectsBySpecialtyid) {
        this.subjectsBySpecialtyid = subjectsBySpecialtyid;
    }

    public Collection<Ugroup> getUgroupsBySpecialtyid() {
        return ugroupsBySpecialtyid;
    }

    public void setUgroupsBySpecialtyid(Collection<Ugroup> ugroupsBySpecialtyid) {
        this.ugroupsBySpecialtyid = ugroupsBySpecialtyid;
    }
}
