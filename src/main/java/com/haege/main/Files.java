package com.haege.main;

public class Files {

    private static final Files OBJ = new Files();

    private Files() {
        System.out.println("Objekt gebildet...");
    }

    public static Files getInstance() {
        return OBJ;
    }

    private String oldfile = null;
    private String newFile = null;

    private String diffResult = "";

    public String getDiffResult() {
        return diffResult;
    }

    public void setDiffResult(String diffResult) {
        this.diffResult = diffResult;
    }

    public String getOldfile() {
        return oldfile;
    }

    public void setOldfile(String oldfile) {
        this.oldfile = oldfile;
    }

    public String getNewFile() {
        return newFile;
    }

    public void setNewFile(String newFile) {
        this.newFile = newFile;
    }
}
