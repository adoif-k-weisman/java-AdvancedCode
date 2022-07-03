package com.itheima.dao;


import com.itheima.domain.Teacher;

public class TeacherDao {

    private static Teacher[] teachers = new Teacher[5];

    public boolean addTeacher(Teacher t) {
        int index = -1;
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = teachers[i];
            if(teacher == null){
                index = i;
                break;
            }
        }

        if(index == -1){
            return false;
        }else{
            teachers[index] = t;
            return true;
        }

    }

    public Teacher[] findAllTeacher() {
        return teachers;
    }

    public void deleteTeacherById(String id) {
        // 1. 查询id在数组中的索引位置
        int index = getIndex(id);
        // 2. 将该索引位置的元素, 使用null进行替换
        teachers[index] = null;
    }

    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < teachers.length; i++) {
            Teacher t = teachers[i];
            if(t != null && t.getId().equals(id)){
                index = i;
                break;
            }
        }

        return index;
    }

    public void updateTeacher(String id, Teacher newTeacher) {
        int index = getIndex(id);
        teachers[index] = newTeacher;
    }
}
