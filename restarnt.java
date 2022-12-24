package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Table{
        int number;
        boolean done = false; // флажок занят ли столик
        String orders = "";
        int sumOrders = 0;
    }
    static class Dishes{
        int position;
        String name;
        int cost;
    }
    static class Menu{
        ArrayList<Dishes> lsMenu = new ArrayList<>(); // список, где хранятся блюда

        int indx = 1; // номер для новой задачи

        void add() {
            Scanner in = new Scanner(System.in);
            Dishes tmp = new Dishes();
            tmp.position = indx;
            indx = indx + 1;
            //System.out.println("Блюдо");
            tmp.name = in.nextLine();
            //System.out.println("Цена");
            tmp.cost = Integer.valueOf(in.nextLine());
            lsMenu.add(tmp);


        }

    }
  /*  static String getOrder() {
        Scanner in = new Scanner(System.in);
        String or =" ";

        while (!or.equals("конец")) {
            System.out.println("Вводите позиции меню ");
            or = in.nextLine();
            for (int i = 0; i < lsMenu.size(); i++)
                try {


                } catch (NumberFormatException e) {
                    System.err.println("Неправильный формат строки!");
                }
        }

        return or;
    }*/
    static class Schedule {
        ArrayList<Table> lsTable = new ArrayList<>(); // список, где хранятся столы

        int indx = 1; // номер для новой задачи

        void add() {
            Table tmp = new Table();
            tmp.number = indx;
            indx = indx + 1;
            lsTable.add(tmp);

        }



        void menu(){

        }

        void tableDone() {
            int i = 0;
            Scanner in = new Scanner(System.in);
            while ((i <= 0) || (i >= indx)) {
                System.out.println("Номер столика для расчета");
                String st = in.nextLine();
                try {
                    i = Integer.valueOf(st);
                } catch (NumberFormatException e) {
                    System.err.println("Неправильный формат номер!");
                }
            }
            for (int j = 0; j < lsTable.size(); j++) {
                if (lsTable.get(j).number == i) {
                    lsTable.get(j).done = true;

                    return;
                }
            }

            System.out.println("такого столика нет");
        }
        void show(){
            for (int j = 0; j < lsTable.size(); j++){
                System.out.println(lsTable.get(j).number);
            }
        }
    }
    public static void main(String[] args) {
        Schedule sch = new Schedule();
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 10; i++)
            sch.add();
        sch.show();


    }
}