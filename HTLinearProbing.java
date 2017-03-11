public class HTLinearProbing extends OpenAddressingBGU {

	
	public HTLinearProbing(Function hashFunction, int size) {
		super(hashFunction, size);
		}

	public void insert(Object key, Object data) {
		if (elementsAtTable<hashTable.length){
			int arrayIndex = hashFunction.h(key);
			int i=arrayIndex;
			HashObject o=new HashObject(key, data);
			while (hashTable[i]!=null && (!(hashTable[i]).equals("$"))){
				i++;
				if (i==hashTable.length) i=0;
			}
			hashTable[i]=o;
			elementsAtTable++;
		}
	}

	public void delete(Object key) {
		int arrayIndex = hashFunction.h(key);
		int i=arrayIndex;
		int numOfChecks=0;
		while (hashTable[i]!=null && numOfChecks<hashTable.length && (!(hashTable[i]).equals("$"))){
			if(((HashObject) hashTable[i]).getKey().equals(key)){
				hashTable[i]="$"; // A unique symbol to avoid holes at the array that can cause a false search
				elementsAtTable--;
				break;
			}
				i++;	
				if (i==hashTable.length) i=0;	
			}
	}

	public boolean isEmpty() {
		return (elementsAtTable==0);
	}

	public Object find(Object key) {
		if (!(isEmpty())){
			int arrayIndex = hashFunction.h(key);
			int i=arrayIndex;
			int numOfChecks=0;
			while (hashTable[i]!=null&&numOfChecks<hashTable.length){
				if (((!(hashTable[i].equals("$")) &&((HashObject) hashTable[i]).getKey().equals(key)))){
					return ((HashObject) hashTable[i]).getData();
				}
					i++;	
					if (i==hashTable.length) i=0;	
			}
		}
		return null;
	}
}
