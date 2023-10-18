public class Entry<K,V>{
    
    private K key;
    private V value;

    public Entry(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    public K getKey()
    {
        return key;
    }

    public V getValue()
    {
        return value;
    }

    /* 
    public int compareTo(Entry<K,V> e)
    {
        int result = 0;

        return result;
    }
    */
    
}
