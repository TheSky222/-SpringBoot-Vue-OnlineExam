package com.exam.entity;

import lombok.Data;

//填空题实体类
@Data
public class FillQuestion {
    private Integer questionId; // 问题id

    private String subject; // 科目

    private String question; // 问题

    private String answer; // 回答

    private Integer score; // 分数

    private String level; // 难度等级

    private String section; // 选择

    private String analysis; //题目解析
}
