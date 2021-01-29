package com.company;

import com.company.enums.Colors;
import com.company.enums.Marks;
import com.company.enums.Types;
import com.company.interfaces.ITransport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Command {
    public static final String PATH = "/Users/zaher/Desktop/1.txt";
    public static final String DEFAULT_TRANSPORT = "Car";
    public static final String DEFAULT_COLOR = "White";
    public static final double DEFAULT_MAX_SPEED = 100;
    public static final double DEFAULT_WEIGHT = 100;
    public static final double DEFAULT_MIGHT = 50;
    public static final String DEFAULT_TYPE = "Coupe";
    private boolean isSignIn = false;
    private boolean isEmpty = true;
    private ArrayList<String[]> users = new ArrayList<>();
    Basket basket = new Basket();

    private void enter() throws IOException {
        putUsers();
        System.out.println("1. Зарегистрироваться.\n2. Авторизоваться.");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        if(answer.equals("1")){
            reg();
        }
        else if(answer.equals("2")){
            Authentication();
        }
    }

    private void get() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", " ");
        params.put("color", DEFAULT_COLOR + "");
        params.put("maxSpeed", DEFAULT_MAX_SPEED + "");
        params.put("type", DEFAULT_TYPE);
        params.put("weight", DEFAULT_WEIGHT + "");
        params.put("might", DEFAULT_MIGHT + "");

        Scanner sc = new Scanner(System.in);

        if(isSignIn) {
            ITransport tr;
            Factory factory = new Factory();
            System.out.println("Выбирите тип транспорта:");
            String transport = sc.nextLine();
            System.out.println("Введите марку:");
            String mark = sc.nextLine();
            mark = Marks.get(mark);

            System.out.println("Введите модель:");
            String model = sc.nextLine();
            params.replace("name", mark + " " + model);
            System.out.println("Хотите ли вы кастомизировать ?\n1.Yes\n2.No");
            String answer = sc.nextLine();
            if (answer.equals("2")) {
                tr = factory.create(transport, params);
            } else if (answer.equals("1")) {
                System.out.println("Введите цвет:");
                String color = sc.nextLine();
                color = Colors.get(color.toUpperCase());
                params.replace("color", color.toString());

                System.out.println("Введите тип:");
                String type = sc.nextLine();
                type = Types.get(type.toUpperCase());
                params.replace("type", type);

                System.out.println("Введите максимальную скорость:");
                String maxSpeed = "" + sc.nextDouble();
                params.replace("maxSpeed", maxSpeed);

                System.out.println("Введите вес:");
                String weight = "" + sc.nextDouble();
                params.replace("weight", weight);

                System.out.println("Введите мощность:");
                String might = "" + sc.nextDouble();
                params.replace("might", might);

                tr = factory.create(transport, params);
            } else {
                System.out.println("Incorrect input.");
                tr = factory.create(transport, params);
            }
            basket.addPurchase(tr);
            System.out.println(tr);
        }
        else{
            System.out.println("Вход не был выполнен!");
        }
    }

    private void putUsers() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(PATH));
        ArrayList<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        for(int i = 0; i < lines.size(); i += 2){
            users.add(new String[]{lines.get(i), lines.get(i+1)});
        }
    }

    private void reg() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите новый логин:");
        String login = sc.nextLine();
        for(int i = 0; i < users.size(); i++){
            if(users.get(i)[0].equals(login)){
                System.out.println("логин занят.");
                isEmpty = false;
                break;
            }
        }

        if(isEmpty){
            System.out.println("Введите новый пароль:");
            String password = sc.nextLine();

            File file = new File(PATH);
            FileWriter writer = new FileWriter(file, true);
            writer.write("\n" + login + "\n" + password);
            writer.flush();
            writer.close();

            isSignIn = true;
        }
    }

    private void Authentication() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите логин:");
        String login = sc.nextLine();
        System.out.println("Введите пароль:");
        String password = sc.nextLine();

        for(int i = 0; i < users.size(); i++){
            if(login.equals(users.get(i)[0]) && password.equals(users.get(i)[1])){
                System.out.println("Вход прошел успешно.");
                isSignIn = true;
                break;
            }
        }
    }

    public void dialog() throws Exception {
        Scanner sc = new Scanner(System.in);
        enter();
        get();

        while(isSignIn){
            System.out.println("1 Продолжить\n2 Показать корзину\n3 Удалить из корзины\n4 Выйти");
            String answer = sc.nextLine();
            if (answer.equals("1")){
                get();
            }
            else if(answer.equals("2")){
                basket.getBasket();
            }
            else if(answer.equals("3")){
                System.out.println("Введите индекс операции:");
                int index = sc.nextInt();
                basket.deletePurchase(index);
                basket.getBasket();
            }
            else if(answer.equals("4")){
                System.out.println("До новых встреч!");
                break;
            }
            else{
                System.out.println("Выбрана неверная оперпция.");
            }
        }
    }


}