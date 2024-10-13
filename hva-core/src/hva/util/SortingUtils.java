package hva.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class SortingUtils {

    /**
     * Utility function to get a case-insensitive sorted collection from a map.
     *
     * @param <K> the type of the map's key
     * @param <V> the type of the map's value
     * @param map The map to be sorted
     * @return A collection of values sorted by keys in a case-insensitive manner
     */
    public static <K, V> Collection<V> getSortedCollection(Map<K, V> map) {
        // TreeMap with case-insensitive comparator for String keys
        Map<String, V> sortedMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String key1, String key2) {
                return key1.toLowerCase().compareTo(key2.toLowerCase());
            }
        });

        // Cast to String key and add all entries from the original map
        map.forEach((key, value) -> sortedMap.put(key.toString(), value));

        // Return the unmodifiable sorted collection of values
        return Collections.unmodifiableCollection(sortedMap.values());
    }
}
