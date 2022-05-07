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
package dev.blocky.library.testzone.commands.app.slash;

import dev.blocky.library.jda.interfaces.app.slash.ISlashCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.OffsetDateTime;

/**
 * This is a simple ping slash command
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.0.0
 */
public class PingSlashCommand implements ISlashCommand {

    @Override
    public void onSlashCommand(@NotNull SlashCommandInteractionEvent event) {
        long restPing = event.getJDA().getRestPing().complete();
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTimestamp(OffsetDateTime.now());
        builder.setFooter(event.getMember().getUser().getAsTag());
        builder.setTitle("Ping? Pong! 🏓");
        builder.addField("Discord API Gateway Ping:",
                "```yml\n" + event.getJDA().getGatewayPing() + "ms ```\n", true);
        builder.addField("Discord API REST Ping:", "```yml\n" + restPing + "ms ```", true);

        if (event.getJDA().getGatewayPing() >= 200) {
            builder.setColor(Color.RED);
        } else if (event.getJDA().getGatewayPing() >= 100 && event.getJDA().getGatewayPing() <= 199) {
            builder.setColor(Color.YELLOW);
        } else if (event.getJDA().getGatewayPing() <= 99) {
            builder.setColor(Color.GREEN);
        }

        event.replyEmbeds(builder.build()).queue();
    }
}
