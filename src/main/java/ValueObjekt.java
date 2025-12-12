public final class ValueObjekt {

    private final String bikeId;

    public ValueObjekt(String bikeId) {
        this.bikeId = bikeId;
        checkBikeId(this.bikeId);
    }

    public String value() {
        return bikeId;
    }

    private void checkBikeId(String bikeId) {
        if (bikeId == null || bikeId.trim().isEmpty()) {
            throw new IllegalArgumentException("bikeId must not be null or empty");
        }
        if (!bikeId.matches("B\\d+")) {
            throw new IllegalArgumentException("bikeId must start with big 'B' followed by numbers only");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValueObjekt)) return false;
        ValueObjekt that = (ValueObjekt) o;
        return bikeId.equals(that.bikeId);
    }

    @Override
    public int hashCode() {
        return bikeId.hashCode();
    }

    @Override
    public String toString() {
        return bikeId;
    }
}
