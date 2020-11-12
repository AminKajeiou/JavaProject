package Zoo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Exception.AnimalDansMauvaisSecteurException;
import Exception.LimiteVisiteurException;
import Zoo.Animal.TypeAnimal;


public class TestApp {
	
	@Test
	public void testNombreVisiteurOK() {
		Zoo z=new Zoo();
		z.ajouterSecteur(TypeAnimal.CHIEN);
		Throwable e=null;
		
		try {
			for (int i = 0; i < 15; i++) {
				z.nouveauVisiteur();
			}
		}
		catch(Throwable exception){
			e=exception;
		}
		assertFalse(e instanceof LimiteVisiteurException);

	}
	
	@Test
	public void testNombreVisiteurKO() {
		Zoo z=new Zoo();
		z.ajouterSecteur(TypeAnimal.CHIEN);
		Throwable e=null;
		
		try {
			for (int i = 0; i < 18; i++) {
				z.nouveauVisiteur();
			}
		}
		catch(Throwable exception){
			e=exception;
		}
		assertTrue(e instanceof LimiteVisiteurException);

	}
	
	@Test
	public void testAnimaux() {
		Zoo z=new Zoo();
		z.ajouterSecteur(TypeAnimal.CHAT);
		Throwable e=null;
		
		try {
			z.nouvelAnimal(new Chien("chien"));
			
		}
		catch(AnimalDansMauvaisSecteurException exception) {
			e=exception;
		}
		assertTrue(e instanceof AnimalDansMauvaisSecteurException);
		//assertEquals(1,z.nombreAnimaux());
	}

}
