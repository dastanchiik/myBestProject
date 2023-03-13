package forAll.hibernate.Controller;

import forAll.dao.repository.GroupDao;
import forAll.hibernate.Controller.models.Group;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GroupController {
    private final GroupDao groupDao;

    public GroupController(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @GetMapping("/groups")
    public String findAll(Model model) {
        model.addAttribute("all", groupDao.getALl());
        return "find-all-group";
    }

    @PostMapping("/saveGroups")
    private String saveStudent(@RequestParam("name") String name,@RequestParam("start") String start,@RequestParam("finish") String finish) {
        Group group = new Group();
        group.setGroupName(name);
        group.setDateOfStart(start);
        group.setDateOfFinish(finish);
        groupDao.save(group);
        return "redirect:/groups";
    }

    @GetMapping("/groupForm")
    public String saveCompanyPage() {
        return "group-save";
    }

    @GetMapping("/deleteGroup/{id}")
    public String deleteById(@PathVariable Long id) {
        Group group = groupDao.getById(id);
        groupDao.deleteById(group.getId());
        return "redirect:/groups";
    }

    @GetMapping("/get/group/by/{id}")
    public String getById(Model model, @PathVariable Long id) {
        Group group = groupDao.getById(id);
        model.addAttribute("group", group);
        return "find-group";
    }

    @GetMapping("/upDate/group/{id}")
    public String updatePersonForm(@PathVariable("id") Long id, Model model) {
        Group group = groupDao.getById(id);
        model.addAttribute("group", group);
        return "update-group-form";
    }

    @PostMapping("/group/update/{id}")
    public String updatePerson(
            @RequestParam("name") String name,
            @RequestParam("start") String start,
            @RequestParam("finish") String finish,
            @PathVariable Long id) {
        Group group = new Group();
        group.setGroupName(name);
        group.setDateOfStart(start);
        group.setDateOfFinish(finish);
        groupDao.updateById(id,group);
        return "redirect:/groups";
    }

    @GetMapping("/deleteAll/group")
    public String clear() {
        groupDao.deleteAll();
        return "redirect:/groups";

    }

}
