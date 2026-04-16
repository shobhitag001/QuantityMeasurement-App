public class QuantityMeasurement936 {

    // ===== Enum for Units =====
    enum LengthUnit {
        FEET(1.0),          // base unit
        INCH(1.0 / 12.0);   // 1 inch = 1/12 feet

        private final double toFeetFactor;

        LengthUnit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        public double toFeet(double value) {
            return value * toFeetFactor;
        }
    }

    // ===== Generic Quantity Class =====
    static class QuantityLength {
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        // Convert to base unit (feet)
        private double toFeet() {
            return unit.toFeet(value);
        }

        @Override
        public boolean equals(Object obj) {
            // Reflexive
            if (this == obj) return true;

            // Null & type check
            if (obj == null || getClass() != obj.getClass()) return false;

            QuantityLength other = (QuantityLength) obj;

            // Compare after conversion to common unit (feet)
            return Double.compare(this.toFeet(), other.toFeet()) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(toFeet());
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", " + unit + ")";
        }
    }

    // ===== Main Method with Test Cases =====
    public static void main(String[] args) {

        // Same Unit Equality
        QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength f2 = new QuantityLength(1.0, LengthUnit.FEET);

        System.out.println("Feet Same Value: " + f1.equals(f2)); // true

        // Inch Same Unit
        QuantityLength i1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength i2 = new QuantityLength(1.0, LengthUnit.INCH);

        System.out.println("Inch Same Value: " + i1.equals(i2)); // true

        // Cross Unit Equality (1 ft = 12 inches)
        QuantityLength f = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength i = new QuantityLength(12.0, LengthUnit.INCH);

        System.out.println("Feet to Inch Equality: " + f.equals(i)); // true
        System.out.println("Inch to Feet Equality: " + i.equals(f)); // true

        // Different Values
        QuantityLength f3 = new QuantityLength(2.0, LengthUnit.FEET);
        System.out.println("Feet Different: " + f.equals(f3)); // false

        QuantityLength i3 = new QuantityLength(2.0, LengthUnit.INCH);
        System.out.println("Inch Different: " + i1.equals(i3)); // false

        // Null Comparison
        System.out.println("Null Comparison: " + f.equals(null)); // false

        // Same Reference
        System.out.println("Same Reference: " + f.equals(f)); // true

        // Invalid Unit Test
        try {
            new QuantityLength(1.0, null);
        } catch (Exception e) {
            System.out.println("Invalid Unit: " + e.getMessage());
        }

        // Example Output
        System.out.println("\nInput: Quantity(1.0, FEET) and Quantity(12.0, INCH)");
        System.out.println("Output: Equal (" + f.equals(i) + ")");

        System.out.println("Input: Quantity(1.0, INCH) and Quantity(1.0, INCH)");
        System.out.println("Output: Equal (" + i1.equals(i2) + ")");
    }
}}