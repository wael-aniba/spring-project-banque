package edu.esprit.gestion.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.esprit.gestion.entities.Client;
import edu.esprit.gestion.entities.Compte;
import edu.esprit.gestion.entities.CompteCourant;
import edu.esprit.gestion.entities.CompteEpargne;
import edu.esprit.gestion.entities.Employe;
import edu.esprit.gestion.entities.Groupe;
import edu.esprit.gestion.service.IBanqueMetier;

public class Test {
	
	public static void main(String[] args) {
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		IBanqueMetier metier = (IBanqueMetier) ctx.getBean("metier");
		
		metier.addClient(new Client("CL1", "AD1"));
		metier.addClient(new Client("CL2", "AD2"));
		
		metier.addEmploye(new Employe("E1"), null);
		metier.addEmploye(new Employe("E2"), 1L);
		metier.addEmploye(new Employe("E3"), 2L);
		
		metier.addGroupe(new Groupe("G1"));
		metier.addGroupe(new Groupe("G2"));
		
		metier.addEmployeToGroupe(1L, 1L);
		metier.addEmployeToGroupe(2L, 2L);
		metier.addEmployeToGroupe(3L, 2L);
		
		metier.addCompte(new CompteCourant("CC1", new Date(), 9000.0, 8000.0), 1L, 2L);
		metier.addCompte(new CompteEpargne("CE1", new Date(), 40000.0, 5.5), 1L, 2L);
		
		metier.verser(5000.0, "CC1", 2L);
		metier.retirer(6000.0, "CC1", 2L);
		metier.virement(4000.0, "CC1", "CE1", 2L);
	}

}
