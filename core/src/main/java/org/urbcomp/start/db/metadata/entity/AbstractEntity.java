package org.urbcomp.start.db.metadata.entity;

/**
 * Abstract class for entities: user, db, table. etc
 *
 * @author zaiyuan
 * @date 2022-05-01 15:17:07
 */
public abstract class AbstractEntity {

    /**
     * user id
     */
    protected long id;

    /**
     * name
     */
    protected String name;

    public AbstractEntity() {
    }

    public AbstractEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IEntity{" +
                "id=" + id +
                ", userName='" + name + '\'' +
                '}';
    }
}
