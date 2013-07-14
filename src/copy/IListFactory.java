package copy;

import java.util.*;

public interface IListFactory {

    public List<MutableEntity> createSameList(List<MutableEntity> list);

    public List<MutableEntity> createCloneList(List<MutableEntity> list);

    public List<MutableEntity> createPartialList(List<MutableEntity> list,
            int toIndex);

    public List<String> findSameString(List<String> listA, List<String> listB);
}