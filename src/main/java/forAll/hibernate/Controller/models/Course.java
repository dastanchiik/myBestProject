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
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    private String duration;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private Teacher teacher;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "courses_groups",
            joinColumns =  @JoinColumn(name = "course_id") ,
            inverseJoinColumns =  @JoinColumn(name = "group_id")
    )
    private List<Group> groups;
    public Course(String courseName, String duration, Company company, Teacher teacher, List<Group> groups) {
        this.courseName = courseName;
        this.duration = duration;
        this.company = company;
        this.teacher = teacher;
        this.groups = groups;
    }
}