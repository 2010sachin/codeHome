package com.sigar.test.service;

import java.util.ArrayList;
import java.util.List;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.DiskUsage;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.ProcStat;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;
import org.springframework.stereotype.Service;

import com.sigar.test.model.CpuData;
import com.sigar.test.model.CpuInfoData;
import com.sigar.test.model.CpuUsageData;
import com.sigar.test.model.DiskData;
import com.sigar.test.model.DiskInfoData;
import com.sigar.test.model.MemoryData;
import com.sigar.test.model.NetworkData;
import com.sigar.test.model.ProcessData;
import com.sigar.test.model.ProcessInfoData;
import com.sigar.test.model.SystemConfigData;

@Service
public class SigarServicesImpl implements SigarServices {
	
	Sigar sigar=new Sigar();
	
	@Override
	public CpuData getCPUInfo() {
		
		CpuData cpuData = new CpuData();
		List<CpuInfoData> CpuInfoList = new ArrayList<CpuInfoData>();
		int count = 0;
		CpuInfo[] cpuList = null;

		try {
			cpuList = sigar.getCpuInfoList();
		} catch (SigarException e) {
		}
		
		cpuData.setTotolCPU(cpuList.length);

		for (CpuInfo info : cpuList) {
			
			count++;
			
			CpuInfoData cpuInfoData = new CpuInfoData();
		
			cpuInfoData.setCupNum(count);
			cpuInfoData.setVendor(info.getVendor());
			cpuInfoData.setClock(info.getMhz());
			cpuInfoData.setCacheSize(info.getCacheSize());
			cpuInfoData.setCoresPerSocket(info.getCoresPerSocket());
			cpuInfoData.setModel(info.getModel());
			cpuInfoData.setTotalCores(info.getTotalCores());
			cpuInfoData.setTotalSockets(info.getTotalSockets());

			CpuInfoList.add(cpuInfoData);
		}
		cpuData.setCpuInfoLit(CpuInfoList);
		
		
		List<CpuUsageData> cpuUsageList =new ArrayList<>();
		
		CpuPerc[] percList;
		try {
			percList = sigar.getCpuPercList();
			
			for (CpuPerc perc : percList) {
				CpuUsageData data=new CpuUsageData();
				
				data.setUser(perc.getUser());
	            data.setSys(perc.getSys());
	            data.setNice(perc.getNice());
	            data.setWait(perc.getWait());
	            data.setIdle(perc.getIdle());
	            data.setCombined(perc.getCombined());
	            data.setIrq(perc.getIrq());
	            data.setSoftIrq(perc.getSoftIrq());
	            data.setStolen(perc.getStolen());
	            
	            cpuUsageList.add(data);
			}
			
		} catch (SigarException e) {
			e.printStackTrace();
		}
		
		cpuData.setCpuUsageData(cpuUsageList);
		
		return cpuData;
	}

	@Override
	public DiskData getDiskUtilizationInfo() {
		
		FileSystem[] fileList=null;
		
		DiskData diskData=new DiskData();
		
		diskData.setDesc("Disk Information");
		
		List<DiskInfoData> diskInfoList=new ArrayList<>();
		
		try {
			fileList=sigar.getFileSystemList();
			
			for (FileSystem fileSystem : fileList) { 

				if(FileSystem.TYPE_LOCAL_DISK == fileSystem.getType())	{
					
					DiskInfoData data=new DiskInfoData();
					data.setDiskName(fileSystem.getDirName());
									
					FileSystemUsage fileSystemUsage = sigar.getFileSystemUsage(fileSystem.getDirName());

					data.setTotalMemory(fileSystemUsage.getTotal());
					data.setFreeMemory(fileSystemUsage.getTotal());
					data.setUsedMemory(fileSystemUsage.getFree());
					
					data.setDiskReadBytes(fileSystemUsage.getDiskReadBytes());
					data.setDiskWriteBytes(fileSystemUsage.getDiskWriteBytes());
					data.setDiskReads(fileSystemUsage.getDiskReads());
					data.setDiskWrites(fileSystemUsage.getDiskWrites());
					
					DiskUsage diskUsage =sigar.getDiskUsage(fileSystem.getDirName());
					
					data.setReadBytes(diskUsage.getReadBytes());
					data.setWriteBytes(diskUsage.getWriteBytes());
					data.setReads(diskUsage.getReads());
					data.setWrites(diskUsage.getWrites());
					
					diskInfoList.add(data);
				}
			}
			
		} catch (SigarException e) {
		}
		
		diskData.setDiskInfoList(diskInfoList);
		
		return diskData;
	}

