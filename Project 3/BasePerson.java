/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author user
 */
import java.io.*;

public abstract class BasePerson implements Serializable{
    public BasePerson(){}

    protected String name;
    private int id;
    private double budget;
    private boolean publish;
    private int age;



    public BasePerson(String name, int age, boolean pub, double budget) {
        this.name =name;
        this.budget = budget;
        publish = pub;
        this.age = age;

    }

    public abstract String getName();

    protected void setId(int id) { this.id = id; }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getAge()
    {
        return age;
    }
    public int getId() { return id; }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
    public boolean getPublish(){return publish;}
}

