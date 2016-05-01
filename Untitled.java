public class Untitled{
	
	public static void main(String[] args){
		String chemicalEquation = "NaCl2";
		String molecule = simplifyMolecule(chemicalEquation);
		if(isValidMolecule(molecule)){
			//process molecule
			
		}
		else{
			System.out.println("Error: invalid molecule: "+molecule);
		}
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