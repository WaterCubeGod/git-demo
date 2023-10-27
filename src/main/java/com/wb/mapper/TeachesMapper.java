package com.wb.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeachesMapper {

    @Select("select courseName from teaches natural join course where id = #{id}")
    List<String> selectById(@Param("id") String id);

    @Select("select course_id from course " +
            "except select course_id from teaches")
    List<String> selectNone();

    @Select("select name from course where course_id = #{course_id}")
    String selectName(@Param("course_id") String course_id);
}
