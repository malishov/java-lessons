package model;

import java.util.*;

public class Store {

    private int id;

    private String name;

    private double amount;

    private double percent;

    private Map<String, Double> clients;

    public Store(int id, String name, double percent, double amount) {
        this.id = id;
        this.name = name;
        this.percent = percent;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {

        this.amount = amount;
    }

    public Map<String, Double> getClients() {
        return clients;
    }

    public void setClients(Map<String, Double> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", percent=" + percent +
                ", clients=" + clients +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return id == store.id && Double.compare(store.percent, percent) == 0 && Objects.equals(name, store.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, percent);
    }
}
