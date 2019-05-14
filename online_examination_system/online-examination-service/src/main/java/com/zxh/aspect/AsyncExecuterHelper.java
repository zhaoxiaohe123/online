package com.zxh.aspect;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

public class AsyncExecuterHelper {

Map<String, ThreadPoolExecutor> commandMap = new HashMap<String, ThreadPoolExecutor>();
	
	public void execute(String name, int capacity, int maxCapacity, int queueCapacity, Runnable command){
		
		ThreadPoolExecutor threadPoolExecutor = null;
		synchronized (commandMap) {
			threadPoolExecutor = commandMap.get(name);
			if(threadPoolExecutor==null){
				threadPoolExecutor = new ThreadPoolExecutor(capacity, maxCapacity, 
						3000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(queueCapacity), 
						Executors.defaultThreadFactory(), new CallerRunsPolicy());
				commandMap.put(name, threadPoolExecutor);
			}
		}
		threadPoolExecutor.execute(command);
	}
}
