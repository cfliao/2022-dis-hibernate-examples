package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory
{
    @Id
    @Column(name = "itemid")
    private String itemId;

    @Column(name = "qty")
    private int quantity;
    
    public int getQuantity()
    {
        return quantity;
    }

    public void setItemId(String itemId)
    {
        this.itemId = itemId;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public String getItemId()
    {
        return itemId;
    }

    public Inventory()
    {
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "itemId='" + itemId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
