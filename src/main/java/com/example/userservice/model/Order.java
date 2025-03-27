package com.example.userservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nro;

    @ManyToOne
    @JoinColumn(name = "idcliente", nullable = false) // Especifica la columna que será la FK
    private User user;

    @NotBlank(message = "Date is required")
    private String date;

    @NotBlank(message = "Ruc is required")
    private String ruc;

    @NotBlank(message = "direccion")
    private String address;

    public Order() {
    }

    public Order(Long id, String nro, User user, String date, String ruc, String address) {
        this.id = id;
        this.nro = nro;
        this.user = user;
        this.date = date;
        this.ruc = ruc;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(nro, order.nro) && Objects.equals(user, order.user) && Objects.equals(date, order.date) && Objects.equals(ruc, order.ruc) && Objects.equals(address, order.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nro, user, date, ruc, address);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", nro='" + nro + '\'' +
                ", user=" + user +
                ", date='" + date + '\'' +
                ", ruc='" + ruc + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
