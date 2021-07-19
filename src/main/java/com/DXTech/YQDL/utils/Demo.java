package com.DXTech.YQDL.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.UUID;

public class Demo {
    public static void main(String []args)
    {
        String basePath = "C:/yqdl-upload/";
        File fileDir = new File(basePath);
        if(!fileDir.exists()) {
            fileDir.mkdir();
        }
        String new_filename = UUID.randomUUID()+".jpg";

        Path fullPath = Paths.get(basePath, "image", new_filename);

    }
}
