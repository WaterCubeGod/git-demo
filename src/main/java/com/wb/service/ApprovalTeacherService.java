package com.wb.service;

import com.wb.mapper.ApprovalEventMapper;
import com.wb.mapper.ApprovalTeacherMapper;
import com.wb.mapper.StudentMapper;
import com.wb.pojo.Student;
import com.wb.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ApprovalTeacherService {
    static public String selectId(String courseName){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalTeacherMapper Mapper = sqlSession.getMapper(ApprovalTeacherMapper.class);

        //4.调用方法
        String id = Mapper.selectId(courseName);

        sqlSession.commit();
        sqlSession.close();
        return id;
    }

    static public List<String> selectEventId(String id){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalTeacherMapper Mapper = sqlSession.getMapper(ApprovalTeacherMapper.class);

        //4.调用方法
        List<String> eventIds = Mapper.selectEventId(id);

        sqlSession.commit();
        sqlSession.close();
        return eventIds;
    }
}
