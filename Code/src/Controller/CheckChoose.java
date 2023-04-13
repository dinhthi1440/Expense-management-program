package Controller;

import java.util.Scanner;

public class CheckChoose {
    static Scanner sc = new Scanner(System.in);
    public int enterChooseInt(int a){
        String check = "^[0-9]$";
        String choose;
        int myChoose = 0;
        do {
            choose = sc.nextLine();
            if(choose.matches(check)){
                myChoose = Integer.parseInt(choose);
                if(myChoose <= 0 || myChoose > a ){
                    System.out.println("Nhập lại lựa chọn từ 1 tới " + a);
                }
            }
            else if(!choose.matches(check)){
                System.out.println("Lỗi nhập, Chỉ nhập các số nguyên: ");
            }
        } while((!choose.matches(check)) || myChoose <=0 || myChoose > a);
        return myChoose;
    }
    public int enterInt(){
        String check = "^[0-9]+$";
        String choose;
        int myChoose = 0;
        do {
            choose = sc.nextLine();
            if(choose.matches(check)){
                myChoose = Integer.parseInt(choose);
                if(myChoose <= 0){
                    System.out.println("Nhập lại số lớn hơn 0: ");
                }
            }
            else if(!choose.matches(check)){
                System.out.println("Lỗi nhập, Chỉ nhập các số nguyên: ");
            }
        } while((!choose.matches(check)) || myChoose <=0);
        return myChoose;
    }
    public float enterFloat(){
        String check = "^[0-9]+(.([0-9]+))?$";
        String enter;
        float enterNumberFloat=0;
        do {            
            enter = sc.nextLine();
            if(enter.matches(check)){
                enterNumberFloat = Float.parseFloat(enter);
                if(enterNumberFloat< 0){
                    System.out.println("Số tiền không hợp lệ! Nhập lại: ");
                }
            }else{
                System.out.println("Chỉ nhập số, không kèm theo ký tự khác: ");
            }
        } while ( !enter.matches(check) || enterNumberFloat < 0 );
        return enterNumberFloat;
    }
    
}
