package com.exam.entity;

import lombok.Data;

//判断题实体类
@Data
public class JudgeQuestion {
    private Integer questionId; // 问题id

    private String subject; // 科目

    private String question; // 问题

    private String answer; // 回答

    private String level; // 难度等级

    private String section; // 选择

    private Integer score; // 分值

    private String analysis; //题目解析
}