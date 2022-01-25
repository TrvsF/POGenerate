package me.travis.pogenerate.util;

import me.travis.pogenerate.gui.Chunk;
import me.travis.pogenerate.world.World;
import me.travis.pogenerate.world.object.Object;
import me.travis.pogenerate.world.object.objects.None;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil { // TODO : THIS

    static public void openFile(String path) throws IOException {

    }

    static public void writeFile(String fileName) throws IOException {
        System.out.print("writing file '" + fileName + "'...");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NAME epicCustomLevel\n");
        stringBuilder.append("TYPE custom\n");
        for (Object[] objects : World.INSTANCE().getWorld()) {
            for (Object object : objects) {
                if (object instanceof None)
                    continue;

                int x = object.getWorldPos().getElement1();
                int y = object.getWorldPos().getElement2();
                stringBuilder.append(object.getObjectName()).append(" ").append(x).append(" ").append(y).append("\n");
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
                System.getProperty("user.home") + "/Desktop/" + fileName + ".pog"
        )));
        writer.write(stringBuilder.toString());
        writer.close();
        System.out.println("done");
    }

}
