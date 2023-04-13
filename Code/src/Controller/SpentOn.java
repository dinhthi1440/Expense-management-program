package Controller;

import static Controller.AccountManagement.date;
import Model.Account;
import Model.InforSpend;
import Model.Objects;
import Model.Spending;
import java.io.File;
import java.util.Scanner;

public class SpentOn {
    CheckChoose check = new CheckChoose();
    int select1=0, select2=0;
    
    
    public void inputSpent(FinanceManagement acc, Spending newSpent, InforSpend infor){
        for(int i = 1; i<=acc.listOb.size(); i++ ){
            System.out.println(i + ", "+acc.getListOb().get(i-1).getNewTarget().getNameTarget());
        }
        System.out.println("Nhập vị trí cần chi tiêu: ");
        select1 = check.enterChooseInt(acc.getListOb().size())-1;
        for(int i=1; i<= acc.getListOb().get(select1).getNewObjectsManagement().getListObject().size() ; i++){
            System.out.println(i+ ", "+ acc.getListOb().get(select1).getNewObjectsManagement().getListObject().get(i-1).getNameObjects());
        }
        newSpent.setTypeOfSpentOnTarget(select1);
        System.out.println("Nhập vị trí cần chi tiêu: ");
        select2 = check.enterChooseInt(acc.getListOb().get(select1).getNewObjectsManagement().getListObject().size())-1;
        System.out.printf("Số tiền còn lại trong %s là: %.3fđ (%.2f%%)\n",acc.getListOb().get(select1).getNewObjectsManagement().getListObject().get(select2).getNameObjects(), acc.getListOb().get(select1).getNewObjectsManagement().getListObject().get(select2).getBalance(), acc.getListOb().get(select1).getNewObjectsManagement().getListObject().get(select2).getPercent());
        newSpent.setTypeOfSpentObject(select2);
        float money;
        
        do {            
            System.out.println("Nhập số tiền chi tiêu: ");
            money = check.enterFloat();
            if(acc.getListOb().get(select1).getNewObjectsManagement().getListObject().get(select2).getBalance() < money){
                System.out.println("Số tiền tiêu đã vượt quá so với số tiền chia vài khoản này");
            }
        } while (acc.getListOb().get(select1).getNewObjectsManagement().getListObject().get(select2).getBalance() < money);
        newSpent.setAmountSpent(money);
        infor.setMoneyOfSpent(infor.getMoneyOfSpent() + money);
        infor.setMoneyOfBalance(infor.getMoneyOfSpend() - infor.getMoneyOfSpent());
        System.out.println("Nhập ghi chú: ");
        newSpent.setDescribe(new Scanner(System.in).nextLine());
    }

    



    
}
