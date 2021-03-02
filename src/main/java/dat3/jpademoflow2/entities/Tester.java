/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat3.jpademoflow2.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    }
}
