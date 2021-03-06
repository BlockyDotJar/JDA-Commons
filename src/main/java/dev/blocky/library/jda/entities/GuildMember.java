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
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import javax.annotation.CheckReturnValue;
import java.util.List;
import java.util.Objects;

/**
 * Represents a guild-specific {@link net.dv8tion.jda.api.entities.User user}.
 *
 * @author BlockyDotJar
 * @version v2.1.3
 * @since v1.0.0-alpha.1
 */
public class GuildMember
{
    private static final Logger logger = JDALogger.getLog(GuildMember.class);
    private final Member member;

    /**
     * Constructs a <b>new</b> {@link GuildMember guild member}.
     * <br>This is a private constructor, because it should not be accessed for other classes.
     *
     * @param member The {@link Member member}, which should be used to get {@link GuildMember guild member}
     */
    private GuildMember(@Nullable Member member)
    {
        this.member = member;

        if (!member.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MEMBERS))
        {
                logger.warn("The GUILD_MEMBERS intent is not enabled, which means, that some stuff could not work.");
        }
    }

    /**
     * Constructs a <b>new</b> {@link GuildMember guild member} instance.
     * <br>If you don't initialize a {@link Member member}, the {@link GuildMember guild member} always will be <b>null</b>.
     *
     * @param member The {@link Member member}, which should be used to get {@link GuildMember guild member}
     * @return A <b>new</b> {@link GuildMember guild member} instance
     */
    @NotNull
    public static GuildMember set(@Nullable Member member)
    {
        return new GuildMember(member);
    }

    /**
     * The author of the {@link net.dv8tion.jda.api.entities.Message message} received as {@link Member member} object.
     *
     * @return The author of the {@link net.dv8tion.jda.api.entities.Message message} as null-able member object
     */
    @Nullable
    public Member getMember()
    {
        return member;
    }

    /**
     * Checks if the {@link Role role} with the id you specified, is found on the role board of the {@link Member member}.
     *
     * @param roleId The id of the {@link Role role}, which should be checked
     * @return The {@link Role role} with the id you specified
     */
    @Nullable
    @CheckReturnValue
    public Role findRoleById(long roleId)
    {
        List<Role> roles = member.getRoles();
        return roles.stream().filter(role -> role.getIdLong() == roleId).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link Role role} with the id you specified, is found on the role board of the {@link Member member}.
     *
     * @param roleId The id of the {@link Role role}, which should be checked
     * @return The {@link Role role} with the id you specified
     */
    @Nullable
    @CheckReturnValue
    public Role findRoleById(@NotNull String roleId)
    {
        List<Role> roles = member.getRoles();
        return roles.stream().filter(role -> role.getId().equals(roleId)).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link Role role} with the name you specified, is found on the role board of the {@link Member member}.
     *
     * @param roleName The name of the {@link Role role}, which should be checked
     * @return The {@link Role role} with the name you specified
     */
    @Nullable
    @CheckReturnValue
    public Role findRoleByName(@NotNull String roleName)
    {
        List<Role> roles = member.getRoles();
        return roles.stream().filter(role -> role.getName().equals(roleName)).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link Member member} has the {@link Role role} with the id you specified.
     *
     * @param roleId The id of the {@link Role role}, which should be checked
     * @return
     * <b>true</b> - If the {@link Member member} has the {@link Role role}
     * <br><b>false</b> - If the {@link Member member} has not the {@link Role role}
     */
    public boolean hasRoleWithId(long roleId)
    {
        return findRoleById(roleId) != null;
    }

    /**
     * Checks if the {@link Member member} has the {@link Role role} with the id you specified.
     *
     * @param roleId The id of the {@link Role role}, which should be checked
     * @return
     * <b>true</b> - If the {@link Member member} has the {@link Role role}
     * <br><b>false</b> - If the {@link Member member} has not the {@link Role role}
     */
    public boolean hasRoleWithId(@NotNull String roleId)
    {
        return findRoleById(roleId) != null;
    }

    /**
     * Checks if the {@link Member member} has the {@link Role role} with the name you specified.
     *
     * @param roleName The name of the {@link Role role}, which should be checked
     * @return
     * <b>true</b> If the {@link Member member} has the {@link Role role}
     * <br><b>false</b> If the {@link Member member} has not the {@link Role role}
     */
    public boolean hasRoleWithName(@NotNull String roleName)
    {
        return findRoleByName(roleName) != null;
    }

    /**
     * Checks if the {@link Member member} was pinged in a specified {@link Message message}.
     *
     * @param message The {@link Message message}, which should checked, if the {@link Member member} got pinged in the {@link Message message}
     * @return
     * <b>true</b> If the {@link Member member} got pinged in the {@link Message message}
     * <br><b>false</b> If the {@link Member member} got pinged in the {@link Message message}
     */
    public boolean isMentioned(@NotNull Message message)
    {
        return message.getMentions().isMentioned(member, Message.MentionType.USER);
    }

    @Override
    public boolean equals(@Nullable Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        GuildMember that = (GuildMember) o;

        return Objects.equals(member, that.member);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(member);
    }

    @Override
    public String toString()
    {
        return "GuildMember{" +
                "member=" + member +
                '}';
    }
}
