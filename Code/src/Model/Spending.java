package Model;

import java.util.Date;

public class Spending {
    private int typeOfSpentOnTarget;
    private int typeOfSpentObject;
    private String describe;
    private float amountSpent;
    private Date date;

    public String getDescribe() {
        return describe;
    }

    public float getAmountSpent() {
        return amountSpent;
    }

    public int getTypeOfSpentOnTarget() {
        return typeOfSpentOnTarget;
    }

    public int getTypeOfSpentObject() {
        return typeOfSpentObject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setTypeOfSpentOnTarget(int typeOfSpentOnTarget) {
        this.typeOfSpentOnTarget = typeOfSpentOnTarget;
    }

    public void setTypeOfSpentObject(int typeOfSpentObject) {
        this.typeOfSpentObject = typeOfSpentObject;
    }
   
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setAmountSpent(float amountSpent) {
        this.amountSpent = amountSpent;
    }

    public Spending() {
        
    }

    public Spending(int typeOfSpentOnTarget, int typeOfSpentObject, String describe, float amountSpent) {
        this.typeOfSpentOnTarget = typeOfSpentOnTarget;
        this.typeOfSpentObject = typeOfSpentObject;
        this.describe = describe;
        this.amountSpent = amountSpent;
    }

    

    
    
    
}
