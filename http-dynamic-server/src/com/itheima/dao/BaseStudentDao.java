package com.itheima.dao;


import com.itheima.domain.Student;

public interface BaseStudentDao {
    // 添加学生
    public abstract boolean addStudent(Student stu);
    // 查看学生
    public abstract Student[] findAllStudent();
    // 删除学生
    public abstract void deleteStudentById(String delId);
    // 修改学生
    public abstract void updateStudent(String updateId, Student newStu);
    // 根据id查找索引
    public abstract int getIndex(String id);

}
