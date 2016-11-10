package io.github.lxgaming.slowloris;

import io.github.lxgaming.slowloris.util.ConsoleOutput;

public class Main {
	
	public static void main(String[] args) {
		ConsoleOutput.info("========== Slowloris ==========");
		ConsoleOutput.info("Version - 1.0.0");
		ConsoleOutput.info("Author - LX_Gaming");
		ConsoleOutput.info("========== Slowloris ==========");
		Slowloris slowloris = new Slowloris();
		slowloris.loadSlowloris();
	}
}