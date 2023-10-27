package com.wb.service;

import com.wb.mapper.DeanMapper;
import com.wb.pojo.Dean;
import com.wb.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeanService {
    static public Dean selectUser(String id, String password){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        DeanMapper Mapper = sqlSession.getMapper(DeanMapper.class);

        //4.调用方法
        Dean dean = Mapper.select(id, password);

        sqlSession.commit();
        sqlSession.close();
        return dean;
    }

    static public Dean selectById(String id){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        DeanMapper Mapper = sqlSession.getMapper(DeanMapper.class);

        //4.调用方法
        Dean dean = Mapper.selectById(id);

        sqlSession.commit();
        sqlSession.close();
        return dean;
    }

    static public List<Dean> selectAll(){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        DeanMapper Mapper = sqlSession.getMapper(DeanMapper.class);

        //4.调用方法
        List<Dean> dean = Mapper.selectAll();

        sqlSession.commit();
        sqlSession.close();
        return dean;
    }

    static public List<String> selectSupervisor(String managerId){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        DeanMapper Mapper = sqlSession.getMapper(DeanMapper.class);

        //4.调用方法
        List<String> supervisorsId = Mapper.selectSupervisor(managerId);

        sqlSession.commit();
        sqlSession.close();
        return supervisorsId;
    }

    static public int addUser(Dean dean){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        DeanMapper Mapper = sqlSession.getMapper(DeanMapper.class);

        //4.调用方法
        int count = Mapper.addDean(dean.getId(),dean.getPassword(),dean.getDept_name(),dean.getName(),dean.getIdentity());

        sqlSession.commit();
        sqlSession.close();
        return count;
    }
}
