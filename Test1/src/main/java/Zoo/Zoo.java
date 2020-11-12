package Zoo;
import java.util.ArrayList;
import java.util.List;

import Exception.AnimalDansMauvaisSecteurException;
import Exception.LimiteVisiteurException;
import Zoo.Animal.TypeAnimal;

public class Zoo {


	private final int NB_MAX_VISITEURS=15;
	private int visiteurs;
	private List<Secteur> secteursAnimaux;
	
	public Zoo() {
		this.visiteurs=0;
		this.secteursAnimaux=new ArrayList<Secteur>();
	}
	
	public void  ajouterSecteur(TypeAnimal type) {
		this.secteursAnimaux.add(new Secteur(type));
	}

	public void  nouveauVisiteur() throws LimiteVisiteurException {
		if(visiteurs==getLimiteVisiteur()) throw new LimiteVisiteurException("Nombre de visiteurs maximum atteint");
		this.visiteurs+=1;
	}
	
	public int getLimiteVisiteur() {
		return NB_MAX_VISITEURS*secteursAnimaux.size();
	}
	
	public void nouvelAnimal(Animal animal) throws AnimalDansMauvaisSecteurException {
		Secteur secteur=null;
		for(Secteur s:secteursAnimaux) {
			if(s.obtenirType()==animal.typeAnimal) secteur=s ;
		}
		if(secteur==null) throw new AnimalDansMauvaisSecteurException("Animal dans mauvais secteur");
		
		secteur.ajouterAnimal(animal);
		
	}
	
	
	public int nombreAnimaux() {
		int n=0;
		for(Secteur s:this.secteursAnimaux) {
			n+=s.getNombreAnimaux();
		}
		return n;
	}
}
