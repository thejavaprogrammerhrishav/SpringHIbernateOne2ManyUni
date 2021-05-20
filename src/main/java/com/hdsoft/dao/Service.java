package com.hdsoft.dao;

import com.hdsoft.model.Event;
import com.hdsoft.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Service {
    @Autowired
    private Dao dao;

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public boolean saveEvent(Event e){
        return dao.saveEvent(e);
    }

    public boolean saveUser(User e){
        return dao.saveUser(e);
    }

    public List<Event> listEvents(){
        return dao.listEvents();
    }

    public List<User> listUser(){
        return dao.listUser();
    }
}
