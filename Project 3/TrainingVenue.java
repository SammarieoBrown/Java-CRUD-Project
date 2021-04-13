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
 *  TrainingVenue and Extension of the Venue Class
 */
public class TrainingVenue extends Venue {
    private double instructorArea;
    private double otherArea;


    /**
     * TrainingVenue Constructor
     * @param name accepts the name of the event
     * @param instructorArea accepts the number of instructorArea
     * @param otherArea accepts the number of otherArea
     * @param basePrice accepts the number of basePrice
     * @param lev accepts the event  level
     */
    public TrainingVenue(String name, double instructorArea, double otherArea,
                         double basePrice,int lev)
    {
        super(name, instructorArea +otherArea, basePrice,  lev);
        this.instructorArea = 	instructorArea;
        this.otherArea = otherArea;

    }



    /**
     * This method returns the area available to instructors
     * @return instructorArea returns the area available to instructors
     */
    public double getInstructorArea()
    {
        return instructorArea;
    }

    /**
     * This method returns the area available to other clients
     * @return otherArea returns the area available to other clients
     */
    public double getOtherArea()
    {
        return otherArea;

    }
    /**
     * Instructor Area Method
     * @param instructorArea initialize the instructorArea
     */
    public void setInstructorArea(double instructorArea){

        this.instructorArea =instructorArea;
    }

    /**
     *  OtherArea Method
     * @param otherArea initialize the otherArea
     */
    public void setOtherArea(double otherArea){

        this.otherArea =otherArea;
    }




}


