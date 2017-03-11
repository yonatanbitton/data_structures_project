/**
 * Created by Dolav on 03/09/2015.
 */
public class HashObject {
    Object key;
    Object data;
    public HashObject(Object key,Object data){
        this.key = key;
        this.data = data;
    }

    public Object getKey() {
        return key;
    }
    public Object getData() {
        return data;
    }

    @Override
    public boolean equals(Object obj) {
        return key.equals(obj);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
