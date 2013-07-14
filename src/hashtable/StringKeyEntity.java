package hashtable;

/**
 * StringをハッシュキーとしたEntity。
 * 
 */
public class StringKeyEntity {

    private final String key;
    private final int value;

    public StringKeyEntity(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        StringKeyEntity otherOne = (StringKeyEntity)other;
        return (getKey().equals(otherOne.getKey()) && getValue() == otherOne.getValue());
    }

    @Override
    public int hashCode() {
        return getKey().hashCode();
    }
}
