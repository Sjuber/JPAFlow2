/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat3.jpademoflow2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author SJUBE
 */
@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long p_id;
    private String name;
    private int yeer;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    List<Fee> fees;

    @ManyToMany(mappedBy = "persons", cascade = CascadeType.PERSIST)
    List<SwimStyle> styles;

    public List<Fee> getFees() {
        return fees;
    }

    public void addFee(Fee fee) {
        this.fees.add(fee);
        if (fee != null) {
            fee.setPerson(this);
        }
    }

    public void addSwimStyle(SwimStyle ss) {
        if (ss != null) {
            this.styles.add(ss);
            ss.getPersons().add(this);
        }
    }

    public void removeSwimStyle(SwimStyle sR) {

        if (sR != null) {
            styles.remove(sR);
            sR.getPersons().remove(this);
        }

    }

    public Person(String name, int year) {
        this.name = name;
        this.yeer = year;
        this.fees = new ArrayList<>();
        this.styles = new ArrayList<>();
    }

    public Person() {
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        if (address != null) {
            address.setPerson(this);
        }
    }

    public Long getP_id() {
        return p_id;
    }

    public void setP_id(Long p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYeer() {
        return yeer;
    }

    public void setYeer(int yeer) {
        this.yeer = yeer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{p_id=").append(p_id);
        sb.append(", name=").append(name);
        sb.append(", year=").append(yeer);
        sb.append('}');
        return sb.toString();
    }

}
