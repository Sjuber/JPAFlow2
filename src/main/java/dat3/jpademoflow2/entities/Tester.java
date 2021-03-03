/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat3.jpademoflow2.entities;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author SJUBE
 */
public class Tester {

    public static void main(String args[]) {

        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("pu");
        EntityManager em = EMF.createEntityManager();

        Person per1 = new Person("Blondike", 2022);
        Person per2 = new Person("Ahjit", 2512);
        Address a1 = new Address("DungeonBy", 1783, "Nighon");
        Address a2 = new Address("CyberBy", 2323, "Snæve");

        per1.setAddress(a2);
        per2.setAddress(a1);

        Fee f1 = new Fee(31050);
        Fee f2 = new Fee(32323);
        Fee f3 = new Fee(18735);

        per1.addFee(f2);
        per2.addFee(f1);
        per1.addFee(f3);

        em.getTransaction().begin();
//        em.persist(a1);
//        em.persist(a2);
        em.persist(per1);
        em.persist(per2);
        em.getTransaction().commit();

        System.out.println("Person et: " + per1.getName() + per1.getP_id());
        System.out.println("id of p2: " + per2.getP_id() + " name of p2:  " + per2.getName());
        System.out.println("Ahjits gade: " + per1.getAddress().getStreet());

        System.out.println("Lad os se om tovejs virker: " + a1.getPerson().getName());

        System.out.println("Hvem skal betale F2? Det skal " + f1.getPerson().getName());

        System.out.println("Hvad skal Blondike betale?");

        TypedQuery<Fee> q1 = em.createQuery("SELECT f FROM Fee f", Fee.class);
        List<Fee> fees = q1.getResultList();
        for (Fee f : fees) {
            System.out.println(f.getPerson().getName() + " : " + f.getAmount() + " : " + f.getPayDate() + " Adr: " + f.getPerson().getAddress().getCity());
        }
    }
}
