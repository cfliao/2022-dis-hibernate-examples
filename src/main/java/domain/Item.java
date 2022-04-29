package domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item")
@SecondaryTable(name = "inventory", pkJoinColumns = @PrimaryKeyJoinColumn(name = "itemid"))
public class Item {
    @Id
    @Column(name = "itemid")
    private String itemId;

    @Column(name = "productid")
    private String productId;

    @Column(name = "listprice")
    private BigDecimal listPrice;

    @Column(name = "unitcost")
    private BigDecimal unitCost;

    @Column(name = "supplier")
    private int supplierId;

    @Column
    private String status;

    @Column(name = "attr1")
    private String attribute1;

    @Column(name = "attr2")
    private String attribute2;

    @Column(name = "attr3")
    private String attribute3;

    @Column(name = "attr4")
    private String attribute4;

    @Column(name = "attr5")
    private String attribute5;

    @ManyToOne
    @JoinColumn(name = "productid", insertable = false, updatable = false)
    private Product product;

    @Column(name = "qty", table = "inventory")
    private int quantity;

    /* JavaBeans Properties */

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId.trim();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    /* Public Methods */

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", productId='" + productId + '\'' +
                ", listPrice=" + listPrice +
                ", unitCost=" + unitCost +
                ", supplierId=" + supplierId +
                ", status='" + status + '\'' +
                ", attribute1='" + attribute1 + '\'' +
                ", attribute2='" + attribute2 + '\'' +
                ", attribute3='" + attribute3 + '\'' +
                ", attribute4='" + attribute4 + '\'' +
                ", attribute5='" + attribute5 + '\'' +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
