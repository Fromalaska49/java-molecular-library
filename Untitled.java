public class Untitled{
	
	public static void main(String[] args){
		String chemicalEquation = "NaCl2";
		Molecule molecule = new Molecule(chemicalEquation);
		System.out.println(molecule.getFormula());
	}
}