package poo.models;

import java.util.concurrent.ConcurrentMap;

public class ClientPremium extends Client implements Comparable<ClientPremium> {
    public ClientPremium(String name, String lastName) {
        super(name, lastName);
    }

    @Override
    public int compareTo(ClientPremium o) {
        return 0;
    }
}
