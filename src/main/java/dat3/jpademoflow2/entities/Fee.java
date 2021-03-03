/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat3.jpademoflow2.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author SJUBE
 */
@Entity
public class Fee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long f_id;
    private int amount;
    @Temporal(TemporalType.DATE)
    private Date payDate;

    @ManyToOne
    private Person person;

    public Fee(int amount) {
        this.amount = amount;
        this.payDate = new Date();
    }



    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Fee() {
    }

    public Long getF_id() {
        return f_id;
    }

    public int getAmount() {
        return amount;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

}
