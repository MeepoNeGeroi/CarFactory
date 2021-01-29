package com.company;

import com.company.interfaces.ITransport;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<ITransport> purchases = new ArrayList<ITransport>();
    private double price;

    public void getBasket(){
        System.out.println("Basket:");

        for (int i = 0; i < purchases.size(); i++) {
            System.out.println(purchases.get(i) + "||| " + purchases.get(i).getPrice());
        }

        System.out.println("Price is: " + price);
    }

    public void addPurchase(ITransport tr){
        purchases.add(tr);
        price += tr.getPrice();
    }

    public void deletePurchase(int index){
        try{
            purchases.remove(index);
        }
        catch (Exception e){
            System.out.println("Неправильный индекс.");
        }
    }
}
