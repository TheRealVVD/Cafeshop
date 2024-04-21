package com.example.cafeshop.domain.order;

public enum Status {

    IN_PROCESSING("Заказ в обработке"),
    ACCEPTED("Заказ принят"),
    COOKING("Заказ готовится"),
    ON_THE_WAY("Заказ в пути"),
    DELIVERED("Заказ доставлен");

    private String translation;

    Status(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }


}
