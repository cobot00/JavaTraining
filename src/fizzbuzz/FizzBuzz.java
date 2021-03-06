package fizzbuzz;

import java.util.List;

/**
 * 保持する整数のリストは昇順にソートされているとみなしてよい。
 * 
 */
public class FizzBuzz implements IFizzBuzz {

    private final List<FizzBuzzEntity> condition;

    public FizzBuzz(List<FizzBuzzEntity> condition) {
        this.condition = condition;
    }

    /**
     * <pre>
     * 保持するリスト内の整数で割り切れる場合は対応する文字列を返し、<br>
     * 割り切れない場合は引数の値をそのまま返す。<br>
     * 約数がリスト内に複数存在する場合はその内で最大のものの値を返す。<br>
     * なお、%演算子は使用不可とする。
     * 
     * e.g.
     * condition: [(3, Fizz), (5, Buzz), (15, FizzBuzz)]
     * 
     * result:
     *   1, 2, Fizz, 4, Buzz,
     *   Fizz, 7, 8, Fizz, Buzz,
     *   11, Fizz, 13, 14, FizzBuzz,
     *   16, 17, Fizz, 19, Buzz
     * 
     * (): Entity, []: List
     * 
     * </pre>
     * 
     * @param number
     *            1以上の整数
     * @return 対応する文字列
     */
    public String doFizzBuzz(int number) {
        return null;
    }
}
