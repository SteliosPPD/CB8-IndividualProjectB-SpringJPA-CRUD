package com.mycompany.springjpa.dao;

import com.mycompany.springjpa.entities.Trainer;
import com.mycompany.springjpa.util.HibernateUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.hibernate.Session;

public class TrainerDao {

    public int InsertTrainer(Trainer tr) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        int id = (Integer) session.save(tr);
        session.getTransaction().commit();
        session.close();
        return id;
    }
    
    public boolean deleteTrainer(int id) {
        boolean completed = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Trainer trainer = (Trainer) session.get(Trainer.class, id);
        session.delete(trainer);
        session.getTransaction().commit();
        completed = true;
        session.close();
        return completed;
    }
    
    public List<Trainer> getAllTrainers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        @SuppressWarnings("unchecked")
        List<Trainer> trainers = (List<Trainer>) session.createQuery("SELECT t FROM Trainer t").list();

        session.getTransaction().commit();
        session.close();
        return trainers;
    }
    
    public boolean updateTrainer(int id, String firstname, String lastname, String subject) {
        
        boolean completed = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Trainer trainer = (Trainer) session.get(Trainer.class, id);
        trainer.setFirstName(firstname);
        trainer.setLastName(lastname);
        trainer.setSubject(subject);
        //session.update(student);//No need to update manually as it will be updated automatically on transaction close.
        session.getTransaction().commit();
        completed = true;
        session.close();
        
        return completed;
    }
}
