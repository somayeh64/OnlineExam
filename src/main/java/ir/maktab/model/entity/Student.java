package ir.maktab.model.entity;

import ir.maktab.util.UserRole;

import javax.persistence.Entity;

@Entity
public class Student extends User {

    public Student(User user) {
        super(user.getName(), user.getFamily(), user.getEmail(), user.getPassword(), user.getRole());
        this.setRole(UserRole.STUDENT);
    }

    public Student() {
    }
}
