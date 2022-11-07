package com.example.codesystem.mapper;

import com.example.codesystem.model.Item;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface ItemMapper {


    @Select("SELECT i.* , t.name as categoryName FROM tb_item i LEFT JOIN tb_category t ON i.cid = t.id WHERE i.status = 1\n" +
            "        <if test=\"title != null\">\n" +
            "            AND title LIKE concat('%', #{title, jdbcType=VARCHAR}, '%')\n" +
            "        </if>\n" +
            "        <if test=\"cid != 0\">\n" +
            "            AND cid = #{cid, jdbcType=INTEGER}\n" +
            "        </if>\n" +
            "        <if test=\"minPrice != null and maxPrice != null\">\n" +
            "            AND price BETWEEN #{minPrice, jdbcType=INTEGER} AND #{maxPrice, jdbcType=INTEGER}\n" +
            "        </if>\n" +
            "        ORDER BY updated desc\n" +
            "        limit #{start, jdbcType=INTEGER},#{end, jdbcType=INTEGER}")
    @Results(id = "BaseResultMap" ,value = {
            @Result(column="title", property="title", jdbcType= JdbcType.VARCHAR),
            @Result(column="sell_point", property="sellPoint", jdbcType= JdbcType.VARCHAR),
            @Result(column="price", property="price", jdbcType= JdbcType.INTEGER),
            @Result(column="num", property="num", jdbcType= JdbcType.INTEGER),
            @Result(column="barcode", property="barcode", jdbcType= JdbcType.VARCHAR),
            @Result(column="image", property="image", jdbcType= JdbcType.VARCHAR),
            @Result(column="cid", property="cid", jdbcType= JdbcType.INTEGER),
            @Result(column="status", property="status", jdbcType= JdbcType.TINYINT),
            @Result(column="created", property="created", jdbcType= JdbcType.TIMESTAMP),
            @Result(column="updated", property="updated", jdbcType= JdbcType.TIMESTAMP),
            @Result(column="categoryName", property="categoryName", jdbcType= JdbcType.VARCHAR),
    })
    List<Item> list(Item item);

    @Select("SELECT i.* , t.name as categoryName FROM tb_item i LEFT JOIN tb_category t ON i.cid = t.id WHERE i.status = 1\n" +
            "        <if test=\"title != null\">\n" +
            "            AND title LIKE concat('%', #{title, jdbcType=VARCHAR}, '%')\n" +
            "        </if>\n" +
            "        <if test=\"cid != 0\">\n" +
            "            AND cid = #{cid, jdbcType=INTEGER}\n" +
            "        </if>\n" +
            "        <if test=\"minNum != null and maxNum != null\">\n" +
            "            AND num BETWEEN #{minNum, jdbcType=INTEGER} AND #{maxNum, jdbcType=INTEGER}\n" +
            "            ORDER BY num\n" +
            "        </if>\n" +
            "        limit #{start, jdbcType=INTEGER},#{end, jdbcType=INTEGER}")
    @ResultMap("BaseResultMap")
    List<Item> listS(Item item);

    @Select("select * FROM jesper.tb_item")
    @ResultMap("BaseResultMap")
    List<Item> selectAll();
}
