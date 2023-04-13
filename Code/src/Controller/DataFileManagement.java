package Controller;

import Model.Account;
import Model.InforSpend;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DataFileManagement {
    ArrayList<DataFile> listDataFile = new ArrayList<>();
    public String dataFileName="Data.txt";
    FileManagement fileMana = new FileManagement();
    private Scanner scanner;
    
    
    public void updateDateFile(ArrayList<TargetManagement> listOb1, Account acc1, InforSpend spend1){
        for(int i=0; i<listDataFile.size(); i++){
            if(listDataFile.get(i).getAcc().getUser() == acc1.getUser()){
                listDataFile.remove(i);
            }
        }
        DataFile newDatafile = new DataFile();
        newDatafile.setAcc(acc1);
        newDatafile.setSpend(spend1);
        newDatafile.setListOb(listOb1);
        listDataFile.add(newDatafile);
    }
    
    
    public void writeListDataToFile(ArrayList<TargetManagement> listOb1,  Account acc, InforSpend spend){
        File file = new File(dataFileName);
        if(file.exists()){
            file.delete();
        }
        
        for(DataFile i : listDataFile){
            i.writeDataToFile();
        }
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    
}
