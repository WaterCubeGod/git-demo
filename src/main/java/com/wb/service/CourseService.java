package com.wb.service;

import com.wb.mapper.CourseMapper;
import com.wb.pojo.Course;
import com.wb.pojo.CourseLicense;
import com.wb.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CourseService {

    static public List<Course> selectCourse(String id){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        CourseMapper Mapper = sqlSession.getMapper(CourseMapper.class);

        //4.调用方法
        List<Course> courses = Mapper.select(id);

        sqlSession.commit();
        sqlSession.close();
        return courses;
    }

    static public Course select(String name){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        CourseMapper Mapper = sqlSession.getMapper(CourseMapper.class);

        //4.调用方法
        Course course = Mapper.selectCourse(name);

        sqlSession.commit();
        sqlSession.close();
        return course;
    }

    static public String selectById(String courseId){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        CourseMapper Mapper = sqlSession.getMapper(CourseMapper.class);

        //4.调用方法
        String courseName = Mapper.selectById(courseId);

        sqlSession.commit();
        sqlSession.close();
        return courseName;
    }

    static public CourseLicense selectId(String courseId){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        CourseMapper Mapper = sqlSession.getMapper(CourseMapper.class);

        //4.调用方法
        CourseLicense courseLicense = Mapper.selectId(courseId);

        sqlSession.commit();
        sqlSession.close();
        return courseLicense;
    }

    static public CourseLicense selectName(String name){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        CourseMapper Mapper = sqlSession.getMapper(CourseMapper.class);

        //4.调用方法
        CourseLicense courseLicense = Mapper.selectName(name);

        sqlSession.commit();
        sqlSession.close();
        return courseLicense;
    }

    static public List<CourseLicense> selectAll(){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        CourseMapper Mapper = sqlSession.getMapper(CourseMapper.class);

        //4.调用方法
        List<CourseLicense> courseLicenses = Mapper.selectAll();

        sqlSession.commit();
        sqlSession.close();
        return courseLicenses;
    }

    static public int updateLicense(String license,String courseId){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        CourseMapper Mapper = sqlSession.getMapper(CourseMapper.class);

        //4.调用方法
        int count = Mapper.updateLicense(license,courseId);

        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    static public String selectDept(String courseName){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        CourseMapper Mapper = sqlSession.getMapper(CourseMapper.class);

        String deptName = Mapper.selectDept(courseName);

        sqlSession.commit();
        sqlSession.close();
        return deptName;
    }
}
