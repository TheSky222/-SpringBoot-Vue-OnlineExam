package com.exam.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Student;
import com.exam.mapper.StudentMapper;
import com.exam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public IPage<Student> findAll(Page<Student> page,Student student) {
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        //判断传入student 模糊查询字段是否为空
        if(student.getStudentName()!=null&&!"".equals(student.getStudentName())){
            studentQueryWrapper.like("studentName",student.getStudentName());
        }
        if (student.getTel()!=null&&!"".equals(student.getTel())){
            studentQueryWrapper.like("tel",student.getTel());
        }
       return studentMapper.selectPage(page,studentQueryWrapper);
    }

    @Override
    public Student findById(Integer studentId) {
        return studentMapper.findById(studentId);
    }

    @Override
    public int deleteById(Integer studentId) {
        return studentMapper.deleteById(studentId);
    }

    @Override
    public int update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public int updatePwd(Student student) {
        return studentMapper.updatePwd(student);
    }

    @Override
    public int add(Student student) {
        return studentMapper.add(student);
    }
}
