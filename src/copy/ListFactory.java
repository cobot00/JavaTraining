package copy;

import java.util.*;

/**
 * 渡されたリストを基に文脈に応じたリストを生成するUtilityクラス。
 * 
 */
public class ListFactory implements IListFactory {

    /**
     * 渡されたリストと同一のインスタンスを要素として持つリストを生成して返す。
     * 
     * @param list
     * @return
     */
    public List<MutableEntity> createSameList(List<MutableEntity> list) {
        return null;
    }

    /**
     * 渡されたリストの要素のcloneを持つリストを生成して返す。
     * 
     * @param list
     * @return
     */
    public List<MutableEntity> createCloneList(List<MutableEntity> list) {
        return null;
    }

    /**
     * 指定されたインデックスまでの要素を含むリストを生成して返す。
     * リストの範囲外のインデックスが渡された場合はIllegalArgumentExceptionを生成する。
     * 
     * @param list
     * @param toIndex
     * @return
     */
    public List<MutableEntity> createPartialList(List<MutableEntity> list, int toIndex) {
        return null;
    }

    /**
     * 渡された2つの文字列リストから共通の文字列を抽出して返す。
     * 返される文字列リストは昇順でソートされている。
     * 共通の文字列が存在しない場合は空のリストを生成して返す。
     * なお、渡されるリストは両方とも昇順にソートされている。
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
        return null;
    }

    public List<String> findSameStringFast(List<String> listA, List<String> listB) {
        return null;
    }
}
