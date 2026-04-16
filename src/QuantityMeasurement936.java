public class QuantityMeasurement936 {

    // Inner class for Feet measurement
    static class Feet {
        private final double value;

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        // Override equals method
        @Override
        public boolean equals(Object obj) {
            // Same reference
            if (this == obj) {
                return true;
            }

            // Null or different class
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            // Cast
            Feet other = (Feet) obj;

            // Compare values
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Simple test runner (instead of JUnit)
    public static void main(String[] args) {

        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        Feet f3 = new Feet(2.0);

        // Test: Same Value
        System.out.println("Test Same Value: " + f1.equals(f2)); // true

        // Test: Different Value
        System.out.println("Test Different Value: " + f1.equals(f3)); // false

        // Test: Null Comparison
        System.out.println("Test Null Comparison: " + f1.equals(null)); // false

        // Test: Non-Feet Object
        System.out.println("Test Non-Numeric Input: " + f1.equals("string")); // false

        // Test: Same Reference
        System.out.println("Test Same Reference: " + f1.equals(f1)); // true

        // Example Output
        System.out.println("\nInput: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + f1.equals(f2) + ")");
    }
}