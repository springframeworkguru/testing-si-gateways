package guru.springframework.si.model;

public class OrderLine {
    private Integer lineNumber;
    private Product product;
    private Integer orderQty;

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }
}
