public class Main {
    public static void main(String[] args) {

        BikeRepository Bike = new InMemoryBikeRepository();


        Bike.save(new Bike("B1", "Speedster"));
        Bike.save(new Bike("B2", "Gym"));
        Bike.save(new Bike("B3", "Trackstar"));

        System.out.println("Bike Repository:");
        System.out.println("All Bikes: " + Bike.listAll());

        Bike.deleteById(new ValueObjekt("B2"));

        System.out.println("\nAfter deleting B2, All Bikes: " + Bike.listAll());

        System.out.println("\nGet Bike by ID B1: " + Bike.getByIdOrThrow(new ValueObjekt("B1")));
    }
}
