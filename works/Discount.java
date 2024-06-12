/**
 * The Discount class represents a discount to be applied to prices.
 * It implements Serializable.
 * 
 * <p>A discount has a percentage value that can be applied to calculate the discounted price.</p>
 * 
 * @author Javier Luis Gael
 */
package works;

import java.io.Serializable;

public class Discount implements Serializable {
    private static final long serialVersionUID = 1L;
    private int discount; 

    /**
     * Constructs a Discount object with the specified discount percentage.
     * 
     * @param discount the discount percentage to be applied
     */
    public Discount(int discount){
        super();
        this.discount = discount;
    }

    /**
     * Calculates the discounted price based on the given price.
     * 
     * @param price the original price before discount
     * @return the discounted price
     */
    public double calculatePrice(double price){
        return price - price * (discount/100);
    }

    /**
     * Sets the discount percentage.
     * 
     * @param discount the discount percentage to be set
     */
    public void setDiscount(int discount){
        this.discount = discount;
    }

    /**
     * Retrieves the discount percentage.
     * 
     * @return the discount percentage
     */
    public int getDiscount() {
        return discount;
    }  
}
