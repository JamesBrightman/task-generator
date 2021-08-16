package com.taskgenerator.UI;

import com.taskgenerator.TaskGeneratorPlugin;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TaskGeneratorImagePanel extends JPanel
{
	private final TaskGeneratorPlugin plugin;
	private final JLabel picLabel;
	private final boolean includeCombat;
	private final boolean includeSkills;

	TaskGeneratorImagePanel(TaskGeneratorPlugin plugin)
	{
		this.plugin = plugin;
		this.includeCombat = plugin.getConfig().includeCombat();
		this.includeSkills = plugin.getConfig().includeSkilling();

		getRandomTask();

		picLabel = new JLabel("phaseIcon");
		add(picLabel);
	}

	private String getRandomTask()
	{
		//TODO - Read in skillingTasks.json, then pick a random object from the array, then print it to console
		return "";
	}

	private String getTaskData()
	{
		if (includeCombat && !includeSkills)
		{

		}
		else if (includeSkills && !includeCombat)
		{

		}
		else if (!includeSkills && !includeCombat)
		{

		}
		else
		{

		}
		return "";
	}
}
