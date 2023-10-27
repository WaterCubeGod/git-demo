package com.wb.service;

import com.wb.mapper.TeacherMapper;
import com.wb.mapper.TeachesMapper;
import com.wb.pojo.Teacher;
import com.wb.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TeachesService {
    static public List<String> selectById(String id){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        TeachesMapper Mapper = sqlSession.getMapper(TeachesMapper.class);

        //4.调用方法
        List<String> courseNames = Mapper.selectById(id);

        sqlSession.commit();
        sqlSession.close();
        return courseNames;
    }

    static public List<String> selectNone(){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        TeachesMapper Mapper = sqlSession.getMapper(TeachesMapper.class);

        //4.调用方法
        List<String> courseIds = Mapper.selectNone();

        sqlSession.commit();
        sqlSession.close();
        return courseIds;
    }

    static public String selectName(String courseId){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        TeachesMapper Mapper = sqlSession.getMapper(TeachesMapper.class);

        //4.调用方法
        String courseName = Mapper.selectName(courseId);

        sqlSession.commit();
        sqlSession.close();
        return courseName;
    }
}
