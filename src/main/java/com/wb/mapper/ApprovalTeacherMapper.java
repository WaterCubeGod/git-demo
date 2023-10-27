package com.wb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ApprovalTeacherMapper {

    @Insert("insert into approval_teacher values(#{eventId},#{id})")
    int add(@Param("eventId") String eventId,@Param("id") String id);

    @Select("select id from teaches natural join course where name = #{courseName}")
    String selectId(@Param("courseName") String courseName);

    @Select("select eventId from approval_teacher where approval_teacher.id = #{id}")
    List<String> selectEventId(@Param("id")String id);
}
