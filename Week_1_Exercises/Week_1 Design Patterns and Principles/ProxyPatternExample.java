public class ProxyPatternExample {

    // 2. Define Subject Interface
    interface Image {
        void display();
    }

    // 3. Implement Real Subject Class
    static class RealImage implements Image {
        private String filename;

        // Constructor to load an image from a remote server
        public RealImage(String filename) {
            this.filename = filename;
            loadImageFromServer();
        }

        private void loadImageFromServer() {
            System.out.println("Loading image: " + filename);
        }

        @Override
        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }

    // 4. Implement Proxy Class
    static class ProxyImage implements Image {
        private RealImage realImage;
        private String filename;
        private boolean isCached;

        public ProxyImage(String filename) {
            this.filename = filename;
            this.isCached = false;
        }

        @Override
        public void display() {
            if (!isCached) {
                if (realImage == null) {
                    realImage = new RealImage(filename);
                }
                isCached = true;
            }
            realImage.display();
        }
    }

    // 5. Test the Proxy Implementation
    public static void main(String[] args) {
        // Create proxies for images
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Display images using proxies
        System.out.println("Displaying images using proxy:");
        image1.display(); // First time, loads from server
        image1.display(); // Second time, uses cached image

        image2.display(); // First time, loads from server
        image2.display(); // Second time, uses cached image
    }
}
