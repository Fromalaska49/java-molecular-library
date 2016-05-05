public class Molecule {

	private String[] elements;
	private int[] atomCount;
	private int moleculeCount;
	
	public Molecule(String molecule) throws MoleculeException{
		molecule = simplifyMolecule(molecule);
		if(!isValidMolecule(molecule)){
			System.out.println("Error: invalid molecule");
			throw new MoleculeException("invalid molecule");
		}

		int index = 0;
		String element = null;
		String strAtomCount = null;
		int intAtomCount = 0;
		int atomCount = 0;
		//needs to be fixed
		this.moleculeCount = 1;
		while(index < molecule.length()){
			element = "";
			strAtomCount = "";
			intAtomCount = 0;
			atomCount = 1;
			if(Character.isUpperCase(molecule.charAt(index))){
				element += molecule.charAt(index);
				index++;
				if(Character.isLowerCase(molecule.charAt(index))){
					//second letter of element detected
					element += molecule.charAt(index);
					index++;
				}
			}
			else{
				//No element detected
				System.out.println("Error: no element detected");
				throw new MoleculeException("no element detected");
			}
			while(index < molecule.length() && Character.isDigit(molecule.charAt(index))){
				//a digit has been found
				strAtomCount += molecule.charAt(index);
				index++;
			}
			if(strAtomCount.length() > 0){
				intAtomCount = Integer.parseInt(strAtomCount);
			}
			if(intAtomCount > 0){
				atomCount = intAtomCount;
			}
			this.elements[this.elements.length] = element;
			this.atomCount[this.atomCount.length] = atomCount;
		}
	}
	
	public String getFormula() throws MoleculeException{
		if(this.atomCount.length != this.elements.length){
			System.out.println("Error: atomCount and elements are out of sync");
			throw new MoleculeException("atomCount and elements are out of sync");
		}
		String formula = "";
		for(int i = 0; i < this.atomCount.length; i++){
			formula += elements[i] + atomCount[i];
		}
		return formula;
	}
	
	public int getAtomCount(String element){
		int index = getElementIndex(element);
		if(index > 0) {
			return this.atomCount[index];
		}
		else {
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
	
	/*
	public String getNextElement(String molecule){
		//assumes that the input has already been validated
	}
	*/
	
	/*
	 * Expects that the molecule has already been simplified
	 */
	public boolean isValidMolecule(String molecule) throws MoleculeException{
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
				throw new MoleculeException("no element detected");
			}
			while(index < molecule.length() && Character.isDigit(molecule.charAt(index))){
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
	public String simplifyMolecule(String molecule){
		return molecule.replaceAll("[^A-Za-z0-9]", "");
	}
}

