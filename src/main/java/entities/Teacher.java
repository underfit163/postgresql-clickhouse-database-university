package entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Teacher {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "teacherid", nullable = false)
    private int teacherid;
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
    @Column(name = "title", nullable = true, length = 50)
    private String title;
    @Basic
    @Column(name = "teacherdegree", nullable = true, length = 50)
    private String teacherdegree;
    @Basic
    @Column(name = "phone", nullable = true, length = 15)
    private String phone;
    @OneToMany(mappedBy = "teacherByTeacheridfk")
    private Collection<Exam> examsByTeacherid;
    @ManyToOne
    @JoinColumn(name = "director", referencedColumnName = "teacherid")
    private Teacher teacherByDirector;
    @OneToMany(mappedBy = "teacherByDirector")
    private Collection<Teacher> teachersByTeacherid;
    @OneToMany(mappedBy = "teacherByTeacheridfk")
    private Collection<Teacherdepartment> teacherdepartmentsByTeacherid;

    public Teacher(String fio, Date birthday, String gender, String title, String teacherdegree, String phone, Teacher teacherByDirector) {
        this.fio = fio;
        this.birthday = birthday;
        this.gender = gender;
        this.title = title;
        this.teacherdegree = teacherdegree;
        this.phone = phone;
        this.teacherByDirector = teacherByDirector;
    }

    public Teacher() {

    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeacherdegree() {
        return teacherdegree;
    }

    public void setTeacherdegree(String teacherdegree) {
        this.teacherdegree = teacherdegree;
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
        Teacher teacher = (Teacher) o;
        return teacherid == teacher.teacherid && Objects.equals(fio, teacher.fio) && Objects.equals(birthday, teacher.birthday) && Objects.equals(gender, teacher.gender) && Objects.equals(title, teacher.title) && Objects.equals(teacherdegree, teacher.teacherdegree) && Objects.equals(phone, teacher.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherid, fio, birthday, gender, title, teacherdegree, phone);
    }

    public Collection<Exam> getExamsByTeacherid() {
        return examsByTeacherid;
    }

    public void setExamsByTeacherid(Collection<Exam> examsByTeacherid) {
        this.examsByTeacherid = examsByTeacherid;
    }

    public Teacher getTeacherByDirector() {
        return teacherByDirector;
    }

    public void setTeacherByDirector(Teacher teacherByDirector) {
        this.teacherByDirector = teacherByDirector;
    }

    public Collection<Teacher> getTeachersByTeacherid() {
        return teachersByTeacherid;
    }

    public void setTeachersByTeacherid(Collection<Teacher> teachersByTeacherid) {
        this.teachersByTeacherid = teachersByTeacherid;
    }

    public Collection<Teacherdepartment> getTeacherdepartmentsByTeacherid() {
        return teacherdepartmentsByTeacherid;
    }

    public void setTeacherdepartmentsByTeacherid(Collection<Teacherdepartment> teacherdepartmentsByTeacherid) {
        this.teacherdepartmentsByTeacherid = teacherdepartmentsByTeacherid;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Teacher{");
        sb.append("teacherid=").append(teacherid);
        sb.append(", fio='").append(fio).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", teacherdegree='").append(teacherdegree).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", teacherByDirector=").append(teacherByDirector);
        sb.append('}');
        return sb.toString();
    }
}
