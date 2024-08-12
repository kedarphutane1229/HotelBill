/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel;

import java.math.BigInteger;

/**
 *
 * @author Admin
 */
public class Customer {
    private String name;
    private int TotalBill;
    private BigInteger contactno;

    public Customer(String name,BigInteger contactno,int TotalBill) {
        this.name = name;
        this.TotalBill = TotalBill;
        this.contactno = contactno;
    }

    public String getName() {
        return name;
    }

    public int getTotalBill() {
        return TotalBill;
    }

    public BigInteger getContactno() {
        return contactno;
    }
    
    
    
    
    
    
}
