package ru.itmo.task1.model;

public final class CustomerRequest {

    private final long id;
    private final Integer age;
    private final String gender;
    private final Purchase[] purchases;
    private Integer points;

    public CustomerRequest(long id, Integer age, String gender, Purchase[] purchases) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.purchases = purchases;
    }

    public long getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Purchase[] getPurchases() {
        return purchases;
    }

    public Double getPurchasesAmount() {
        Double amount = 0d;
        for (Purchase purchase: purchases) {
            amount += purchase.price;
        }
        return amount;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
