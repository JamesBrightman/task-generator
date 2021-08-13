package com.taskgenerator;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class TaskGeneratorTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(TaskGeneratorPlugin.class);
		RuneLite.main(args);
	}
}