	@Override
	public MemoryData getMemoryInfo() {
		
		MemoryData memoryData = new MemoryData();
		try {
			// System.out.println("sigar.getPid()-:"+sigar.getPid());
			memoryData.setResidentMem(sigar.getProcMem(sigar.getPid()).getResident());
			memoryData.setVirtualMem(sigar.getProcMem(sigar.getPid()).getSize());

			Mem mem = sigar.getMem();
			memoryData.setRamMem(mem.getRam());
			memoryData.setFreeMem(mem.getFree());
			memoryData.setUsedMem(mem.getUsed());
			memoryData.setTotalMem(mem.getTotal());

			Swap swap = sigar.getSwap();
			memoryData.setFreeSwapMem(swap.getFree());
			memoryData.setSwapPageIn(swap.getPageIn());
			memoryData.setSwapPageOut(swap.getPageOut());
			memoryData.setTotalSwapMem(swap.getTotal());
			memoryData.setUsedSwapMem(swap.getUsed());

		} catch (SigarException se) {
			se.getMessage();
		} catch (UnsatisfiedLinkError ule) {
			System.out.println("OS memory: (missing native libraries)");
		}
		return memoryData;
	}

	@Override
	public NetworkData getNetworkInfo() {
		return null;
	}

	@Override
	public ProcessData getProcessInfo() {
		
		Sigar sigar=new Sigar();
		ProcessData processData = new ProcessData();
		List<ProcessInfoData> processInfoList = new ArrayList<>();
		int count = 0;
		
		try {
			ProcStat procStat = sigar.getProcStat();
			System.out.println("procStat -:" + procStat);

			long[] pids = sigar.getProcList();

			

			for (int i = 0; i < pids.length; i++) {

				ProcessInfoData data = new ProcessInfoData();

				long pid = pids[i];

				// System.out.println("PID=" + pid );
				data.setPid(pid);
				// System.out.println("sigar.getProcCred(pid)-:"+sigar.getProcCred(pid)); error

				// System.out.println("sigar.getProcCpu(pid)-:"+sigar.getProcCpu(pid));
				data.setProcCpuUser(sigar.getProcCpu(pid).getUser());
				data.setProcCpuSys(sigar.getProcCpu(pid).getSys());
				data.setProcCpuPercent(sigar.getProcCpu(pid).getPercent());
				data.setProcCpuTotal(sigar.getProcCpu(pid).getTotal());
				data.setProcCpuStartTime(sigar.getProcCpu(pid).getStartTime());
				data.setProcCpuLastTime(sigar.getProcCpu(pid).getLastTime());

				// System.out.println("sigar.getProcCredName(pid)-:"+sigar.getProcCredName(pid));
				data.setProcCredNameGroup(sigar.getProcCredName(pid).getGroup());
				data.setProcCredNameUser(sigar.getProcCredName(pid).getUser());

				// System.out.println("sigar.getProcEnv(pid):-"+sigar.getProcEnv(pid));

				// System.out.println("sigar.getProcExe(pid):-"+sigar.getProcExe(pid));
				data.setProcExeCwd(sigar.getProcExe(pid).getCwd());
				data.setProcExeCwd(sigar.getProcExe(pid).getName());

				// System.out.println("sigar.getProcFd(pid):-"+sigar.getProcFd(pid));
				data.setProcFdTotal(sigar.getProcFd(pid).getTotal());

				// System.out.println("sigar.getProcModules(pid)-:"+sigar.getProcModules(pid));

				// System.out.println("sigar.getProcTime(pid)-:"+sigar.getProcTime(pid));
				data.setProcTimeUser(sigar.getProcTime(pid).getUser());
				data.setProcTimeSys(sigar.getProcTime(pid).getSys());
				data.setProcTimeTotal(sigar.getProcTime(pid).getTotal());
				data.setProcTimeStartTime(sigar.getProcTime(pid).getStartTime());

				// System.out.println("sigar.getProcMem(pid)-:"+sigar.getProcMem(pid));
				data.setProcMemPageFaults(sigar.getProcMem(pid).getPageFaults());
				data.setProcMemMajorFaults(sigar.getProcMem(pid).getMajorFaults());
				data.setProcMemMinorFaults(sigar.getProcMem(pid).getMinorFaults());
				data.setProcMemResident(sigar.getProcMem(pid).getResident());
				data.setProcMemVsize(sigar.getProcMem(pid).getVsize());
				data.setProcMemSize(sigar.getProcMem(pid).getSize());
				data.setProcMemRss(sigar.getProcMem(pid).getRss());
				data.setProcMemShare(sigar.getProcMem(pid).getShare());

				count++;

				processInfoList.add(data);

				//System.out.println(processInfoList);
			}
		} catch (SigarException e) {
				    	e.printStackTrace();
					System.err.println("Could not get information for PID: " );
					    }
		
		processData.setProcessInfoList(processInfoList);

		System.out.println("count-:"+count);
	
		return processData;
	}

