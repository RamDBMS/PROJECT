package com.ram.sms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="stu_id")
    private Long id;
    @Column(name="stu_name")
    private String name;
    @Column(name="stu_age")
    private int age;
    @Column(name="stu_gender")
    private String gender;
}
