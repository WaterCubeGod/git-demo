package com.wb.service;

import com.wb.mapper.SupervisorMapper;
import com.wb.mapper.TeacherMapper;
import com.wb.pojo.Supervisor;
import com.wb.pojo.Teacher;
import com.wb.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TeacherService {

    static public Teacher selectUser(String id, String password){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        TeacherMapper Mapper = sqlSession.getMapper(TeacherMapper.class);

        //4.调用方法
        Teacher teacher = Mapper.select(id, password);

        sqlSession.commit();
        sqlSession.close();
        return teacher;
    }

    static public Teacher selectById(String id){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        TeacherMapper Mapper = sqlSession.getMapper(TeacherMapper.class);

        //4.调用方法
        Teacher teacher = Mapper.selectById(id);

        sqlSession.commit();
        sqlSession.close();
        return teacher;
    }

    static public List<Teacher> selectAll(){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        TeacherMapper Mapper = sqlSession.getMapper(TeacherMapper.class);

        //4.调用方法
        List<Teacher> teacher = Mapper.selectAll();

        sqlSession.commit();
        sqlSession.close();
        return teacher;
    }

    static public List<String> selectCourseName(String id){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        TeacherMapper Mapper = sqlSession.getMapper(TeacherMapper.class);

        //4.调用方法
        List<String> name = Mapper.selectCourseName(id);

        sqlSession.commit();
        sqlSession.close();
        return name;
    }


    static public int addUser(Teacher teacher){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        TeacherMapper Mapper = sqlSession.getMapper(TeacherMapper.class);

        //4.调用方法
        int count = Mapper.addTeacher(teacher.getId(),teacher.getPassword(),teacher.getDept_name(),teacher.getName(),teacher.getIdentity());

        sqlSession.commit();
        sqlSession.close();
        return count;
    }

}
