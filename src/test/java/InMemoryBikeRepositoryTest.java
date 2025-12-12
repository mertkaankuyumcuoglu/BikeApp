import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

final class InMemoryBikeRepositoryTest {
    // Testfälle für InMemoryBikeRepository
    @Test
    void saveBikeSucceeds() {
        InMemoryBikeRepository repo = new InMemoryBikeRepository();
        Bike bike = new Bike("B1", "Speedster");
        assertTrue(repo.save(bike));
        assertFalse(repo.save(bike));
    }

    @Test
    void saveNullBikeShouldThrowException() {
        InMemoryBikeRepository repo = new InMemoryBikeRepository();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            repo.save(null);
        });
        assertEquals("bike must not be null", exception.getMessage());
    }

    @Test
    void getByIdOrThrowWithNullIdShouldThrowException() {
        InMemoryBikeRepository repo = new InMemoryBikeRepository();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            repo.getByIdOrThrow(null);
        });
        assertEquals("id must not be null or blank", exception.getMessage());
    }

    @Test
    void deleteByIdWithEmptyIdShouldThrowException() {
        InMemoryBikeRepository repo = new InMemoryBikeRepository();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            repo.deleteById("");
        });
        assertEquals("id must not be null or blank", exception.getMessage());
    }

    // Testfälle für ValueObjekt.value(String bikeId)
    @Test
    void valueEmptyShouldThrowException() {
        ValueObjekt test = new ValueObjekt("");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            test.value();
        });
        assertEquals("bikeId must not be null or empty", exception.getMessage());
    }

    @Test
    void valueWithoutBShouldThrowException() {
        ValueObjekt test = new ValueObjekt("B123"); // gültiger Startwert

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, () ->
                test.value()
        );

        assertEquals(
            "bikeId must start with big 'B' followed by numbers only",
            exception.getMessage()
        );
    }


    @Test
    void valueWithLettersAfterBShouldThrowException() {
        ValueObjekt test = new ValueObjekt("B123"); // gültiger Startwert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            test.value();
        });
        assertEquals("bikeId must start with big 'B' followed by numbers only", exception.getMessage());
    }
}



