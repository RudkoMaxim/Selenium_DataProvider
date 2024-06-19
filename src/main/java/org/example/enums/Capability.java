package org.example.enums;

public enum Capability {
    BROWSER("browser", "chrome"),
    BROWSER_VERSION("browserVersion", "126");

    private String key;
    private String defaultValue;

    Capability(String key, String defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    public String getKey() {
        return key;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}
