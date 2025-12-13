public final class ValueObjekt {

    private final String bikeId;

    // Konstruktor für ValueObjekt.
    public ValueObjekt(String bikeId) {
        this.bikeId = bikeId;
        checkBikeId(this.bikeId);
    }

    // Gibt den Wert des bikeId zurück.
    public String value() {
        return bikeId;
    }

    // Prüft die Gültigkeit der bikeId.
    private void checkBikeId(String bikeId) {
        if (bikeId == null || bikeId.trim().isEmpty()) {
            throw new IllegalArgumentException("bikeId must not be null or empty");
        }
        if (!bikeId.matches("B\\d+")) {
            throw new IllegalArgumentException("bikeId must start with big 'B' followed by numbers only");
        }
    }

    // Vergleicht zwei ValueObjekt-Instanzen basierend auf ihrer bikeId.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValueObjekt that)) return false;
        return bikeId.equals(that.bikeId);
    }

    // Generiert einen Hash-Code basierend auf der bikeId.
    @Override
    public int hashCode() {
        return bikeId.hashCode();
    }
}
