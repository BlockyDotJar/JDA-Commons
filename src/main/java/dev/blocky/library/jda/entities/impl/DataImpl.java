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
package dev.blocky.library.jda.entities.impl;

import javax.annotation.Nonnull;
import java.util.HashMap;

/**
 * Implements all the Data from other implementations.
 *
 * @author BlockyDotJar
 * @version v1.0.0
 * @since v1.0.0-alpha.3
 */
public class DataImpl {
    private final static HashMap<Long, Long> map = new HashMap<>();

    /**
     * Constructs a new {@link DataImpl Data Implementation}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     */
    private DataImpl() {
    }

    /**
     * /**
     * The {@link HashMap Hash Map} Instance from the
     * {@link DataImpl Data Implementation} class
     *
     * @return {@link DataImpl#map}
     */
    @Nonnull
    public static HashMap<Long, Long> getMap() {
        return map;
    }
}
