package com.wb.service;

import com.wb.mapper.FileInfoMapper;
import com.wb.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

public class FileInfoService {

    static public int addFile(String eventId,String fileName,String fileSize){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        FileInfoMapper Mapper = sqlSession.getMapper(FileInfoMapper.class);

        int count = Mapper.insertFile(eventId,fileName, fileSize);


        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    static public int deleteFile(String eventId,String fileName){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        FileInfoMapper Mapper = sqlSession.getMapper(FileInfoMapper.class);

        int count = Mapper.deleteFile(eventId,fileName);

        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    static public String selectFileName(String eventId){
        //2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //3.获取PeopleMapper
        FileInfoMapper Mapper = sqlSession.getMapper(FileInfoMapper.class);

        String fileName = Mapper.selectFileName(eventId);

        sqlSession.commit();
        sqlSession.close();
        return fileName;
    }
}
