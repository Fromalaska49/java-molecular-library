public class Molecule {

	private String[] elements;
	private int[] atomCount;
	private int moleculeCount;
	
	public Molecule(String molecule){
		
	}
	
	public int getAtomCount(String element){
		int index = getElementIndex(element);
		if(index > 0){
			return this.atomCount[index];
		}
		else{
			//element not found
			return -1;
		}
	}
	
	private int getElementIndex(String element){
		int index;
		for(index = 0; index < this.elements.length; index++){
			if(this.elements[index].equals(element)){
				return index;
			}
		}
		//element not found
		return -1;
	}
	
	public String getNextElement(String molecule){
		//assumes that the input has already been validated
	}
	
	/*
	 * Expects that the molecule has already been simplified
	 */
	public boolean isValidMolecule(String molecule){
		//molecule = simplifyMolecule(molecule);
		int index = 0;
		while(index < molecule.length()){
			if(Character.isUpperCase(molecule.charAt(index))){
				index++;
				if(Character.isLowerCase(molecule.charAt(index))){
					//second letter of element detected
					index++;
				}
			}
			else{
				//No element detected
				System.out.println("Error: no element detected");
				return false;
			}
			while(Character.isDigit(molecule.charAt(index))){
				//a digit has been found
				index++;
			}
		}
		return true;
	}
	
	/*
	 * All non alphanumeric characters are stripped out
	 * so " (OH3+)(OH-) " would be simplified to "OH3OH"
	 */
	private String simplifyMolecule(String molecule){
		return molecule.replaceAll("[^A-Za-z0-9]", "");
	}
}

