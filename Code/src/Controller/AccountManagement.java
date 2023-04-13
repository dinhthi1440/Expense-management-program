package Controller;

import Model.Account;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AccountManagement {
    
    static Scanner sc = new Scanner(System.in);
    static String Address = "[^0-9&^*%!$#@]$";
    static String Username = "^[\\w]{6,}$";
    static String Password = "^((?=.*[A-Z]).(?=.*[a-z])(?=.*[0-9])(?=.*[&^*%!$#@])).{8,}$";
    static String Phone = "^[\\d]{10}$";
    static String fileName = "Account.txt";
    
    static ArrayList<Account> listAcc = new ArrayList<>();
    static FileManagement fileAcc = new FileManagement();
    static LoggedInSuccessfully logged = new LoggedInSuccessfully();
    static Date date = new Date();
    static CheckChoose checkChoose = new CheckChoose();
    
    //Account(String user, String passWord, String name, int age, String phone, String address)
    
    public void InitializeUserInfo(){
        listAcc = fileAcc.ReadAccountFromFile(fileName);
        if(listAcc.size() >1){
            return;
        }
        listAcc.add(new Account("ThaoM", "foreverM123#", "Ngô Thị Thanh Thảo", 19, "0326872924", "Hải Hoá"));
        listAcc.add(new Account("NaLeee", "LLNa333@#", "Lê Lê Na", 17, "0326872924", "Hà Tĩnh"));
        listAcc.add(new Account("LinhThuy", "LinhDao777&#", "Đào Thuỳ Linh", 22, "0326872924", "Hà Nội"));
        listAcc.add(new Account("LanLam", "LanLam333$#", "Lê Thị Mai Lan", 19, "0326872924", "Ninh Bình"));
        listAcc.add(new Account("Thiii324", "DinhThi911#", "Đinh Văn Thi", 20, "0326872924", "Yên Bái"));
        listAcc.add(new Account("Chiennn204", "ChienNguyen2004#", "Nguyễn Văn Chiến", 19, "0326872924", "Thanh Hoá"));
        listAcc.add(new Account("VanN444", "VanThiNguyen432#", "Nguyễn Thị Thu Vân", 14, "0326872924", "Hà Nội"));
        listAcc.add(new Account("Thanhh22", "VuThanh3@#", "Vũ Thị Thanh", 21, "0326872924", "Hải Dương"));
        listAcc.add(new Account("ThinhLe", "LeThinh611%", "Lê Xuân Thịnh", 25, "0326872924", "Thanh Hoá"));
        listAcc.add(new Account("Thanhh52", "TranThanh324%#", "Trần Xuân Thành", 30, "0326872924", "Nam Định"));
        writeTofile();
    }
    public void ouputAccount(Account acc) {
        System.out.printf("===================================================\n"
                + ">||     <*****> Thông tin người dùng <*****>          \n"
                + ">||   - Tên người dùng: %s                            \n"
                + ">||   - Tuổi: %d                                      \n"
                + ">||   - Số điện thoại: %s                             \n"
                + ">||   - Quê quán: %s                                  \n"
                + ">||                                                   \n"
                + "====================================================="
                , acc.getName(), acc.getAge(), acc.getPhone(), acc.getAddress());
    }
    public int deleteAccount(Account acc2){
        int select=0;
        System.out.println("Bạn có muốn xoá tài khoản mình đang sử dụng?  1,Yes   2,No");
        select = checkChoose.enterChooseInt(2);
        if(select==1){
            System.out.println("Nhập thông tin để xác thực: ");
            System.out.println("Nhập user: ");
            String user = sc.nextLine();
            System.out.println("Nhập password: ");
            String pass = sc.nextLine();
            if(acc2.getUser().equals(user) && acc2.getPassWord().equals(pass)){
                System.out.println("Đã xoá tài khoản thành công!");
                listAcc.remove(acc2);
                writeTofile();
                return 1;
            }else{
                System.out.println("Xác thực xoá tài khoản thất bại do user hoặc password sai!");
                return 0;
            }
        }
        return 1;
    }
    
    public void addNewAcc(){
        Account newA = new Account();
        System.out.println("Nhập user: ");
        newA.setUser(sc.nextLine());
        for(Account i : listAcc){
            while(newA.getUser().equals(i.getUser())){
                System.out.println("User bị trùng, hãy nhập lại: ");
                newA.setUser(sc.nextLine());
            }
        }
        while(!newA.getUser().matches(Username)) {
            System.out.println("User phải có từ 6 ký tự trở lên,chỉ gồm chữ cái và chữ số, hãy nhập lại: ");
            newA.setUser(sc.nextLine());
        }
        
        System.out.println("Nhập Password: ");
        newA.setPassWord(sc.nextLine());
        while(!newA.getPassWord().matches(Password)){
            System.out.println("Password phải từ 8 ký tự trở lên,gồm ký tự đặc biệt, chữ số, chữ in hoa, hãy nhập lại: ");
            newA.setPassWord(sc.nextLine());
        }
        
        System.out.println("Nhập name: ");
        newA.setName(sc.nextLine());
        
        System.out.println("Nhập tuổi: ");
        newA.setAge(sc.nextInt());
        sc.nextLine();
        while (newA.getAge()<0 || newA.getAge()>150) {
            System.out.println("Tuổi không được có chữ, phải lớn hơn 0 và nhỏ hơn 150, hãy nhập lại: ");
            newA.setAge(sc.nextInt());
            sc.nextLine();
        }
        
        System.out.println("Nhập quê quán: ");
        newA.setAddress(sc.nextLine());

        while(newA.getAddress().matches(Address)){
            System.out.println("Quê không được bao gồm ký tự đặc biệt, hãy nhập lại: ");
            newA.setAddress(sc.nextLine());
        }
        
        System.out.println("Nhập sđt: ");
        newA.setPhone(sc.nextLine());
        while (!newA.getPhone().matches(Phone)) {
            System.out.println("Sđt chỉ gồm 10 chữ số, nhập lại: ");
            newA.setPhone(sc.nextLine());
        }
        listAcc.add(newA);
        fileAcc.OpenFileToWrite(fileName);
        fileAcc.getPrintWriter().println( newA.getName()+ "|" +newA.getUser()+ "|" + newA.getPassWord()+ "|" +newA.getAge() + "|" + newA.getPhone() + "|"+ newA.getAddress() + "|" + date);
        fileAcc.CloseFileAfterWrite();
        System.out.println("Đã tạo tài khoản thành công!");
    }

    public boolean checkLogin(String a, String b){
        return listAcc.stream().anyMatch(i -> (i.getUser().equals(a) && i.getPassWord().equals(b)));
    }

    public Account selectAcc(String a, String b){
        for(Account i : listAcc){
            if (i.getUser().equals(a) && i.getPassWord().equals(b)) {
                return i;
            }
        }
        return null;
    }

    public void login(){
        String userWhenLogin;
        String PasswordWhenLogin;

        System.out.println("Nhập user: ");
        userWhenLogin = sc.nextLine();
        while(!userWhenLogin.matches(Username)) {
            System.out.println("User phải có từ 6 ký tự trở lên,chỉ gồm chữ cái và chữ số, hãy nhập lại: ");
            userWhenLogin = sc.nextLine();
        }
        System.out.println("Nhập password: ");
        PasswordWhenLogin = sc.nextLine();
        while(!PasswordWhenLogin.matches(Password)){
            System.out.println("Password phải từ 8 ký tự trở lên,gồm ký tự đặc biệt, chữ số, chữ in hoa, hãy nhập lại: ");
            PasswordWhenLogin = sc.nextLine();
        }
        if(checkLogin(userWhenLogin, PasswordWhenLogin)){
            System.out.println("Đăng nhập thành công!");
//            String userWhenLogin="Thiii324";
//            String PasswordWhenLogin = "DinhThi911#" ;
            
            logged.AfterLogged(selectAcc(userWhenLogin, PasswordWhenLogin));
            
        }else {
            System.out.println("Đăng nhập thất bại! Bạn có muốn tiếp tục đăng nhập?");
            System.out.println("1. Tiếp tục \n" + "2. Thoát");
            int select=0;
            select = checkChoose.enterChooseInt(2);
            if(select ==1){
                login();
            }
        }
        
    }
    public void forgetPassword(){
        System.out.println("Nhập tên user: ");
        String user = sc.nextLine();
        System.out.println("Nhập số điện thoại");
        String sdt = sc.nextLine();
        int a=0;
        for(Account i : listAcc){
            if(i.getUser().equals(user) && i.getPhone().equals(sdt)){
                System.out.println("Xác thực đúng, mời nhập password mới: ");
                String PW = sc.nextLine();
                while(!PW.matches(Password)){
                    System.out.println("Password phải từ 8 ký tự trở lên,gồm ký tự đặc biệt, chữ số, chữ in hoa, hãy nhập lại: ");
                    PW = sc.nextLine();
                }
                i.setPassWord(PW);
                System.out.println("Đổi Password thành công!");
                a=1;
            }
        }
        if(a==0){
            System.out.println("Lấy lại mật khẩu thất bại, do user hoặc sđt không đúng!");
        }
    }
    
    public void UpdateAcc(Account acc ){
        
        int n=0;
        do { 
            System.out.println("===================================================\n"
                        + "||     <*****> Sửa thông tin người dùng <*****>  ||\n"
                        + "||   1.User                                      ||\n"
                        + "||   2.Password                                  ||\n"
                        + "||   3.Tên người dùng                            ||\n"
                        + "||   4.Tuổi                                      ||\n"
                        + "||   5.Số điện thoại                             ||\n"
                        + "||   6.Quê quán                                  ||\n"
                        + "||   7.Thoát                                     ||\n"
                        + "||                                               ||\n"
                        + "=====================================================");
            n=checkChoose.enterChooseInt(7);
            switch(n){
                case 1:{
                    System.out.println("User cũ: " + acc.getUser());
                    System.out.println("Nhập user mới: ");
                    String a;
                    int b=0;
                    do {                        
                        b=1;
                        a = sc.nextLine();
                        for(Account i : listAcc){
                            while(a.equals(i.getUser())){
                                System.out.println("User bị trùng, hãy nhập lại: ");
                                b=2;
                            }
                        }
                        if(!a.matches(Username)) {
                            System.out.println("User phải có từ 6 ký tự trở lên,chỉ gồm chữ cái và chữ số, hãy nhập lại: ");
                        } 
                    } while (!a.matches(Username) || b==2);
                    acc.setName(a);
                    System.out.println("Sửa user thành công!");
                    break;
                }
                case 2:{
                    System.out.println("Password cũ: " + acc.getPassWord());
                    String again;
                    do {                        
                        System.out.println("Nhập password mới: ");
                        acc.setPassWord(sc.nextLine());
                        while(!acc.getPassWord().matches(Password)){
                            System.out.println("Password phải từ 8 ký tự trở lên,gồm ký tự đặc biệt, chữ số, chữ in hoa, hãy nhập lại: ");
                            acc.setPassWord(sc.nextLine());   
                        }
                        System.out.println("Xác nhận lại password: ");
                        again = sc.nextLine();
                        if(!acc.getPassWord().equals(again)){
                            System.out.println("Lỗi! Password xác nhận lại khác với Password mới");
                        }
                    } while (!acc.getPassWord().equals(again));
                    System.out.println("Sửa Password thành công!");
                    break;
                }
                case 3:{
                    System.out.println("Tên người dùng cũ: " + acc.getName());
                    System.out.println("Nhập tên mới: ");
                    acc.setName(sc.nextLine());
                    System.out.println("Sửa tên người dùng thành công!");
                    break;
                }
                case 4:{
                    System.out.println("Tuổi cũ: " + acc.getAge());
                    System.out.println("Nhập tuổi mới: ");
                    acc.setAge(sc.nextInt());
                    sc.nextLine();
                    while (acc.getAge()<0 || acc.getAge()>150) {
                        System.out.println("Tuổi không được có chữ, phải lớn hơn 0 và nhỏ hơn 150, hãy nhập lại: ");
                        acc.setAge(sc.nextInt());
                        sc.nextLine();
                    }
                    System.out.println("Sửa tuổi thành công!");
                    break;
                }
                case 5:{
                    System.out.println("Số điện thoại cũ: " + acc.getPhone());
                    System.out.println("Nhập sđt mới: ");
                    acc.setPhone(sc.nextLine());
                    while (!acc.getPhone().matches(Phone)) {
                        System.out.println("Sđt chỉ gồm các chữ số và trên 9 chữ số, nhập lại: ");
                        acc.setPhone(sc.nextLine());
                    }
                    System.out.println("Sửa số điện thoại thành công!");
                    break;
                }
                case 6:{
                    System.out.println("Quê quán cũ: " + acc.getAddress());
                    System.out.println("Nhập quê mới: ");
                    acc.setAddress(sc.nextLine());
                    while(acc.getAddress().matches(Address)){
                        System.out.println("Quê không được bao gồm ký tự đặc biệt, hãy nhập lại: ");
                        acc.setAddress(sc.nextLine());
                    }
                    System.out.println("Sửa quê quán thành công!");
                    break;
                }
                case 7:{
                    break;
                }
                default:{
                    System.out.println("Lỗi");
                }
            }
        } while (n!=7);
        writeTofile();
        System.out.println("Đã sửa thông tin thành công!");
    }
    
    public void writeTofile(){
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        fileAcc.OpenFileToWrite(fileName);
        listAcc.forEach(i -> {
            fileAcc.getPrintWriter().println( i.getName()+ "|" +i.getUser()+ "|" + i.getPassWord()+ "|" +i.getAge() + "|" + i.getPhone() + "|"+ i.getAddress() + "|" + date);
        });
        fileAcc.CloseFileAfterWrite();
    }
    

    public ArrayList<Account> getListAcc() {
        return listAcc;
    }

    
}
