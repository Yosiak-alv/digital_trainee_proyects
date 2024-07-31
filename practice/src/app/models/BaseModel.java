package app.models;

public abstract class BaseModel<ID> {
    public BaseModel(){}
    public abstract ID getId();
}
