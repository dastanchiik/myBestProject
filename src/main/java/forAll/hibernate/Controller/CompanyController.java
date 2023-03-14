package forAll.hibernate.Controller;

import forAll.dao.repository.CompanyDao;
import forAll.dao.repository.CourseDao;
import forAll.hibernate.Controller.models.Company;
import forAll.hibernate.Controller.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class CompanyController {
    private final CompanyDao companyRepository;
    @Autowired
    private final CourseDao courseDao;

    public CompanyController(CompanyDao companyRepository, CourseDao courseDao) {
        this.companyRepository = companyRepository;
        this.courseDao = courseDao;
    }

    @GetMapping("/companies")
    public String findAll(Model model){
        model.addAttribute( "all",companyRepository.getALl() );
        return "find-all";
    }
    @GetMapping("/find/{id}")
    public String relation(Model model,@PathVariable Long id){
        model.addAttribute("com",companyRepository.relationship(id));
        model.addAttribute("example",courseDao.connectionFindAll(id,courseDao.getById(id)));
        return "kol";
    }

    @PostMapping("/saveCompany")
    private String saveStudent(@RequestParam("name") String name,@RequestParam("located") String located){
        Company company = new Company();
        company.setCompanyName(name);
        company.setLocatedCountry(located);
        companyRepository.save(company);
        return "redirect:/companies";
    }

    @GetMapping("/companyForm")
    public String saveCompanyPage(){
        return "company-save";
    }

    @GetMapping("/deleteCompany/{id}")
    public String deleteById(@PathVariable Long id){
//        Company company = companyRepository.getById(id);
        companyRepository.deleteById(id);
        return "redirect:/companies";
    }

    @GetMapping("/get/by/{id}")
    public  String getById(Model model, @PathVariable Long id) {
        Company company = companyRepository.getById(id);
        model.addAttribute("company",company);
        return "find";
    }

    @GetMapping("/update/{id}")
    public String updatePersonForm(@PathVariable Long id, Model model) {
        Company companies = companyRepository.getById(id);
        model.addAttribute("company", companies);
        return "update-company-form";
    }

    @PostMapping(value = "/real/update/{id}")
    public String updatePerson(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "country") String country, @PathVariable Long id) {
        Company company = companyRepository.getById(id);
        company.setCompanyName(name);
        company.setLocatedCountry(country);
        companyRepository.updateById(id,company);
        return "redirect:/companies/";
    }

    @GetMapping("/clear")
    public String clear(){
        companyRepository.deleteAll();
        return "redirect:/companies";
    }
}
