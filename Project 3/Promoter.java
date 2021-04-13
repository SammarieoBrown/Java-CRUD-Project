/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */


import java.io.Serializable;

public class Promoter extends BasePerson implements Serializable,Comparable<Promoter>
{

    private static int nextId=0;


    public Promoter(String name, int age, boolean willPublish,double budget)
    {
        super(name, age, willPublish,budget);
        super.setId(nextId);
        nextId++;
    }

    @Override
    public double getBudget() {
        return super.getBudget();
    }

    public String getName()
    {
        return name;
    }

    public static String getPHeader()
    {
        String returnval = "ID\tName\tAge\tWillPublish\tBudget";
        returnval+="\n---------------------------------";
        return returnval;

    }

    public String toString()
    {
        return(getId()+"\t"+getName()+"\t"+getAge()+"\t"+getPublish()+"\t"+getBudget());
    }


    public static void resetId()
    {
        nextId=0;
    }

    public int compareTo(Promoter other)
    {
        return other.getId() - this.getId();
    }

}
