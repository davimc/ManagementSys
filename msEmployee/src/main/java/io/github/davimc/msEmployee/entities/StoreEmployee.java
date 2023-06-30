package io.github.davimc.msEmployee.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_store_employee")
public class StoreEmployee implements Serializable {
    private final static long serialVersionUID = 1L;
    @Id
    private Long id;
    private String storeName;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private String name;

    public StoreEmployee() {
    }

    public StoreEmployee(Long id, String storeName, Employee employee, String name) {
        this.id = id;
        this.storeName = storeName;
        this.employee = employee;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreEmployee that = (StoreEmployee) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
