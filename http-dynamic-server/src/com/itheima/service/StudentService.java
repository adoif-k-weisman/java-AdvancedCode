package com.itheima.service;


import com.itheima.dao.OtherStudentDao;
import com.itheima.domain.Student;

public class StudentService {

    private OtherStudentDao studentDao = new OtherStudentDao();

    // 添加学生方法
    public boolean addStudent(Student stu) {
        // 2. 将学生对象, 传递给StudentDao 库管中的addStudent方法
        // 3. 将返回的boolean类型结果, 返还给StudentController
        return studentDao.addStudent(stu);
    }
    // 判断学号是否存在方法
    public boolean isExists(String id) {
        Student[] stus = studentDao.findAllStudent();
        // 假设id在数组中不存在
        boolean exists = false;
        // 遍历数组, 获取每一个学生对象, 准备进行判断
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if(student != null && student.getId().equals(id)){
                exists = true;
                break;
            }
        }

        return exists;
    }
    // 查看学生方法
    public Student[] findAllStudent() {
        // 1. 调用库管对象的findAllStudent获取学生对象数组
        Student[] allStudent = studentDao.findAllStudent();
        // 2. 判断数组中是否有学生信息 (有: 返回地址,  没有: 返回null)
        // 思路: 数组中只要存在一个不是null的元素, 那就代表有学生信息
        boolean flag = false;
        for (int i = 0; i < allStudent.length; i++) {
            Student stu = allStudent[i];
            if(stu != null){
                flag = true;
                break;
            }
        }

        if(flag){
            // 有信息
            return allStudent;
        }else{
            // 没有信息
            return null;
        }

    }

    public void deleteStudentById(String delId) {
        studentDao.deleteStudentById(delId);
    }

    public void updateStudent(String updateId, Student newStu) {
        studentDao.updateStudent(updateId, newStu);
    }
}
