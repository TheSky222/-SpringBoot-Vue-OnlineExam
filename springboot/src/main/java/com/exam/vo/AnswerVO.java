package com.exam.vo;

import lombok.Data;
// vo层 参数封装
// 题目信息
@Data
public class AnswerVO {
    private String question;
    private String subject;
    private String score;
    private String section;
    private String level;
    private String type;
}
