package utils.vos;

public class Package {

    private final String packageType;
    private final String packageDesc;
    private final String packageSummary;

    public Package(String packageType, String packageDesc, String packageSummary) {
        this.packageType = packageType;
        this.packageDesc = packageDesc;
        this.packageSummary = packageSummary;
    }

    public String getPackageType() {
        return packageType;
    }

    public String getPackageDesc() {
        return packageDesc;
    }

    public String getPackageSummary() {
        return packageSummary;
    }

    public static Package create(com.integration.extensions.domains.devops.Package packageType) {
        return new Package(packageType.packageType, packageType.description, packageType.summary);
    }

}
