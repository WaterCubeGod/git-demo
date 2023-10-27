package com.wb.service;

import com.wb.mapper.ApprovalEventMapper;
import com.wb.pojo.ApprovalComment;
import com.wb.pojo.ApprovalEvent;
import com.wb.pojo.ApprovalReg;
import com.wb.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class ApprovalEventService {
    //查找事件
    static public List<ApprovalEvent> selectApprovalEvent(String id,Integer start,Integer end){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalEventMapper Mapper = sqlSession.getMapper(ApprovalEventMapper.class);

        //4.调用方法
        List<ApprovalEvent> approvalEvents = Mapper.select(id,start,end);

        sqlSession.commit();
        sqlSession.close();
        return approvalEvents;
    }

    static public List<ApprovalEvent> selectByName(List<String> courseNames){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalEventMapper Mapper = sqlSession.getMapper(ApprovalEventMapper.class);

        List<ApprovalEvent> approvalEvents = new ArrayList<>();
        //4.调用方法
        for (int i = 0; i < courseNames.size(); i++) {
            String courseName = courseNames.get(i);
            ApprovalEvent approvalEvent = Mapper.selectByName(courseName);
            approvalEvents.add(approvalEvent);
        }
        sqlSession.commit();
        sqlSession.close();
        return approvalEvents;
    }


    static public int addApprovalEvent(String id,String courseName,String reason,String eventStatus){

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalEventMapper Mapper = sqlSession.getMapper(ApprovalEventMapper.class);

        //4.调用方法
        int count = Mapper.add(id,courseName,reason,eventStatus);
        sqlSession.commit();
        sqlSession.close();
        return count;
    }


    static public String selectEventId(){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalEventMapper Mapper = sqlSession.getMapper(ApprovalEventMapper.class);
        String eventId = Mapper.selectEventId();
        sqlSession.commit();
        sqlSession.close();
        return eventId;
    }

    //通过事件id找ApprovalEvent
    static public ApprovalEvent selectId(String eventId){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalEventMapper Mapper = sqlSession.getMapper(ApprovalEventMapper.class);
        ApprovalEvent approvalEvent = Mapper.selectId(eventId);
        sqlSession.commit();
        sqlSession.close();
        return approvalEvent;
    }

    static public String selectCourse(){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalEventMapper Mapper = sqlSession.getMapper(ApprovalEventMapper.class);
        String courseName = Mapper.selectCourse();
        sqlSession.commit();
        sqlSession.close();
        return courseName;
    }

    static public int addApprovalTeacher(String eventId,String id) {

        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalEventMapper Mapper = sqlSession.getMapper(ApprovalEventMapper.class);
        //4.调用方法
        int count = Mapper.addTeacher(eventId,id);
        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    //通过事件id找ApprovalReg
    static public ApprovalReg selectById(String eventId){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalEventMapper Mapper = sqlSession.getMapper(ApprovalEventMapper.class);

        ApprovalReg approvalEvent = Mapper.selectReg(eventId);

        sqlSession.commit();
        sqlSession.close();
        return approvalEvent;
    }

    static public int updateStatus(String eventStatus,String eventId){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalEventMapper Mapper = sqlSession.getMapper(ApprovalEventMapper.class);

        int count = Mapper.updateStatus(eventStatus,eventId);

        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    static public int updateEndTime(String endTime,String eventId){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalEventMapper Mapper = sqlSession.getMapper(ApprovalEventMapper.class);

        int count = Mapper.updateEndTime(endTime,eventId);

        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    static public int updateReason(String reason,String startTime,String eventId){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalEventMapper Mapper = sqlSession.getMapper(ApprovalEventMapper.class);

        int count = Mapper.updateReason(reason,startTime,eventId);

        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    static public int delete(String eventId){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalEventMapper Mapper = sqlSession.getMapper(ApprovalEventMapper.class);

        int count = Mapper.delete(eventId);

        sqlSession.commit();
        sqlSession.close();
        return count;
    }
    static public int deleteTeacher(String eventId){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalEventMapper Mapper = sqlSession.getMapper(ApprovalEventMapper.class);

        int count = Mapper.deleteTeacher(eventId);

        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    static public List<ApprovalEvent> selectAllEvent(){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalEventMapper Mapper = sqlSession.getMapper(ApprovalEventMapper.class);

        List<ApprovalEvent> approvalEvents = Mapper.selectAllEvent();

        sqlSession.commit();
        sqlSession.close();
        return approvalEvents;
    }

    static public int updateTeacherComment(String teacherComment,String eventId){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalEventMapper Mapper = sqlSession.getMapper(ApprovalEventMapper.class);

        int count = Mapper.updateTeacherComment(teacherComment,eventId);

        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    static public int updateSupervisorComment(String supervisorComment,String eventId){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalEventMapper Mapper = sqlSession.getMapper(ApprovalEventMapper.class);

        int count = Mapper.updateSupervisorComment(supervisorComment,eventId);

        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    static public int updateDeanComment(String deanComment,String eventId){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalEventMapper Mapper = sqlSession.getMapper(ApprovalEventMapper.class);

        int count = Mapper.updateDeanComment(deanComment,eventId);

        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    static public int addComment(String eventId){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalEventMapper Mapper = sqlSession.getMapper(ApprovalEventMapper.class);

        int count = Mapper.insertComments(eventId);

        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    static public ApprovalComment selectComment(String eventId){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        ApprovalEventMapper Mapper = sqlSession.getMapper(ApprovalEventMapper.class);

        ApprovalComment approvalComment = Mapper.selectComment(eventId);

        sqlSession.commit();
        sqlSession.close();
        return approvalComment;
    }
}
