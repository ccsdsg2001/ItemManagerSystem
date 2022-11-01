package com.example.codesystem.mapper;

import com.example.codesystem.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.net.InetAddress;

@Mapper
public interface UserMapper {

    @Select("SELECT * from tb_user  where userName = #{userName, jdbcType=VARCHAR} and password = #{password, jdbcType=VARCHAR} and state = 1\n")
    User selectByNameAndPwd(User user);//查找用户登录

    @Select("INSERT INTO tb_user (id, userName, password, realName, business, email, headPicture, addDate, updateDate, state)\n" +
            "        VALUES   (null, #{userName, jdbcType=VARCHAR}, #{password, jdbcType=VARCHAR}, null, null, #{email, jdbcType=VARCHAR}, null, #{addDate, jdbcType=DATE}, #{updateDate, jdbcType=DATE}, 1)")
    int insert(User user);//注册用户

    @Update("UPDATE tb_user SET\n" +
            "        password = #{password, jdbcType=VARCHAR},\n" +
            "        email = #{email, jdbcType=VARCHAR},\n" +
            "        realName = #{realName, jdbcType=VARCHAR},\n" +
            "        business = #{business, jdbcType=VARCHAR},\n" +
            "        updateDate = #{updateDate, jdbcType=DATE}\n" +
            "        WHERE   userName = #{userName, jdbcType=VARCHAR}")
    int update(User user);//更改用户

    @Select("SELECT 1 from tb_user  where userName = #{userName, jdbcType=VARCHAR}")
    int insertIsname(User user);//查询用户名是否存在

    @Select("SELECT password from tb_user  where userName = #{userName, jdbcType=VARCHAR} AND  email = #{email, jdbcType=VARCHAR}")
    String selectPasswordByname(User user);//更改密码通过名字查找


}
