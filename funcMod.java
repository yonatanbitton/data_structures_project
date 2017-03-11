public class funcMod implements Function {
	int size;

	// The constructor receives the size of a data structure
	public funcMod(int size){
		this.size=size;
	}

	// This function returns a number from 0 to size-1
	public int h(Object x) {
		return (Integer) x % size;
	}

}
