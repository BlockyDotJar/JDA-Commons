/**
 * Copyright 2022 Dominic (aka. BlockyDotJar)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.blocky.library.testzone;

import dev.blocky.library.jda.interfaces.app.message.IMessageContext;
import dev.blocky.library.jda.interfaces.app.slash.ISlashCommand;
import dev.blocky.library.jda.interfaces.app.user.IUserContext;
import dev.blocky.library.testzone.commands.app.message.IDMessageContextCommand;
import dev.blocky.library.testzone.commands.app.slash.PingSlashCommand;
import dev.blocky.library.testzone.commands.app.user.AvatarUserContextCommand;

import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import org.jetbrains.annotations.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This is a class, which manages
 * {@link SlashCommandInteractionEvent Slash Commands},
 * {@link MessageContextInteractionEvent Message Context Menus} and
 * {@link UserContextInteractionEvent User Context Menus}
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.0.0
 */
public class ApplicationCommandManager extends ListenerAdapter {
    private final Map<String, ISlashCommand> slashMap;
    private final Map<String, IUserContext> userMap;
    private final Map<String, IMessageContext> messageMap;

    private static final Logger logger = LoggerFactory.getLogger(ApplicationCommandManager.class);

    /**
     * Constructs a new {@link ApplicationCommandManager
     * Application Command Manager}
     */
    public ApplicationCommandManager() {
        slashMap = new ConcurrentHashMap<>();
        userMap = new ConcurrentHashMap<>();
        messageMap = new ConcurrentHashMap<>();

        /*
         * Here you can import your Slash Commands
         */

        slashMap.put("ping", new PingSlashCommand());

        /*
         * Here you can import your User Context Commands
         */

        userMap.put("avatar", new AvatarUserContextCommand());

        /*
         * Here you can import your Message Context Commands
         */

        messageMap.put("userID", new IDMessageContextCommand());

        DiscordBotExample.getJDA().updateCommands()
                .addCommands(Commands.slash("ping", "Shows the ping of the bot!"))
                .addCommands(Commands.user("avatar"))
                .addCommands(Commands.message("userID"))
                .queue();
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String commandName = event.getName();
        ISlashCommand command = slashMap.get(commandName);

        command.onSlashCommand(event);

        logger.debug(event.getGuild() == null ? "The specified Guild equals null" : "Successfully found guild");
    }

    @Override
    public void onMessageContextInteraction(@NotNull MessageContextInteractionEvent event) {
        String commandName = event.getName();
        IMessageContext command = messageMap.get(commandName);

        command.onMessageContext(event);

        logger.debug(event.getGuild() == null ? "The specified Guild equals null" : "Successfully found guild");
    }

    @Override
    public void onUserContextInteraction(@NotNull UserContextInteractionEvent event) {
        String commandName = event.getName();
        IUserContext command = userMap.get(commandName);

        command.onUserContext(event);

        logger.debug(event.getGuild() == null ? "The specified Guild equals null" : "Successfully found guild");
    }
}
