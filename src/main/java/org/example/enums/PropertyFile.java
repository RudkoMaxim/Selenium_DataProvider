package org.example.enums;

public enum PropertyFile {
    CONFIG("config.proprties"),
    EMAIL("email.properties");

    private String pathToFile;

    PropertyFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public String getPathToFile() {
        return pathToFile;
    }
}
