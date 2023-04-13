package Controller;

import Model.InforSpend;
import Model.Target;
import java.util.ArrayList;

public class TargetManagement{
    ObjectsManagement newObjectsManagement = new ObjectsManagement();
    Target newTarget = new Target();

    public void truTienTrongTarget(float moneySpent){
        newTarget.setMoneySpentOfTarget(newTarget.getMoneySpentOfTarget() + moneySpent);
        newTarget.setMoneyBalanceOfTarget(newTarget.getmoneyOfTarget() - newTarget.getMoneySpentOfTarget());
    }
    
    public void editTarget(int n){
        switch (n){
            case 1: {
                System.out.println("Tên cũ la: " + newTarget.getNameTarget());
                newTarget.setNameTarget(" Đã sửa tên target");
                break;
            }
            case 2:{
                System.out.println("% cũ là: "+newTarget.getPercentOfTarget());
                newTarget.setPercentOfTarget(100);
                break;
            }
            default:{
                System.out.println("Lỗi ");
                break;
            }
        }
    }
    public float soDu(){
        return newObjectsManagement.soduconlai();
    }
    
    
    public void inputNewTarget(String name , float percent, InforSpend spen){
        newTarget.setNameTarget(name);
        newTarget.setPercentOfTarget(percent);
        newTarget.setMoneyOfTarget(spen.getMoneyOfSpend()*newTarget.getPercentOfTarget()/100);
        newTarget.setMoneyBalanceOfTarget(newTarget.getmoneyOfTarget());
    }
    
    void TargetDefault(Target newTargets, String nameTarget, float percentOfTarget, float money){
        newTargets.setNameTarget(nameTarget);
        newTargets.setPercentOfTarget(percentOfTarget);
        newTargets.setMoneyOfTarget(money*percentOfTarget/100);
    }

    public void inputTargetDefault(String nameTarget , float[] P,InforSpend spend, String a, String b, String c, String d, String e, String f){
        TargetDefault(newTarget, nameTarget, P[0], spend.getMoneyOfSpend());
        newObjectsManagement.inputObjectDefault(P, spend.getMoneyOfSpend(), a, b, c, d, e, f);
    }

    public void inputTargetDefault(String nameTarget,float[] P, InforSpend spend ,int s, String a){
        if(s==0){
            TargetDefault(newTarget, nameTarget, P[7], spend.getMoneyOfSpend());
        }else{
            TargetDefault(newTarget, nameTarget, P[12], spend.getMoneyOfSpend());
        }

        newObjectsManagement.inputObjectDefault(P, spend.getMoneyOfSpend(), s, a);
    }

    public void inputTargetDefault(String nameTarget, float[] P,InforSpend spend, String a, String b){
        TargetDefault(newTarget, nameTarget, P[9], spend.getMoneyOfSpend());
        newObjectsManagement.inputObjectDefault(P, spend.getMoneyOfSpend(), a, b);
    }

    public void outputInforTarget(ArrayList<ObjectsManagement> listOb){
        for(int i=0; i<4; i++){
            listOb.get(i).output();
        }
    }
    
    
    
    
    public void outputTarget(Target a){
        System.out.println(a.getNameTarget());
    }

    
    
    
    
    public ObjectsManagement getNewObjectsManagement() {
        return newObjectsManagement;
    }

    public Target getNewTarget() {
        return newTarget;
    }

    public void setNewObjectsManagement(ObjectsManagement newObjectsManagement) {
        this.newObjectsManagement = newObjectsManagement;
    }

    public void setNewTarget(Target newTarget) {
        this.newTarget = newTarget;
    }

    public TargetManagement() {
    }
    
    
    
    
    
    
    
}
