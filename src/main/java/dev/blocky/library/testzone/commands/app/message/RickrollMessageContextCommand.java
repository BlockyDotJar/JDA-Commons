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
package dev.blocky.library.testzone.commands.app.message;

import dev.blocky.library.jda.interfaces.app.message.IMessageContext;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;
import org.jetbrains.annotations.NotNull;

/**
 * This is a simple command, which definitely is not going to rickroll you ;D
 *
 * @author BlockyDotJar
 * @version v2.1.0
 * @since v1.0.0
 */
public class RickrollMessageContextCommand implements IMessageContext {

    @Override
    public void onMessageContext(@NotNull MessageContextInteractionEvent event) {
        // Gets the ID of the user
        String userID = event.getUser().getId();

        // Replys a message with a SelectMenu, which has two options (yes and no) and a Button
        event.reply("Do you want infinite money? A villa or a diamond?")
                .addActionRow(
                        SelectMenu.create("rickroll") // Sets the ID of this SelectMenu
                                .addOption("YEEESSS!!!!!!!!", userID + ":yes", "GET IT NOW!!!!", Emoji.fromUnicode("U+1F440")) // Adds the option 'yes', which also has a description and an emoji
                                .addOption("No thank you.", userID + ":no") // Adds the second option 'no', which does not have a description or an emoji
                                .build()
                )
                .addActionRow(Button.danger(userID + ":delete", "Delete Message!")) // Adds a button in a different action row
                .queue();
    }
}
