package org.top.orderpage.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_t", schema = "orders_db", catalog = "")
public class OrderTEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_f")
    private Integer idF;
    @Basic
    @Column(name = "name_f")
    private String nameF;
    @Basic
    @Column(name = "email_f")
    private String emailF;
    @Basic
    @Column(name = "phone_f")
    private String phoneF;
    @Basic
    @Column(name = "address_f")
    private String addressF;

    public Integer getIdF() {
        return idF;
    }

    public void setIdF(Integer idF) {
        this.idF = idF;
    }

    public String getNameF() {
        return nameF;
    }

    public void setNameF(String nameF) {
        this.nameF = nameF;
    }

    public String getEmailF() {
        return emailF;
    }

    public void setEmailF(String emailF) {
        this.emailF = emailF;
    }

    public String getPhoneF() {
        return phoneF;
    }

    public void setPhoneF(String phoneF) {
        this.phoneF = phoneF;
    }

    public String getAddressF() {
        return addressF;
    }

    public void setAddressF(String addressF) {
        this.addressF = addressF;
    }

    //копирование полей объекта
    public void updateFields(OrderTEntity src) {
        nameF = src.nameF;
        phoneF = src.phoneF;
        emailF = src.emailF;
        addressF = src.addressF;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderTEntity that = (OrderTEntity) o;

        if (idF != null ? !idF.equals(that.idF) : that.idF != null) return false;
        if (nameF != null ? !nameF.equals(that.nameF) : that.nameF != null) return false;
        if (emailF != null ? !emailF.equals(that.emailF) : that.emailF != null) return false;
        if (phoneF != null ? !phoneF.equals(that.phoneF) : that.phoneF != null) return false;
        if (addressF != null ? !addressF.equals(that.addressF) : that.addressF != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idF != null ? idF.hashCode() : 0;
        result = 31 * result + (nameF != null ? nameF.hashCode() : 0);
        result = 31 * result + (emailF != null ? emailF.hashCode() : 0);
        result = 31 * result + (phoneF != null ? phoneF.hashCode() : 0);
        result = 31 * result + (addressF != null ? addressF.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderTEntity{" +
                "idF=" + idF +
                ", nameF='" + nameF + '\'' +
                ", emailF='" + emailF + '\'' +
                ", phoneF='" + phoneF + '\'' +
                ", addressF='" + addressF + '\'' +
                '}';
    }
}
