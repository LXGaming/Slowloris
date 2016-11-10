package io.github.lxgaming.slowloris;

import io.github.lxgaming.slowloris.configuration.Config;
import io.github.lxgaming.slowloris.configuration.Configuration;
import io.github.lxgaming.slowloris.util.ConsoleOutput;
import io.github.lxgaming.slowloris.util.SlowlorisThread;

public class Slowloris {
	
	private static Slowloris slowloris;
	private Configuration configuration;
	private SlowlorisThread slowlorisThread;
	
	public Slowloris() {
		slowloris = this;
	}
	
	public void loadSlowloris() {
		ConsoleOutput.info("Initializing Slowloris - the low bandwidth, yet greedy and poisonous HTTP client...");
		loadConfig();
		loadSlowlorisThread();
	}
	
	private void loadConfig() {
		this.configuration = new Configuration();
		this.configuration.loadConfig();
	}
	
	public Config getConfig() {
		return this.configuration.config;
	}
	
	public void loadSlowlorisThread() {
		this.slowlorisThread = new SlowlorisThread();
		this.slowlorisThread.start();
	}
	
	public SlowlorisThread getSlowlorisThread() {
		return this.slowlorisThread;
	}
	
	public static Slowloris getSlowloris() {
		return slowloris;
	}
}