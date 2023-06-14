import java.io.Serializable;

/**
 * Enum class containing statuses of rental: ORDERED, RENTED, AVAILABLE
 */
public enum RentalStatus implements Serializable {
    /**
     * Means the book is ordered
     */
    ORDERED,
    /**
     * means the book is being rented now
     */
    RENTED,
    /**
     * means the book is available at the moment
     */
    AVAILABLE
}
