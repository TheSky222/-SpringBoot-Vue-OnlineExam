package com.exam.mapper;

import com.exam.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("select adminName,sex,tel,email,cardId,role from admin")
    public List<Admin> findAll();

    @Select("select adminName,sex,tel,email,cardId,role from admin where adminId = #{adminId}")
    public Admin findById(Integer adminId);

    @Delete("delete from admin where adminId = #{adminId}")
    public int deleteById(int adminId);

    @Update("update admin set adminName = #{adminName},sex = #{sex}," +
            "tel = #{tel}, email = #{email},pwd = #{pwd},cardId = #{cardId},role = #{role} where adminId = #{adminId}")
    public int update(Admin admin);

    @Options(useGeneratedKeys = true,keyProperty = "adminId")  // useGeneratedKeys =true 这个表示插入数据之后返回一个自增的主键id给你对应实体类中的主键属性。 keyproperty=主键，这样就可以解决在主键自增的情况下获取主键。
    @Insert("insert into admin(adminName,sex,tel,email,pwd,cardId,role) " +
            "values(#{adminName},#{sex},#{tel},#{email},#{pwd},#{cardId},#{role})")
    public int add(Admin admin);
}
