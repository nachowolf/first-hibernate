package com.project.stuff;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;


public class TestSystem {


    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        addCustomer(1, "Sue", "Smith", session);
        readSingle(session);
        readAll(session);
        session.close();


    }

    public static void addCustomer(int id, String fname, String lname, Session session) {

        Customer cust = new Customer();
        cust.setId(id);
        cust.setFname(fname);
        cust.setLname(lname);

        session.beginTransaction();
        session.save(cust);
        session.getTransaction().commit();


    }

    public static void readSingle(Session session) {
        Customer cust= (Customer) session.get(Customer.class, 1);
        System.out.println(cust.getFname());
    }

    public static void readAll(Session session){
        Query q = session.createQuery("from Customer c");
        List l = q.getResultList();
        Iterator it = l.iterator();
        while(it.hasNext())
        {
            Object o = (Object)it.next();
            Customer c = (Customer) o;
            System.out.println("Customer id : "+c.getId());
            System.out.println("Customer Name : "+c.getFname());
            System.out.println("Customer Surname : "+c.getLname());
            System.out.println("----------------------");
        }
    }

}






