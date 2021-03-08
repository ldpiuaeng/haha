package com.pactera.demo.service.impl;

import com.pactera.demo.dao.PersonMapper;
import com.pactera.demo.model.Person;
import com.pactera.demo.service.PersonService;
import com.util.core.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends AbstractService<Person> implements PersonService {

    @Autowired
    PersonMapper personMapper;

    @Override
    public Person findById(Integer id) {
        return personMapper.findById(id);
    }
}
