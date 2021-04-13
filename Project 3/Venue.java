/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */


import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Venue Class
 */
public class Venue implements Serializable, Comparable<Venue> {
    /**
     *  venue name
     */
    private String name;
    /**
     * venue size
     */
    private double size;
    /**
     * venue base price
     */
    protected double basePrice;
    private int level; // 1,2,3 for low,medium, high repectively;
    private int id;
    private static int nextId=0;
    /**
     * venue prep
     */
    protected double partyPrep=2000,  trainPrep=500, sportsPrep = 1000;

    /**
     * Venue default constructor
     */
    public Venue()
    {}

    /**
     * Venue Constructor
     * @param name accepts name
     * @param size accepts size
     * @param basePrice accepts basePrice
     * @param lev accepts lev
     */
    public Venue( String name, double size, double basePrice, int lev)
    {
        this.name = name;
        this.size = size;
        this.basePrice=basePrice;
        this.level = lev;

        id =nextId;
        nextId++;


    }

    /**
     * resetId
     */
    public static void resetId()
    {

        nextId=0;
    }

    //////


    public int compareTo(Venue other)
    {
        return this.getName().compareTo(other.getName());
    }

    /**
     *  This method returns the size of the event
     * @return size of the event
     */
    public double getSize()
    {
        return size;

    }

    /**
     * This is a method to initialize persons name
     * @return name of person
     */
    public String getName()
    {
        return name;
    }
    /**
     * This is a method to initialize the base price
     * @return the base price
     */
    public double getPrice()
    {
        return basePrice;

    }

    /**
     *
     * @return level of event
     */
    public int getLevel()
    {
        return level;
    }


    /**
     * This method sets the name of the person
     * @param name set the name of the person
     */

    public void setName(String name)
    {

        this.name =name;
    }

    /**
     *  This method sets the base price of the event
     * @param basePrice returns the base price of the event
     */
    public void setPrice(double basePrice)
    {

        this.basePrice =basePrice;
    }

    /**
     * This method sets the the size of the event
     * @param size the size of the event
     */
    public void setSize(double size)
    {

        this.size =size;
    }

    /**
     * THis method sets the level of the event
     * @param level set the level of the event
     */
    public void setLevel(int level)
    {

        this.level =level;
    }

    /**
     *  THis method returns the price of an event
     * @param type type of events
     * @return price of the event
     */
    public double getEstimate(String type)
    {
        double price = basePrice;
        if (type.equals("PARTY"))
            price += partyPrep;
        if (type.equals("SPORT"))
            price += sportsPrep;
        if (type.equals("TRAINING"))
            price += trainPrep;


        //System.out.println(this.getName()+":estimate  to hold a "+type +" is "+ price);
        return price;

    }

    /**
     * This method returns the ID
     * @return id
     */
    public int getId(){
        return id;}



}
