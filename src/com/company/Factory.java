package com.company;

import com.company.interfaces.ITransport;
import com.company.transport.Car;
import com.company.transport.Motorcycle;

import java.util.Map;

public class Factory {
    public ITransport create(String name, Map<String, String> params) throws Exception {
        switch (name) {
            case "Car":
                return new Car.Builder(params.get("name"))
                        .setColor(params.get("color"))
                        .setType(params.get("type"))
                        .setMaxSpeed(Double.parseDouble(params.get("maxSpeed")))
                        .setMight(Double.parseDouble(params.get("might")))
                        .setWeight(Double.parseDouble(params.get("weight")))
                        .build();
            case "Motorcycle":
                return new Motorcycle.Builder(params.get("name"))
                        .setColor(params.get("color"))
                        .setType(params.get("type"))
                        .setMaxSpeed(Double.parseDouble(params.get("maxSpeed")))
                        .setMight(Double.parseDouble(params.get("might")))
                        .setWeight(Double.parseDouble(params.get("weight")))
                        .build();
            default:
                throw new Exception("Неверный тип транспорта!");
        }
    }
}