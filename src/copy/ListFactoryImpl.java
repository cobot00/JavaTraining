package copy;

import java.util.*;

/**
 * 渡されたリストを基に文脈に応じたリストを生成するUtilityクラス。
 * 
 */
public class ListFactoryImpl implements IListFactory {

    /**
     * 渡されたリストと同一のインスタンスを要素として持つリストを生成して返す。
     * 
     * @param list
     * @return
     */
    public List<MutableEntity> createSameList(List<MutableEntity> list) {
        List<MutableEntity> result = new ArrayList<MutableEntity>();
        for (MutableEntity each : list) {
            result.add(each);
        }

        return result;
    }

    /**
     * 渡されたリストの要素のクローンを持つリストを生成して返す。
     * 
     * @param list
     * @return
     */
    public List<MutableEntity> createCloneList(List<MutableEntity> list) {
        List<MutableEntity> result = new ArrayList<MutableEntity>();
        for (MutableEntity each : list) {
            result.add(createClone(each));
        }

        return result;
    }

    /**
     * 指定されたインデックスまでの要素を含むリストを生成して返す。
     * 
     * @param list
     * @param toIndex
     * @return
     */
    public List<MutableEntity> createPartialList(List<MutableEntity> list, int toIndex) {
        if (toIndex < 0 || toIndex >= list.size()) {
            throw new IllegalArgumentException();
        }

        List<MutableEntity> result = new ArrayList<MutableEntity>();
        for (int i = 0; i <= toIndex; i++) {
            result.add(list.get(i));
        }

        return result;
    }

    private MutableEntity createClone(MutableEntity target) {
        MutableEntity result = new MutableEntity(target.getId());
        result.setMutableValue(target.getMutableValue());
        return result;
    }

    /**
     * 渡された2つの文字列リストから共通の文字列を抽出して返す。
     * 共通の文字列が存在しない場合は空のリストを生成して返す。
     * なお、渡されたリストは昇順にソートされている。
     * 
     * ex.
     * listA: [a, b, c, f, g, i, j]、listB: [b, d, g, h, i]
     * -> return [b, g, i]
     * 
     * ※処理速度を考慮しなければ7行以内で実装可能
     * 
     * @param listA
     * @param listB
     * @return
     */
    public List<String> findSameString(List<String> listA, List<String> listB) {
        List<String> result = new ArrayList<String>();
        for (String each : listA) {
            if (listB.contains(each)) {
                result.add(each);
            }
        }
        return result;
    }

    /**
     * 高速マッチング処理版の実装例
     * 
     */
    public List<String> findSameStringFast(List<String> listA, List<String> listB) {
        // より要素数の少ないほうを主リストに指定する
        if (listA.size() > listB.size()) {
            return matchList(listB, listA);
        }

        return matchList(listA, listB);
    }

    private static final int COMPARE_MATCH = 0;
    private static final int COMPARE_LEFT_HIGH = 1;

    private List<String> matchList(List<String> mainList, List<String> subList) {
        final List<String> result = new ArrayList<String>();

        int indexMain = 0;
        int indexSub = 0;

        while (indexMain < mainList.size() && indexSub < subList.size()) {
            final int compareResult = mainList.get(indexMain).compareTo(subList.get(indexSub));
            if (compareResult == COMPARE_MATCH) {
                // キーが等しい場合は結果リストに追加し、両方のリストのインデックスを進める
                result.add(mainList.get(indexMain));
                indexMain++;
                indexSub++;
            } else if (compareResult >= COMPARE_LEFT_HIGH) {
                // サブリストのインデックスを進める
                indexSub++;
            } else {
                // メインリストのインデックスを進める
                indexMain++;
            }
        }

        return result;
    }
}
