package com.enation.framework.plugin;

import java.util.List;
import java.util.logging.Logger;


public abstract class AutoRegisterPlugin implements IPlugin {
	protected final Logger logger = Logger.getLogger(AutoRegisterPlugin.class.getName());
	protected List<IPluginBundle> bundleList;

	public List<IPluginBundle> getBundleList() {
		return bundleList;
	}

	public void setBundleList(List<IPluginBundle> bundleList) {
		this.bundleList = bundleList;
	} 
	
	public abstract void register();
}
