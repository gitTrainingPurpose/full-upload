
public class ChemicalElement {
	private final int atomicNumber;
	private final String symbolicName, fullName;
	final static int [] metalElements = {13, 49, 50, 81, 82, 83, 113, 114, 115,116};
	
	public ChemicalElement(int atomicNumber, String symbolicName, String fullName) {
		super();
		this.atomicNumber = atomicNumber;
		this.symbolicName = symbolicName;
		this.fullName = fullName;
		
	}
	/*
	 * public void setAtomicNumber(int atomicNumber) { this.atomicNumber =
	 * atomicNumber; }
	 * 
	 * public void setSymbolicName(String symbolicName) { this.symbolicName =
	 * symbolicName; }
	 * 
	 * public void setFullName(String fullName) { this.fullName = fullName; }
	 */

	public String getSymbolicName() {
		return symbolicName;
	}
	public int getAtomicNumber() {
		return atomicNumber;
	}
	public String getFullName() {
		return fullName;
	}
	
//	public void setFullName(String fullName) {
//		this.fullName = fullName;
//	}
	public boolean isAlkaliMetal() {
//		3, 11, 19, 37, 55, or 87
		switch (this.atomicNumber) {
		case 3:
			return true;
//			break;
		case 11:
			return true;
		case 19:
			return true;
		case 37:
			return true;
		case 55:
			return true;
		case 87:
			return true;
		default:
			return false;
		}
//		return false;
	}
	public boolean isTransitionMetal() {
		return ((this.atomicNumber>=21 && this.atomicNumber <=31)|| (this.atomicNumber>=39 && this.atomicNumber <=48) || (this.atomicNumber>=72 && this.atomicNumber <=80) || (this.atomicNumber>=104 && this.atomicNumber <=112))?true:false;
	}
	public boolean isMetal() {
		for (int i = 0; i < metalElements.length; i++) {
			if(this.atomicNumber==metalElements[i])
				return true;
		}
		return false;
	}
    public boolean equals(Object o) {
    	ChemicalElement p1 = (ChemicalElement) o;
    	if(p1.atomicNumber == this.atomicNumber && p1.symbolicName == this.symbolicName && p1.fullName == this.fullName) {
    		return true;
    	}
    	return false;
    }
}
