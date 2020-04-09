package com.sigar.test.model;

import java.util.List;

public class CpuData {
	
	private String desc;
	private int totolCPU;
	
	private  List<CpuInfoData> cpuInfoLit;
	private  List<CpuUsageData> cpuUsageData;
	
	public int getTotolCPU() {
		return totolCPU;
	}
	public void setTotolCPU(int totolCPU) {
		this.totolCPU = totolCPU;
	}
	public List<CpuInfoData> getCpuInfoLit() {
		return cpuInfoLit;
	}
	public void setCpuInfoLit(List<CpuInfoData> cpuInfoLit) {
		cpuInfoLit = cpuInfoLit;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<CpuUsageData> getCpuUsageData() {
		return cpuUsageData;
	}
	public void setCpuUsageData(List<CpuUsageData> cpuUsageData) {
		this.cpuUsageData = cpuUsageData;
	}

}
