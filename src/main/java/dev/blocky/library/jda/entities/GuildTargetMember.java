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

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

/**
 * Represents the {@link net.dv8tion.jda.api.entities.Member member} instance for the target
 * {@link net.dv8tion.jda.api.entities.User user}.
 *
 * @author BlockyDotJar
 * @version v1.1.0
 * @since v1.0.0-alpha.4
 */
public class GuildTargetMember
{
    private static final Logger logger = LoggerFactory.getLogger(GuildTargetMember.class);
    private UserContextInteractionEvent userEvent;
    private MessageContextInteractionEvent messageEvent;

    /**
     * Constructs a new {@link GuildTargetMember guild target member}.
     * <br> This is a private constructor, because it should not be accessed for other classes.
     */
    private GuildTargetMember()
    {
    }

    /**
     * Constructs a new {@link GuildTargetMember guild target member}.
     * <br> This is a private constructor, because it should not be accessed for other classes.
     *
     * @param userEvent The {@link UserContextInteractionEvent user context interaction event}, which should be
     *                  used to get {@link GuildTargetMember guild target member}
     */
    private GuildTargetMember(@NotNull UserContextInteractionEvent userEvent)
    {
        this.userEvent = userEvent;

        if (JDALogger.SLF4J_ENABLED)
        {
            if (!userEvent.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MEMBERS))
            {
                logger.warn("The GUILD_MEMBERS intent is not enabled, which means, that some stuff could not work.");
                return;
            }

            if (userEvent == null)
            {
                logger.error("The user context interaction event you specify equals null.", new NullPointerException());
            }
        }
    }


    /**
     * Constructs a new {@link GuildTargetMember guild target member}.
     * <br> This is a private constructor, because it should not be accessed for other classes.
     *
     * @param messageEvent The {@link MessageContextInteractionEvent message context interaction event}, which should be
     *                     used to get {@link GuildTargetMember guild target member}
     */
    private GuildTargetMember(@NotNull MessageContextInteractionEvent messageEvent)
    {
        this.messageEvent = messageEvent;

        if (JDALogger.SLF4J_ENABLED)
        {
            if (!messageEvent.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MEMBERS))
            {
                logger.warn("The GUILD_MEMBERS Intent is not enabled, which means, that some stuff could not work.");
                return;
            }

            if (messageEvent == null)
            {
                logger.error("The message context interaction event you specify equals null.", new NullPointerException());
            }
        }
    }

    /**
     * Constructs a <b>new</b> {@link GuildTargetMember guild target member} instance. If you don't
     * initialize a {@link UserContextInteractionEvent user context interaction event},
     * {@link GuildTargetMember Guild Target Member} always will be <b>null</b>.
     *
     * @param userEvent The {@link UserContextInteractionEvent user context interaction event}, which should be initialized
     * @return A <b>new</b> {@link GuildTargetMember guild target member} instance
     */
    @NotNull
    public static GuildTargetMember set(@Nullable UserContextInteractionEvent userEvent)
    {
        return new GuildTargetMember(userEvent);
    }

    /**
     * Constructs a <b>new</b> {@link GuildTargetMember guild target member} instance. If you don't
     * initialize a {@link MessageContextInteractionEvent message context interaction event},
     * {@link GuildTargetMember guild target member} always will be <b>null</b>.
     *
     * @param messageEvent The {@link MessageContextInteractionEvent message context interaction event}, which should be initialized
     * @return A <b>new</b> {@link GuildTargetMember guild target member} instance
     */
    @NotNull
    public static GuildTargetMember set(@Nullable MessageContextInteractionEvent messageEvent)
    {
        return new GuildTargetMember(messageEvent);
    }

    /**
     * Indicates that a user context command was used.
     *
     * @return The {@link UserContextInteractionEvent user context interaction event}
     */
    @Nullable
    public UserContextInteractionEvent getUserContext()
    {
        return userEvent;
    }

    /**
     * Indicates that a message context command was used.
     *
     * @return The {@link MessageContextInteractionEvent message context interaction event}
     */
    @Nullable
    public MessageContextInteractionEvent getMessageContext()
    {
        return messageEvent;
    }

    /**
     * Checks if the {@link Role role} with the id you specified, is found on the role board of the {@link Member target member}.
     *
     * @param roleId The id of the {@link Role role}, which should be checked
     * @return
     * <b>not-null -</b> If the {@link Role role} is found on the role board of the {@link Member target member}
     * <br><b>null -</b> If the {@link Role role} is not found on the role board of the {@link Member target member}
     */
    @Nullable
    public Role findRoleById(long roleId)
    {
        List<Role> roles = userEvent != null ? userEvent.getTargetMember().getRoles() : messageEvent.getTarget().getMember().getRoles();
        return roles.stream().filter(role -> role.getIdLong() == roleId).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link Role role} with the id you specified, is found on the role board of the {@link Member target member}.
     *
     * @param roleId The id of the {@link Role role}, which should be checked
     * @return
     * <b>not-null -</b> If the {@link Role role} is found on the role board of the {@link Member target member}
     * <br><b>null -</b> If the {@link Role role} is not found on the role board of the {@link Member target member}
     */
    @Nullable
    public Role findRoleById(@NotNull String roleId)
    {
        List<Role> roles = userEvent != null ? userEvent.getTargetMember().getRoles() : messageEvent.getTarget().getMember().getRoles();
        return roles.stream().filter(role -> role.getId().equals(roleId)).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link Role role} with the name you specified, is found on the role board of the {@link Member target member}.
     *
     * @param roleName The name of the {@link Role role}, which should be checked
     * @return
     * <b>not-null -</b> If the {@link Role role} is found on the role board of the {@link Member target member}
     * <br><b>null -</b> If the {@link Role role} is not found on the role board of the {@link Member target member}
     */
    @Nullable
    public Role findRoleByName(@NotNull String roleName)
    {
        List<Role> roles = userEvent != null ? userEvent.getTargetMember().getRoles() : messageEvent.getTarget().getMember().getRoles();
        return roles.stream().filter(role -> role.getName().equals(roleName)).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link Member target member} has the {@link Role role} with the id you specified.
     *
     * @param roleId The id of the {@link Role role}, which should be checked
     * @return
     * <b>true -</b> If the {@link Member target member} has the {@link Role role}
     * <br><b>false -</b> If the {@link Member target member} has not the {@link Role role}
     */
    public boolean hasRoleWithId(long roleId)
    {
        return findRoleById(roleId) != null;
    }

    /**
     * Checks if the {@link Member target member} has the {@link Role role} with the id you specified.
     *
     * @param roleId The id of the {@link Role role}, which should be checked
     * @return
     * <b>true -</b> If the {@link Member target member} has the {@link Role role}
     * <br><b>false -</b> If the {@link Member target member} has not the {@link Role role}
     */
    public boolean hasRoleWithId(@NotNull String roleId)
    {
        return findRoleById(roleId) != null;
    }

    /**
     * Checks if the {@link Member target member} has the {@link Role role} with the name you specified.
     *
     * @param roleName The name of the {@link Role role}, which should be checked
     * @return
     * <b>true -</b> If the {@link Member target member} has the {@link Role role}
     * <br><b>false -</b> If the {@link Member target member} has not the {@link Role role}
     */
    public boolean hasRoleWithName(@NotNull String roleName)
    {
        return findRoleByName(roleName) != null;
    }

    /**
     * Checks if a {@link Member target member} is a server booster.
     *
     * @return
     * <b>true -</b> If the {@link Member target member} is boosting the server
     * <br><b>false -</b> If the {@link Member target member} is not boosting the server
     */
    public boolean isServerBooster()
    {
        return userEvent != null ? userEvent.getTargetMember().getTimeBoosted() != null :
                messageEvent.getTarget().getMember().getTimeBoosted() != null;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        GuildTargetMember that = (GuildTargetMember) o;

        return Objects.equals(userEvent, that.userEvent) && Objects.equals(messageEvent, that.messageEvent);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(userEvent, messageEvent);
    }

    @Override
    public String toString()
    {
        return userEvent != null ?
                "GuildTargetMember{" +
                        "userEvent=" + userEvent +
                        '}' :
                "GuildTargetMember{" +
                        ", messageEvent=" + messageEvent +
                        '}';
    }
}
