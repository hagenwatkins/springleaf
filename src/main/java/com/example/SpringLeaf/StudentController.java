package com.example.SpringLeaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home () {
        return "index";
    }


    @RequestMapping("/new_student")
    public String newStudent(Model model) {
        model.addAttribute("grades", Grade.values());
        return "new_student";
    }

    @RequestMapping("/create_student")
    public String createStudent(@RequestParam(value="first_name") String firstName, @RequestParam(value="last_name") String lastName, @RequestParam(value ="grade") Grade grade, Model model) {
        /* set student firstName, lastName and grade using the http request parameters */


        Student student = new Student();
        student.setFirstName("firstName");
        student.setLastName("lastName");
        student.setGrade(grade);


        model.addAttribute(student);

        /* add the student to the model that will be used by the view_student html file */

        return "view_student";
    }
}