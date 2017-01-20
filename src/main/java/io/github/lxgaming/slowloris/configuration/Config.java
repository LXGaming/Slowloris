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

package io.github.lxgaming.slowloris.configuration;

public class Config {
	
	private String host;
	private int port;
	private int timeout;
	private int connections;
	private int sleep;
	private String payload;
	private String keepalive;
	
	public String getHost() {
		return this.host;
	}
	
	public int getPort() {
		return this.port;
	}
	
	public int getTimeout() {
		return this.timeout;
	}
	
	public int getConnections() {
		return this.connections;
	}
	
	public int getSleep() {
		return this.sleep;
	}
	
	public String getPayload() {
		return this.payload;
	}
	
	public String getKeepAlive() {
		return this.keepalive;
	}
}
