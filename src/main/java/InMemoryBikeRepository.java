import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class InMemoryBikeRepository implements BikeRepository {

    private final Map<ValueObjekt, Bike> store = new LinkedHashMap<>();

    //Speichert ein Bike-Objekt im Repository.
    @Override
    public boolean save(Bike bike) {

        // Fehler Exception
        if (bike == null) {
            throw new IllegalArgumentException("bike must not be null");
        }
        ValueObjekt id = bike.id;
        // Fehler Exception
        if (id == null || id.value() == null || id.value().trim().isEmpty()) {
            throw new IllegalArgumentException("bike.id must not be null or blank");
        }

        boolean isNew = !store.containsKey(id);
        store.put(id, bike);
        return isNew;
    }

    // Ruft ein Bike-Objekt anhand seiner ID ab oder wirft eine Ausnahme, wenn es nicht gefunden wird.
    @Override
    public Bike getByIdOrThrow(ValueObjekt id) {

        // Fehler Exception
        if (id == null || id.value() == null || id.value().trim().isEmpty()) {
            throw new IllegalArgumentException("id must not be null or blank");
        }

        Bike o = store.get(id);

        // Bussiness Result
        if (o == null) {
            throw new java.util.NoSuchElementException("unknown id " + id.value());
        }
        return o;
    }

    // Löscht ein Bike-Objekt anhand seiner ID aus dem Repository.
    @Override
    public boolean deleteById(ValueObjekt id) {
        if (id == null || id.value() == null || id.value().trim().isEmpty()) {
            throw new IllegalArgumentException("id must not be null or blank");
        }
        return store.remove(id) != null;
    }

    // Listet alle Bike-Objekte im Repository auf.
    @Override
    public List<Bike> listAll() {
        return new ArrayList<>(store.values());
    }
}
