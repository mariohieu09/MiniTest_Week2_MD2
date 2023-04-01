package Abstrac_interface;

import java.time.LocalDate;
import java.time.Month;

public class CripsyFlour extends Material implements Discount{
    private int quantity;
    public CripsyFlour(LocalDate manufacturing , int cost){
        super.setCost(cost);
        super.setManufacturingDate(manufacturing);
    }

    public double getAmount() {
        return this.quantity * super.getCost();
    }

    public LocalDate getExpiryDate() {
        return super.getManufacturingDate().plusYears(1);
    }

    public int getMonth(LocalDate now) {
        Month month = now.getMonth();
        int m = 0;
        switch (month) {
            case JANUARY -> m = 1;
            case FEBRUARY -> m = 2;
            case MARCH -> m = 3;
            case APRIL -> m = 4;
            case MAY -> m = 5;
            case JULY -> m = 6;
            case JUNE -> m = 7;
            case AUGUST -> m = 8;
            case SEPTEMBER -> m = 9;
            case OCTOBER -> m = 10;
            case NOVEMBER -> m = 11;
            case DECEMBER -> m = 12;

        }
        return m;
    }

    public int checkingExp(LocalDate now) {
        int discount = 5;
        int MonthExp = getMonth(this.getExpiryDate());
        int MonthNow = getMonth(now);
        if(this.getExpiryDate().getYear() == now.getYear() && MonthExp - MonthNow <= 4){
            discount = 20;
        }else if(this.getExpiryDate().getYear() == now.getYear() && MonthExp - MonthNow <= 2){
            discount = 40;
        }else if(this.getExpiryDate().getYear() > now.getYear() && Math.abs(MonthExp - MonthNow) >= 9){
            discount = 20;
        }else if(this.getExpiryDate().getYear() > now.getYear() && Math.abs(MonthExp - MonthNow) >= 11){
            discount = 40;
        }if(this.getExpiryDate().isBefore(now)){
            discount = 0;
        }
        return discount;
    }

    @Override
    public double getRealMoney(LocalDate now) {
        double result = 0;
        if (checkingExp(now) == 0) {
            result = 0;
        } else {
            double profit = this.getCost() * checkingExp(now) / 100;
            result = this.getCost() - profit;

        }
        return  result;
    }
}