package app.models;

import app.models.enums.ClientType;

import java.util.Objects;

public class Client extends BaseModel<Integer> {
    private Integer id;
    private String name;
    private ClientType type;

    private static int countId = 0;

    public Client(String name, ClientType type) {
        this.id = ++countId;
        this.name = name;
        this.type = type;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static int getCountId() {
        return countId;
    }

    public static void setCountId(int countId) {
        Client.countId = countId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return  "id=" + id + '\'' +
                ", name=" + name + '\'' +
                ", type=" + type ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
