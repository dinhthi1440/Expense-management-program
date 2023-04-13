package Model;

public class Target {
    private String nameTarget;
    private float percentOfTarget;
    private float moneyOfTarget;
    private float moneySpentOfTarget;
    private float moneyBalanceOfTarget;

    public float getPercentOfTarget() {
        return percentOfTarget;
    }
    

    public String getNameTarget() {
        return nameTarget;
    }

    public float getmoneyOfTarget() {
        return moneyOfTarget;
    }


    public float getMoneySpentOfTarget() {
        return moneySpentOfTarget;
    }

    public float getMoneyBalanceOfTarget() {
        return moneyBalanceOfTarget;
    }
    

    public void setMoneyOfTarget(float moneyOfTarget) {
        this.moneyOfTarget = moneyOfTarget;
    }
    

    public void setNameTarget(String nameTarget) {
        this.nameTarget = nameTarget;
    }

    public void setPercentOfTarget(float percentOfTarget) {
        this.percentOfTarget = percentOfTarget;
    }

    public void setMoneySpentOfTarget(float moneySpentOfTarget) {
        this.moneySpentOfTarget = moneySpentOfTarget;
    }

    public void setMoneyBalanceOfTarget(float moneyBalanceOfTarget) {
        this.moneyBalanceOfTarget = moneyBalanceOfTarget;
    }
    
    
    public Target() {
    }

    public Target(String nameTarget, float percentOfTarget, float moneyOfTarget) {
        this.nameTarget = nameTarget;
        this.percentOfTarget = percentOfTarget;
        this.moneyOfTarget = moneyOfTarget;
        
    }
    
    
}
