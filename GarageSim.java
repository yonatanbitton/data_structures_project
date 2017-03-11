import java.util.LinkedList;
import java.util.List;

public class GarageSim{
	private Function funcMod;
	private int size;
    protected HTChaining TreatTable;
    protected HTChaining IDModTable;
    private int nextToTreatIndex;

	
	// The size should be N+1
	// The funcMod is a hash Function that we choose to be "x mod n+1" while x is the car ID
	public GarageSim(int size){
		this.size=size;
		funcMod=new funcMod(size);
		zeroFunc zeroFunc=new zeroFunc();
		HTChaining TreatTable = new HTChaining(zeroFunc, size);
		// In order for the IDModTable to be at prime size, and we assume that the number of cars <= 10000,
		// we choose the size of the IDModTable to be 10,007 which is the first prime number above 10,000
		HTChaining IDModTable = new HTChaining(funcMod, size);
		this.TreatTable=TreatTable;
		this.IDModTable=IDModTable;
		nextToTreatIndex=-1; // Empty garage
	}
	
	// While receiving a car ID - (x), we send with: key and data, while the key represents the ID, and the data represents the numberOfTreatments (at first - 0)
	// we send it to 1. TreatTable.insert, 2. IDModTable.insert 
	public void insert(Integer x){ 
		if (IDModTable.find(x)!=null) { System.out.println("Car "+x+" is already in"); return; }
		if (((List<HashObject>)TreatTable.hashTable[0]).isEmpty()) nextToTreatIndex=0;
		HashObject newObj=new HashObject(x, 0);
		TreatTable.insert(x, newObj);
		IDModTable.insert(x, newObj);
		System.out.println("Car "+x+" is inserted");
	}
	
	// 1. We approach to the TreatTable, find the car with the least amount of treatments, increase by one it's number of treatment,
	// and transfer it to the lower cell in the table, which represents all of the cars with min+1 number of treatments.
	// 2. We approach the IDModTable, find the car that was treated, and increase it's numberOfTreatments field by one.
	public void treat(){
		if (TreatTable.isEmpty()) { System.out.println("No cars to treat"); return; }
		// while (((List<HashObject>)(TreatTable.hashTable[i])).isEmpty()) i++;
		int i=nextToTreatIndex; // Initialize i to be the next to treat index - the first existing not empty LinkedList at TreatTable
		List<HashObject> list=(List<HashObject>) TreatTable.hashTable[i];
		HashObject car=list.get(0); // Gets the first car from the list
		list.remove(0); // Removes it from the list
		if (i+1 == TreatTable.hashTable.length) { System.out.println("Reached maximum number of treatments"); return; }
		List<HashObject> listToAdd=(List<HashObject>) TreatTable.hashTable[i+1];
		listToAdd.add(0, car); // Adds the car to the first place in the next list 
		if (list.isEmpty()) nextToTreatIndex=nextToTreatIndex+1;
		((HashObject)car.data).data=((Integer)((HashObject)car.data).data)+1;
		System.out.println("Car "+car.getKey()+" is moved to treatment "+((HashObject)car.data).data);
		}
		
	
	// This function finds the car in the IDModTable, and returns it's numberOfTreatments 
	public int times(Integer x){
		if (IDModTable.find(x)==null) { System.out.println ("There is no car "+x); return 0; } 
		System.out.println("Car "+x+" passed "+((Integer)((HashObject)IDModTable.find(x)).data)+" treatments");
		return ((Integer)((HashObject)IDModTable.find(x)).data);
	}
}
