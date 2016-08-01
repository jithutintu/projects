package com.niit.shoppingcart;

public class Testsupplier {
public static void main(String args[])
{
Product p1=new Product(101,"iphone",65_000);
Supplier s1=new Supplier(p1,"sup001","jithu","bombay");


System.out.println("the details are");
System.out.println(s1.getId());
System.out.println(s1.getName());
System.out.println(s1.getAddress());
System.out.println(s1.getProduct());
System.out.println(s1.getId());
System.out.println(s1.getId());
}
}