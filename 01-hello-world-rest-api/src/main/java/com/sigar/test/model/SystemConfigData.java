package com.sigar.test.model;

import java.util.List;

public class SystemConfigData {
	
	private String osDescription;
	private String osName;
	private String osArch;
	private String osMachine;
	private String osVersion;
	private String osPatchLevel;
	private String osVendor;
	private String osVendorVersion;
	private String osVendorCodeName;
	private String osDataModel;
	private String osCpuEndian;
	
	private List<DiskInfoData> diskInfoList;

	public String getOsDescription() {
		return osDescription;
	}

	public void setOsDescription(String osDescription) {
		this.osDescription = osDescription;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public String getOsArch() {
		return osArch;
	}

	public void setOsArch(String osArch) {
		this.osArch = osArch;
	}

	public String getOsMachine() {
		return osMachine;
	}

	public void setOsMachine(String osMachine) {
		this.osMachine = osMachine;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getOsPatchLevel() {
		return osPatchLevel;
	}

	public void setOsPatchLevel(String osPatchLevel) {
		this.osPatchLevel = osPatchLevel;
	}

	public String getOsVendor() {
		return osVendor;
	}

	public void setOsVendor(String osVendor) {
		this.osVendor = osVendor;
	}

	public String getOsVendorVersion() {
		return osVendorVersion;
	}

	public void setOsVendorVersion(String osVendorVersion) {
		this.osVendorVersion = osVendorVersion;
	}

	public String getOsVendorCodeName() {
		return osVendorCodeName;
	}

	public void setOsVendorCodeName(String osVendorCodeName) {
		this.osVendorCodeName = osVendorCodeName;
	}

	public String getOsDataModel() {
		return osDataModel;
	}

	public void setOsDataModel(String osDataModel) {
		this.osDataModel = osDataModel;
	}

	public String getOsCpuEndian() {
		return osCpuEndian;
	}

	public void setOsCpuEndian(String osCpuEndian) {
		this.osCpuEndian = osCpuEndian;
	}

	public List<DiskInfoData> getDiskInfoList() {
		return diskInfoList;
	}

	public void setDiskInfoList(List<DiskInfoData> diskInfoList) {
		diskInfoList = diskInfoList;
	}
}
