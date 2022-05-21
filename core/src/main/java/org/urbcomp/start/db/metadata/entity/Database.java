package org.urbcomp.start.db.metadata.entity;

/**
 * This class is used to encapsulate the basic information of databases
 *
 * @author wangbohong
 * @date 2022-05-20 16:21:07
 */
public class Database extends AbstractEntity{

    /**
     * creatorId of the DataBase
     */
    private long userId;

    public Database (Long id, Long userId, String name) {
        super(id, name);
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Database{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }
}