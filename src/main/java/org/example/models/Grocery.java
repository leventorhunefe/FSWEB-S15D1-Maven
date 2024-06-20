package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    public void startGrocery(){
        int choice;
        do {
            System.out.println("Operasyon seç: (0 = çıkış, 1 = ekleme, 2 = çıkarma)");
            System.out.println("Elemanları virgül(,) operatörü ile ayırın");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    printSorted();
                    break;

                case 2:
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    printSorted();
                    break;
            }
        }
        while (choice != 0);
        // Java'da açtığımız şeyleri kapatmazsak çalışmaya devam eder (scanner'ı bu yüzden kapattık)
        scanner.close();
    }

    // Metodlar

    public static void addItems(String itemsToAdd){
        String[] splitItems = itemsToAdd.split(",");
        for (String item : splitItems){
            item = item.trim();
            if (checkItemsInList(item)){
                System.out.println("girilen item listede mevcut: " + item);
            } else {
                groceryList.add(item);
            }
        }
        sortItems();
    }

    public static void removeItems(String itemsToRemove){
        String[] splitItems = itemsToRemove.split(",");
        for (String item : splitItems){
            item = item.trim();
            if (!checkItemsInList(item)){
                System.out.println("girilen item listede değil: " + item);
            } else {
                groceryList.remove(item);
            }
        }
        sortItems();
    }

    public static boolean checkItemsInList(String item){
        return groceryList.contains(item);
    }

    public static void printSorted(){
        sortItems();
        System.out.println("Mevcut pazar listesi: ");
        for (String item : groceryList){
            System.out.println(item);
        }
    }

    public static void sortItems(){
        Collections.sort(groceryList);
    }

}
