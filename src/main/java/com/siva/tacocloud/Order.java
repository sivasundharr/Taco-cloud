package com.siva.tacocloud;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.CreditCardNumber;

@Data
@Entity
@Table(name = "Taco_Order")
public class Order implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is Required")
    private String name;

    @NotBlank(message="Street is Required")
    private String street;

    @NotBlank(message="City is Required")
    private String city;

    @NotBlank(message="State is Required")
    private String state;

    @NotBlank(message="Zip is Required")
    private String zip;

    @CreditCardNumber(message="Not a Valid CreditCard Number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",message = "Must be formatted in MM/YY")
    private String ccExpiration;

    @Digits(integer = 3,fraction = 0,message = "Invalid CVV")
    private String ccCVV;
    
    private Date createdAt;

    @ManyToMany(targetEntity=Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    public void addTacoDesign(Taco design){
        this.tacos.add(design);
    }

    @PrePersist
    void createdAt() {
        this.createdAt  = new Date();
    }
}
