public class QuantityMeasurement936{

    // ===== Feet Class =====
    static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // ===== Inches Class =====
    static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // ===== Static Methods (as per UC2 requirement) =====
    public static boolean compareFeet(double v1, double v2) {
        Feet f1 = new Feet(v1);
        Feet f2 = new Feet(v2);
        return f1.equals(f2);
    }

    public static boolean compareInches(double v1, double v2) {
        Inches i1 = new Inches(v1);
        Inches i2 = new Inches(v2);
        return i1.equals(i2);
    }

    // ===== Main Method =====
    public static void main(String[] args) {

        // Feet Tests
        System.out.println("Feet Same Value: " + compareFeet(1.0, 1.0)); // true
        System.out.println("Feet Different Value: " + compareFeet(1.0, 2.0)); // false

        // Inches Tests
        System.out.println("Inches Same Value: " + compareInches(1.0, 1.0)); // true
        System.out.println("Inches Different Value: " + compareInches(1.0, 2.0)); // false

        // Null & Type Safety Checks
        Feet f = new Feet(1.0);
        System.out.println("Feet Null Check: " + f.equals(null)); // false
        System.out.println("Feet Non-Type Check: " + f.equals("string")); // false
        System.out.println("Feet Same Reference: " + f.equals(f)); // true

        Inches i = new Inches(1.0);
        System.out.println("Inches Null Check: " + i.equals(null)); // false
        System.out.println("Inches Non-Type Check: " + i.equals(10)); // false
        System.out.println("Inches Same Reference: " + i.equals(i)); // true

        // Example Output Format
        System.out.println("\nInput: 1.0 inch and 1.0 inch");
        System.out.println("Output: Equal (" + compareInches(1.0, 1.0) + ")");

        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + compareFeet(1.0, 1.0) + ")");
    }
}