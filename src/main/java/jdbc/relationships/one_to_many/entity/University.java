package jdbc.relationships.one_to_many.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "universities")
public class University { ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "founding_date")
    private Date founding_date;

    @OneToMany(mappedBy = "university", fetch = FetchType.LAZY)
    @OrderBy("avgGrade")
    private List<Student> students = new ArrayList<>();

    public void addStudentToUniversity (Student student) {
        students.add(student);
        student.setUniversity(this);
    }


    public University() {
    }

    public University(String name, Date founding_date) {
        this.name = name;
        this.founding_date = founding_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFounding_date() {
        return founding_date;
    }

    public void setFounding_date(Date founding_date) {
        this.founding_date = founding_date;
    }
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", founding_date='" + founding_date + '\'' +
                '}';
    }


}

