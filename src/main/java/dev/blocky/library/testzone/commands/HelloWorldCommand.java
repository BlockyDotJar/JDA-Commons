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

import dev.blocky.library.jda.entities.GuildMessageChannel;
import dev.blocky.library.jda.interfaces.ICommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.requests.restaction.MessageAction;
import org.jetbrains.annotations.NotNull;

/**
 * This is a simple hello world command.
 *
 * @author BlockyDotJar
 * @version v2.1.0
 * @since v1.0.0-alpha.3
 */
public class HelloWorldCommand implements ICommand
{
    @Override
    public void onCommand(@NotNull MessageReceivedEvent event, @NotNull String[] args)
    {
        // Creates a new guild message channel, by initializing a message channel and a member.
        GuildMessageChannel channel = GuildMessageChannel.set(event.getChannel(), event.getMember());
        // Creates a message action by simply sending a message.
        MessageAction action = event.getChannel().sendMessage("Hello World!");
        //Creates a timeouted message by handing over the message action above and setting a delay of 10 seconds.
        channel.sendTimeoutedMessage(action, 10L, null).queue();
    }
}
