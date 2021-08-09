package entity;

import base.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {
    @Column
    private String name;
    @Column
    private String lName;
    @Column
    private String username;
    @Column
    private String password;

    public User() {

    }

    public User(String name, String lName, String username, String password) {
        this.name = name;
        this.lName = lName;
        this.username = username;
        this.password = password;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
