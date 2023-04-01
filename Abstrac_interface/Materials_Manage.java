package Abstrac_interface;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Materials_Manage implements Validate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Materials_Manage list = new Materials_Manage();
        List<Material> materials = new ArrayList<>();
        materials.add(new Meat(LocalDate.of(2019, 12, 23), 3000));
        materials.add(new Meat(LocalDate.of(2019, 10, 19), 3000));
        while(true){
            System.out.println("Input choice: \n1. Add \n2.Display \n3.remove \n4.Edit \n5.Get Real Cost \n0. Exit");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    list.addM(materials);
                    break;
                case 2:
                    list.display(materials);
                    break;
                case 3:
                    System.out.println("Nhap vi tri can xoa ");
                    int delete = sc.nextInt();
                    list.remove(materials, delete);
                    break;
                case 5:
                    for(Material c : materials){
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
                    break;
                case 4:
                    System.out.println("Nhap vi tri ban muon chinh sua: ");
                    int index = sc.nextInt();
                    list.Edit(materials, index);
                    break;
                case 0:
                    System.exit(1);


            }
        }

    }

    @Override
    public void addM(List<Material> materials) {
        Scanner sc = new Scanner(System.in);
        System.out.println("List adding: \n1. Meat \n2.CripsyFlour");
        int x = sc.nextInt();
        System.out.println("Nhập năm sản xuất: ");
        int year = sc.nextInt();
        System.out.println("Nhập tháng sản xuất: ");
        int month = sc.nextInt();
        System.out.println("Nhập ngày sản xuất: ");
        int day = sc.nextInt();
        System.out.println("Nhập giá tiền: ");
        int cost = sc.nextInt();
        if(x == 1) {
            materials.add(new Meat( LocalDate.of(year, month, day), cost));
        }else if(x == 2){
            materials.add(new CripsyFlour(LocalDate.of(year, month, day), cost));
        }else{
            System.out.println("Ban nhap sai.");
            System.exit(0);
        }
    }

    @Override
    public void display(List<Material> materials) {
        for(Material s : materials){
            System.out.println(s);
        }
    }

    @Override
    public void remove(List<Material> materials, int i) {
        materials.remove(i);
    }

    @Override
    public void Edit(List<Material> materials, int m) {
            int i = 0;
            Scanner sc = new Scanner(System.in);
            for(i = 0; i < materials.size(); i++){
                if(i == m){
                    System.out.println("Nhập năm sản xuất: ");
                    int year = sc.nextInt();
                    System.out.println("Nhập tháng sản xuất: ");
                    int month = sc.nextInt();
                    System.out.println("Nhập ngày sản xuất: ");
                    int day = sc.nextInt();
                    System.out.println("Nhập giá tiền: ");
                    int cost = sc.nextInt();

                    materials.get(i).setManufacturingDate(LocalDate.of(year,month,day));
                    materials.get(i).setCost(cost);
                }
        }
    }

}
