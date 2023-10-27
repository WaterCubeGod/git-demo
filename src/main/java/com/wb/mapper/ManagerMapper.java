package com.wb.mapper;

import com.wb.pojo.Manager;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ManagerMapper {

    @Select("select * from manager where id = #{id} and password = #{password}")
    Manager select(@Param("id") String id,@Param("password") String password);

    @Insert("insert into teaches values (#{id} ,#{course_id})")
    int addTeaches(@Param("id") String id,@Param("course_id") String courseId);

    @Select("select managerId from manage where employeeId = #{employeeId}")
    String selectId(@Param("employeeId") String id);

    @Delete("delete from manage where managerId = #{managerId} and employeeId = #{employeeId}")
    int deleteManage(@Param("managerId") String managerId,@Param("employeeId") String employeeId);

    @Insert("insert into manage values (#{managerId},#{employeeId})")
    int addManage(@Param("managerId") String managerId,@Param("employeeId") String employeeId);
}
