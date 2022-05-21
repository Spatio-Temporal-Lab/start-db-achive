package org.urbcomp.start.db.metadata.entity;

/**
 * This class is used to encapsulate the basic information of field
 *
 * @author  Wang Bohong
 * @date    2022-05-20 16:40:19
 * */
public class Field extends AbstractEntity{

    /**
     * tableId of the Field
     */
    private long tableId;

    /**
     * type
     */
    private String type;

    /**
     * 0: primary key; 1: else
     */
    private int isPrimary;


    public Field(long id,  long tableId, String name, String type,int isPrimary) {
        super(id, name);
        this.tableId = tableId;
        this.type = type;
        this.isPrimary = isPrimary;
    }

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(int isPrimary) {
        this.isPrimary = isPrimary;
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tableId=" + tableId +
                ", type='" + type + '\'' +
                ", isPrimary=" + isPrimary +
                '}';
    }

}
