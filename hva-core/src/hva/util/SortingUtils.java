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
     * @param <V> the type of the map's value
     * @param map The map to be sorted, where keys are strings
     * @return A collection of values sorted by keys in a case-insensitive manner
     */
    public <V> Collection<V> getSortedCollection(Map<String, V> map) {
        Map<String, V> sortedMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        sortedMap.putAll(map);
        return Collections.unmodifiableCollection(sortedMap.values());
    }
}
