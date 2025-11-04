package ua.opnu.java.inheritance.bill;

public class DiscountBill extends GroceryBill {

    private final boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    @Override
    public void add(Item i) {
        super.add(i);

        if (regularCustomer && i.getDiscount() > 0) {
            this.discountCount++;
            this.discountAmount += i.getDiscount();
        }
    }

    @Override
    public double getTotal() {
        double fullPrice = super.getTotal();

        if (regularCustomer) {
            return fullPrice - this.discountAmount;
        } else {
            return fullPrice;
        }
    }

    public int getDiscountCount() {
        return this.discountCount;
    }

    public double getDiscountAmount() {
        return this.discountAmount;
    }

    public double getDiscountPercent() {
        if (!regularCustomer || super.getTotal() == 0) {
            return 0.0;
        }
        return (this.discountAmount * 100) / super.getTotal();
    }
}