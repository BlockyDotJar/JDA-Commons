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
package dev.blocky.library.jda.interfaces.app.slash;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.jetbrains.annotations.NotNull;

/**
 * A simple Slash Command Interface, which you can use to easily program some slash commands.
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.0.0
 */
public interface ISlashCommand {

    /**
     * An interface, which you can use to easily program some slash commands.
     *
     * <br>
     * <p>
     * This contains a
     * <a href="https://github.com/BlockyDotJar/JDA-Commons/blob/main/src/main/java/dev/blocky/library/testzone/ApplicationCommandManager.java">Application Command Manager</a>.
     *
     * @param event Indicates that a slash command was used in a {@link net.dv8tion.jda.api.entities.MessageChannel MessageChannel}.
     */
    void onSlashCommand(@NotNull SlashCommandInteractionEvent event);
}
