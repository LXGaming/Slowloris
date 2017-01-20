/*
 * Copyright 2017 Alex Thomson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
