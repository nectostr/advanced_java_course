//черновая версия!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
import java.util.LinkedHashMap;
import java.util.Map;

class LFU_сache {

    class CacheEntry
    {
        private String data;
        private int frequency;
        private CacheEntry()
        {}

        public String getData() {
            return data;
        }
        public void setData(String data) {
            this.data = data;
        }

        public int getFrequency() {
            return frequency;
        }
        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

    }

    private static int initialCapacity = 10;

    private static LinkedHashMap<Integer, CacheEntry> cacheMap = new LinkedHashMap<Integer, CacheEntry>();


    public void LFUCache(int initialCapacity)
    {
        this.initialCapacity = initialCapacity;
    }

    public void addCacheEntry(int key, String data)
    {
        if(!isFull())
        {
            CacheEntry temp = new CacheEntry();
            temp.setData(data);
            temp.setFrequency(0);

            cacheMap.put(key, temp);
        }
        else
        {
            int entryKeyToBeRemoved = getLFUKey();
            cacheMap.remove(entryKeyToBeRemoved);

            CacheEntry temp = new CacheEntry();
            temp.setData(data);
            temp.setFrequency(0);

            cacheMap.put(key, temp);
        }
    }

    public int getLFUKey()
    {
        int key = 0;
        int minFreq = Integer.MAX_VALUE;

        for(Map.Entry<Integer, CacheEntry> entry : cacheMap.entrySet())
        {
            if(minFreq > entry.getValue().frequency)
            {
                key = entry.getKey();
                minFreq = entry.getValue().frequency;
            }
        }

        return key;
    }

    public String getCacheEntry(int key)
    {
        if(cacheMap.containsKey(key))
        {
            CacheEntry temp = cacheMap.get(key);
            temp.frequency++;
            cacheMap.put(key, temp);
            return temp.data;
        }
        return null;
    }

    public static boolean isFull()
    {
        if(cacheMap.size() == initialCapacity)
            return true;

        return false;
    }
}
//черновая версия!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!