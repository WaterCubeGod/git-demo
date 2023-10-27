package com.wb.mapper;

import com.wb.pojo.Dean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DeanMapper {
    @Select("select * from dean where id = #{id} and password = #{password}")
    Dean select(@Param("id") String username, @Param("password") String password);

    @Select("select * from dean where id = #{id}")
    Dean selectById(@Param("id") String username);

    @Select("select * from dean")
    List<Dean> selectAll();

    @Select("select employeeId from manage where managerId = #{managerId}")
    List<String> selectSupervisor(@Param("managerId") String managerId);

    @Insert("insert into dean values (#{id},#{password},#{deptName},#{name},#{identity})")
    int addDean(@Param("id") String id,@Param("password") String password,
                   @Param("deptName") String deptName, @Param("name") String name,
                   @Param("identity") String identity);
}
