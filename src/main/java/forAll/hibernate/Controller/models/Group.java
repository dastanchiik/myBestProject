package forAll.hibernate.Controller.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "start")
    private String dateOfStart;
    @Column(name = "finish")
    private String dateOfFinish;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students;
    @ManyToMany(mappedBy = "groups")
    private List<Course> courses;
    public Group(String groupName, String dateOfStart, String dateOfFinish, Company company, List<Student> students, List<Course> courses) {
        this.groupName = groupName;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
        this.company = company;
        this.students = students;
        this.courses = courses;
    }
}