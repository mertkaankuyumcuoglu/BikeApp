/**
 * Minimales Domain-Objekt für Bike-Modell.
 * Einheiten:
 * - modell als String.
 *
 * Contract:
 * - modell darf nicht null/leer sein.
 */
final class Bike {
    ValueObjekt id;
    final String modell;

    /**
     * Konstruktor für Bike-Objekt.
     *
     * @param id
     * @param modell
     */
    public Bike(String id, String modell) {
        this.id = new ValueObjekt(id);
        this.modell = modell;
    }

    public String getId() {
        return id.value();
    }

    @Override
    public String toString() {
        return "Bike id = " + id.value() + " modell = " + modell;
    }
}
