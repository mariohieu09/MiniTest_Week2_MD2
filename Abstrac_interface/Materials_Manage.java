package Abstrac_interface;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Materials_Manage {
    public static void main(String[] args) {
        ArrayList<Material> list = new ArrayList<Material>();
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; i++){
            System.out.println("Nhap vao so ban muon them: \n1. Meat \n2.CripsyFlour");
            int x = sc.nextInt();
            System.out.println("Nhập năm sản xuất: ");
            int year = sc.nextInt();
            System.out.println("Nhập tháng sản xuất: ");
            int month = sc.nextInt();
            System.out.println("Nhập ngày sản xuất: ");
            int day = sc.nextInt();
            System.out.println("Nhập giá tiền: ");
            int cost = sc.nextInt();
            if (x == 1) {
                list.add(new Meat(LocalDate.of(year,month,day), cost));
            }else{
                list.add(new CripsyFlour(LocalDate.of(year, month, day), cost));
            }

        }
        for(Material c : list){
            if(c instanceof Meat){
                System.out.println("Gia thit khi chua giam gia la: ");
                System.out.println(c.getCost());
                System.out.println("Gia thit khi da giam gia la:");
                System.out.println(((Meat)c).getRealMoney(LocalDate.now()));
            }else{
                System.out.println("Gia bot chien gion khi chua giam gia la: ");
                System.out.println(c.getCost());
                System.out.println("Gia bot chien da giam gia la: ");
                System.out.println(((CripsyFlour)c).getRealMoney(LocalDate.now()));
            }
        }

    }

}
