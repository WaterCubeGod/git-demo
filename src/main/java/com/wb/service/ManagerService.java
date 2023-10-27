package com.wb.service;

import com.wb.mapper.DeanMapper;
import com.wb.mapper.ManagerMapper;
import com.wb.pojo.Dean;
import com.wb.pojo.Manager;
import com.wb.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

public class ManagerService {

    static public Manager selectUser(String id, String password){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ManagerMapper Mapper = sqlSession.getMapper(ManagerMapper.class);

        //4.调用方法
        Manager manager = Mapper.select(id, password);
        sqlSession.commit();
        sqlSession.close();
        return manager;
    }

    static public int addTeaches(String id, String courseId){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ManagerMapper Mapper = sqlSession.getMapper(ManagerMapper.class);

        //4.调用方法
        int count = Mapper.addTeaches(id, courseId);
        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    static public String selectId(String id){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ManagerMapper Mapper = sqlSession.getMapper(ManagerMapper.class);

        //4.调用方法
        String employeeId = Mapper.selectId(id);
        sqlSession.commit();
        sqlSession.close();
        return employeeId;
    }

    static public int delete(String managerId,String employeeId){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ManagerMapper Mapper = sqlSession.getMapper(ManagerMapper.class);

        //4.调用方法
        int count = Mapper.deleteManage(managerId,employeeId);
        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    static public int add(String managerId,String employeeId){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ManagerMapper Mapper = sqlSession.getMapper(ManagerMapper.class);

        //4.调用方法
        int count = Mapper.addManage(managerId,employeeId);
        sqlSession.commit();
        sqlSession.close();
        return count;
    }
}
