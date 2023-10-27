package com.wb.mapper;

import com.wb.pojo.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    @Select("select * from teacher where id = #{id} and password = #{password}")
    Teacher select(@Param("id") String username, @Param("password") String password);

    @Select("select * from teacher where id = #{id}")
    Teacher selectById(@Param("id") String username);

    @Select("select * from teacher")
    List<Teacher> selectAll();

    @Select("select course_id from teaches where id = #{id}")
    List<String> selectCourseName(@Param("id") String id);

    @Insert("insert into teacher values (#{id},#{password},#{deptName},#{name},#{identity})")
    int addTeacher(@Param("id") String id,@Param("password") String password,
                @Param("deptName") String deptName, @Param("name") String name,
                @Param("identity") String identity);
}
