package ir.maktab.model.dto;

import ir.maktab.model.entity.Course;
import ir.maktab.util.StatusType;
import ir.maktab.util.UserRole;

import java.util.List;

public class UserDto {

    private Long id;

    private String name;

    private String family;

    private String email;

    private UserRole role;

    private String password;

    private StatusType status;

    private List<Course> courseList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public StatusType isEnabled() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public StatusType getStatus() {
        return status;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

}
