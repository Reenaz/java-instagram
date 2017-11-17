package ru.kfu.itis.entity;

import java.sql.Date;

/**
 * Created by Reenaz on 13.11.2017.
 */
public class Subscriber {
    private int subscriberId;
    private int personId;
    private Date date;

    public Subscriber() {
    }

    public Subscriber(int subscriberId, int personId, Date date) {
        this.subscriberId = subscriberId;
        this.personId = personId;
        this.date = date;
    }

    public int getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(int subscriberId) {
        this.subscriberId = subscriberId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
