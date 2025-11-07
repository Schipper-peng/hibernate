package jdbc.example.relationships.many_to_many.entity;

import jakarta.persistence.*;
import jdbc.example.relationships.one_to_many.entity.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "universities")
public class University { ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "founding_date")
    private Date founding_date;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_id",
    joinColumns = @JoinColumn(name = "university_id"),
    inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )


    private List<Teacher> teachers = new ArrayList<>();

    public University() {
    }

    public University(String name, Date founding_date) {
        this.name = name;
        this.founding_date = founding_date;
    }
    public void addTeacherToUniversity(Teacher teacher) {
        teachers.add(teacher);
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
    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
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

