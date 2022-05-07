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
package dev.blocky.library.testzone.commands;

import dev.blocky.library.jda.interfaces.ICommand;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

/**
 * This is a simple hello world command
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.0.0-alpha.3
 */
public class HelloWorldCommand implements ICommand {

    @Override
    public void onCommand(@NotNull MessageReceivedEvent event, @Nonnull String[] args) {
        event.getChannel().sendMessage("Hello World!").queue();
    }
}
