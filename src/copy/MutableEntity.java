package copy;

/**
 * mutableなフィールドを持つEntity。
 * Cloneableではないのでクローンが必要ならばインスタンスを生成して
 * 値をコピーする必要があります。
 * 
 */
public class MutableEntity {

    private final int id;
    private int mutableValue;

    public MutableEntity(int id) {
        this.id = id;
        this.mutableValue = 0;
    }

    public int getId() {
        return id;
    }

    public int getMutableValue() {
        return mutableValue;
    }

    public void setMutableValue(int mutableValue) {
        this.mutableValue = mutableValue;
    }
}
