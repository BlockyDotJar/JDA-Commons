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
package dev.blocky.library.jda.interfaces;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

/**
 * A simple Command Interface, which you can use to easily program message commands.
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.0.0-alpha.3
 */
public interface ICommand {

    /**
     * An interface, which you can use to easily program message commands.
     *
     * <br>
     * This contains a
     * <a href="https://github.com/BlockyDotJar/JDA-Commons/blob/main/src/main/java/dev/blocky/library/testzone/CommandManager.java">Command Manager</a>.
     *
     * @param event The {@link MessageReceivedEvent Message Received Event} for performing a command
     * @param args  An {@link java.lang.reflect.Array Array} of Strings for performing a command
     */
    void onCommand(@NotNull MessageReceivedEvent event, @Nonnull String[] args);
}
