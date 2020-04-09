package com.sigar.test.model;

public class CpuInfoData {
	
	private Integer cupNum;
	private String vendor;
	private Integer clock;
	private Long cacheSize;
	private Integer coresPerSocket;
	private String model;
	private Integer totalCores;
	private Integer totalSockets;
	
	public Integer getCupNum() {
		return cupNum;
	}
	public void setCupNum(Integer cupNum) {
		this.cupNum = cupNum;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Integer getClock() {
		return clock;
	}
	public void setClock(Integer clock) {
		this.clock = clock;
	}
	public Long getCacheSize() {
		return cacheSize;
	}
	public void setCacheSize(Long cacheSize) {
		this.cacheSize = cacheSize;
	}
	public Integer getCoresPerSocket() {
		return coresPerSocket;
	}
	public void setCoresPerSocket(Integer coresPerSocket) {
		this.coresPerSocket = coresPerSocket;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getTotalCores() {
		return totalCores;
	}
	public void setTotalCores(Integer totalCores) {
		this.totalCores = totalCores;
	}
	public Integer getTotalSockets() {
		return totalSockets;
	}
	public void setTotalSockets(Integer totalSockets) {
		this.totalSockets = totalSockets;
	}
	
	
	
	
	
}
