package jdbc.jpql.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "universities")
//@NamedQuery(name = "University.allUniversitiesLessOrEqualTo2"
//        , query = "select u from University u where size(u.students) <= 2")
//@NamedQuery(name = "University.studentsWithAvgGradeBetween"
//, query = "select s from Student s where avgGrade between :from and :to")
@NamedQueries (
        {@NamedQuery(name = "University.allUniversitiesLessOrEqualTo2"
        , query = "select u from University u where size(u.students) <= 2"),
@NamedQuery(name = "University.studentsWithAvgGradeBetween"
, query = "select s from Student s where avgGrade between :from and :to")}
)
public class University { ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "founding_date")
    private Date founding_date;

    @OneToMany(mappedBy = "university")
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

