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
package dev.blocky.library.jda;

import dev.blocky.library.jda.annotations.Deadline;

import javax.annotation.Nonnull;

/**
 * This is a Client for the JDA-Commons Library.
 * <br>
 * The exact use is still unknown.
 *
 * @author BlockyDotJar
 * @version v1.0.0-alpha.1
 * @since v1.0.0
 */
@Deadline(version = "v1.5.0")
public final class CommonsClient {

    /**
     * Constructs a new {@link CommonsClient Commons Client}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     */
    private CommonsClient() {
    }

    /**
     * This is the Builder for the {@link CommonsClient Commons Client}
     *
     * @author BlockyDotJar
     * @version v1.0.0-alpha.1
     * @since v1.0.0
     */
    @Deadline(version = "v1.6.0")
    public static class Builder {

        /**
         * Represents a new {@link CommonsClient Commons Client} instance
         *
         * @return new {@link CommonsClient Commons Client}
         */
        @Nonnull
        public static CommonsClient getCommonsClient() {
            return new CommonsClient();
        }
    }
}
