public class BuilderPatternExample {

    // 1. Define the Product Class
    static class Computer {
        // Attributes of Computer
        private String CPU;
        private String RAM;
        private String Storage;
        private String GPU;
        private boolean isBluetoothEnabled;
        private boolean isWiFiEnabled;

        // Private constructor to enforce the use of the Builder
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.Storage = builder.Storage;
            this.GPU = builder.GPU;
            this.isBluetoothEnabled = builder.isBluetoothEnabled;
            this.isWiFiEnabled = builder.isWiFiEnabled;
        }

        @Override
        public String toString() {
            return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + Storage +
                   ", GPU=" + GPU + ", BluetoothEnabled=" + isBluetoothEnabled +
                   ", WiFiEnabled=" + isWiFiEnabled + "]";
        }

        // 2. Implement the Builder Class (Static Nested)
        public static class Builder {
            private String CPU;
            private String RAM;
            private String Storage;
            private String GPU;
            private boolean isBluetoothEnabled;
            private boolean isWiFiEnabled;

            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(String Storage) {
                this.Storage = Storage;
                return this;
            }

            public Builder setGPU(String GPU) {
                this.GPU = GPU;
                return this;
            }

            public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
                this.isBluetoothEnabled = isBluetoothEnabled;
                return this;
            }

            public Builder setWiFiEnabled(boolean isWiFiEnabled) {
                this.isWiFiEnabled = isWiFiEnabled;
                return this;
            }

            // Build method to create an instance of Computer
            public Computer build() {
                return new Computer(this);
            }
        }
    }

    // 3. Test the Builder Implementation
    public static void main(String[] args) {
        // Create a Computer with various configurations using the Builder pattern
        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA GeForce RTX 3080")
                .setBluetoothEnabled(true)
                .setWiFiEnabled(true)
                .build();

        Computer officeComputer = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setGPU("Integrated Graphics")
                .setBluetoothEnabled(false)
                .setWiFiEnabled(true)
                .build();

        // Display the created Computers
        System.out.println("Gaming Computer: " + gamingComputer);
        System.out.println("Office Computer: " + officeComputer);
    }
}
