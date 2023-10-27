package com.wb.service;

import com.wb.mapper.TeacherMapper;
import com.wb.mapper.WorkMapper;
import com.wb.pojo.Teacher;
import com.wb.pojo.WorkEvent;
import com.wb.pojo.WorkFlow;
import com.wb.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class WorkService {

    static public WorkFlow selectFlow(String deptName){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        WorkMapper Mapper = sqlSession.getMapper(WorkMapper.class);

        //4.调用方法
        WorkFlow workFlow = Mapper.selectFlow(deptName);

        sqlSession.commit();
        sqlSession.close();
        return workFlow;
    }

    static public List<WorkFlow> selectAllFlow(){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        WorkMapper Mapper = sqlSession.getMapper(WorkMapper.class);

        //4.调用方法
        List<WorkFlow> workFlows = Mapper.selectAllFlow();

        sqlSession.commit();
        sqlSession.close();
        return workFlows;
    }

    static public WorkEvent selectEvent(String eventId){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        WorkMapper Mapper = sqlSession.getMapper(WorkMapper.class);

        //4.调用方法
        WorkEvent workEvent = Mapper.selectEvent(eventId);

        sqlSession.commit();
        sqlSession.close();
        return workEvent;
    }

    static public int addEvent(String eventId,int teacher,int supervisor,int dean){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        WorkMapper Mapper = sqlSession.getMapper(WorkMapper.class);

        //4.调用方法
        int count = Mapper.addEvent(eventId,teacher,supervisor,dean);

        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    static public int updateTeacher(int teacher,String eventId){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        WorkMapper Mapper = sqlSession.getMapper(WorkMapper.class);

        //4.调用方法
        int count = Mapper.updateTeacher(teacher,eventId);

        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    static public int updateSupervisor(int supervisor,String eventId){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        WorkMapper Mapper = sqlSession.getMapper(WorkMapper.class);

        //4.调用方法
        int count = Mapper.updateSupervisor(supervisor,eventId);

        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    static public int updateDean(int dean,String eventId){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        WorkMapper Mapper = sqlSession.getMapper(WorkMapper.class);

        //4.调用方法
        int count = Mapper.updateDean(dean,eventId);

        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    static public int delete(String eventId){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        WorkMapper Mapper = sqlSession.getMapper(WorkMapper.class);

        //4.调用方法
        int count = Mapper.delete(eventId);

        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    static public int updateFlow(int teacher,int supervisor,int dean,String deptName){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        WorkMapper Mapper = sqlSession.getMapper(WorkMapper.class);

        int count = Mapper.updateFlow(teacher,supervisor,dean,deptName);

        sqlSession.commit();
        sqlSession.close();
        return count;
    }
}
