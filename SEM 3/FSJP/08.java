interface Printable {
    void printDocument(String documentName);
    void checkInkLevel();
}

interface Scannable {
    void scanDocument(String documentName);
    void saveScanToCloud(String fileName);
}

class SmartDevice implements Printable, Scannable {
    private String deviceId;
    private String modelName;
    private int inkLevelPercent;

    public SmartDevice(String deviceId, String modelName, int inkLevelPercent) {
        this.deviceId = deviceId;
        this.modelName = modelName;
        this.inkLevelPercent = inkLevelPercent;
    }

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

        System.out.println(">> Operating device directly as SmartDevice:");
        device.printDocument("Annual_Financial_Report.pdf");
        device.scanDocument("Signed_Vendor_Contract.jpg");
        device.saveScanToCloud("Signed_Vendor_Contract");
        System.out.println();

        System.out.println(">> Accessing device via Printable interface reference:");
        Printable printerRef = device;
        printerRef.checkInkLevel();
        printerRef.printDocument("Lecture_Notes_Unit1.docx");
        System.out.println();

        System.out.println(">> Accessing device via Scannable interface reference:");
        Scannable scannerRef = device;
        scannerRef.scanDocument("National_Identity_Card.png");
        scannerRef.saveScanToCloud("Identity_Proof_Verification");
        System.out.println("------------------------------------------------------------");
    }
}