	@Override
	public SystemConfigData getSystemConfigInfo() {
		
		OperatingSystem sys = OperatingSystem.getInstance();
		
		SystemConfigData systemConfigData=new SystemConfigData();

		systemConfigData.setOsDescription(sys.getDescription());
		systemConfigData.setOsName(sys.getName());
		systemConfigData.setOsArch(sys.getArch());
		systemConfigData.setOsMachine(sys.getMachine());
		systemConfigData.setOsVersion(sys.getVersion());
		systemConfigData.setOsPatchLevel(sys.getPatchLevel());
		systemConfigData.setOsVendor(sys.getVendor());
		systemConfigData.setOsVendorVersion(sys.getVendorVersion());

		if (sys.getVendorCodeName() != null) 
		{
			systemConfigData.setOsVendorCodeName(sys.getVendorCodeName());
			systemConfigData.setOsDataModel(sys.getDataModel());
			systemConfigData.setOsCpuEndian(sys.getCpuEndian());
		}

		CpuInfo[] cpuInfoList;
		try {
			cpuInfoList = sigar.getCpuInfoList();
		

		System.out.println(cpuInfoList[0].getModel());

		FileSystem[] fileList = sigar.getFileSystemList();
		List<DiskInfoData> diskInfoList=new ArrayList<>();
		
		for (FileSystem fileSystem : fileList) { 

			if(FileSystem.TYPE_LOCAL_DISK == fileSystem.getType())	{
				
				DiskInfoData data=new DiskInfoData();
				data.setDiskName(fileSystem.getDirName());
								
				FileSystemUsage fileSystemUsage = sigar.getFileSystemUsage(fileSystem.getDirName());

				data.setTotalMemory(fileSystemUsage.getTotal());
				data.setFreeMemory(fileSystemUsage.getTotal());
				data.setUsedMemory(fileSystemUsage.getFree());
				
				data.setDiskReadBytes(fileSystemUsage.getDiskReadBytes());
				data.setDiskWriteBytes(fileSystemUsage.getDiskWriteBytes());
				data.setDiskReads(fileSystemUsage.getDiskReads());
				data.setDiskWrites(fileSystemUsage.getDiskWrites());
				
				DiskUsage diskUsage =sigar.getDiskUsage(fileSystem.getDirName());
				
				data.setReadBytes(diskUsage.getReadBytes());
				data.setWriteBytes(diskUsage.getWriteBytes());
				data.setReads(diskUsage.getReads());
				data.setWrites(diskUsage.getWrites());
				
				diskInfoList.add(data);
			}
		}
		
		systemConfigData.setDiskInfoList(diskInfoList);
		} catch (SigarException e) {
			e.printStackTrace();
		}
	return systemConfigData;
	}

}
