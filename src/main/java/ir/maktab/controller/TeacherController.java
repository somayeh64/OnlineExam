package ir.maktab.controller;

import ir.maktab.service.CourseService;
import ir.maktab.service.ExamService;
import ir.maktab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@PreAuthorize("hasAnyAuthority('ADMIN, TEACHER')")
public class TeacherController {

    private UserService userService;
    private CourseService courseService;
    private ExamService examService;

    @Autowired
    public TeacherController(UserService userService,CourseService courseService,
                              ExamService examService) {
        this.userService = userService;
        this.courseService=courseService;
        this.examService =examService;
    }

    @RequestMapping(value = "/addTeacherToCourse", method = RequestMethod.GET)
    public ModelAndView addTeacherToCourse(@RequestParam("email")String email
            , @RequestParam("course") String courseTitle) {
        courseService.addUserToCourse(courseTitle, email);
        ModelAndView modelAndView = new ModelAndView("simpleMessage");
        modelAndView.addObject("message", "teacher successfully added to  " + courseTitle);
        return modelAndView;
    }


    @RequestMapping(value = "teacherDashboard", method = RequestMethod.GET)
    public String getAdminPage() {
        return "teacherDashboard";
    }


}
