package com.sigar.test.model;

public class MemoryData {
	
	private Long freeMem;
	private Long usedMem;
	private Long totalMem;
	private Long ramMem;
	
	private Long freeSwapMem;
	private Long usedSwapMem;
	private Long totalSwapMem;
	private Long swapPageIn;
	private Long swapPageOut;
	
	private Long residentMem;
	private Long virtualMem;
	

	public Long getFreeMem() {
		return freeMem;
	}
	public void setFreeMem(Long freeMem) {
		this.freeMem = freeMem;
	}
	public Long getUsedMem() {
		return usedMem;
	}
	public void setUsedMem(Long usedMem) {
		this.usedMem = usedMem;
	}
	public Long getTotalMem() {
		return totalMem;
	}
	public void setTotalMem(Long totalMem) {
		this.totalMem = totalMem;
	}
	public Long getRamMem() {
		return ramMem;
	}
	public void setRamMem(Long ramMem) {
		this.ramMem = ramMem;
	}
	public Long getFreeSwapMem() {
		return freeSwapMem;
	}
	public void setFreeSwapMem(Long freeSwapMem) {
		this.freeSwapMem = freeSwapMem;
	}
	public Long getUsedSwapMem() {
		return usedSwapMem;
	}
	public void setUsedSwapMem(Long usedSwapMem) {
		this.usedSwapMem = usedSwapMem;
	}
	public Long getTotalSwapMem() {
		return totalSwapMem;
	}
	public void setTotalSwapMem(Long totalSwapMem) {
		this.totalSwapMem = totalSwapMem;
	}
	public Long getSwapPageIn() {
		return swapPageIn;
	}
	public void setSwapPageIn(Long swapPageIn) {
		this.swapPageIn = swapPageIn;
	}
	public Long getSwapPageOut() {
		return swapPageOut;
	}
	public void setSwapPageOut(Long swapPageOut) {
		this.swapPageOut = swapPageOut;
	}
	public Long getResidentMem() {
		return residentMem;
	}
	public void setResidentMem(Long residentMem) {
		this.residentMem = residentMem;
	}
	public Long getVirtualMem() {
		return virtualMem;
	}
	public void setVirtualMem(Long virtualMem) {
		this.virtualMem = virtualMem;
	}
	

}
