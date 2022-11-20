package com.example.codesystem.mapper;

import com.example.codesystem.model.Item;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface ItemMapper {

    Item findById(Item item);

    void delete(Item item);

    List<Item> list(Item item);

    List<Item> listS(Item item);

    int count(Item item);

    int insert(Item item);

    int update (Item item);


    List<Item> selectAll();

//    @Select("SELECT i.* , t.name as categoryName FROM tb_item i LEFT JOIN tb_category t ON i.cid = t.id WHERE i.status = 1\n" +
//            "        <if test=\"title != null\">\n" +
//            "            AND title LIKE concat('%', #{title, jdbcType=VARCHAR}, '%')\n" +
//            "        </if>\n" +
//            "        <if test=\"cid != 0\">\n" +
//            "            AND cid = #{cid, jdbcType=INTEGER}\n" +
//            "        </if>\n" +
//            "        <if test=\"minPrice != null and maxPrice != null\">\n" +
//            "            AND price BETWEEN #{minPrice, jdbcType=INTEGER} AND #{maxPrice, jdbcType=INTEGER}\n" +
//            "        </if>\n" +
//            "        ORDER BY updated desc\n" +
//            "        limit #{start, jdbcType=INTEGER},#{end, jdbcType=INTEGER}")
//    @Results(id = "BaseResultMap" ,value = {
//            @Result(column="title", property="title", jdbcType= JdbcType.VARCHAR),
//            @Result(column="sell_point", property="sellPoint", jdbcType= JdbcType.VARCHAR),
//            @Result(column="price", property="price", jdbcType= JdbcType.INTEGER),
//            @Result(column="num", property="num", jdbcType= JdbcType.INTEGER),
//            @Result(column="barcode", property="barcode", jdbcType= JdbcType.VARCHAR),
//            @Result(column="image", property="image", jdbcType= JdbcType.VARCHAR),
//            @Result(column="cid", property="cid", jdbcType= JdbcType.INTEGER),
//            @Result(column="status", property="status", jdbcType= JdbcType.TINYINT),
//            @Result(column="created", property="created", jdbcType= JdbcType.TIMESTAMP),
//            @Result(column="updated", property="updated", jdbcType= JdbcType.TIMESTAMP),
//            @Result(column="categoryName", property="categoryName", jdbcType= JdbcType.VARCHAR),
//    })
//    List<Item> list(Item item);
//
//    @Select("SELECT i.* , t.name as categoryName FROM tb_item i LEFT JOIN tb_category t ON i.cid = t.id WHERE i.status = 1\n" +
//            "        <if test=\"title != null\">\n" +
//            "            AND title LIKE concat('%', #{title, jdbcType=VARCHAR}, '%')\n" +
//            "        </if>\n" +
//            "        <if test=\"cid != 0\">\n" +
//            "            AND cid = #{cid, jdbcType=INTEGER}\n" +
//            "        </if>\n" +
//            "        <if test=\"minNum != null and maxNum != null\">\n" +
//            "            AND num BETWEEN #{minNum, jdbcType=INTEGER} AND #{maxNum, jdbcType=INTEGER}\n" +
//            "            ORDER BY num\n" +
//            "        </if>\n" +
//            "        limit #{start, jdbcType=INTEGER},#{end, jdbcType=INTEGER}")
//    @ResultMap("BaseResultMap")
//    List<Item> listS(Item item);
//
//    @Select("select * FROM jesper.tb_item")
//    @ResultMap("BaseResultMap")
//    List<Item> selectAll();
//
//
//    @Select("SELECT * from tb_item where id = #{id, jdbcType=INTEGER}")
//    @ResultMap("BaseResultMap")
//    Item findById(Item item);
//
//    @Delete("DELETE FROM tb_item WHERE id = #{id, jdbcType=INTEGER} ")
//    void delete(Item item);
//
//
////
////    @Select("SELECT count(*) from tb_item i LEFT JOIN tb_category t ON i.cid = t.id WHERE i.status = 1\n" +
////            "        <if test=\"title != null\">\n" +
////            "            AND title LIKE concat('%', #{title, jdbcType=VARCHAR}, '%')\n" +
////            "        </if>\n" +
////            "        <if test=\"cid != 0\">\n" +
////            "            AND cid = #{cid, jdbcType=INTEGER}\n" +
////            "        </if>\n" +
////            "        <if test=\"minPrice != null and maxPrice != null\">\n" +
////            "            AND price BETWEEN #{minPrice, jdbcType=INTEGER} AND #{maxPrice, jdbcType=INTEGER}\n" +
////            "            ORDER BY price\n" +
////            "        </if>")
////    int count(Item item); 用来做分页
//
//    @Insert("INSERT INTO tb_item (id, title, sell_point, price, num, barcode, image, cid, status, created, updated)\n" +
//            "         VALUE (\n" +
//            "         #{id, jdbcType=INTEGER},\n" +
//            "         #{title, jdbcType=VARCHAR},\n" +
//            "         #{sellPoint, jdbcType=VARCHAR},\n" +
//            "         #{price, jdbcType=INTEGER},\n" +
//            "         #{num, jdbcType=INTEGER},\n" +
//            "         #{barcode, jdbcType=VARCHAR},\n" +
//            "         #{image, jdbcType=VARCHAR},\n" +
//            "         #{cid, jdbcType=INTEGER},\n" +
//            "         1,\n" +
//            "         #{created, jdbcType=TIMESTAMP},\n" +
//            "         #{updated, jdbcType=TIMESTAMP}\n" +
//            "          )")
//    int insert(Item item);
//
//    @Update(" UPDATE tb_item SET\n" +
//            "        <if test=\"title != null\">\n" +
//            "            title = #{title, jdbcType=VARCHAR},\n" +
//            "        </if>\n" +
//            "        <if test=\"sellPoint != null\">\n" +
//            "            sell_point= #{sellPoint, jdbcType=VARCHAR},\n" +
//            "        </if>\n" +
//            "        <if test=\"price != null\">\n" +
//            "            price = #{price, jdbcType=INTEGER},\n" +
//            "        </if>\n" +
//            "        <if test=\"num != null\">\n" +
//            "            num = #{num, jdbcType=INTEGER},\n" +
//            "        </if>\n" +
//            "        <if test=\"cid != null\">\n" +
//            "            cid = #{cid, jdbcType=INTEGER},\n" +
//            "        </if>\n" +
//            "        <if test=\"updated != null\">\n" +
//            "            updated = #{updated, jdbcType=TIMESTAMP},\n" +
//            "        </if>\n" +
//            "        <if test=\"image != null\">\n" +
//            "            image = #{image, jdbcType=VARCHAR}\n" +
//            "        </if>\n" +
//            "        WHERE id = #{id, jdbcType=INTEGER}")
//    int update (Item item);



}
