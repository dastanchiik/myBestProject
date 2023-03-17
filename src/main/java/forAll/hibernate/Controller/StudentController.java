package forAll.hibernate.Controller;

import forAll.dao.repository.GroupDao;
import forAll.dao.repository.StudentDao;
import forAll.hibernate.Controller.models.Groups;
import forAll.hibernate.Controller.models.Student;
import forAll.hibernate.Controller.models.StudyFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private final StudentDao studentDao;
    private final GroupDao groupDao;

    public StudentController(StudentDao companyDao, GroupDao groupDao) {
        this.studentDao = companyDao;
        this.groupDao = groupDao;
    }

    @GetMapping("/students")
    public String findAll(Model model) {
        model.addAttribute("all", studentDao.getALl());
        return "find-all-student";
    }

    @PostMapping("/saveStudent")
    private String saveStudent(@RequestParam("name") String name, @RequestParam("format") String format, @RequestParam("lName") String lName, @RequestParam("email") String email,
                               @RequestParam("id") Long id) {
        Groups groups = groupDao.getById(id);
        Student student = new Student();
        student.setFirstName(name);
        student.setStudyFormat(StudyFormat.valueOf(format));
        student.setLastName(lName);
        student.setGroup(groups);
        student.setEmail(email);

        studentDao.save(student);
        return "redirect:/students";
    }

    @GetMapping("/studentForm")
    public String saveCompanyPage(Model model) {
        model.addAttribute("groupConnection", groupDao.getALl());
        return "student-save";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteById(@PathVariable Long id) {
        Student company = studentDao.getById(id);
        studentDao.deleteById(company.getId());
        return "redirect:/students";
    }

    @GetMapping("/get/student/by/{id}")
    public String getById(Model model, @PathVariable Long id) {
        Student company = studentDao.getById(id);
        model.addAttribute("company", company);
        return "find-student";
    }

    @GetMapping("/izmenit/student/{id}")
    public String updatePersonForm(@PathVariable("id") Long id, Model model) {
        Student company = studentDao.getById(id);
        model.addAttribute("company", company);
        return "update-student-form";
    }

    @PostMapping("/student/update/{id}")
    public String updatePerson(
            @RequestParam("name") String firstName,
            @RequestParam("lName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("format") String format,
            @PathVariable Long id
    ) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setStudyFormat(StudyFormat.valueOf(format));
        studentDao.updateById(id, student);
        return "redirect:/students";
    }

    @GetMapping("/removeAll/student")
    public String clear() {
        studentDao.deleteAll();
        return "redirect:/students";
    }
}
