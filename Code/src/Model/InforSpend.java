package Model;

public class InforSpend {
    private float moneyOfSpend;
    private int dayForSpend;
    private float moneyOfBalance;
    private float moneyOfSpent=0;

    public float getMoneyOfSpend() {
        return moneyOfSpend;
    }

    public int getDayForSpend() {
        return dayForSpend;
    }

    public float getMoneyOfBalance() {
        return moneyOfBalance;
    }

    public float getMoneyOfSpent() {
        return moneyOfSpent;
    }

    public void setMoneyOfSpent(float moneyOfSpent) {
        this.moneyOfSpent = moneyOfSpent;
    }

    
    public void setMoneyOfBalance(float moneyOfBalance) {
        this.moneyOfBalance = moneyOfBalance;
    }
    
    public void setMoneyOfSpend(float moneyOfSpend) {
        this.moneyOfSpend = moneyOfSpend;
    }

    public void setDayForSpend(int dayForSpend) {
        this.dayForSpend = dayForSpend;
    }

    public InforSpend() {
    }

    public InforSpend(float moneyOfSpend, int dayForSpend) {
        this.moneyOfSpend = moneyOfSpend;
        this.dayForSpend = dayForSpend;
    }
    
    
}
