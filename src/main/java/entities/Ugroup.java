package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Ugroup {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "groupid", nullable = false)
    private int groupid;
    @Basic
    @Column(name = "groupnumber", nullable = false)
    private int groupnumber;
    @Basic
    @Column(name = "groupyear", nullable = false)
    private int groupyear;
    @OneToMany(mappedBy = "ugroupByGroupidfk")
    private Collection<Studentgroup> studentgroupsByGroupid;
    @ManyToOne
    @JoinColumn(name = "specialtyidfk", referencedColumnName = "specialtyid")
    private Specialty specialtyBySpecialtyidfk;

    public Ugroup(int groupnumber, int groupyear, Specialty specialtyBySpecialtyidfk) {
        this.groupnumber = groupnumber;
        this.groupyear = groupyear;
        this.specialtyBySpecialtyidfk = specialtyBySpecialtyidfk;
    }

    public Ugroup() {

    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public int getGroupnumber() {
        return groupnumber;
    }

    public void setGroupnumber(int groupnumber) {
        this.groupnumber = groupnumber;
    }

    public int getGroupyear() {
        return groupyear;
    }

    public void setGroupyear(int groupyear) {
        this.groupyear = groupyear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ugroup ugroup = (Ugroup) o;
        return groupid == ugroup.groupid && groupnumber == ugroup.groupnumber && groupyear == ugroup.groupyear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupid, groupnumber, groupyear);
    }

    public Collection<Studentgroup> getStudentgroupsByGroupid() {
        return studentgroupsByGroupid;
    }

    public void setStudentgroupsByGroupid(Collection<Studentgroup> studentgroupsByGroupid) {
        this.studentgroupsByGroupid = studentgroupsByGroupid;
    }

    public Specialty getSpecialtyBySpecialtyidfk() {
        return specialtyBySpecialtyidfk;
    }

    public void setSpecialtyBySpecialtyidfk(Specialty specialtyBySpecialtyidfk) {
        this.specialtyBySpecialtyidfk = specialtyBySpecialtyidfk;
    }
}
