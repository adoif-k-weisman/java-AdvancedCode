package com.itheima.myservlet;

import com.itheima.domain.Student;
import com.itheima.httpserver.HttpRequest;
import com.itheima.httpserver.HttpResponse;
import com.itheima.parse.WebServlet;
import com.itheima.service.StudentService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/servlet/studentservlet")
public class StudentServlet implements HttpServlet {
    //1.创建StudentService对象
    private StudentService studentService = new StudentService();

    @Override
    public void service(HttpRequest httpRequest, HttpResponse httpResponse) {
        //获取method请求参数

        String method = httpRequest.getParamter("method");
        System.out.println(method);
        //判断
        if ("addStudent".equals(method)) {
            //添加学生
            addStudent(httpRequest, httpResponse);
        } else if ("delStudent".equals(method)) {
            //删除学生
            delStudent(httpRequest, httpResponse);
        } else if ("updateStudent".equals(method)) {
            //修改学生
            updateStudent(httpRequest, httpResponse);
        } else if ("findStudent".equals(method)) {
            //查询学生
            findStudent(httpRequest, httpResponse);
        }
    }

    //查询学生
    private void findStudent(HttpRequest httpRequest, HttpResponse httpResponse) {
        //2.调用StudentService中的findAllStudent方法，完成学生数据的查询操作
        Student[] allStudent = studentService.findAllStudent();
        //3.遍历数组，拼接成一个字符串
        StringBuilder sb = new StringBuilder();
        for (Student student : allStudent) {
            sb.append(student.getId()).append(", ").append(student.getName()).
                    append(", ").append(student.getAge()).append(", ").
                    append(student.getBirthday()).append("<br>");
        }
        String result = sb.toString();
        //4.将拼接的结果响应给浏览器
        //告诉浏览器响应的类型
        httpResponse.setContentTpye("text/html;charset=UTF-8");
        if (result == null || "".equals(result)) {
            httpResponse.write("暂无学生数据。。。。");
        } else {
            httpResponse.write(result);
        }
    }


    //修改学生
    private void updateStudent(HttpRequest httpRequest, HttpResponse httpResponse) {
    }


    //删除学生
    private void delStudent(HttpRequest httpRequest, HttpResponse httpResponse) {
    }

    //添加学生
    private void addStudent(HttpRequest httpRequest, HttpResponse httpResponse) {
        //1.获取id的请求参数
        String id = httpRequest.getParamter("id");
        //2.判断id是否重复
        boolean exists = studentService.isExists(id);
        httpResponse.setContentTpye("text/html;charset=UTF-8");
        if (exists) {
            //3.如果重复。给浏览器响应，id已经重复
            httpResponse.write("id已经存在，请重新输入。。。");
        } else {
            //4.如果id不重复。添加学生。并给浏览器响应添加学生成功
            String name = httpRequest.getParamter("name");
            String age = httpRequest.getParamter("age");
            String birthday = httpRequest.getParamter("birthday");

            //对数据进行处理
            try {
                int ageInt = Integer.parseInt(age);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = sdf.parse(birthday);

                //创建一个学生对象
                Student s = new Student();
                s.setId(id);
                s.setName(name);
                s.setAge(age);
                s.setBirthday(birthday);

                //调用studentservice里面的方法
                studentService.addStudent(s);

                //给浏览器响应
                httpResponse.write("学生数据添加成功....");

            } catch (ParseException e) {
                httpResponse.write("日期格式不正确，正确的格式为:yyyy-MM-dd");
                e.printStackTrace();
            } catch (NumberFormatException e) {
                httpResponse.write("年龄只能为整数");
                e.printStackTrace();
            }
            //birthday  yyyy-MM-dd

        }
    }
}
