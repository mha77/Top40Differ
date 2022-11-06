package com.haege.main;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Compare {

    //File resourcesDirectory = new File("src/main/resources");

    public Compare() {
    }

    public static void compare(String oldFile, String newFile) throws IOException {

        Files files = Files.getInstance();

        ZipFile zipFileOld = new ZipFile(oldFile);
        ZipFile zipFileNew = new ZipFile(newFile);


        Set<String> oldSet = getSetOfEntries(zipFileOld);
        Set<String> newSet = getSetOfEntries(zipFileNew);

        StringBuilder sb = new StringBuilder();

        for(String ticker :oldSet){
            if (!newSet.contains(ticker)) {
                sb.append("New File does not contain " + ticker + "\n");
                System.out.println("New Set does not contain " + ticker);
            }
        }

        for(String ticker :newSet){
            if (!oldSet.contains(ticker)) {
                sb.append("Old File does not contain " + ticker + "\n");
                System.out.println("Old Set does not contain " + ticker);
            }
        }

        files.setDiffResult(sb.toString());
    }

    private static Set<String> getSetOfEntries(ZipFile zipFile) {

        Set<String> mapOfEntries = new HashSet<>();
        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        while(entries.hasMoreElements()){
            ZipEntry entry = entries.nextElement();

            if(entry.toString().startsWith("__MACOSX")){
                continue;
            }

            int index = entry.toString().indexOf('/');
            String pathWithFile = entry.toString();
            String filename = pathWithFile.substring(index + 1);

            int index2 = 0;

            for (int i = 0; i < filename.length(); ++i) {
                if (filename.charAt(i) == ' ') {
                    index2 = i;
                }
            }

            if(index2 == 0 || filename.endsWith("txt")){
                continue;
            }

            String tickerSymbol = filename.substring(0, index2);
            mapOfEntries.add(tickerSymbol);
        }
        return mapOfEntries;
    }
}
