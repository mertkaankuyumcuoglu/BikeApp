public class Main {
    public static void main(String[] args) {

        BikeRepository Bike = new InMemoryBikeRepository();

        // Anlegen einiger Bikes
        Bike.save(new Bike("B1", "Speedster"));
        Bike.save(new Bike("B2", "Gym"));
        Bike.save(new Bike("B3", "Trackstar"));

        // Ausgabe aller Bikes im Repository
        System.out.println("Bike Repository:");
        System.out.println("All Bikes: " + Bike.listAll());

        // Löschen eines Bikes anhand seiner ID
        Bike.deleteById(new ValueObjekt("B2"));

        // Ausgabe aller Bikes nach dem Löschen
        System.out.println("\nAfter deleting B2, All Bikes: " + Bike.listAll());

        // Abrufen eines Bikes anhand seiner ID
        System.out.println("\nGet Bike by ID B1: " + Bike.getByIdOrThrow(new ValueObjekt("B1")));

        // Testen der equals- und hashCode-Methoden von ValueObjekt
        System.out.println("HashCode of Bike with ID B1: " + new ValueObjekt("B1").hashCode());
        System.out.println("Equals check between B1 and B3: " + new ValueObjekt("B1").equals(new ValueObjekt("B3")));
    }
}
