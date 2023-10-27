package com.wb.mapper;

import com.wb.pojo.Supervisor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SupervisorMapper {
    @Select("select * from supervisor where id = #{id} and password = #{password}")
    Supervisor select(@Param("id") String username, @Param("password") String password);

    @Select("select * from supervisor where id = #{id}")
    Supervisor selectById(@Param("id") String username);

    @Select("select * from supervisor")
    List<Supervisor> selectAll();

    @Select("select employeeId from manage where managerId = #{managerId}")
    List<String> selectTeacher(@Param("managerId") String managerId);

    @Insert("insert into supervisor values (#{id},#{password},#{deptName},#{name},#{identity})")
    int addSupervisor(@Param("id") String id,@Param("password") String password,
                @Param("deptName") String deptName, @Param("name") String name,
                @Param("identity") String identity);
}
