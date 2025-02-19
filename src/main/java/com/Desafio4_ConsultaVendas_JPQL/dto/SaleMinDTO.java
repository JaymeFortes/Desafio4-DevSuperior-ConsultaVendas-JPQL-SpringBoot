package com.Desafio4_ConsultaVendas_JPQL.dto;

import com.Desafio4_ConsultaVendas_JPQL.entities.Sale;

import java.time.LocalDate;

public class SaleMinDTO {
    private Long id;
    private LocalDate date;
    private Double amount;
    private String sellerName;

    public SaleMinDTO(Long id, LocalDate date, Double amount, String sellerName) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.sellerName = sellerName;
    }

    public SaleMinDTO(Sale entity) {
        id = entity.getId();
        date = entity.getDate();
        amount = entity.getAmount();
        sellerName = entity.getSeller().getName();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
