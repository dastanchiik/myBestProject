package forAll.hibernate.Controller;

import forAll.dao.repository.*;
import forAll.hibernate.Controller.models.Company;
import forAll.hibernate.Controller.models.Groups;
import forAll.hibernate.Controller.models.Student;
import forAll.hibernate.Controller.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CompanyController {
    private final CompanyDao companyDao;
    private final CourseDao courseDao;
    private final GroupDao groupDao;
    private final StudentDao studentDao;
    private final TeacherDao teacherDao;

    @Autowired
    public CompanyController(CompanyDao companyDao, CourseDao courseDao, GroupDao groupDao, StudentDao studentDao, TeacherDao teacherDao) {
        this.companyDao = companyDao;
        this.courseDao = courseDao;
        this.groupDao = groupDao;
        this.studentDao = studentDao;
        this.teacherDao = teacherDao;
    }

    @GetMapping("/companies")
    public String findAll(Model model) {
        model.addAttribute("all", companyDao.getALl());
        return "find-all";
    }

    @PostMapping("/saveCompany")
    private String saveStudent(@RequestParam("name") String name, @RequestParam("located") String located) {
        Company company = new Company();
        company.setCompanyName(name);
        company.setLocatedCountry(located);
        companyDao.save(company);
        return "redirect:/companies";
    }

    @GetMapping("/findAll/{id}")
    public String findAllById(@PathVariable Long id, Model model) {
        model.addAttribute("company", companyDao.getById(id));
        model.addAttribute("courses", courseDao.connectionFindAll(id));
        model.addAttribute("groups", groupDao.findAllGroups(id));
        for (int i = 0; i <= teacherDao.findAllTeacher(id).size(); i++) {
            model.addAttribute("teachers", teacherDao.findAllTeacher(id));
        }
        for (int i = 0; i <= studentDao.findAllStudent(id).size(); i++) {
            model.addAttribute("students", studentDao.findAllStudent(id));
        }
        return "viewer";
    }

    @GetMapping("/companyForm")
    public String saveCompanyPage() {
        return "company-save";
    }

    @GetMapping("/deleteCompany/{id}")
    public String deleteById(@PathVariable Long id) {
        companyDao.deleteById(id);
        return "redirect:/companies";
    }

    @GetMapping("/get/by/{id}")
    public String getById(Model model, @PathVariable Long id) {
        Company company = companyDao.getById(id);
        model.addAttribute("company", company);
        return "find";
    }

    @GetMapping("/update/{id}")
    public String updatePersonForm(@PathVariable Long id, Model model) {
        Company companies = companyDao.getById(id);
        model.addAttribute("company", companies);
        return "update-company-form";
    }

    @PostMapping(value = "/real/update/{id}")
    public String updatePerson(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "country") String country, @PathVariable Long id) {
        Company company = companyDao.getById(id);
        company.setCompanyName(name);
        company.setLocatedCountry(country);
        companyDao.updateById(id, company);
        return "redirect:/companies/";
    }

    @GetMapping("/clear")
    public String clear() {
        companyDao.deleteAll();
        return "redirect:/companies";
    }
}
