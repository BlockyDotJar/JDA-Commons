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
package dev.blocky.library.jda.enums;

/**
 * This is an {@link java.lang.Enum Enum}, which is used for a safer clearing process.
 *
 * @author BlockyDotJar
 * @version v1.0.0-alpha.1
 * @since v1.0.0
 */
public enum SafetyClear {
    NONE, ALL, PINNED_MESSAGES, WEBHOOK_MESSAGES, EDITED_MESSAGES
}
