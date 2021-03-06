package com.exam.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Teacher;
import com.exam.mapper.TeacherMapper;
import com.exam.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public IPage<Teacher> findAll(Page<Teacher> page, Teacher teacher) {
        QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();//查询包装类
        //判断传入teacher 模糊查询字段是否为空
        if (teacher.getTeacherName() != null && !"".equals(teacher.getTeacherName())) {
            teacherQueryWrapper.like("teacherName", teacher.getTeacherName());
        }
        if (teacher.getTel() != null && !"".equals(teacher.getTel())) {
            teacherQueryWrapper.like("tel", teacher.getTel());
        }
        return teacherMapper.selectPage(page, teacherQueryWrapper);//分页查找
    }

    @Override
    public List<Teacher> findAll() {
        return teacherMapper.findAll();
    }

    @Override
    public Teacher findById(Integer teacherId) {
        return teacherMapper.findById(teacherId);
    }

    @Override
    public int deleteById(Integer teacherId) {
        return teacherMapper.deleteById(teacherId);
    }

    @Override
    public int update(Teacher teacher) {
        return teacherMapper.update(teacher);
    }

    @Override
    public int add(Teacher teacher) {
        return teacherMapper.add(teacher);
    }
}
