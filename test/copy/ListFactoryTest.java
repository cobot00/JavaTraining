package copy;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class ListFactoryTest {

    private final static int LIST_SIZE = 10;

    private List<MutableEntity> targetList;

    @Before
    public void setUp() throws Exception {
        targetList = new ArrayList<MutableEntity>();

        for (int i = 1; i <= LIST_SIZE; i++) {
            MutableEntity entity = new MutableEntity(i);
            entity.setMutableValue(i * 10);
            targetList.add(entity);
        }
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

    public static void assertThatWrapper(String actual, String expected) {
        assertThat(actual, is(expected));
    }

    /**
     * 管理用のユーティリティメソッド。
     * 
     * @return
     */
    private IListFactory createInstance() {
        // return new ListFactory();
        return new ListFactoryImpl();
    }

    /* 以降が検証用のコード */

    @Test
    public void createSameList() {
        IListFactory listFactory = createInstance();
        List<MutableEntity> result = listFactory.createSameList(targetList);

        // 生成されたリストが異なるインスタンスであるかの確認
        assertNotSame(result, targetList);

        // 要素数の確認
        assertThatWrapper(result.size(), LIST_SIZE);

        // リストの要素が同一のインスタンスであることを確認する
        for (int i = 0; i < result.size(); i++) {
            assertSame(result.get(i), targetList.get(i));
            assertThatWrapper(result.get(i).getId(), targetList.get(i).getId());
            assertThatWrapper(result.get(i).getMutableValue(), targetList
                    .get(i).getMutableValue());
        }
    }

    @Test
    public void createCloneList() {
        IListFactory listFactory = createInstance();
        List<MutableEntity> result = listFactory.createCloneList(targetList);

        // 生成されたリストが異なるインスタンスであるかの確認
        assertNotSame(result, targetList);

        // 要素数の確認
        assertThatWrapper(result.size(), LIST_SIZE);

        // リストの要素が異なるインスタンスであり、値が同じ事を確認する
        for (int i = 0; i < result.size(); i++) {
            assertNotSame(result.get(i), targetList.get(i));
            assertThatWrapper(result.get(i).getId(), targetList.get(i).getId());
            assertThatWrapper(result.get(i).getMutableValue(), targetList
                    .get(i).getMutableValue());
        }
    }

    @Test
    public void createPartialList1() {
        createPartialList(1);
    }

    @Test
    public void createPartialList7() {
        createPartialList(7);
    }

    @Test
    public void createPartialList10() {
        createPartialList(LIST_SIZE);
    }

    public void createPartialList(int copySize) {
        IListFactory listFactory = createInstance();
        List<MutableEntity> result = listFactory.createPartialList(targetList,
                copySize - 1);

        // 生成されたリストが異なるインスタンスであるかの確認
        assertNotSame(result, targetList);

        // 要素数の確認
        assertThatWrapper(result.size(), copySize);

        // 同一のインスタンスであることを確認する
        for (int i = 0; i < result.size(); i++) {
            assertSame(result.get(i), targetList.get(i));
            assertThatWrapper(result.get(i).getId(), targetList.get(i).getId());
            assertThatWrapper(result.get(i).getMutableValue(), targetList
                    .get(i).getMutableValue());
        }
    }

    @Test
    public void createPartialListException() {
        IListFactory listFactory = createInstance();

        // 例外処理の確認
        try {
            listFactory.createPartialList(targetList, -1);
            fail();
        } catch (IllegalArgumentException e) {
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        try {
            listFactory.createPartialList(targetList, targetList.size());
            fail();
        } catch (IllegalArgumentException e) {
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void findSameString2by3() {
        IListFactory listFactory = createInstance();

        List<String> listA = createSampleList(10, 2);
        List<String> listB = createSampleList(10, 3);

        Collections.sort(listA);
        Collections.sort(listB);

        List<String> actual = listFactory.findSameString(listA, listB);

        List<String> expected = new ArrayList<String>();
        expected.add("TEST6");
        expected.add("TEST12");
        expected.add("TEST18");

        Collections.sort(expected); // Stringの昇順でソートしておかないと直感的なソート順とのgapにはまる

        // 要素数の確認
        assertThatWrapper(actual.size(), expected.size());

        // リストの要素の値が同じ事を確認する
        for (int i = 0; i < actual.size(); i++) {
            assertThatWrapper(actual.get(i), expected.get(i));
        }
    }

    @Test
    public void findSameString3by5() {
        IListFactory listFactory = createInstance();

        List<String> listA = createSampleList(20, 3);
        List<String> listB = createSampleList(15, 5);

        Collections.sort(listA);
        Collections.sort(listB);

        List<String> actual = listFactory.findSameString(listA, listB);

        List<String> expected = new ArrayList<String>();
        expected.add("TEST15");
        expected.add("TEST30");
        expected.add("TEST45");
        expected.add("TEST60");

        Collections.sort(expected); // Stringの昇順でソートしておかないと直感的なソート順とのgapにはまる

        // 要素数の確認
        assertThatWrapper(actual.size(), expected.size());

        // リストの要素の値が同じ事を確認する
        for (int i = 0; i < actual.size(); i++) {
            assertThatWrapper(actual.get(i), expected.get(i));
        }
    }

    @Test
    public void findSameStringFirstMatch() {
        IListFactory listFactory = createInstance();

        /* 最初の要素のみがマッチするパターン */
        List<String> listA = new ArrayList<String>();
        listA.add("TEST00");
        listA.add("TEST01");

        List<String> listB = new ArrayList<String>();
        listB.add("TEST00");
        listB.add("TEST02");

        List<String> actual = listFactory.findSameString(listA, listB);

        List<String> expected = new ArrayList<String>();
        expected.add("TEST00");

        // 要素数の確認
        assertThatWrapper(actual.size(), expected.size());

        // リストの要素の値が同じ事を確認する
        for (int i = 0; i < actual.size(); i++) {
            assertThatWrapper(actual.get(i), expected.get(i));
        }
    }

    @Test
    public void findSameStringLastMatch() {
        IListFactory listFactory = createInstance();

        /* 最後の要素のみがマッチするパターン */
        List<String> listA = new ArrayList<String>();
        listA.add("TEST01");
        listA.add("TEST03");
        listA.add("TEST99");

        List<String> listB = new ArrayList<String>();
        listB.add("TEST02");
        listB.add("TEST04");
        listB.add("TEST99");

        List<String> actual = listFactory.findSameString(listA, listB);

        List<String> expected = new ArrayList<String>();
        expected.add("TEST99");

        // 要素数の確認
        assertThatWrapper(actual.size(), expected.size());

        // リストの要素の値が同じ事を確認する
        for (int i = 0; i < actual.size(); i++) {
            assertThatWrapper(actual.get(i), expected.get(i));
        }
    }

    /**
     * 結果が空リストになるケース。
     */
    @Test
    public void findSameStringNoResult() {
        IListFactory listFactory = createInstance();

        List<String> listA = createSampleList(5, 3);
        List<String> listB = createSampleList(10, 7);

        Collections.sort(listA);
        Collections.sort(listB);

        List<String> actual = listFactory.findSameString(listA, listB);

        // 要素数の確認
        assertThatWrapper(actual.size(), 0);

        /* 空リスト */
        List<String> actual2 = listFactory.findSameString(listA,
                new ArrayList<String>());

        // 要素数の確認
        assertThatWrapper(actual2.size(), 0);

        /* 空リスト */
        List<String> actual3 = listFactory.findSameString(
                new ArrayList<String>(), listB);

        // 要素数の確認
        assertThatWrapper(actual3.size(), 0);
    }

    /**
     * 一定の規則に従った要素を含む検証用のリストを生成します。
     * 
     * @param count
     * @param base
     * @return
     */
    private List<String> createSampleList(int count, int base) {
        List<String> result = new ArrayList<String>(count);

        int value = base;
        for (int i = 0; i < count; i++) {
            result.add(String.valueOf("TEST" + value));
            value += base;
        }

        return result;
    }
}
