public class Record {

    private String value;
    private int hashValue;

    public Record(String value) {
        this.value = value;
        this.hashValue = value.hashCode();
    }

    public String getValue() {
        return value;
    }

    public int getHashValue() {
        return hashValue;
    }
}
