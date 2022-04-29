package org.urbcomp.start.db.metadata.entity;

/**
 * This class is used to encapsulate the basic information of users
 *
 * @author zaiyuan
 * @date 2022-03-27 15:17:07
 */
public class User extends AbstractEntity {

    /**
     * password
     */
    private String password;

    public User(long id, String userName, String password) {
        super(id, userName);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
