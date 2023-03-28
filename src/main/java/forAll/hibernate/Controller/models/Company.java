package forAll.hibernate.Controller.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class  Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "located_country")
    private String locatedCountry;
    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE
            , fetch = FetchType.LAZY
    )
    private List<Course> courses;
    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE
            , fetch = FetchType.LAZY
    )
    private List<Groups> groups;

    public Company(String companyName, String locatedCountry, List<Course> courses, List<Groups> groups) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;
        this.courses = courses;
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Company{" +
               "id=" + id +
               ", companyName='" + companyName + '\'' +
               ", locatedCountry='" + locatedCountry + '\'' +
               ", courses=" + courses +
               ", groups=" + groups +
               '}';
    }
}