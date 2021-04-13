/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */


import java.util.Scanner;

/**
 * PartyVenue Class
 */
public class PartyVenue extends Venue{
    double stageArea;
    double barArea, foodArea;
    int numSecurity;

    /**
     * PartyVenue Constructor
     * @param name accepts name of event
     * @param stageArea accepts stage area
     * @param barArea accepts bar area
     * @param foodArea accepts food area
     * @param numSecurity accepts number of security
     * @param basePrice accepts base price
     * @param lev accepts level of event
     */
    public PartyVenue(String name, double stageArea,double barArea,
                      double foodArea,int numSecurity, double basePrice,
                      int lev)
    {
        super( name, stageArea+barArea+foodArea, basePrice, lev);
        this.numSecurity=numSecurity;
        this.stageArea = 	stageArea;
        this.barArea = barArea;
        this.foodArea = foodArea;



    }

    /**
     * getEstimate cost of event
     * @param type type of events
     * @return the estimate cost to host the event
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
     * return stageArea information
     * @return stageArea
     */
    public double getCurrStage()
    {
        return stageArea;
    }

    /**
     * returns bar area information
     * @return size of bar area
     */
    public double getBarArea()
    {
        return barArea;
    }

    /**
     * returns food area info
     * @return size of food area
     */
    public double getFoodArea()
    {
        return foodArea;
    }

    /**
     * returns the number of security
     * @return number of of security
     */
    public int getNumSecurity()
    {
        return numSecurity;
    }

    /**
     * initializes the stageArea
     * @param stageArea initial stage area
     */
    public void setStageArea(double stageArea)
    {

        this.stageArea =stageArea;
    }

    /**
     * initializes the foodArea
     * @param foodArea initialization of food area
     */
    public void setFoodArea(double foodArea)
    {

        this.foodArea =foodArea;
    }

    /**
     * initializes the bar area
     * @param barArea initialization of bar area
     */
    public void setBarArea(double barArea)
    {

        this.barArea =barArea;
    }

    /**
     * initializes the number of security
     * @param numSecurity initialization of number of security
     */
    public void setNumSecurity(int numSecurity)
    {

        this.numSecurity =numSecurity;
    }


}

