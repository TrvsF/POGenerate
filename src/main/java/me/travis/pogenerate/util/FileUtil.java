package me.travis.pogenerate.util;

import me.travis.pogenerate.POGenerate;
import me.travis.pogenerate.world.World;
import me.travis.pogenerate.world.object.Object;
import me.travis.pogenerate.world.object.objects.None;
import me.travis.pogenerate.world.object.objects.Player;
import me.travis.pogenerate.world.object.objects.Wall;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtil { // TODO : THIS

    static public void openFile(String path) throws IOException {
        String extension = "";
        int index = path.lastIndexOf('.');
        if (index > 0) {
            extension = path.substring(index + 1);
        }
        if (!extension.equalsIgnoreCase("pog")) {
            System.out.print("...\nERROR : cannot load file that is not POG\n");
            return;
        }
        // Buffered Reader to read file
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        // add each line to a list of lines
        List<String[]> lines = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            lines.add(line.split("\\s+")); // split lines by spaces
        }
        br.close();

        for (String[] l : lines) {
            int x;
            int y;
            switch (l[0]) {
                case "NAME":
                    break;
                case "TYPE":
                    break;
                case "WALL":
                    x = Common.gameToCoord(Integer.parseInt(l[1]));
                    y = Common.gameToCoord(Integer.parseInt(l[2]));
                    World.INSTANCE().getWorld()[x][y] = new Wall(Integer.parseInt(l[1]), Integer.parseInt(l[2]));
                    break;
                case "PLAYER":
                    x = Common.gameToCoord(Integer.parseInt(l[1]));
                    y = Common.gameToCoord(Integer.parseInt(l[2]));
                    World.INSTANCE().getWorld()[x][y] = new Player(Integer.parseInt(l[1]), Integer.parseInt(l[2]));
                    break;
            }
        }

        POGenerate.Window.redrawWorld();
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
