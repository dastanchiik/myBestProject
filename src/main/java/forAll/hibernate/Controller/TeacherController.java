package forAll.hibernate.Controller;

import forAll.dao.repository.TeacherDao;
import forAll.hibernate.Controller.models.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TeacherController {
    private final TeacherDao companyDao;

    public TeacherController(TeacherDao companyDao) {
        this.companyDao = companyDao;
    }

    @GetMapping("/teachers")
    public String findAll(Model model) {
        model.addAttribute("all", companyDao.getALl());
        return "find-all-teacher";
    }

    @PostMapping("/saveTeacher")
    private String saveStudent(@RequestParam("fName") String fName,@RequestParam("lName") String lName,@RequestParam("email") String email) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(fName);
        teacher.setLastName(lName);
        teacher.setEmail(email);
        companyDao.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teacherForm")
    public String saveCompanyPage() {
        return "teacher-save";
    }

    @GetMapping("/deleteTeacher/{id}")
    public String deleteById(@PathVariable Long id) {
        Teacher company = companyDao.getById(id);
        companyDao.deleteById(company.getId());
        return "redirect:/teachers";
    }

    @GetMapping("/get/teacher/by/{id}")
    public String getById(Model model, @PathVariable Long id) {
        Teacher company = companyDao.getById(id);
        model.addAttribute("company", company);
        return "find-teacher";
    }

    @GetMapping("/zamenit/teacher/{id}")
    public String updatePersonForm(@PathVariable("id") Long id, Model model) {
        Teacher company = companyDao.getById(id);
        model.addAttribute("company", company);
        return "update-teacher-form";
    }

    @PostMapping("/teacher/update/{id}")
    public String updatePerson(
            @RequestParam("fName") String firstName,
            @RequestParam("lName") String lastName,
            @RequestParam("email") String email,
            @PathVariable Long id
    ) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setEmail(email);
        companyDao.updateById(id, teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/allRemove/teacher")
    public String clear() {
        companyDao.deleteAll();
        return "redirect:/teachers";
    }
}