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

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;

import javax.annotation.Nonnull;

/**
 * Represents the Self Member (aka. the bot itself) of a specific {@link Guild Guild}.
 *
 * @author BlockyDotJar
 * @version v1.0.0
 * @since v1.0.1
 */
public class SelfMember {
    private Guild guild;

    /**
     * Constructs a new {@link SelfMember Self Member}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     */
    private SelfMember() {
    }

    /**
     * Constructs a new {@link SelfMember Self Member}
     *
     * @param guild The {@link Guild Guild}, which should be used to get {@link SelfMember Self Member}
     */
    public SelfMember(@Nonnull Guild guild) {
        this.guild = guild;
    }

    /**
     * Checks if {@link SelfMember Self Member} was pinged in a specified message.
     *
     * @param message The {@link Message Message}, which should checked, if there is a {@link SelfMember Self Member} ping in it
     * @return <b>true -</b> If the {@link SelfMember Self Member} was pinged
     * <b>false -</b> If the {@link SelfMember Self Member} was not pinged
     */
    public boolean isPinged(@Nonnull Message message) {
        return message.getContentDisplay().startsWith("@" + guild.getSelfMember().getEffectiveName());
    }
}
