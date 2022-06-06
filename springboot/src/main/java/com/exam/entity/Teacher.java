package com.exam.entity;

import lombok.Data;

@Data
public class Teacher {
    private Integer teacherId;

    private String teacherName; // 姓名

    private String institute; // 学院

    private String sex; //性别

    private String tel; // 电话号码

    private String email; // 邮箱

    private String pwd; // 密码

    private String cardId; // 身份证号

    private String type; // 职称

    private String role;
}