package hashtable;

import java.util.*;

/**
 * 数学や歴史のあるプログラミング言語において「Map」は
 * ある集合に演算を施し、異なる集合(写像)に変換する操作を指す。
 * Javaで任意の要素の集合を「Map」というキーワードで表現しているのは
 * 他のプログラミング言語の経験がある者にとっては奇異に感じられることがある。
 * ここではJavaのHashtable、HashMapクラスの内部実装の意味合いから
 * Hashtableという表現で統一しています。
 * なお、Mapインターフェースの実装クラスの1つであるTreeMapは
 * 木構造を利用して実装されており、ハッシュテーブルとは
 * 全く異なるアルゴリズムを用いるコレクションクラスになります。
 * 
 * ---> ハッシュテーブル、木構造についてはしっかりと理解しておくこと
 * 
 */

public class HashTableConverter implements IHashTableConverter {

    /**
     * EntityのListをMapに変換して返す。
     * 
     * e.g.
     * [(a, 1), (b, 2), (c, 3), (d, 1), (e,5)]
     * -> {(a, 1), (b, 2), (c,3), (d, 1), (e,5)}
     * 
     * (): Entity, []: List, {}: Map
     * 
     * @param list
     * @return
     */
    public Map<String, StringKeyEntity> convert(List<StringKeyEntity> list) {
        return null;
    }

    /**
     * EntityのListをEntityのkey値毎にグルーピングしたListに分割し、Mapに詰めて返す。
     * なお、渡されるリストは昇順にソートされているとみなしてよい。
     * 
     * e.g.
     * [(a, 1), (a,2), (b, 1), (c, 1), (c,2), (c,3)]
     * -> {[(a, 1), (a, 2)], [(b, 1)], [(c, 1), (c,2), (c,3)]}
     * 
     * (): Entity, []: List, {}: Map
     * 
     * @param list
     * @return
     */
    public Map<String, List<StringKeyEntity>> convertAsContainingList(List<StringKeyEntity> list) {
        return null;
    }
}
