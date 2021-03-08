package com.pactera.demo.dao;

import com.pactera.demo.model.Person;
import com.util.core.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMapper extends Mapper<Person> {
    @Select("SELECT * FROM T_Person WHERE pid = #{id}")
    Person selectPerson(int id);

    Person findById(int id);
}