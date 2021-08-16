package com.taskgenerator.UI;

import com.taskgenerator.TaskGeneratorPlugin;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.ImageUtil;

public class TaskGeneratorPanel extends PluginPanel
{
	private final TaskGeneratorPlugin plugin;
	private static final ImageIcon REROLL_ICON;
	private static final String TITLE_STRING = "Task Generator";
	private static final String REROLL_TOOLTIP = "Reroll current task";

	static
	{
		final BufferedImage initRerollIcon = ImageUtil.loadImageResource(TaskGeneratorPlugin.class, "/reroll_icon.png");
		REROLL_ICON = new ImageIcon(initRerollIcon);
	}

	private final JLabel title = new JLabel();
	private final JButton reroll = new JButton(REROLL_ICON);

	public TaskGeneratorPanel(TaskGeneratorPlugin plugin)
	{
		this.plugin = plugin;

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel header = new JPanel(new BorderLayout());
		header.setBorder(new EmptyBorder(1, 0, 10, 0));

		title.setText(TITLE_STRING);

		reroll.setToolTipText(REROLL_TOOLTIP);
		reroll.addActionListener(l -> plugin.rerollTask());

		header.add(title, BorderLayout.WEST);
		header.add(reroll, BorderLayout.EAST);

		header.add(new TaskGeneratorImagePanel(plugin), BorderLayout.SOUTH);

		add(header, BorderLayout.NORTH);

	}
}
