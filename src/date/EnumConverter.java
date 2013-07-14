package date;

import java.util.*;

public class EnumConverter<K, V extends Convertable<K>> {

    private Map<K, V> map = new HashMap<K, V>();

    public EnumConverter(V[] values) {
        for (V value: values) {
            map.put(value.key(), value);
        }
    }

    public V convert(K key) {
        return map.get(key);
    }

}
