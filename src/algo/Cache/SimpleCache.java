package algo.Cache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleCache extends LinkedHashMap{


    private int size=0;
    private Map<String, String > cacheMem;

    public SimpleCache(int size){
        this.size=size;
        this.cacheMem =
                new LinkedHashMap<String, String>(size, 0.75f, true) {
                    @Override
                    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > size;
            }
                };
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String get(String key) {
        return this.cacheMem.getOrDefault(key, "NULL");
    }

    public void put(String key, String value) {
        this.cacheMem.put(key, value);
    }

    String Get(String key){
        // As key accessed to remove and add back as it become recently used
        if (cacheMem.containsKey(key)){
            String value = cacheMem.get(key);
            cacheMem.remove(key);
            this.Put(key, value);
            return value;
        }else{
            return null;
        }
    }

    void Put(String key , String value )  {
        // if key exist then remove  else remove first as exceeding size
        if (cacheMem.containsKey(key)){
            cacheMem.remove(key);
        }else {
            if (this.cacheMem.size() == this.size()){
                Iterator it= this.cacheMem.keySet().iterator();
                it.next();
                it.remove();
            }
        }
        //  Add the key (even existing one  needs to again as it accessed recently)
        cacheMem.put(key,value);
        System.out.println (cacheMem.size());

    }

    public static void main(String[] args) {
        SimpleCache cache= new SimpleCache(2);

        System.out.println("Cache size"+ cache.size);
        System.out.println ("hashmap size "+cache.cacheMem.size());



            cache.put("A", "B");
            cache.put("C", "D");

//            cache.put("c", "G");


        System.out.println (cache.get("A"));//  <- "B"
        System.out.println (cache.get("C")); //<-  D
        cache.put("E", "F");                   // add e and remove A
        System.out.println (cache.get("A"));//  <- Null
        System.out.println (cache.get("C")); //<- D
        System.out.println (cache.get("E"));//  <- "F"
        System.out.println (cache.cacheMem.size());

    }



}
