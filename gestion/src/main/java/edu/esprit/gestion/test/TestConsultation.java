package edu.esprit.gestion.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.esprit.gestion.entities.Compte;
import edu.esprit.gestion.entities.Operation;
import edu.esprit.gestion.service.IBanqueMetier;

public class TestConsultation {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IBanqueMetier metier = (IBanqueMetier) ctx.getBean("metier");

		Compte cp = metier.consulterCompte("CC1");
		
		System.out.println("Solde: " + cp.getSolde());
		System.out.println("Date: " + cp.getDateCreation());
		System.out.println("Client: " + cp.getClient().getNomClient());
		System.out.println("Employe: " + cp.getEmploye().getNomEmploye());
		
		List<Operation> operations = metier.consulterOperationCompte("CC1");
		for (Operation operation : operations) {
			
			System.out.println("" + operation.getNumeroOperation() + ": " + operation.getClass().getSimpleName() + " " + operation.getMontant() + " by employe: " + operation.getEmploye().getCodeEmploye());
		}
		
		
	}
}
