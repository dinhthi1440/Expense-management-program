package Model;

public class Objects {
    private String nameObjects;
    //tiền được chuyển vào object
    private float money;
    //% được chuyển vào object
    private float percent;
    //số tiền bị trừ
    private float amountDeducted=0;
    //số tiền còn lại
    private float balance;

    public Objects() {
    }

    public Objects(String nameObjects, float money, float percent) {
        this.nameObjects = nameObjects;
        this.money = money;
        this.percent = percent;
    }

    public String getNameObjects() {
        return nameObjects;
    }
    
    public float getMoney() {
        return money;
    }

    public float getPercent() {
        return percent;
    }

    public float getAmountDeducted() {
        return amountDeducted;
    }

    public float getBalance() {
        return balance;
    }

    public void setNameObjects(String nameObjects) {
        this.nameObjects = nameObjects;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public void setAmountDeducted(float amountDeducted) {
        this.amountDeducted = amountDeducted;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    
}

