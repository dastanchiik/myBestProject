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
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "located_country")
    private String locatedCountry;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL
            , fetch = FetchType.LAZY
    )
    private List<Course> courses;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL
            , fetch = FetchType.EAGER
    )
    private List<Group> groups;


    public Company(String companyName, String locatedCountry, List<Course> courses, List<Group> groups) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;
        this.courses = courses;
        this.groups = groups;
    }
}