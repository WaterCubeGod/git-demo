package com.wb.mapper;

import com.wb.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    @Select("select id,password,dept_name,name,identity from student where id = #{id} and password = #{password}")
    Student select(@Param("id") String id, @Param("password") String password);

    @Select("select id,password,dept_name,name,identity from student where id = #{id}")
    Student selectById(@Param("id") String id);

    @Select("select id,password,dept_name,name,identity from student")
    List<Student> selectAll();

    @Insert("insert into student values (#{id},#{password},#{deptName},#{name},#{identity})")
    int addStudent(@Param("id") String id,@Param("password") String password,
                   @Param("deptName") String deptName, @Param("name") String name,
                   @Param("identity") String identity);
}
