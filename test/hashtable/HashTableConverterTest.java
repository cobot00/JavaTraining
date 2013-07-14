package hashtable;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class HashTableConverterTest {

    public HashTableConverterTest() {
        //
    }

    /**
     * assertThatのユーティリティラッパーメソッド。
     * 
     * @param actual
     * @param expected
     */
    public static void assertThatWrapper(int actual, int expected) {
        assertThat(Integer.valueOf(actual), is(Integer.valueOf(expected)));
    }

    /**
     * 管理用のユーティリティメソッド。
     * 
     * @return
     */
    private IHashTableConverter createInstance() {
        return new HashTableConverter();
        // return new HashTableConverterImpl();
    }

    @Test
    public void convert() {
        // テスト用のリストの生成
        List<StringKeyEntity> targetList = new ArrayList<StringKeyEntity>();
        targetList.add(new StringKeyEntity("A001", 1));
        targetList.add(new StringKeyEntity("A002", 2));
        targetList.add(new StringKeyEntity("A003", 3));
        targetList.add(new StringKeyEntity("B001", 11));
        targetList.add(new StringKeyEntity("B002", 12));
        targetList.add(new StringKeyEntity("C001", 21));
        targetList.add(new StringKeyEntity("C005", 25));

        IHashTableConverter converter = createInstance();
        Map<String, StringKeyEntity> result = converter.convert(targetList);

        for (StringKeyEntity each : targetList) {
            StringKeyEntity entity = result.get(each.getKey());

            // 対象の要素が存在するかの確認
            assertNotNull(entity);

            // 同一インスタンスであることの確認
            assertSame(entity, each);
        }
    }

    @Test
    public void convertIrregular() {
        // テスト用のリストの生成
        List<StringKeyEntity> targetList = new ArrayList<StringKeyEntity>();
        targetList.add(new StringKeyEntity("A001", 1));

        IHashTableConverter converter = createInstance();
        Map<String, StringKeyEntity> result = converter.convert(targetList);

        for (StringKeyEntity each : targetList) {
            StringKeyEntity entity = result.get(each.getKey());

            // 対象の要素が存在するかの確認
            assertNotNull(entity);

            // 同一インスタンスであることの確認
            assertSame(entity, each);
        }
    }

    @Test
    public void convertAsContainingList() {
        // テスト用のリストの生成
        List<StringKeyEntity> targetList = new ArrayList<StringKeyEntity>();
        targetList.add(new StringKeyEntity("A", 1));
        targetList.add(new StringKeyEntity("A", 2));
        targetList.add(new StringKeyEntity("A", 3));
        targetList.add(new StringKeyEntity("B", 1));
        targetList.add(new StringKeyEntity("B", 2));
        targetList.add(new StringKeyEntity("C", 1));
        targetList.add(new StringKeyEntity("C", 2));
        targetList.add(new StringKeyEntity("D", 1));
        targetList.add(new StringKeyEntity("D", 2));
        targetList.add(new StringKeyEntity("E", 1));

        IHashTableConverter converter = createInstance();
        Map<String, List<StringKeyEntity>> result = converter
                .convertAsContainingList(targetList);

        for (StringKeyEntity each : targetList) {
            List<StringKeyEntity> actualList = result.get(each.getKey());

            // 対象のリストが存在するかの確認
            assertNotNull(actualList);

            List<StringKeyEntity> expectedList = createSubList(targetList,
                    each.getKey());

            // 件数比較
            assertThatWrapper(actualList.size(), expectedList.size());

            // 値の比較
            for (int i = 0; i < expectedList.size(); i++) {
                assertThat(actualList.get(i).getKey(), is(expectedList.get(i)
                        .getKey()));
                assertThatWrapper(actualList.get(i).getValue(), expectedList
                        .get(i).getValue());
            }
        }
    }

    private List<StringKeyEntity> createSubList(List<StringKeyEntity> list,
            String key) {
        List<StringKeyEntity> result = new ArrayList<StringKeyEntity>();
        for (StringKeyEntity entity : list) {
            if (entity.getKey().equals(key)) {
                result.add(entity);
            }
        }
        return result;
    }

    @Test
    public void convertAsContainingListIrregular() {
        // テスト用のリストの生成
        List<StringKeyEntity> targetList = new ArrayList<StringKeyEntity>();
        targetList.add(new StringKeyEntity("A", 1));

        IHashTableConverter converter = createInstance();
        Map<String, List<StringKeyEntity>> result = converter
                .convertAsContainingList(targetList);

        for (StringKeyEntity each : targetList) {
            List<StringKeyEntity> entityList = result.get(each.getKey());

            // 対象のリストが存在するかの確認
            assertNotNull(entityList);

            // 対象の要素がリスト内に存在するかの確認
            assertTrue(entityList.contains(each));
        }
    }
}