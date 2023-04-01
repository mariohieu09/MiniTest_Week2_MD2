package Abstrac_interface;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.List;

public class Materials_Manage {
    public static void main(String[] args) {
        ArrayList<Material> list = new ArrayList<Material>();
        list.add(new Meat(LocalDate.of(2023,4,1), 209));
        list.add(new Meat(LocalDate.of(2023,3,26), 300));
        list.add(new Meat(LocalDate.of(2023,3,30), 400));
        list.add(new Meat(LocalDate.of(2023,3,29),200));
        list.add(new Meat(LocalDate.of(2023,3,20),400));
        list.add(new CripsyFlour(LocalDate.of(2022,2,9), 1000));
        list.add(new CripsyFlour(LocalDate.of(2022,7,7), 2000));
        list.add(new CripsyFlour(LocalDate.of(2022, 8, 6), 4000));
        list.add(new CripsyFlour(LocalDate.of(2022, 9, 9), 6000));
        list.add(new CripsyFlour(LocalDate.of(2022, 4, 30), 8000));
//        var c = new CripsyFlour(LocalDate.of(2022,3,23),3000);
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
