package com.wb.mapper;

import com.wb.pojo.Course;
import com.wb.pojo.CourseLicense;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CourseMapper {

    @Select("select course_id as courseId,name,deptName from takes natural join course " +
            "natural join courselicense where id = #{id} and license = 1")
    List<Course> select(@Param("id") String id);

    @Select("select course_id as courseId,name,deptName from course where name = #{name}")
    Course selectCourse(@Param("name") String name);

    @Select("select name from course where course_id = #{course_id}")
    String selectById(@Param("course_id") String courseId);

    @Select("select course_id as courseId,name,license from course natural join courselicense where course_id = #{courseId}")
    CourseLicense selectId(@Param("courseId") String courseId);

    @Select("select course_id as courseId,name,license from course natural join courselicense where name = #{name}")
    CourseLicense selectName(@Param("name") String name);

    @Select("select course_id as courseId,name,license from course natural join courselicense")
    List<CourseLicense> selectAll();

    @Update("update courselicense set license = #{license} where course_id = #{courseId}")
    int updateLicense(@Param("license") String license,@Param("courseId") String courseId);

    @Select("select deptName from course where name=#{name}")
    String selectDept(@Param("name") String courseName);
}
