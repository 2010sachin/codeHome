package com.sigar.test.service;

import com.sigar.test.model.CpuData;
import com.sigar.test.model.DiskData;
import com.sigar.test.model.MemoryData;
import com.sigar.test.model.NetworkData;
import com.sigar.test.model.ProcessData;
import com.sigar.test.model.SystemConfigData;

public interface SigarServices {

	public CpuData getCPUInfo();
	public DiskData getDiskUtilizationInfo();
	public MemoryData getMemoryInfo();
	public NetworkData getNetworkInfo();
	public ProcessData getProcessInfo();
	public SystemConfigData getSystemConfigInfo();

}
