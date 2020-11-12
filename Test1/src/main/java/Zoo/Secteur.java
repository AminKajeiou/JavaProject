package Zoo;
import java.util.ArrayList;
import java.util.List;

import Exception.AnimalDansMauvaisSecteurException;
import Zoo.Animal.TypeAnimal;

public class Secteur {


	
	private TypeAnimal typeAnimauxDansSecteur; 
	private List<Animal> animauxDansSecteur;
	
	public Secteur(TypeAnimal type) {
		this.typeAnimauxDansSecteur=type;
		animauxDansSecteur=new ArrayList<Animal>();
	}
	
	public void  ajouterAnimal(Animal animal) throws AnimalDansMauvaisSecteurException {
		if(animal.getTypeAnimal() != typeAnimauxDansSecteur) throw new AnimalDansMauvaisSecteurException("Animal dans mauvais secteur");
		this.animauxDansSecteur.add(animal);
	}
	
	public int getNombreAnimaux() {
		return this.animauxDansSecteur.size(); 	
	}
	
	public TypeAnimal obtenirType() {
		return typeAnimauxDansSecteur;
	}
}
