package Controller;

import static Controller.AccountManagement.checkChoose;
import Model.Account;
import Model.InforSpend;
import Model.Spending;
import Model.Target;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FinanceManagement {
    TargetManagement necessity = new TargetManagement();
    TargetManagement eatDrink = new TargetManagement();
    TargetManagement entertainment = new TargetManagement();
    TargetManagement arise = new TargetManagement();
    InforSpend spend = new InforSpend();
    
    static Scanner sc = new Scanner(System.in);
    CheckChoose check = new CheckChoose();
    ArrayList<TargetManagement> listOb = new ArrayList<>();
    FileManagement fileMana = new FileManagement();
    final float[] listPercentsDefault = {60, 25, 10, 2.5f, 5, 7.5f, 10, 25, 25, 10, 2.5f, 7.5f, 5, 5};

    public void inputInforTargetDefault(Account acc){
        System.out.println("Nhập số tiền cần quản lý: ");
        spend.setMoneyOfSpend(check.enterFloat());
        spend.setMoneyOfBalance(spend.getMoneyOfSpend());
        necessity.inputTargetDefault("Nhu cầu thiết yếu",listPercentsDefault, spend,  "Nhà cửa", "Điện", "Nước", "Xăng xe", "Sách vở", "Quần áo");
        eatDrink.inputTargetDefault("Ăn uống" ,listPercentsDefault, spend, 0, "Ăn uống");
        entertainment.inputTargetDefault("Giải trí",listPercentsDefault, spend, "Xem phim", "Tiêu vặt");
        arise.inputTargetDefault("Phát sinh",listPercentsDefault, spend, 1, "Thuốc");
        listOb.add(necessity);
        listOb.add(eatDrink);
        listOb.add(entertainment);
        listOb.add(arise);
        writeBillToFile(acc, spend);
        System.out.println("Đã thiết lập các nhóm chi tiêu mặc định! ");
    }
    
    public void inputFromFile(ArrayList<TargetManagement> listOb2, InforSpend spend2, Account acc){
        System.out.println("Hahaha");
            listOb = listOb2;
            spend = spend2;
            writeBillToFile(acc, spend);
    }
    public void menu(){
        int select =0;
        do {            
            System.out.println("==========================================\n"
                        + "||      Bạn có muốn sửa phân bố chi tiêu?  ||\n"
                        + "||   1.Có                                  ||\n"
                        + "||   2.Không                               ||\n"
                        + "||                                         ||\n"
                        + "============================================");
            select = checkChoose.enterChooseInt(2);
            switch (select){
                case 1:{
                    editAllPercent();
                    break;
                }
                case 2:{
                    break;
                }
                default:{
                    System.out.println("Lỗi");
                }
            }
            
        } while (select != 2);
    }
    public void addNewTarget(){
        System.out.println("=======================================\n"
                        + "||       <*****> Thêm nhóm đối tượng <*****>    ||\n"
                        + "=======================================");
        TargetManagement newTarget = new TargetManagement();
        System.out.println("Nhập tên nhóm: ");
        String setName = sc.nextLine();
        System.out.println("Nhập %: ");
        float a = check.enterFloat();
        newTarget.inputNewTarget(setName, a, spend);
        listOb.add(newTarget);
    }
    public void writeBillToFile(Account acc, InforSpend infor){
        fileMana.OpenFileToWrite("ChiTieu.txt");
        fileMana.getPrintWriter().println("\n\t\t\t\t SAO KÊ TÀI KHOẢN\n");
        fileMana.getPrintWriter().printf("Chủ tài khoản: %s\n", acc.getName());
        fileMana.getPrintWriter().printf("User: %s\n", acc.getUser());
        fileMana.getPrintWriter().printf("Tuổi: %d\n", acc.getAge());
        fileMana.getPrintWriter().printf("Địa chỉ: %s\n", acc.getAddress());
        fileMana.getPrintWriter().printf("Số điện thoại: %s\n", acc.getPhone());
        fileMana.getPrintWriter().printf("\tSố dư khi thiết lập: %.2f đ\n", infor.getMoneyOfSpend());
        fileMana.getPrintWriter().printf("%-20s %-20s %-20s %-20s%-20s\n", "Loại chi tiêu", "Số tiền chi(đ)", "Số tiền còn lại(đ)", "Mô tả giao dịch", "Ngày giao dịch");
        fileMana.CloseFileAfterWrite();
    }

    public void truTien() {
        Date date = new  Date();
        SpentOn Spent = new SpentOn();
        Spending spending = new Spending();
        Spent.inputSpent(this, spending, spend);
        listOb.get(spending.getTypeOfSpentOnTarget()).getNewObjectsManagement().truTienTrongObject(spending.getTypeOfSpentObject(), spending.getAmountSpent());
        listOb.get(spending.getTypeOfSpentOnTarget()).truTienTrongTarget(spending.getAmountSpent());
        fileMana.OpenFileToWrite("ChiTieu.txt");
        // "Loại chi tiêu", "Số tiền chi", "Số tiền còn lại", "Mô tả giao dịch", "Ngày giao dịch"
        fileMana.getPrintWriter().printf("%-20s %-20.2f %-20.2f %-20s %-20s",
                listOb.get(spending.getTypeOfSpentOnTarget()).getNewObjectsManagement().getListObject().get(spending.getTypeOfSpentObject()).getNameObjects(),
                spending.getAmountSpent(),
                spend.getMoneyOfBalance(),
                spending.getDescribe(),""+ date +"\n");
        fileMana.CloseFileAfterWrite();
    }
    public void soTienConLai(){
        float tong=0;
        for( TargetManagement i : listOb){
            tong += i.soDu();
        }
        System.out.printf("Số dư: %.4fđ (%.2f%%) \n", tong,tong/spend.getMoneyOfSpend()*100);
        System.out.printf("Số tiền đã tiêu: %.4fđ (%.2f%%) ",(spend.getMoneyOfSpend()-tong), (100-(tong/spend.getMoneyOfSpend()*100)));
        
    }
    
    
    public void statistics(Account acc){
        int select=0;
        do {       
            System.out.println("==========================================\n"
                        + "||     <*****> Thống kê giao dịch <*****>     ||\n"
                        + "||   1.Kiểm tra số dư và số tiền đã tiêu      ||\n"
                        + "||   2.Kiểm tra số dư trong các khoản         ||\n"
                        + "||   3.In chi tiêu                            ||\n"
                        + "||   4.Thoát                                  ||\n"
                        + "||                                            ||\n"
                        + "============================================");
            select = checkChoose.enterChooseInt(4);
            switch (select){
                case 1:{
                    soTienConLai();
                    break;
                }
                case 2:{
                    outputAfterSpent();
                    break;
                }
                case 3:{
                    fileMana.printBill();
                    break;
                }
                case 4:{
                    
                    break;
                }
            }
            
        } while (select!=4);
    }
    
    
    
    public ArrayList<TargetManagement> getListOb() {
        return listOb;
    }
    public void outputDefault(){
        for(TargetManagement i : listOb){
            System.out.printf(" - %s (%.2f%%): %.3fđ \n", i.getNewTarget().getNameTarget() ,i.getNewTarget().getPercentOfTarget() ,+i.getNewTarget().getmoneyOfTarget() );
            i.getNewObjectsManagement().output();
        }
    }
    public void outputAfterSpent(){
        for(TargetManagement i : listOb){
            System.out.printf(" - %s: %.3fđ (%.2f%%), số tiền còn lại %.2f , số tiền đã tiêu %.2f\n", i.getNewTarget().getNameTarget(),  i.getNewTarget().getmoneyOfTarget(),  i.getNewTarget().getPercentOfTarget(),  i.getNewTarget().getMoneyBalanceOfTarget(),  i.getNewTarget().getMoneySpentOfTarget());
            i.getNewObjectsManagement().outputAfterSpent();
        }
    }
    public void deleteTarget(){
        System.out.println("Nhóm đối tượng cần xoá: ");
        for(int i=0; i<listOb.size(); i++){
            System.out.println((i+1) +", "+ listOb.get(i).getNewTarget().getNameTarget());
        }
        System.out.println("Chọn: ");
        int select = check.enterChooseInt(listOb.size());
        listOb.remove(listOb.size()-1);
    }
    public void deleteObjectFromTarget(){
        System.out.println("Nhóm đối tượng cần xoá đối tượng chi tiêu: ");
        for(int i=0; i<listOb.size(); i++){
            System.out.println((i+1) +", "+ listOb.get(i).getNewTarget().getNameTarget());
        }
        System.out.println("Chọn: ");
        int select = check.enterChooseInt(listOb.size());
        for(int i=0; i<listOb.get(select).getNewObjectsManagement().getListObject().size(); i++){
            System.out.println((i+1)+"," + listOb.get(select-1).getNewObjectsManagement().getListObject().get(i).getNameObjects());
        }
        System.out.println("Chọn: ");
        int select1 = check.enterChooseInt(listOb.get(select-1).getNewObjectsManagement().getListObject().size());
        listOb.get(select-1).getNewObjectsManagement().getListObject().remove(select1-1);
    }

    
    public void editAllPercent(){
        for(int i=0; i<listOb.size(); i++){
            System.out.println("- Nhóm "+ listOb.get(i).getNewTarget().getNameTarget());
            System.out.println("Bạn có muốn sửa nhóm này không:  1,Có       2,Không");
            int select1=check.enterChooseInt(2);
            if(select1==1){
                System.out.println("Sửa: 1,Sử tên     2, Sửa '%'");
                int choose= check.enterChooseInt(2);
                if(choose==1){
                    System.out.println("Bạn muốn sửa tên thành gì?");
                    String set = sc.nextLine();
                    listOb.get(i).getNewTarget().setNameTarget(set);  
                }else if(choose==2){
                    System.out.println("Bạn muốn sửa % = ?");
                    float set = check.enterFloat();
                    listOb.get(i).getNewTarget().setMoneyOfTarget(set);
                }
                
            }
            for(int j=0; j<listOb.get(i).getNewObjectsManagement().getListObject().size(); j++){
                System.out.println("     + "+ listOb.get(i).getNewObjectsManagement().getListObject().get(j).getNameObjects());
                System.out.println("Bạn có muốn sửa đối tượng này không :    1,Có      2,Không");
                int select2=check.enterChooseInt(2);
                if(select2==1){
                    System.out.println("Sửa: 1,Sử tên     2, Sửa '%'");
                    int choose= check.enterChooseInt(2);
                    if(choose==1){
                        System.out.println("Bạn muốn sửa tên thành gì?");
                        String set = sc.nextLine();
                        listOb.get(i).getNewObjectsManagement().getListObject().get(j).setNameObjects(set);
                    }else if(choose==2){
                        System.out.println("Bạn muốn sửa % = ?");
                        float set = check.enterFloat();
                        listOb.get(i).getNewObjectsManagement().getListObject().get(j).setPercent(set);
                    }
                }
            }
        }
    }
    public void addObjectToTarget(){
        System.out.println("Nhóm đối tượng cần thêm đối tượng chi tiêu: ");
        for(int i=0; i<listOb.size(); i++){
            System.out.println((i+1) +", "+ listOb.get(i).getNewTarget().getNameTarget());
        }
        System.out.println("Chọn: ");
        int select = check.enterChooseInt(listOb.size());
        System.out.println("Nhập tên đối tượng: ");
        String setName = sc.nextLine();
        System.out.println("Nhập %: ");
        float percent = check.enterFloat();
        listOb.get(select-1).getNewObjectsManagement().addNewObjectToTarget(setName, percent, spend.getMoneyOfSpend());
    }

    public void edit(){
        int n=0;
        do {
            System.out.println("==========================================\n"
                        + "||      <*****> Sửa thông tin dự án <*****>                  ||\n"
                        + "||   1.Thêm nhóm đối tượng chi tiêu         ||\n"
                        + "||   2.Thêm đối tượng chi tiêu              ||\n"
                        + "||   3.Xoá nhóm đối tượng chi tiêu          ||\n"
                        + "||   4.Xoá đối tượng chi tiêu               ||\n"
                        + "||   5.Thoát                                ||\n"
                        + "||                                          ||\n"
                        + "============================================");
            n = checkChoose.enterChooseInt(5);
            switch (n){
                case 1:{
                    addNewTarget();
                    break;
                }
                case 2:{
                    addObjectToTarget();
                    break;
                }
                case 3:{
                    deleteTarget();
                    break;
                }
                case 4:{
                    deleteObjectFromTarget();
                    break;
                }
                case 5:{
                    break;
                }
                default:{
                    System.out.println("Lỗi lỗi");
                    break;
                }
            }
        } while (n!=5);
        
        
    }
    public FinanceManagement() {
        
    }

    
}
