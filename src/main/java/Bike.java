/**
 * Minimales Domain-Objekt für Bike-Modell.
 * Einheiten:
 * - modell als String.
 * Contract:
 * - modell darf nicht null/leer sein.
 */
public final class Bike {
    ValueObjekt id;
    final String modell;

    /**
     * Konstruktor für Bike-Objekt.
     *
     * @param id
     * ID des Bikes als ValueObjekt.
     *
     * @param modell
     * Modell des Bikes als String.
     */
    public Bike(String id, String modell) {
        this.id = new ValueObjekt(id);
        this.modell = modell;
    }

    // String-Repräsentation des Bike-Objekts.
    @Override
    public String toString() {
        return "\nBike id = " + id.value() + ", Modell = " + modell;
    }
}
