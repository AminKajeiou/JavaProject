package Zoo;

public abstract class Animal {

	
	protected String nomAnimal;
	protected TypeAnimal typeAnimal;
	public enum TypeAnimal {
	    CHAT,
	    CHIEN,
	}
	
	public String getNomAnimal() {
		return this.nomAnimal;
	}

	public TypeAnimal getTypeAnimal() {
		return this.typeAnimal;
	}

}
