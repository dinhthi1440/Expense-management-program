package Controller;

import Model.Account;
import Model.InforSpend;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManagement {

    private FileWriter fileWriter;
    private BufferedWriter buffWriter;
    private PrintWriter printWriter;
    private Scanner scanner;

    public void OpenFileToWrite(String Fname) {
        try {
            fileWriter = new FileWriter(Fname, true);
            buffWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(buffWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CloseFileAfterWrite() {
        try {
            printWriter.close();
            buffWriter.close();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OpenFileToRead(String Fname) {
        try {
            scanner = new Scanner(Paths.get(Fname));
        } catch (IOException e) {
            File file = new File(Fname);
        }
    }

    public Account CreateAccountFromData(String data) {
        String[] datas = data.split("\\|");
        //String user, String passWord, String name, int age, String phone, String address
        Account acc = new Account(datas[1], datas[2], datas[0], Integer.parseInt(datas[3]), datas[4], datas[5]);
        return acc;
    }

    public void printBill(){
        OpenFileToRead("ChiTieu.txt");
        while(scanner.hasNext()) {
            String data = scanner.nextLine();
            System.out.println(data);
        }
        CloseFileAfterRead();
    }
    
    public void readDataToAcc(DataFileManagement listDataFile){
        OpenFileToRead("Data.txt");
        System.out.println("Đã đnagw nhập3");
        while(scanner.hasNext()) {
            System.out.println("Đã đnagw nhập2");
            String data = scanner.nextLine();
            DataFile newDatafile = new DataFile();
            newDatafile.createDataFileFromFile(data);
            listDataFile.listDataFile.add(newDatafile);
        }
        CloseFileAfterRead();
    }
    
    public ArrayList<Account> ReadAccountFromFile(String fileName) {
        OpenFileToRead(fileName);
        ArrayList<Account> list = new ArrayList<>();

        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            Account acc = CreateAccountFromData(data);
            list.add(acc);
        }
        CloseFileAfterRead();
        return list;
    }

    public void CloseFileAfterRead() {
        scanner.close();
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }

    public BufferedWriter getBuffWriter() {
        return buffWriter;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void setBuffWriter(BufferedWriter buffWriter) {
        this.buffWriter = buffWriter;
    }

    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

}
