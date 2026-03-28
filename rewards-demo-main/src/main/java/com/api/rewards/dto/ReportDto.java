package com.api.rewards.dto;

public class ReportDto {
    private String product;
    private int totalQty;
    private double totalAmount;

    public ReportDto() {}

    public ReportDto(String product, int totalQty, double totalAmount) {
        this.product = product;
        this.totalQty = totalQty;
        this.totalAmount = totalAmount;
    }

    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }

    public int getTotalQty() { return totalQty; }
    public void setTotalQty(int totalQty) { this.totalQty = totalQty; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}