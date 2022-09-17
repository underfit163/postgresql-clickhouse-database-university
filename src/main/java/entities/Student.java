package entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "studentid", nullable = false)
    private int studentid;
    @Basic
    @Column(name = "fio", nullable = false, length = 50)
    private String fio;
    @Basic
    @Column(name = "birthday", nullable = false)
    private Date birthday;
    @Basic
    @Column(name = "gender", nullable = true, length = 1)
    private String gender;
    @Basic
    @Column(name = "phone", nullable = true, length = 15)
    private String phone;
    @OneToMany(mappedBy = "studentByStudentidfk")
    private Collection<Studentgroup> studentgroupsByStudentid;

    @OneToMany(mappedBy = "studentByStudentidfk")
    private Collection<Mark> marks;

    public Student(String fio, Date birthday, String gender, String phone) {
        this.fio = fio;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
    }

    public Student() {

    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Collection<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Collection<Mark> marks) {
        this.marks = marks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentid == student.studentid && Objects.equals(fio, student.fio) && Objects.equals(birthday, student.birthday) && Objects.equals(gender, student.gender) && Objects.equals(phone, student.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentid, fio, birthday, gender, phone);
    }

    public Collection<Studentgroup> getStudentgroupsByStudentid() {
        return studentgroupsByStudentid;
    }

    public void setStudentgroupsByStudentid(Collection<Studentgroup> studentgroupsByStudentid) {
        this.studentgroupsByStudentid = studentgroupsByStudentid;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("studentid=").append(studentid);
        sb.append(", fio='").append(fio).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
