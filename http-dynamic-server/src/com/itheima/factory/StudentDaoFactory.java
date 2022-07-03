package com.itheima.factory;


import com.itheima.dao.StudentDao;

public class StudentDaoFactory {
    public static StudentDao getStudentDao(){
        return new StudentDao();
    }
}
