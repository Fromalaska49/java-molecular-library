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
}