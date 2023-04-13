package Controller;

import Model.Account;
import Model.InforSpend;
import java.io.File;
import java.util.ArrayList;

public class DataFile {
    FileManagement fileMana = new FileManagement();
    String dataFileName="Data.txt";
    ArrayList<TargetManagement> listOb = new ArrayList<>();
    Account acc = new Account();
    InforSpend spend = new InforSpend();
    

    
    public void createDataFileFromFile(String data){
        String[] datas = data.split("\\|");
        acc.setUser(datas[0]);
        spend.setMoneyOfSpend(Float.parseFloat(datas[1]));
        spend.setMoneyOfBalance(Float.parseFloat(datas[2]));
        spend.setMoneyOfSpent(Float.parseFloat(datas[3]));
        int a=0;
        int forN=Integer.parseInt(datas[4]);
        for(int i=0; i<forN; i++){
            TargetManagement newTar = new TargetManagement();
            listOb.add(newTar);
            listOb.get(i).getNewTarget().setNameTarget(datas[5+a]);
            listOb.get(i).getNewTarget().setPercentOfTarget(Float.parseFloat(datas[6+a]));
            listOb.get(i).getNewTarget().setMoneyOfTarget(Float.parseFloat(datas[7+a]));
            listOb.get(i).getNewTarget().setMoneySpentOfTarget(Float.parseFloat(datas[8+a]));
            listOb.get(i).getNewTarget().setMoneyBalanceOfTarget(Float.parseFloat(datas[9+a]));
            int forT=Integer.parseInt(datas[10+a]);
            for(int j=0; j<forT; j++){
                ObjectsManagement newObj = new ObjectsManagement();
                listOb.get(i).getNewObjectsManagement().getListObject().add(newObj);
                listOb.get(i).getNewObjectsManagement().getListObject().get(j).setAmountDeducted(Float.parseFloat(datas[11+a]));
                listOb.get(i).getNewObjectsManagement().getListObject().get(j).setBalance(Float.parseFloat(datas[12+a]));
                listOb.get(i).getNewObjectsManagement().getListObject().get(j).setMoney(Float.parseFloat(datas[13+a]));
                listOb.get(i).getNewObjectsManagement().getListObject().get(j).setNameObjects(datas[14+a]);
                listOb.get(i).getNewObjectsManagement().getListObject().get(j).setPercent(Float.parseFloat(datas[15+a]));
                a+=5;
            }
            a+=6;
        }
    }
    public void writeDataToFile(){
        fileMana.OpenFileToWrite(dataFileName);
        fileMana.getPrintWriter().print(acc.getUser() + "|");
        fileMana.getPrintWriter().print(spend.getMoneyOfSpend()+ "|");
        fileMana.getPrintWriter().print(spend.getMoneyOfBalance()+ "|");
        fileMana.getPrintWriter().print(spend.getMoneyOfSpent()+ "|");
        fileMana.getPrintWriter().print(listOb.size()+ "|");
        for(int i=0; i<listOb.size(); i++){
            fileMana.getPrintWriter().print(listOb.get(i).getNewTarget().getNameTarget()+"|");
            fileMana.getPrintWriter().print(listOb.get(i).getNewTarget().getPercentOfTarget()+"|");
            fileMana.getPrintWriter().print(listOb.get(i).getNewTarget().getmoneyOfTarget()+"|");
            fileMana.getPrintWriter().print(listOb.get(i).getNewTarget().getMoneySpentOfTarget()+"|");
            fileMana.getPrintWriter().print(listOb.get(i).getNewTarget().getMoneyBalanceOfTarget()+"|");
            fileMana.getPrintWriter().print(listOb.get(i).getNewObjectsManagement().getListObject().size()+ "|");
            for(int j=0; j<listOb.get(i).getNewObjectsManagement().getListObject().size(); j++){
                fileMana.getPrintWriter().print(listOb.get(i).getNewObjectsManagement().getListObject().get(j).getAmountDeducted()+"|");
                fileMana.getPrintWriter().print(listOb.get(i).getNewObjectsManagement().getListObject().get(j).getBalance()+"|");
                fileMana.getPrintWriter().print(listOb.get(i).getNewObjectsManagement().getListObject().get(j).getMoney()+"|");
                fileMana.getPrintWriter().print(listOb.get(i).getNewObjectsManagement().getListObject().get(j).getNameObjects()+"|");
                fileMana.getPrintWriter().print(listOb.get(i).getNewObjectsManagement().getListObject().get(j).getPercent()+"|");
            }
        }
        fileMana.getPrintWriter().println();
        fileMana.CloseFileAfterWrite();
    }

    public ArrayList<TargetManagement> getListOb() {
        return listOb;
    }

    public Account getAcc() {
        return acc;
    }

    public InforSpend getSpend() {
        return spend;
    }

    public void setListOb(ArrayList<TargetManagement> listOb) {
        this.listOb = listOb;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public void setSpend(InforSpend spend) {
        this.spend = spend;
    }
    
    
    
}
