package com.wb.mapper;

import com.wb.pojo.ApprovalComment;
import com.wb.pojo.ApprovalEvent;
import com.wb.pojo.ApprovalReg;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface ApprovalEventMapper {

    @Select("<script>" +
            "select * from approvalevent where id = #{id} " +
            "<if test=\"start!=null and end!=null\">" +
            "limit #{start},#{end}" +
            "</if>" +
            "</script>")
    List<ApprovalEvent> select(@Param("id")String id,@Param("start") Integer start,@Param("end") Integer end);

    @Select("select * from approvalevent where courseName = #{courseName}")
    ApprovalEvent selectByName(@Param("courseName")String courseName);

    @Insert("insert into approvalevent(id,courseName,reason,eventStatus) values (#{id},#{courseName},#{reason},#{eventStatus})")
    int add(@Param("id")String id,@Param("courseName")String courseName,@Param("reason")String reason,
            @Param("eventStatus") String eventStatus);

    @Insert("insert into approval_teacher(eventId,id) values (#{eventId},#{id})")
    int addTeacher(@Param("eventId")String eventId,@Param("id")String id);

    @Delete("delete from approval_teacher where eventId = #{eventId}")
    int deleteTeacher(@Param("eventId") String eventId);

    //通过事件id找ApprovalReg
    @Select("select * from approvalevent natural join student where eventId = #{eventId}")
    ApprovalReg selectReg(@Param("eventId") String eventId);

    @Select("select * from approvalevent")
    List<ApprovalEvent> selectAllEvent();

    @Select("select eventId from approvalevent order by eventId desc limit 1")
    String selectEventId();

    @Select("select courseName from approvalevent order by eventId desc limit 1")
    String selectCourse();

    @Select("select * from approvalevent where eventId = #{eventId}")
    ApprovalEvent selectId(@Param("eventId") String eventId);

    @Update("update approvalevent set eventStatus = #{eventStatus} where eventId = #{eventId}")
    int updateStatus(@Param("eventStatus") String eventStatus,@Param("eventId") String eventId);

    @Update("update approvalevent set endTime = #{endTime} where eventId = #{eventId}")
    int updateEndTime(@Param("endTime") String endTime, @Param("eventId") String eventId);

    @Update("update approvalevent set reason = #{reason},startTime = #{startTime} where eventId = #{eventId}")
    int updateReason(@Param("reason") String reason,@Param("startTime") String startTime, @Param("eventId") String eventId);

    @Delete("delete from approvalevent where eventId = #{eventId}")
    int delete(@Param("eventId") String eventId);

    @Update("update approvalcomments set teacherComment = #{teacherComment} where eventId = #{eventId}")
    int updateTeacherComment(@Param("teacherComment") String teacherComment,
                             @Param("eventId") String eventId);

    @Update("update approvalcomments set supervisorComment = #{supervisorComment} where eventId = #{eventId}")
    int updateSupervisorComment(@Param("supervisorComment") String supervisorComment,
                             @Param("eventId") String eventId);

    @Update("update approvalcomments set deanComment = #{deanComment} where eventId = #{eventId}")
    int updateDeanComment(@Param("deanComment") String deanComment,
                             @Param("eventId") String eventId);

    @Insert("insert into approvalcomments(eventId) values (#{eventId})")
    int insertComments(@Param("eventId") String eventId);

    @Select("select * from approvalcomments where eventId = #{eventId}")
    ApprovalComment selectComment(@Param("eventId") String eventId);
}
