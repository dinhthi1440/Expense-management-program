package Controller;

import static Controller.AccountManagement.checkChoose;
import Model.Account;
import java.io.File;

public class LoggedInSuccessfully {

    AccountManagement acc1 = new AccountManagement();
    FinanceManagement finan = new FinanceManagement();
    DataFileManagement dataFile = new DataFileManagement();
    FileManagement fileMM = new FileManagement();
    SpentOn spent = new SpentOn();
    static int val=0;

    public void AfterLogged(Account acc) {
        int select = 0;
        int reChoooe=0;
        File file = new File(dataFile.dataFileName);
        if(file.exists()){
                fileMM.readDataToAcc(dataFile);

        }
        
        if(!dataFile.listDataFile.isEmpty()){
            for(DataFile i : dataFile.listDataFile){
                if(i.getAcc().getUser().equals(acc.getUser())){
                    finan.inputFromFile(i.getListOb(), i.getSpend(), acc);
                    reChoooe=1;
                }
            }
        }
        
        
        do {
            System.out.println("=======================================\n"
                    + "||       <*****> MENU <*****>      ||\n"
                    + "||   1.Phân bố chi tiêu            ||\n"
                    + "||   2.Chi tiêu                    ||\n"
                    + "||   3.Thống kê giao dịch          ||\n"
                    + "||   4.Xem thông tin tài khoản     ||\n"
                    + "||   5.Cài đặt tài khoản           ||\n"
                    + "||   6.Thoát                       ||\n"
                    + "||                                 ||\n"
                    + "=======================================");
            select = checkChoose.enterChooseInt(6);
            switch (select) {
                case 1: {
                    if(reChoooe==0){
                        finan.inputInforTargetDefault(acc);
                        finan.outputDefault();
                        finan.menu();
                        dataFile.updateDateFile(finan.listOb, acc, finan.spend);
                        dataFile.writeListDataToFile(finan.getListOb(), acc, finan.spend);
                        reChoooe=1;
                    }else{
                        System.out.println("Đã thiết lập phân bố chi tiêu!");
                        System.out.println("Bạn có muốn reset phân bố chi tiêu mới?");
                        System.out.println("1, Yes         2, No");
                        int chon=0;
                        chon = checkChoose.enterChooseInt(2);
                        if(chon==1){
                            finan.inputInforTargetDefault(acc);
                            finan.outputDefault();
                            finan.menu();
                        }
                    }
                    break;
                }
                case 2: {
                    if (finan.getListOb().size() == 0) {
                        System.out.println("Chưa tồn tại các đối tượng chi tiêu! Hãy cập nhật");
                    } else {
                        finan.truTien();
                        dataFile.updateDateFile(finan.listOb, acc, finan.spend);
                        dataFile.writeListDataToFile(finan.getListOb(), acc, finan.spend);
                    }
                    break;
                }
                case 3: {
                    if (finan.getListOb().size() == 0) {
                        System.out.println("Chưa tồn tại các đối tượng chi tiêu! Hãy cập nhật");
                    } else {
                        finan.statistics(acc);
                        
                    }
                    break;
                }
                case 4: {
                    acc1.ouputAccount(acc);
                    
                    break;
                }
                case 5: {
                    menuuu4(acc);
                    if(val == 6){
                        select = 6;
                    }
                    break;
                }
                case 6: {
                    System.out.println("Chương trình kết thúc!");
                    break;
                }
                default: {
                    System.out.println("Lỗi");
                }
            }

        } while (select != 6);
    }

    
    public void menuuu4(Account account) {
        int n = 0;
        do {
            System.out.println("===========================================================\n"
                    + "||       <*****> Sửa đổi thông tin tài khoản <*****>      ||\n"
                    + "||   1.Sửa đổi thông tin người dùng                       ||\n"
                    + "||   2.Sửa đổi thông tin dự án                            ||\n"
                    + "||   3.Xoá tài khoản                                      ||\n"
                    + "||   4.Thoát                                              ||\n"
                    + "||                                                        ||\n"
                    + "===========================================================");
            n = checkChoose.enterChooseInt(4);
            switch (n) {
                case 1: {
                    acc1.UpdateAcc(account);
                    break;
                }
                case 2: {
                    if (finan.getListOb().size() == 0) {
                        System.out.println("Chưa tồn tại các đối tượng chi tiêu! Hãy cập nhật");
                    } else {
                        finan.edit();
                    }
                    break;
                }
                case 3: {
                    int value = acc1.deleteAccount(account);
                    if(value ==1){
                        val = 6;
                        n=4;
                    }
                    break;
                }
                case 4: {
                    break;
                }
            }
        } while (n != 4);
    }

}
