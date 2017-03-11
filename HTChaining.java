import java.util.LinkedList;
import java.util.List;

public class HTChaining extends HashTableBGU {

	public HTChaining(Function hashFunction, int size) { 
		super(hashFunction, size);
		for (int i=0; i<hashTable.length; i++){
			hashTable[i]=new LinkedList<HashObject>();
		}
	}

	public void insert(Object key, Object data) { //Insert a hash object to the linked list in place hashTable[arrayIndex]
			int arrayIndex = hashFunction.h(key);
			HashObject o=new HashObject (key,data);//Creating the hash object that will be inserted
			List<HashObject> list=(List<HashObject>) hashTable[arrayIndex];
			((LinkedList<HashObject>) list).addFirst(o);
			elementsAtTable++; //Increase the number of elements in table by 1
	}	
	

	public void delete(Object key) {
		int arrayIndex = hashFunction.h(key);
		List<HashObject> list=(List<HashObject>) hashTable[arrayIndex];
		int i=0;
		while (i<list.size()){ // Iterate on the list in place hashTable[arrayIndex] up to list.size
			if (((HashObject)list.get(i)).getKey().equals(key)) { // If the keys equals - remove the link at i
				list.remove(i);
				elementsAtTable--;
				return;
			}
			i++;
		}	
	}
	
	public boolean isEmpty() { 
		return (elementsAtTable==0);
	}

	public Object find(Object key) {
		int arrayIndex = hashFunction.h(key);
			List<HashObject> list=(List<HashObject>) hashTable[arrayIndex];
			int i=0;
			while (i<list.size()){ //Iterate on the list in place hashTable[arrayIndex] up to list.size
				if (((HashObject)list.get(i)).getKey().equals(key)) // If the keys equals - return (link at i).data
					return ((HashObject)list.get(i)).getData();
				i++;
			}
	return null;
	}
}
