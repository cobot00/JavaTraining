package fizzbuzz;

/**
 * 約数と出力文字列を保持するEntity。
 *
 */
public class FizzBuzzEntity {

    private final int number;
    private final String output;

    public FizzBuzzEntity(int number, String output) {
        this.number = number;
        this.output = output;
    }

    public int getNumber() {
        return number;
    }

    public String getOutput() {
        return output;
    }
}
