package View;

import Controller.AccountManagement;
import Controller.CheckChoose;
import Controller.FinanceManagement;
import Controller.SpentOn;
import Controller.TargetManagement;
import java.io.File;
import java.util.Scanner;

public class Main {
    static AccountManagement acc = new AccountManagement();
    static TargetManagement target = new TargetManagement();
    static Scanner sc = new Scanner(System.in);
    static CheckChoose checkChoose = new CheckChoose();
    public static void main(String[] args) {
        int select =0;
        acc.InitializeUserInfo();
        do {            
            System.out.println("=======================================\n"
                        + "||       <*****> MENU <*****>    ||\n"
                        + "||   1.Đăng nhập                 ||\n"
                        + "||   2.Đăng ký                   ||\n"
                        + "||   3.Quên mật khẩu             ||\n"
                        + "||   4.Thoát                     ||\n"
                        + "||                               ||\n"
                        + "=======================================");
            select = checkChoose.enterChooseInt(4);
            switch (select){
                case 1:{
                    acc.login();
                    break;
                }
                case 2:{
                    acc.addNewAcc();
                    acc.login();
                    break;
                }
                case 3:{
                    acc.forgetPassword();
                    break;
                }
                case 4:{
                    System.out.println("Chương trình kết thúc!");
                    break;
                }
                default:{
                    System.out.println("Lỗi");
                }
            }
            
        } while (select != 4);  

    }
    
}
