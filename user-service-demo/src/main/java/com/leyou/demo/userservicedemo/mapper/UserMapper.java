package com.leyou.demo.userservicedemo.mapper;

import com.leyou.demo.userservicedemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName:UserMapper
 * @Description:
 * @author:chenyun
 * @Date:2019/11/27 16:09
 */
@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {
}
