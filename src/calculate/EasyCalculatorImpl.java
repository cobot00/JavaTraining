package calculate;

public class EasyCalculatorImpl implements IEasyCalculator {

    /**
     * 計算は[left operator right]の順で実行する。
     * 引数のoperatorについてはenumのOperatorを参照のこと。
     * 計算不能な場合は全てIllegalArgumentExceptionを生成する。
     * 
     * ex.
     * left: "2", right: "5", operator: ADD -> 5 + 2 -> 7
     * left: "2", right: "5", operator: SUBTRACT -> 5 - 2 -> 3
     * left: "2", right: "5", operator: MULTIPLY -> 5 * 2 -> 10
     * left: "2", right: "5", operator: DIVIDE -> 5 / 2 -> 2
     * 
     * @param left
     * @param right
     * @param operator
     * @return
     */
    public int calculate(String left, String right, Operator operator) {
        final int leftValue = convertToInt(left);
        final int rightValue = convertToInt(right);

        switch (operator) {
        case ADD:
            return leftValue + rightValue;
        case SUBTRACT:
            return leftValue - rightValue;
        case MULTIPLY:
            return leftValue * rightValue;
        case DIVIDE:
            if (rightValue == 0) {
                throw new IllegalArgumentException("zero divide");
            }
            return leftValue / rightValue;
        }
        throw new IllegalArgumentException();
    }

    private int convertToInt(String arg) {
        try {
            return Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("argument is not number -> " + arg);
        }
    }
}
