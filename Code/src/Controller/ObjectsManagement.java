
package Controller;

import Model.InforSpend;
import Model.Objects;
import java.util.ArrayList;
import java.util.Scanner;

public class ObjectsManagement extends Objects{
    Scanner sc = new Scanner(System.in);
    ArrayList<Objects> listObject = new ArrayList<>();
    
    
    void newObject(String a, float percent, float moneyOfTarget){
        Objects newO = new Objects();
        newO.setNameObjects(a);
        newO.setPercent(percent);
        newO.setMoney(percent*moneyOfTarget/100);
        newO.setBalance(newO.getMoney());
        listObject.add(newO);
    }
    
    
    
    public void addNewObjectToTarget(String a, float percent, float moneyOfTarget){
        Objects newO = new Objects();
        newO.setNameObjects(a);
        newO.setPercent(percent);
        newO.setMoney(percent*moneyOfTarget/100);
        newO.setBalance(newO.getMoney());
        listObject.add(newO);
    }
    
    
    public void inputObjectDefault(float[] P, float moneyOfTarget, String a, String b, String c, String d, String e, String f){
            newObject(a, P[1], moneyOfTarget);
            newObject(b, P[2], moneyOfTarget);
            newObject(c, P[3], moneyOfTarget);
            newObject(d, P[4], moneyOfTarget);
            newObject(e, P[5], moneyOfTarget);
            newObject(f, P[6], moneyOfTarget);
    }
    
    
    
    public void inputObjectDefault(float[] P, float moneyOfTarget,int s, String a){
            if(s==0){
                newObject(a, P[8], moneyOfTarget);
            }else{
                newObject(a, P[13], moneyOfTarget);
            }
    }
    
    
    
    public void inputObjectDefault(float[] P, float moneyOfTarget, String a, String b){
            newObject(a, P[10], moneyOfTarget);
            newObject(b, P[11], moneyOfTarget);
        
    }
    
    
    
    
    public void output(){
        for(Objects i : listObject){
            System.out.printf("       + %s (%.2f%%) :   %.4fđ\n", i.getNameObjects(), i.getPercent(), i.getMoney());
        }
    }

    public float soduconlai(){
        float tong=0;
        for(Objects i : listObject){
            tong += i.getBalance();
        }
        return tong;
    }
    
    public void outputAfterSpent(){
        System.out.printf("        %-25s %-25s %-25s %-25s %-25s \n", "Loại chi tiêu", "Số dư ban đầu(đ)", "Phần trăm",  "Còn lại(đ)", "Đã tiêu");
        for(Objects i : listObject){
            System.out.printf("        %-25s %-25.4f %-25.2f %-25.2f %-25.2f \n", i.getNameObjects(), i.getMoney(), i.getPercent(), i.getBalance(), i.getAmountDeducted());
        }
    }

    public void truTienTrongObject(int i, float moneySpent){
        listObject.get(i).setBalance(listObject.get(i).getMoney() - moneySpent);
        listObject.get(i).setAmountDeducted(listObject.get(i).getAmountDeducted() + moneySpent);
    }
    
    public void editObject(int i, int n){
        switch (n){
            case 1:{
                System.out.println("Tên cũ là: " + listObject.get(i).getNameObjects());
                listObject.get(i).setNameObjects(" đã sửa");
                break;
            }
            case 2:{
                System.out.println("Số % cũ là: " +listObject.get(i).getPercent() );
                listObject.get(i).setPercent(100);
                break;
            }
            default:{
                System.out.println("Không có ");
                break;
            }
        }
    }


    
    public ArrayList<Objects> getListObject() {
        return listObject;
    }

    
}
