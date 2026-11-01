// To implement multiple inheritance using interfaces for a Smart Device with printing and scanning capabilities.

// Interface 1: Printing functionality
interface Printable {
    void printDocument(String documentName);
    void checkInkLevel();
}

// Interface 2: Scanning functionality
interface Scannable {
    void scanDocument(String documentName);
    void saveScanToCloud(String fileName);
}

// SmartDevice class implementing multiple interfaces
class SmartDevice implements Printable, Scannable {
    private String deviceId;
    private String modelName;
    private int inkLevelPercent;

    public SmartDevice(String deviceId, String modelName, int inkLevelPercent) {
        this.deviceId = deviceId;
        this.modelName = modelName;
        this.inkLevelPercent = inkLevelPercent;
    }

    // Implementation of Printable methods
    @Override
    public void printDocument(String documentName) {
        if (inkLevelPercent < 5) {
            System.out.println("[" + modelName + "] Printing failed: Ink critically low (" + inkLevelPercent + "%).");
            return;
        }
        inkLevelPercent -= 2;
        System.out.println("[" + modelName + "] Printing document: '" + documentName + "' -> Complete. (Remaining ink: " + inkLevelPercent + "%)");
    }

    @Override
    public void checkInkLevel() {
        System.out.println("[" + modelName + "] Current Ink Level: " + inkLevelPercent + "%");
    }

    // Implementation of Scannable methods
    @Override
    public void scanDocument(String documentName) {
        System.out.println("[" + modelName + "] Scanning physical document: '" + documentName + "' at 600 DPI -> Scan successful.");
    }

    @Override
    public void saveScanToCloud(String fileName) {
        System.out.println("[" + modelName + "] Uploading scanned file '" + fileName + ".pdf' to secure cloud storage -> Done.");
    }

    public void displayDeviceInfo() {
        System.out.println("Device ID   : " + deviceId);
        System.out.println("Model Name  : " + modelName);
        System.out.println("Capabilities: Printing, Scanning, Cloud Sync");
        System.out.println("------------------------------------------------------------");
    }
}

class InterfaceDemo {
    public static void main(String[] args) {
        System.out.println("--- Smart All-In-One Device (Multiple Inheritance via Interfaces) ---\n");

        SmartDevice device = new SmartDevice("HP-ENVY-702", "HP Envy All-in-One Multifunction", 85);
        device.displayDeviceInfo();

        // 1. Direct object interaction
        System.out.println(">> Operating device directly as SmartDevice:");
        device.printDocument("Annual_Financial_Report.pdf");
        device.scanDocument("Signed_Vendor_Contract.jpg");
        device.saveScanToCloud("Signed_Vendor_Contract");
        System.out.println();

        // 2. Demonstration of interface reference (Printable view)
        System.out.println(">> Accessing device via Printable interface reference:");
        Printable printerRef = device;
        printerRef.checkInkLevel();
        printerRef.printDocument("Lecture_Notes_Unit1.docx");
        System.out.println();

        // 3. Demonstration of interface reference (Scannable view)
        System.out.println(">> Accessing device via Scannable interface reference:");
        Scannable scannerRef = device;
        scannerRef.scanDocument("National_Identity_Card.png");
        scannerRef.saveScanToCloud("Identity_Proof_Verification");
        System.out.println("------------------------------------------------------------");
    }
}
