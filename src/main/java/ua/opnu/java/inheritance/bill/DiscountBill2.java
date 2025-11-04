package ua.opnu.java.inheritance.bill;

public class DiscountBill2 {

    private final GroceryBill bill;
    private final boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    public void add(Item i) {
        this.bill.add(i);

        if (regularCustomer && i.getDiscount() > 0) {
            this.discountCount++;
            this.discountAmount += i.getDiscount();
        }
    }

    public double getTotal() {

        double fullPrice = this.bill.getTotal();


        if (regularCustomer) {
            return fullPrice - this.discountAmount;
        }
        return fullPrice;
    }

    public Employee getClerk() {
        return this.bill.getClerk();
    }

    public int getDiscountCount() {
        return this.discountCount;
    }

    public double getDiscountAmount() {
        return this.discountAmount;
    }

    public double getDiscountPercent() {
        double fullPrice = this.bill.getTotal();
        if (!regularCustomer || fullPrice == 0) {
            return 0.0;
        }

        return (this.discountAmount * 100) / fullPrice;
    }
}