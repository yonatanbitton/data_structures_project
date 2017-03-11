public class HTDoubleHashing extends OpenAddressingBGU {
	private Function stepFunc;
	
	public HTDoubleHashing(Function hashFunction, Function stepFunction, int size) {
		super(hashFunction, size);
		this.stepFunc=stepFunction;
	}

	public void insert(Object key, Object data) {
		if (elementsAtTable<hashTable.length){
			int arrayIndex = hashFunction.h(key);
			HashObject o=new HashObject(key, data);
			if (hashTable[arrayIndex]==null || hashTable[arrayIndex].equals("$")){
				hashTable[arrayIndex]=o;
				elementsAtTable++;
			}
			else {
				while (hashTable[arrayIndex]!=null && (!(hashTable[arrayIndex]).equals("$"))){
					arrayIndex=arrayIndex+stepFunc.h(key);
					if (arrayIndex>=hashTable.length) arrayIndex=arrayIndex-hashTable.length;
				}
				hashTable[arrayIndex]=o;
				elementsAtTable++;

			}
		}
	}

	public void delete(Object key) {
		if (!(isEmpty())){
			int numOfChecks=0;
			int arrayIndex = hashFunction.h(key);
			while (hashTable[arrayIndex]!=null && numOfChecks<hashTable.length){
				if (!(hashTable[arrayIndex].equals("$"))){
					if (((HashObject)hashTable[arrayIndex]).getKey().equals(key)){
						hashTable[arrayIndex]="$";
						elementsAtTable--;
						break;
					}
				}
				arrayIndex=arrayIndex+stepFunc.h(key);
				if (arrayIndex>=hashTable.length) arrayIndex=arrayIndex-hashTable.length;
				numOfChecks++;
			}
		}	
	}

	public boolean isEmpty() {
		return (elementsAtTable==0);
	}

	public Object find(Object key) {
		if (!(isEmpty())){
			int arrayIndex = hashFunction.h(key);
			if (hashTable[arrayIndex]==null || hashTable[arrayIndex].equals("$")) return null; 
			if (((HashObject)hashTable[arrayIndex]).getKey().equals(key))
				return ((HashObject)hashTable[arrayIndex]).getData();
			else {
				int numOfChecks=0;
				while (hashTable[arrayIndex]!=null && numOfChecks<hashTable.length){
					arrayIndex=arrayIndex+stepFunc.h(key);
					if (arrayIndex>=hashTable.length) arrayIndex=arrayIndex-hashTable.length;
					if (hashTable[arrayIndex]!=null && (!(hashTable[arrayIndex].equals("$"))) && ((HashObject)hashTable[arrayIndex]).getKey().equals(key))
						return ((HashObject)hashTable[arrayIndex]).getData();
					numOfChecks++;
				}
			}
		}
		return null;
	}
	
	
}