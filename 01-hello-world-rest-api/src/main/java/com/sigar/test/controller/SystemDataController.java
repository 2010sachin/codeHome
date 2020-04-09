package com.sigar.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigar.test.model.CpuData;
import com.sigar.test.model.DiskData;
import com.sigar.test.model.MemoryData;
import com.sigar.test.model.NetworkData;
import com.sigar.test.model.ProcessData;
import com.sigar.test.model.SystemConfigData;
import com.sigar.test.model.SystemData;
import com.sigar.test.service.SigarServices;

@RestController
public class SystemDataController {
	
	@Autowired
	SigarServices sigarServices;
	
	@GetMapping(path = "/system-data")
	public SystemData systemData() {
		
		SystemData systemData=new SystemData();
		
		//CpuData cpuData=sigarServices.getCPUInfo();
		
		//DiskData diskData =sigarServices.getDiskUtilizationInfo();
		
		//MemoryData memoryData=sigarServices.getMemoryInfo();
		
		//NetworkData networkData=sigarServices.getNetworkInfo();
		
		ProcessData processData=sigarServices.getProcessInfo();
		
		//SystemConfigData systemConfigData=sigarServices.getSystemConfigInfo();
		
		//systemData.setCpuData(cpuData);
		//systemData.setDiskData(diskData);
		//systemData.setMemoryData(memoryData);
		systemData.setProcessData(processData);
		//systemData.setNetworkData(networkData);
		//systemData.setSystemConfigData(systemConfigData);
		
		return systemData;
	}

}
