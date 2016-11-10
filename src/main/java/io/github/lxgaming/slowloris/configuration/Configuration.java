package io.github.lxgaming.slowloris.configuration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import io.github.lxgaming.slowloris.Main;
import io.github.lxgaming.slowloris.util.ConsoleOutput;

public class Configuration {
	
	public File configFile = new File("config.json");
	
	public Config config;
	
	public void loadConfig() {
		try {
			if (!configFile.exists()) {
				configFile.createNewFile();
				InputStream inputStream = Main.class.getResourceAsStream("/config.json");
				Files.copy(inputStream, Paths.get(configFile.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
				ConsoleOutput.info("Successfully created configuration file.");
			}
			
			JsonObject jsonObject = new JsonParser().parse(new String(Files.readAllBytes(Paths.get(configFile.getAbsolutePath())), StandardCharsets.UTF_8)).getAsJsonObject();
			config = new Gson().fromJson(jsonObject, Config.class);
			
			ConsoleOutput.info("Successfully loaded configuration file.");
		} catch (IllegalStateException | InvalidPathException | IOException | JsonParseException | NullPointerException | OutOfMemoryError | SecurityException | UnsupportedOperationException ex) {
			ConsoleOutput.error("Exception loading configuration file!");
			ex.printStackTrace();
		}
		return;
	}
}