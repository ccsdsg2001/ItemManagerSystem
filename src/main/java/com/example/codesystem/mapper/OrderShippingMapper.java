package com.example.codesystem.mapper;

import com.example.codesystem.model.Order;
import com.example.codesystem.model.OrderShipping;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * @author cc
 * @date 2022年11月12日 20:04
 */

@Mapper
public interface OrderShippingMapper {

//
//    @Results(id = "BaseResultMap",value = {
//            @Result(column ="order_id",property = "orderId",jdbcType = JdbcType.VARCHAR),
//            @Result(column ="receiver_name",property = "receiverName",jdbcType = JdbcType.VARCHAR),
//            @Result(column ="receiver_phone",property = "receiverPhone",jdbcType = JdbcType.VARCHAR),
//            @Result(column ="receiver_mobile",property = "receiverMobile",jdbcType = JdbcType.VARCHAR),
//            @Result(column ="receiver_state",property = "receiverState",jdbcType = JdbcType.VARCHAR),
//            @Result(column ="receiver_city",property = "receiverCity",jdbcType = JdbcType.VARCHAR),
//            @Result(column ="receiver_district",property = "receiverDistrict",jdbcType = JdbcType.VARCHAR),
//            @Result(column ="receiver_address",property = "receiverAddress",jdbcType = JdbcType.VARCHAR),
//            @Result(column ="receiver_zip",property = "receiverZip",jdbcType = JdbcType.VARCHAR),
//                @Result(column ="created",property = "created",jdbcType = JdbcType.TIMESTAMP),
//            @Result(column ="updated",property = "updated",jdbcType = JdbcType.TIMESTAMP)
//    })
//    @Delete("DELETE FROM tb_order_shipping WHERE order_id = #{orderId,jdbcType=VARCHAR} ")
    int deleteByPrimaryKey(String orderId);//删除


//    @Select(" select order_id, receiver_name, receiver_phone, receiver_mobile, receiver_state, \n" +
//            "    receiver_city, receiver_district, receiver_address, receiver_zip, created, updated\n" +
//            "    from tb_order_shipping ")
//    @ResultMap("BaseResultMap")
    List<OrderShipping> selectAll();//显示发货管理的数据

//    @ResultMap("BaseResultMap")
//    @Update("update tb_order_shipping\n" +
//            "    set receiver_name = #{receiverName,jdbcType=VARCHAR},\n" +
//            "      receiver_phone = #{receiverPhone,jdbcType=VARCHAR},\n" +
//            "      receiver_mobile = #{receiverMobile,jdbcType=VARCHAR},\n" +
//            "      receiver_state = #{receiverState,jdbcType=VARCHAR},\n" +
//            "      receiver_city = #{receiverCity,jdbcType=VARCHAR},\n" +
//            "      receiver_district = #{receiverDistrict,jdbcType=VARCHAR},\n" +
//            "      receiver_address = #{receiverAddress,jdbcType=VARCHAR},\n" +
//            "      receiver_zip = #{receiverZip,jdbcType=VARCHAR},\n" +
//            "      created = #{created,jdbcType=TIMESTAMP},\n" +
//            "      updated = #{updated,jdbcType=TIMESTAMP}\n" +
//            "    where order_id = #{orderId,jdbcType=VARCHAR}")
    int updateByPrimaryKey(OrderShipping record);

//    @ResultMap("BaseResultMap")
//    @Select("select order_id, receiver_name, receiver_phone, receiver_mobile, receiver_state, \n" +
//            "    receiver_city, receiver_district, receiver_address, receiver_zip, created, updated\n" +
//            "    from tb_order_shipping\n" +
//            "    where order_id = #{orderId,jdbcType=VARCHAR}")
    OrderShipping selectByPrimaryKey(String orderId);

//    @ResultMap("BaseResultMap")
//    @Insert("insert into tb_order_shipping (order_id, receiver_name, receiver_phone, \n" +
//            "      receiver_mobile, receiver_state, receiver_city, \n" +
//            "      receiver_district, receiver_address, receiver_zip, \n" +
//            "      created, updated)\n" +
//            "    values (#{orderId,jdbcType=VARCHAR}, #{receiverName,jdbcType=VARCHAR}, #{receiverPhone,jdbcType=VARCHAR}, \n" +
//            "      #{receiverMobile,jdbcType=VARCHAR}, #{receiverState,jdbcType=VARCHAR}, #{receiverCity,jdbcType=VARCHAR}, \n" +
//            "      #{receiverDistrict,jdbcType=VARCHAR}, #{receiverAddress,jdbcType=VARCHAR}, #{receiverZip,jdbcType=VARCHAR}, \n" +
//            "      #{created,jdbcType=TIMESTAMP}, #{updated,jdbcType=TIMESTAMP})")
    int insert(OrderShipping record);


    List<OrderShipping> searchByName(String name);


}
