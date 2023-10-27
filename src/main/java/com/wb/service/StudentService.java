package com.wb.service;

import com.wb.mapper.DeanMapper;
import com.wb.mapper.StudentMapper;
import com.wb.pojo.Dean;
import com.wb.pojo.Student;
import com.wb.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentService {

    static public Student selectUser(String id, String password){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        StudentMapper Mapper = sqlSession.getMapper(StudentMapper.class);

        //4.调用方法
        Student student = Mapper.select(id, password);

        sqlSession.commit();
        sqlSession.close();
        return student;
    }

    static public Student selectById(String id){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        StudentMapper Mapper = sqlSession.getMapper(StudentMapper.class);

        //4.调用方法
        Student student = Mapper.selectById(id);

        sqlSession.commit();
        sqlSession.close();
        return student;
    }

    static public List<Student> selectAll(){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        StudentMapper Mapper = sqlSession.getMapper(StudentMapper.class);

        //4.调用方法
        List<Student> student = Mapper.selectAll();

        sqlSession.commit();
        sqlSession.close();
        return student;
    }


    static public int addUser(Student student){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        StudentMapper Mapper = sqlSession.getMapper(StudentMapper.class);

        //4.调用方法
        int count = Mapper.addStudent(student.getId(),student.getPassword(),student.getDept_name(),student.getName(),student.getIdentity());

        sqlSession.commit();
        sqlSession.close();
        return count;
    }

}
