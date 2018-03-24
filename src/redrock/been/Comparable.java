package redrock.been;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface Comparable {
    int size();

    boolean isEmpty();

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    Object get(Object key);

    Object put(String key, Object value);

    Object remove(Object key);

    void putAll(Map<? extends String, ?> m);

    void clear();

    Set<String> keySet();

    Collection<Object> values();

    Set<Map.Entry<String, Object>> entrySet();

    int compareTo(Object o);
}
