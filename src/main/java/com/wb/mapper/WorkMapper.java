package com.wb.mapper;

import com.wb.pojo.WorkEvent;
import com.wb.pojo.WorkFlow;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface WorkMapper {
    @Select("select * from workflow where deptName = #{deptName}")
    WorkFlow selectFlow(@Param("deptName") String deptName);

    @Select("select * from workflow")
    List<WorkFlow> selectAllFlow();

    @Select("select * from workevent where eventId = #{eventId}")
    WorkEvent selectEvent(@Param("eventId") String eventId);

    @Insert("insert into workevent values (#{eventId},#{teacher},#{supervisor},#{dean})")
    int addEvent(@Param("eventId") String eventId,@Param("teacher") int teacher,
                 @Param("supervisor") int supervisor,@Param("dean") int dean);

    @Update("update  workevent set teacher = #{teacher} where eventId = #{eventId}")
    int updateTeacher(@Param("teacher") int teacher, @Param("eventId") String eventId);

    @Update("update  workevent set supervisor = #{supervisor} where eventId = #{eventId}")
    int updateSupervisor(@Param("supervisor") int supervisor, @Param("eventId") String eventId);

    @Update("update  workevent set dean = #{dean} where eventId = #{eventId}")
    int updateDean(@Param("dean") int dean, @Param("eventId") String eventId);

    @Delete("delete from workevent where eventId = #{eventId}")
    int delete(@Param("eventId") String eventId);

    @Update("update workflow set teacher = #{teacher},supervisor = #{supervisor},dean = #{dean} where deptName = #{deptName}")
    int updateFlow(@Param("teacher") int teacher,
                @Param("supervisor") int supervisor,@Param("dean") int dean,@Param("deptName") String deptName);
}
