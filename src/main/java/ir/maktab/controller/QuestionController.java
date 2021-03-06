package ir.maktab.controller;

import ir.maktab.model.dto.ExamDto;
import ir.maktab.model.dto.QuestionDto;
import ir.maktab.model.dto.UserDto;
import ir.maktab.model.entity.Classification;
import ir.maktab.model.entity.Exam;
import ir.maktab.model.entity.Question;
import ir.maktab.model.entity.User;
import ir.maktab.service.ClassificationService;
import ir.maktab.service.ExamService;
import ir.maktab.service.UserService;
import ir.maktab.util.Mapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class QuestionController {

    private ExamService examService;
    private ClassificationService classificationService;
    private UserService userService;
    private Mapper mapper;

    public QuestionController(ExamService examService, Mapper mapper
            , ClassificationService classificationService, UserService userService) {
        this.examService = examService;
        this.classificationService = classificationService;
        this.userService = userService;
        this.mapper = mapper;
    }

    @RequestMapping(value = "addQuestionToExam", method = RequestMethod.GET)
    public ModelAndView addQuestionToExam(@RequestParam("id") String examId,
                                          @RequestParam("user") String teacher_id,
                                          HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        UserDto userDto = (UserDto) session.getAttribute("user");
        Exam exam = examService.getExamById(Long.valueOf(examId));
        ExamDto examDto = mapper.convertEntityToExamDto(exam);
        User teacher = userService.findById(Long.valueOf(teacher_id));
        ModelAndView modelAndView = new ModelAndView("teacher_addQuestion", "exam", examDto);
        modelAndView.addObject("question", new QuestionDto());
        modelAndView.addObject("exam", examDto);
        modelAndView.addObject("user", teacher);
        return modelAndView;
    }


    @RequestMapping(value = "/getFromQuestionBank", method = RequestMethod.GET)
    public ModelAndView getQuestionBank(@RequestParam("examId") String examId) {
        Exam exam = examService.getExamById(Long.valueOf((examId)));
        Classification classification = exam.getCourse().getClassification();
        List<Question> questionFromBank = classificationService.getQuestionFromBank(classification.getClassificationTitle());
        ModelAndView modelAndView = new ModelAndView("teacher_questionBank");
        modelAndView.addObject("questionFromBank", questionFromBank);
        modelAndView.addObject("question", new QuestionDto());
        modelAndView.addObject("exam", exam);
        return modelAndView;
    }

    @RequestMapping(value = "/addFromBank", method = RequestMethod.POST)
    public ModelAndView addQuestionFromBank(@ModelAttribute("question") QuestionDto questionDto
            , @RequestParam("examId") String examId, @RequestParam("score") String score) {

        ModelAndView modelAndView = new ModelAndView("simpleMessage");
        try {
            examService.addQuestionToExamFromBank(Long.valueOf(examId), score, questionDto);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("message", e.getMessage());
            return modelAndView;
        }
        modelAndView.addObject("message", "question successfully added");
        return modelAndView;
    }


}
