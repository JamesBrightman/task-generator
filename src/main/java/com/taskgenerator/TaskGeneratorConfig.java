package com.taskgenerator;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup("TaskGenerator")
public interface TaskGeneratorConfig extends Config
{
	@ConfigItem(
		keyName = "includeSkilling",
		name = "Include skilling tasks",
		description = "Task generator can assign skilling tasks",
		position = 1
	)
	default boolean includeSkilling()
	{
		return true;
	}

	@ConfigItem(
		keyName = "includeCombat",
		name = "Include combat tasks",
		description = "Task generator can assign combat tasks",
		position = 2
	)
	default boolean includeCombat()
	{
		return true;
	}

	@ConfigItem(
		keyName = "onlyCompletable",
		name = "All tasks completable",
		description = "Only generate completable tasks for your character",
		position = 3
	)
	default boolean onlyCompletable()
	{
		return false;
	}

	@ConfigItem(
		keyName = "rerollTaskHotkey",
		name = "Reroll Task",
		description = "Generate a new task",
		position = 3
	)
	default Keybind rerollTaskHotkey()
	{
		return Keybind.NOT_SET;
	}
}
