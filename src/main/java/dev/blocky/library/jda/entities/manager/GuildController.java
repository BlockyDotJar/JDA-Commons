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
package dev.blocky.library.jda.entities.manager;

import dev.blocky.library.jda.annotations.Deadline;
import dev.blocky.library.jda.entities.SelfMember;
import net.dv8tion.jda.api.entities.Guild;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * This is a controller you can control guilds with.
 * <br>
 * The exact use is still unknown.
 *
 * @author BlockyDotJar
 * @version v1.0.0-alpha.1
 * @since v1.0.0
 */
@Deadline(version = "v1.5.0")
public class GuildController {

    /**
     * Constructs a new {@link GuildController Guild Controller}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     */
    private GuildController() {
    }

    /**
     * Get a new {@link SelfMember}, by initializing a specific {@link Guild Guild}
     *
     * @return A <b>new</b> {@link SelfMember Self Member} instance
     */
    @Nullable
    public SelfMember getSelfMember(Guild guild) {
        return new SelfMember(guild);
    }

    /**
     * Represents a new {@link GuildController Guild Controller} instance
     *
     * @return new {@link GuildController Guild Controller}
     */
    @Nonnull
    public static GuildController getGuildController() {
        return new GuildController();
    }
}
