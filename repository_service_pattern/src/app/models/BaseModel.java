package app.models;

import java.util.Objects;
import java.util.UUID;

public class BaseModel {
    protected Integer id;
    private static Integer idCounter = 0;

    public BaseModel() {
        this.id = ++idCounter;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BaseModel baseModel = (BaseModel) obj;
        return Objects.equals(id, baseModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
