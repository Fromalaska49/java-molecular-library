public class Untitled{
	
	public static void main(String[] args){
		String chemicalEquation = "NaCl2";
		Molecule molecule = null;
		try {
			molecule = new Molecule(chemicalEquation);
		} catch (MoleculeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(molecule.getFormula());
		} catch (MoleculeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}