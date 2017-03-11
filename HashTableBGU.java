public abstract class HashTableBGU {
    protected Function hashFunction;
    protected Object[] hashTable;
    protected int elementsAtTable=0;
    public HashTableBGU(Function hashFunction,int size){
        this.hashFunction = hashFunction;
        this.hashTable = new Object[size];
    }
    public abstract void insert(Object key ,Object data);
    public abstract void delete(Object key);
    public abstract boolean isEmpty();
    public abstract Object find(Object key);
    public Object[] getHashTable(){
        return hashTable;
    }
}
