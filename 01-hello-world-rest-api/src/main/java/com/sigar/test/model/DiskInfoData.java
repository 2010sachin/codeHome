package com.sigar.test.model;

public class DiskInfoData {
	
	private String diskName;
	private Long totalMemory;
	private Long freeMemory;
	private Long usedMemory;
	
	private Long diskReads;
	private Long diskWrites;
	private Long diskReadBytes;
	private Long diskWriteBytes;
	
	private Long readBytes;
	private Long writeBytes;
	private Long reads;
	private Long writes;
	
	public String getDiskName() {
		return diskName;
	}
	public void setDiskName(String diskName) {
		this.diskName = diskName;
	}
	public Long getTotalMemory() {
		return totalMemory;
	}
	public void setTotalMemory(Long totalMemory) {
		this.totalMemory = totalMemory;
	}
	public Long getFreeMemory() {
		return freeMemory;
	}
	public void setFreeMemory(Long freeMemory) {
		this.freeMemory = freeMemory;
	}
	public Long getUsedMemory() {
		return usedMemory;
	}
	public void setUsedMemory(Long usedMemory) {
		this.usedMemory = usedMemory;
	}
	public Long getDiskReads() {
		return diskReads;
	}
	public void setDiskReads(Long diskReads) {
		this.diskReads = diskReads;
	}
	public Long getDiskWrites() {
		return diskWrites;
	}
	public void setDiskWrites(Long diskWrites) {
		this.diskWrites = diskWrites;
	}
	public Long getDiskReadBytes() {
		return diskReadBytes;
	}
	public void setDiskReadBytes(Long diskReadBytes) {
		this.diskReadBytes = diskReadBytes;
	}
	public Long getDiskWriteBytes() {
		return diskWriteBytes;
	}
	public void setDiskWriteBytes(Long diskWriteBytes) {
		this.diskWriteBytes = diskWriteBytes;
	}
	public Long getReadBytes() {
		return readBytes;
	}
	public void setReadBytes(Long readBytes) {
		this.readBytes = readBytes;
	}
	public Long getWriteBytes() {
		return writeBytes;
	}
	public void setWriteBytes(Long writeBytes) {
		this.writeBytes = writeBytes;
	}
	public Long getReads() {
		return reads;
	}
	public void setReads(Long reads) {
		this.reads = reads;
	}
	public Long getWrites() {
		return writes;
	}
	public void setWrites(Long writes) {
		this.writes = writes;
	}
	
	
}
