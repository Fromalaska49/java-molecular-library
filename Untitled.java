public class Untitled{
	
	public static void main(String[] args){
		String chemicalEquation = "CaCO3";
		Molecule calciumCarbonate = null;
		try {
			calciumCarbonate = new Molecule(chemicalEquation);
		} catch (MoleculeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(calciumCarbonate.getFormula());
		} catch (MoleculeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}