/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 * SportsVenue Class
 */
public class SportsVenue extends  Venue {
    private double competitorArea;
    private double spectatorArea;
    private int numSecurity;


    public SportsVenue(String name, double competitorArea, double spectatorArea,
                       int numSecurity, double basePrice, int lev)
    {
        super(name, competitorArea +spectatorArea, basePrice,  lev);
        this.competitorArea = 	competitorArea;
        this.spectatorArea = spectatorArea;
        this.numSecurity=numSecurity;

    }

    public double getSize()
    {
        return competitorArea+ spectatorArea;
    }

    public int countSecurity()
    {
        return numSecurity;
    }

    public double getCompArea()
    {
        return competitorArea;
    }

    public double getSpecArea()
    {
        return spectatorArea;

    }

    public int getNumSecurity()
    {
        return numSecurity;
    }


    public void setCompArea(double competitorArea)
    {

        this.competitorArea =competitorArea;
    }

    public void setSpecArea(double spectatorArea)
    {

        this.spectatorArea =spectatorArea;
    }



    public void setNumSecurity(int numSecurity)
    {

        this.numSecurity =numSecurity;
    }



}


