package com.Desafio4_ConsultaVendas_JPQL.entities;

//Vendedor
//Vendedor tem varias vendas/um para muitos
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "seller")
    private List<Sale> sales = new ArrayList<Sale>();

    public Seller() {}

    public Seller(Long id, String name, String email, String phone, List<Sale> sales) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.sales = sales;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Sale> getSales() {
        return sales;
    }
}
