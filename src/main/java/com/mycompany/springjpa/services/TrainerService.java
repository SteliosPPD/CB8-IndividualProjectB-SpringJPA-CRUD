/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springjpa.services;

import com.mycompany.springjpa.dao.TrainerDao;
import com.mycompany.springjpa.entities.Trainer;
import java.util.List;

/**
 *
 * @author stpap
 */
public class TrainerService {
    
    TrainerDao tDao = new TrainerDao();
    
    public List<Trainer> getTrainers(){
        
        List<Trainer> trainers = tDao.getAllTrainers();
        return trainers;
    }
    
    public int InsertTrainer(Trainer tr) {
        
        int id = tDao.InsertTrainer(tr);
        return id;  
}
    
    public boolean DeleteTrainer(int tid) {
        
        if (tDao.deleteTrainer(tid)) return true;
        
        return false;  
}
    
    public boolean UpdateTrainer(int tid, String firstname, String lastname, String subject) {
        
        if (tDao.updateTrainer(tid, firstname, lastname, subject)) return true;
        
        return false;  
}
    
}
