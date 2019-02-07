package com.company.week1;
import java.util.*;
import java.math.*;
//Matthew Massey, 2/5/2019
//Exercise 4, CSCI-1660
//User inputs city names, then avg temp for next 5 days for each, and then program calculates the 5-day avg for each city

public class Main {
    static Scanner input = new Scanner(System.in);
    static Map<String, Double> citiesTemp = new HashMap<>();

    public static void main(String[] args) {
        promptInput();
        displayResults();
    }

    static void promptInput() {
        String cityName;
        while (true) {
            System.out.println("Name of city? (Type 'end' to exit)");
            cityName = input.nextLine();
            if (cityName.equalsIgnoreCase("end")) {
                break;
            }
            double average = calculateAvg();
            citiesTemp.put(cityName, Math.floor(average));
        }
    }

    static double calculateAvg() {
        double singleTemp;
        double avgTemp = 0;
        for (int i = 0; i<5; i++) {
            System.out.println("Temperature for day " + (i+1) + "?");
            singleTemp = Double.parseDouble(input.nextLine());
            avgTemp += singleTemp;
        }
        avgTemp /= 5;
        return avgTemp;
    }

    static void displayResults() {
        System.out.println("The average temperatures for the next " + 5 + " days: ");
        System.out.println(citiesTemp);
    }
}
