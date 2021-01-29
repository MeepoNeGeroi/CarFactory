package com.company.transport;

import com.company.interfaces.ITransport;

public class Motorcycle implements ITransport {
    protected String name;
    protected double maxSpeed;
    protected String color;
    protected String type;
    protected double weight;
    protected double might;
    protected double price;

    public String getName() {
        return name;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public double getMight() {
        return might;
    }

    private Motorcycle(Builder builder){
        this.name = builder.name;
        this.maxSpeed = builder.maxSpeed;
        this.color = builder.color;
        this.type = builder.type;
        this.weight = builder.weight;
        this.might = builder.might;
        this.price = builder.price;
    }

    @Override
    public void drive() {

    }

    @Override
    public double getPrice() {
        return price;
    }

    public static class Builder{
        protected String name;
        protected double maxSpeed;
        protected String color;
        protected String type;
        protected double weight;
        protected double might;
        protected double price = 100;

        public Builder(String name){
            this.name = name;
        }

        public double getWeight() {
            return weight;
        }

        public Builder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public double getMight() {
            return might;
        }

        public Builder setMight(double might) {
            this.might = might;
            return this;
        }

        public String getName() {
            return name;
        }

        public double getMaxSpeed() {
            return maxSpeed;
        }

        public Builder setMaxSpeed(double maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public String getColor() {
            return color;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public String getType() {
            return type;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Motorcycle build(){
            price += might/2;
            return new Motorcycle(this);
        }
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", might=" + might +
                '}';
    }
}
