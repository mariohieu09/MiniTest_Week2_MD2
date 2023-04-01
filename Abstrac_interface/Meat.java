package Abstrac_interface;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;

public class Meat extends Material implements Discount {
    private double weight;

    public Meat() {
    }

    public Meat(double weight) {
        this.weight = weight;

    }

    public Meat(LocalDate manufacturing, int cost) {
        super.setManufacturingDate(manufacturing);
        super.setCost(cost);
    }

    public double getAmount() {
        return super.getCost() * this.weight;
    }

    public LocalDate getExpiryDate() {
        return super.getManufacturingDate().plusDays(7);
    }

    @Override
    public double getRealMoney(LocalDate x) {
        double afterdiscount = 0;
        double totalCost = 0;
        if (isAboutExp(x) == 0) {
            totalCost = 0;
        } else {
            afterdiscount = this.getCost() * isAboutExp(x) / 100;
            totalCost = this.getCost() - afterdiscount;
        }
        return  totalCost;
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

    public int isAboutExp(LocalDate now) {
        LocalDate expire = this.getExpiryDate();
        int discount = 0;
        if (getMonth(now) < getMonth(expire)) {
            switch (getMonth(now)) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (now.getDayOfMonth() - expire.getDayOfMonth() >= 28) {
                        discount = 30;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (now.getDayOfMonth() - expire.getDayOfMonth() >= 27) {
                        discount = 30;
                    }
                    break;
                case 2:
                    if (now.isLeapYear()) {
                        if (now.getDayOfMonth() - expire.getDayOfMonth() >= 25) {
                            discount = 30;
                        }
                    } else {
                        if (now.getDayOfMonth() - expire.getDayOfMonth() >= 24) {
                            discount = 30;
                        }
                    }
            }
        } else if (getMonth(now) == getMonth(expire)) {
            if (expire.getDayOfMonth() - now.getDayOfMonth() >= 5) {
                discount = 30;
            } else {
                discount = 10;
            }
        } else {
            discount = 0;
        }
        return discount;
    }
}
