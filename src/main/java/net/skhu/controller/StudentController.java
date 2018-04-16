package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.domain.Pagination;
import net.skhu.domain.Student;
import net.skhu.repository.DepartmentRepository;
import net.skhu.repository.StudentRepository;
import net.skhu.service.DepartmentService;
import net.skhu.service.StudentService;


@Controller

@RequestMapping("student")
public class StudentController {
	@Autowired StudentService studentService;
	@Autowired DepartmentService departmentService;
	@Autowired StudentRepository studentRepository;
	@Autowired DepartmentRepository departmentRepository;

    @RequestMapping("list")
    public String list(Pagination pagination, Model model) {
        List<Student> list = studentService.findAll(pagination);
        model.addAttribute("list", list);
        return "student/list";
    }


    @RequestMapping(value="edit", method=RequestMethod.GET)
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("student", studentService.findById(id));
        return "student/edit";
    }

    @RequestMapping(value="edit", method=RequestMethod.POST)
    public String edit(Student student, Model model) {
        studentService.save(student);
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("message", "저장했습니다.");
        return "student/edit";
    }


    @RequestMapping(value="create", method=RequestMethod.GET)
    public String create(Pagination pagination, Model model) {
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("student", new Student());
        model.addAttribute("title", "등록");
        return "student/edit";
    }

    @RequestMapping(value="create", method=RequestMethod.POST)
    public String create(Student student, Pagination pagination, Model model) {
        studentService.save(student);
        long recordCount = studentService.count();
        long pageCount = (recordCount + pagination.getSz() - 1) / pagination.getSz();
        return "redirect:list?pg=" + pageCount;
    }

    @RequestMapping("delete")
    public String delete(@RequestParam("id") int id, Pagination pagination, Model model) {
        studentService.delete(id);
        return "redirect:list?pg=" + pagination.getPg();
    }




}