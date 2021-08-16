package com.taskgenerator;

import com.google.inject.Provides;
import com.taskgenerator.UI.TaskGeneratorPanel;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.HotkeyListener;
import net.runelite.client.util.ImageUtil;

@Slf4j
@PluginDescriptor(
	name = "Task Generator"

)
public class TaskGeneratorPlugin extends Plugin
{
	@Inject
	private Client client;

	@Getter
	@Inject
	private TaskGeneratorConfig config;

	@Inject
	private ClientToolbar clientToolbar;

	private NavigationButton navButton;
	private TaskGeneratorPanel panel;

	@Inject
	private KeyManager keyManager;

	private HotkeyListener hotkey;


	@Override
	protected void startUp() throws Exception
	{
		initHotkey();
		keyManager.registerKeyListener(hotkey);
		setupNavPanel();
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Example stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Task Generator Loaded", null);
		}
	}

	public void rerollTask()
	{
		System.out.println("TODO - REROLLING TASK");
	}

	private void initHotkey()
	{
		hotkey = new HotkeyListener(() -> config.rerollTaskHotkey())
		{
			@Override
			public void hotkeyPressed()
			{
				rerollTask();
			}
		};
	}

	private void setupNavPanel() throws Exception
	{
		panel = new TaskGeneratorPanel(this);
		navButton = NavigationButton.builder()
			.tooltip("Task Generator")
			.icon(ImageUtil.loadImageResource(getClass(), "/icon.png"))
			.priority(70)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);
	}

	@Provides
	TaskGeneratorConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(TaskGeneratorConfig.class);
	}
}