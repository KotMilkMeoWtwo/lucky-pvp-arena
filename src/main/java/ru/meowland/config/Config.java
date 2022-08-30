package ru.meowland.config;

import arc.Core;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Config {

    public static String get(String meow){
        Yaml yml = new Yaml();
        Map<String, Object> obj = null;
        try {
            obj = yml.load(Files.readString(Path.of("./plugins/LuckyBlockBattle/config.yml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return obj.get(meow).toString();
    }
}
