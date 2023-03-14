package forAll.hibernate.Controller;

import forAll.dao.repository.CompanyDao;
import forAll.dao.repository.CourseDao;
import forAll.dao.repository.GroupDao;
import forAll.hibernate.Controller.models.Company;
import forAll.hibernate.Controller.models.Course;
import forAll.hibernate.Controller.models.Groups;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class GroupController {
    private final GroupDao groupDao;
    private final CompanyDao companyDao;
    private final CourseDao courseDao;

    public GroupController(GroupDao groupDao, CompanyDao companyDao, CourseDao courseDao) {
        this.groupDao = groupDao;
        this.companyDao = companyDao;
        this.courseDao = courseDao;
    }

    @GetMapping("/groups")
    public String findAll(Model model) {
        model.addAttribute("all", groupDao.getALl());
        return "find-all-group";
    }

    @PostMapping("/saveGroups")
    private String saveStudent(@RequestParam("name") String name, @RequestParam("start") String start, @RequestParam("finish") String finish,
                               @RequestParam("companyId") Long id,@RequestParam("courseId") Long id1) {
        Company company = companyDao.getById(id);
        Course course = courseDao.getById(id1);
        ArrayList<Course>courses = new ArrayList<>();
        courses.add(course);
        Groups group = new Groups();
        group.setGroupName(name);
        group.setDateOfStart(start);
        group.setDateOfFinish(finish);
        group.setCompany(company);
        group.setCourses(courses);
        groupDao.save(group);
        return "redirect:/groups";
    }

    @GetMapping("/groupForm")
    public String saveCompanyPage(Model model) {
        model.addAttribute("companyConnection",companyDao.getALl());
        model.addAttribute("courseConnection",courseDao.getALl());
        return "group-save";
    }

    @GetMapping("/deleteGroup/{id}")
    public String deleteById(@PathVariable Long id) {
        Groups group = groupDao.getById(id);
        groupDao.deleteById(group.getId());
        return "redirect:/groups";
    }

    @GetMapping("/get/group/by/{id}")
    public String getById(Model model, @PathVariable Long id) {
        Groups group = groupDao.getById(id);
        model.addAttribute("group", group);
        return "find-group";
    }

    @GetMapping("/upDate/group/{id}")
    public String updatePersonForm(@PathVariable("id") Long id, Model model) {
        Groups group = groupDao.getById(id);
        model.addAttribute("group", group);
        return "update-group-form";
    }

    @PostMapping("/group/update/{id}")
    public String updatePerson(
            @RequestParam("name") String name,
            @RequestParam("start") String start,
            @RequestParam("finish") String finish,
            @PathVariable Long id) {
        Groups group = new Groups();
        group.setGroupName(name);
        group.setDateOfStart(start);
        group.setDateOfFinish(finish);
        groupDao.updateById(id, group);
        return "redirect:/groups";
    }

    @GetMapping("/deleteAll/group")
    public String clear() {
        groupDao.deleteAll();
        return "redirect:/groups";

    }

}
