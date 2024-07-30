package poo.models;

public class Client extends BaseEntity {
    private String name;
    private String lastname;

    public Client(String name, String lastName) {
        this.name = name;
        this.lastname = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return
                "id=" + getId() + '\'' +
                "name='" + name + '\'' +
                ", lastName='" + lastname  ;
    }
}
