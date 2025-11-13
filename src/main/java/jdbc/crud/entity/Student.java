package jdbc.crud.entity;

//@Entity
//@Table(name = "test_students")
//public class Student {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//    @Column(name = "first_name", unique = true)
//    private String name;
//    //@Column(name = "surname")
//    private String surname;
//    @Column(name = "avg_grade", nullable = false)
//    private Double avgGrade;
//    @Transient
//    private LocalDateTime createDate;
//    public Student() {
//
//    }
//
//    public Student(String name, String surname, Double avgGrade) {
//        this.name = name;
//        this.surname = surname;
//        this.avgGrade = avgGrade;
//        createDate = LocalDateTime.now();
//    }
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public Double getAvgGrade() {
//        return avgGrade;
//    }
//
//    public void setAvgGrade(Double avgGrade) {
//        this.avgGrade = avgGrade;
//    }
//
//    public LocalDateTime getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(LocalDateTime createDate) {
//        this.createDate = createDate;
//    }
//
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(avgGrade, student.avgGrade);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, surname, avgGrade);
//    }
//
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", avgGrade=" + avgGrade +
//                ", createDate=" + createDate +
//                '}';
//    }
//}

