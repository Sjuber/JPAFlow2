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
        Person per3 = new Person("Klamar", 2102);
        Person per4 = new Person("Jinki", 1986);
        Person per5 = new Person("Nimbus", 2123);
        Person per6 = new Person("Illidan", 1023);
        Person per7 = new Person("Rexxar", 4351);
        Person per8 = new Person("Fangarm", 1220);
        Person per9 = new Person("Obelix", 6666);
        Person per10 = new Person("Hrezuz", 0);

        Address a1 = new Address("DungeonBy", 1783, "Nighon");
        Address a2 = new Address("CyberBy", 2323, "Snæve");
        Address a3 = new Address("UnicornValley", 9183, "El Revee");
        Address a4 = new Address("Sons Of Sigmar Cathedral Ship", 23104, "O5 Lower Deck");

        per1.setAddress(a2);
        per2.setAddress(a1);
        per3.setAddress(a2);
        per4.setAddress(a2);
        per5.setAddress(a3);
        per6.setAddress(a3);
        per7.setAddress(a3);
        per8.setAddress(a1);
        per9.setAddress(a4);
        per10.setAddress(a4);

        Fee f1 = new Fee(31050);
        Fee f2 = new Fee(32323);
        Fee f3 = new Fee(18735);
        Fee f4 = new Fee(39834);
        Fee f5 = new Fee(9181);
        Fee f6 = new Fee(937382);
        Fee f7 = new Fee(346);
        Fee f8 = new Fee(2136438);
        Fee f9 = new Fee(124);
        Fee f10 = new Fee(965);

        per1.addFee(f2);
        per2.addFee(f1);
        per10.addFee(f4);
        per6.addFee(f5);
        per4.addFee(f3);
        per9.addFee(f10);
        per8.addFee(f9);
        per5.addFee(f8);
        per7.addFee(f7);
        per3.addFee(f6);

        SwimStyle s1 = new SwimStyle("Crawl");
        SwimStyle s2 = new SwimStyle("Harrid way of sailing");
        SwimStyle s3 = new SwimStyle("Stroke");
        SwimStyle s4 = new SwimStyle("Funky swim");
        SwimStyle s5 = new SwimStyle("Dancing while swimming");
        SwimStyle s6 = new SwimStyle("Not Stroke");
        SwimStyle s7 = new SwimStyle("Water themed heroes 3 town");
        SwimStyle s8 = new SwimStyle("Cross Strokes");
        SwimStyle s9 = new SwimStyle("Stork");
        SwimStyle s10 = new SwimStyle("Reincarnation swim");

        per2.addSwimStyle(s2);
        per1.addSwimStyle(s1);
        per3.addSwimStyle(s3);
        per4.addSwimStyle(s4);
        per7.addSwimStyle(s5);
        per8.addSwimStyle(s6);
        per9.addSwimStyle(s7);
        per6.addSwimStyle(s8);
        per10.addSwimStyle(s9);
        per5.addSwimStyle(s10);

        em.getTransaction().begin();
        em.persist(per1);
        em.persist(per2);
        em.persist(per3);
        em.persist(per4);
        em.persist(per5);
        em.persist(per6);
        em.persist(per7);
        em.persist(per8);
        em.persist(per9);
        em.persist(per10);
        em.getTransaction().commit();

        em.getTransaction().begin();
        per1.removeSwimStyle(s3);
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
