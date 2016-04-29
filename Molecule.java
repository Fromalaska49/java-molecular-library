public class Molecule {

	private String[] elements;
	private int[] atomCount;
	
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
}