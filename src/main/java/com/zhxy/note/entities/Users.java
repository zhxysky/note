package com.zhxy.note.entities;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by zhxy on 2016/8/31.
 */

@Entity
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(nullable = false)
    public String name;

    //JPA需要的无参构造方法。 protected保证不能被外界直接使用
    protected Users() {}

    public Users(String name) {
        this.name = name;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

