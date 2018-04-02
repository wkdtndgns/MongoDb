package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.domain.Student;
import net.skhu.service.StudentService;

@Controller

@RequestMapping("student")
public class StudentController {
	@Autowired StudentService studentService;

    @RequestMapping("list")
    public String list(Model model) {
        List<Student> list = studentService.findAll();
        model.addAttribute("list", list);
        return "student/list";
    }


}