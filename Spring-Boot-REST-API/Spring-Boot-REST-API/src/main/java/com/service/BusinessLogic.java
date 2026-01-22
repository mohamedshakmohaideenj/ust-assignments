package com.service;

import org.springframework.stereotype.Service;

@Service
public class BusinessLogic {
    //welcome
    public String getWelcomeMessage() {
        return "Welcome to the Spring Boot REST API!";
    }
    //add
    public String add(int a, int b,int c) {
        int sum = a + b + c;
        return "The sum of " + a + " + "+ b + " and " + c  + " is: " + sum;
    }

    //evenodd
    public String getEvenOdd(int a){
        if(a%2==0){
            return "Even";
        }
        return "odd";
    }
    //age
    public String getAgg(int age){
        if(age == 0 || age < 0){
            return "Age must be greater than 0";
        }
        else if (age < 18) {
            return "Child";
        }
        else if (age <=59) {
            return "Adult";
        }
        return "Senior";
    }
    //grade
    public String getGrade(int grade){
        if(grade >= 'a' && grade <= 'z'){
            return "grade must be a numeric";
        }
        else if (grade >= 90) {
            return  "A";
        }
        else if (grade >= 75) {
            return  "B";
        }
        else if (grade >= 65) {
            return  "C";
        }
        return "FAIL";
    }
    //celsius-to-fahrenheit
    public String celsiusToFahrenheit(double celsius) {
        double fahrenheit = (celsius * 9/5) + 32;
        return celsius + "C is equal to " + fahrenheit + "F";
    }
    //max
    public String max(int a, int b,int c) {
        int max;
        if(a>b && a>c){
            max = a;
        }
        else if(b>a && b>c){
            max = b;
        }
        else{
            max = c;
        }
        return "max of 3 numbers: "+ max;
    }
    //Reverse a given string.
    public String reverse(String a) {
        return new StringBuilder(a).reverse().toString();
    }
    //palindrome
    public String palindrome(String a){
        String b = a;
        String c = new StringBuilder(a).reverse().toString();
        if(b.equals(c)){
            return "Palindrome";
        }
        return "Not a Palindrom";
    }
    //factorial
    public long factorial(int a){
        long fact =  1;
        for (int i = 1; i <= a; i++) {
            fact *= i;
        }
        return fact;
    }
    //prime
    public String prime(long a){
        if (a <= 1) return "Not a Prime Number";
        for(int i = 2;i <= Math.sqrt(a);i++){
            if(a%i==0){
                return "Not a Prime Number";
            }
        }
        return "Prime Number";
    }

    //discount
    public long discount(double price, double discount) {
        double discountAmount = (price * discount / 100);
        return Math.round(price - discountAmount);
    }
    //login
    public String login(String username, String password){
        String validUsername = "admin";
        String validPassword = "password123";

        if(username.equals(validUsername) && password.equals(validPassword)){
            return "Login Successful";
        }
        return "Invalid Credentials";
    }
    //sip
    public int sip(int p, int r, int t){
        return (p * r * t) /100;
    }
    //word count
    public int word(String word) {
        return word.trim().split("\\s+").length;
    }
}
