package com.pactera.demo.service;

import com.pactera.demo.model.Person;
import com.util.core.Service;


public interface PersonService extends Service<Person> {

    Person findById(Integer id);

}
