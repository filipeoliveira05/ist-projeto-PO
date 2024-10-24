package hva.employee;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Collection;
import java.util.Collections;

public abstract class Employee<T> implements Serializable {

    /**
     * Serial number for serialization.
     */
    @Serial
    private static final long serialVersionUID = 202410081520L;

    private String id;
    private String name;
    private Map<String, T> responsibilities;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
        this.responsibilities = new HashMap<>();
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void addResponsibility(String key, T responsibility) {
        responsibilities.put(key, responsibility);
    }


    public void removeResponsibility(String key) {
        responsibilities.remove(key);
    }


    public Collection<T> getResponsibilities() {
        Map<String, T> sortedResponsibilities = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        sortedResponsibilities.putAll(responsibilities);
        return Collections.unmodifiableCollection(sortedResponsibilities.values());
    }

    public String getResponsibilitiesAsString() {
        Map<String, T> sortedResponsibilities = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        sortedResponsibilities.putAll(responsibilities);  
        return String.join(",", sortedResponsibilities.keySet());
    }
    

    public abstract boolean isCaretaker();
    public abstract boolean isVet();

    public abstract String getType();
}