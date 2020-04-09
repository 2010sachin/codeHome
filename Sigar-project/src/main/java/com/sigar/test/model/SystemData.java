package com.sigar.test.model;

public class SystemData {
	
	private CpuData cpuData;
	private CpuUsageData cpuUsageData;
	private DiskData diskData;
	private MemoryData memoryData;
	private SystemConfigData systemConfigData;
	private NetworkData networkData;
	private ProcessData processData;
	
	public CpuData getCpuData() {
		return cpuData;
	}
	public void setCpuData(CpuData cpuData) {
		this.cpuData = cpuData;
	}
	public DiskData getDiskData() {
		return diskData;
	}
	public void setDiskData(DiskData diskData) {
		this.diskData = diskData;
	}
	public MemoryData getMemoryData() {
		return memoryData;
	}
	public void setMemoryData(MemoryData memoryData) {
		this.memoryData = memoryData;
	}
	public SystemConfigData getSystemConfigData() {
		return systemConfigData;
	}
	public void setSystemConfigData(SystemConfigData systemConfigData) {
		this.systemConfigData = systemConfigData;
	}
	public NetworkData getNetworkData() {
		return networkData;
	}
	public void setNetworkData(NetworkData networkData) {
		this.networkData = networkData;
	}
	public ProcessData getProcessData() {
		return processData;
	}
	public void setProcessData(ProcessData processData) {
		this.processData = processData;
	}
	public CpuUsageData getCpuUsageData() {
		return cpuUsageData;
	}
	public void setCpuUsageData(CpuUsageData cpuUsageData) {
		this.cpuUsageData = cpuUsageData;
	}
	
	
}
