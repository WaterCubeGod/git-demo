package com.wb.service;

import com.wb.mapper.StudentMapper;
import com.wb.mapper.SupervisorMapper;
import com.wb.pojo.Student;
import com.wb.pojo.Supervisor;
import com.wb.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SupervisorService {
    static public Supervisor selectUser(String id, String password){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        SupervisorMapper Mapper = sqlSession.getMapper(SupervisorMapper.class);

        //4.调用方法
        Supervisor supervisor = Mapper.select(id, password);
        sqlSession.commit();
        sqlSession.close();
        return supervisor;
    }

    static public Supervisor selectById(String id){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        SupervisorMapper Mapper = sqlSession.getMapper(SupervisorMapper.class);

        //4.调用方法
        Supervisor supervisor = Mapper.selectById(id);
        sqlSession.commit();
        sqlSession.close();
        return supervisor;
    }

    static public List<Supervisor> selectAll(){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        SupervisorMapper Mapper = sqlSession.getMapper(SupervisorMapper.class);

        //4.调用方法
        List<Supervisor> supervisor = Mapper.selectAll();
        sqlSession.commit();
        sqlSession.close();
        return supervisor;
    }

    static public List<String> selectTeacher(String managerId){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        SupervisorMapper Mapper = sqlSession.getMapper(SupervisorMapper.class);

        //4.调用方法
        List<String> teachersId = Mapper.selectTeacher(managerId);

        sqlSession.commit();
        sqlSession.close();
        return teachersId;
    }

    static public int addUser(Supervisor supervisor){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        SupervisorMapper Mapper = sqlSession.getMapper(SupervisorMapper.class);

        //4.调用方法
        int count = Mapper.addSupervisor(supervisor.getId(),supervisor.getPassword(),supervisor.getDept_name(),supervisor.getName(),supervisor.getIdentity());

        sqlSession.commit();
        sqlSession.close();
        return count;
    }
}
