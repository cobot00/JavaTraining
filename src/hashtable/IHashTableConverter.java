package hashtable;

import java.util.*;

public interface IHashTableConverter {

    public Map<String, StringKeyEntity> convert(List<StringKeyEntity> list);

    public Map<String, List<StringKeyEntity>> convertAsContainingList(List<StringKeyEntity> list);

}