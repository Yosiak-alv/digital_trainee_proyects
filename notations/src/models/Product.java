package models;

import annotations.Init;
import annotations.JsonAtributo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Product {
    @JsonAtributo(capitalize = true)
    private String name;
    @JsonAtributo(name = "cost")
    private Long price;
    private LocalDate date;

    @Init
    private void init() {
        this.name = Arrays.stream(name.split(" "))
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .collect(Collectors.joining(" "));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
