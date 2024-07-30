package poo.models;

import java.util.Objects;

public class BaseEntity {
    protected Integer id;
    private static int lastId ;

    public BaseEntity() {
        this.id = ++lastId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
       if(this == obj) return true;
       if(obj == null || getClass() != obj.getClass()) return false;
       BaseEntity that = (BaseEntity) obj;
       return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
