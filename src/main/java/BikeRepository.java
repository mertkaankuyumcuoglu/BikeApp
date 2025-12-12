/**
 * Repository für Bike Modelle.
 * Verantwortlich für Anlegen, Lesen, Löschen, Auflisten.
 * Invariante: Methoden geben niemals null zurück (Listen ggf. leer).
 */
public interface BikeRepository {

    /**
     * Legt eine Bestellung an oder aktualisiert sie.
     *
     * @param bike darf nicht null sein; auch bike.id darf nicht null (und nicht leer) sein
     * @return true, wenn neu angelegt; false, wenn bestehende Bestellung aktualisiert wurde
     * @throws IllegalArgumentException wenn bike oder bike.id null/leer sind
     */
    boolean save(Bike bike);

    /**
     * Liefert die Bestellung zur ID oder signalisiert, dass sie nicht existiert.
     *
     * @param id darf nicht null (und nicht leer) sein
     * @return nie null
     * @throws IllegalArgumentException wenn id null/leer ist
     * @throws java.util.NoSuchElementException wenn keine Bestellung zu dieser id existiert
     */
    Bike getByIdOrThrow(ValueObjekt id);

    /**
     * Löscht die Bestellung zur ID.
     *
     * @param id darf nicht null (und nicht leer) sein
     * @return true, wenn gelöscht; false, wenn keine Bestellung vorhanden (Business, keine Exception)
     * @throws IllegalArgumentException wenn id null/leer ist
     */
    boolean deleteById(ValueObjekt id);

    /**
     * Gibt alle Bestellungen in Einfügereihenfolge zurück.
     *
     * @return nie null; ggf. leere Liste
     */
    java.util.List<Bike> listAll();
}
