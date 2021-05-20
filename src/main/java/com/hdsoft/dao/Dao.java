package com.hdsoft.dao;

import com.hdsoft.model.Event;
import com.hdsoft.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Dao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public boolean saveEvent(Event e){
        return hibernateTemplate.save(e)!=null;
    }

    @Transactional
    public boolean saveUser(User e){
        return hibernateTemplate.save(e)!=null;
    }

    @Transactional
    public List<Event> listEvents(){
        return hibernateTemplate.loadAll(Event.class);
    }

    @Transactional
    public List<User> listUser(){
        return hibernateTemplate.loadAll(User.class);
    }
}
