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
package dev.blocky.library.jda.entities;

import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;

import javax.annotation.Nonnull;

/**
 * Represents the {@link net.dv8tion.jda.api.entities.Member member} instance for the target
 * {@link net.dv8tion.jda.api.entities.User User}.
 *
 * @author BlockyDotJar
 * @version v1.0.0
 * @since v1.0.0-alpha.4
 */
public class GuildTargetMember {
    private UserContextInteractionEvent userEvent;
    private MessageContextInteractionEvent messageEvent;

    /**
     * Constructs a new {@link GuildTargetMember Guild Target Member}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     */
    private GuildTargetMember() {
    }

    /**
     * Constructs a <b>new</b> {@link GuildTargetMember Guild Target Member} instance. If you don't
     * initialize a {@link net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent
     * User Context Interaction Event}, {@link GuildTargetMember Guild Target Member}
     * always will be <b>null</b>.
     *
     * @param userEvent The {@link net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent
     *                  User Context Interaction Event}, which should be initialized.
     */
    public GuildTargetMember(@Nonnull UserContextInteractionEvent userEvent) {
        this.userEvent = userEvent;
    }


    /**
     * Constructs a <b>new</b> {@link GuildTargetMember Guild Target Member} instance. If you don't
     * initialize a {@link net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent
     * Message Context Interaction Event}, {@link GuildTargetMember Guild Target Member}
     * always will be <b>null</b>.
     *
     * @param messageEvent The {@link net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent
     *                     Message Context Interaction Event}, which should be initialized.
     */
    public GuildTargetMember(@Nonnull MessageContextInteractionEvent messageEvent) {
        this.messageEvent = messageEvent;
    }

    /**
     * Constructs a <b>new</b> {@link GuildTargetMember Guild Target Member} instance. If you don't
     * initialize a {@link net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent
     * User Context Interaction Event} or a {@link net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent
     * Message Context Interaction Event}, {@link GuildTargetMember Guild Target Member}
     * always will be <b>null</b>.
     *
     * @param userEvent    The {@link net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent
     *                     User Context Interaction Event}, which should be initialized.
     * @param messageEvent The {@link net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent
     *                     Message Context Interaction Event}, which should be initialized.
     */
    public GuildTargetMember(@Nonnull UserContextInteractionEvent userEvent, @Nonnull MessageContextInteractionEvent messageEvent) {
        this.userEvent = userEvent;
        this.messageEvent = messageEvent;
    }

    /**
     * Checks if a
     * {@link net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent#getTargetMember()
     * Target Member} is a Server Booster or not.
     *
     * @return <b>true</b> If the target member is boosting the server. <br>
     * <b>false</b> If the target member is not boosting the server.
     */
    public boolean isServerBooster() {
        return userEvent.getTargetMember().getTimeBoosted() != null || messageEvent.getTarget().getMember().getTimeBoosted() != null;
    }
}
