package com.wb.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface FileInfoMapper {
    @Insert("insert into fileinfo values (#{eventId},#{fileName},#{fileSize})")
    int insertFile(@Param("eventId") String eventId,@Param("fileName") String fileName,
                   @Param("fileSize") String fileSize);

    @Delete("delete from fileinfo where eventId = #{eventId} and fileName = #{fileName}")
    int deleteFile(@Param("eventId") String eventId,@Param("fileName") String fileName);

    @Select("select fileName from fileinfo where eventId = #{eventId}")
    String selectFileName(@Param("eventId") String eventId);

}
