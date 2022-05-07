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

import dev.blocky.library.jda.enums.SafetyClear;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * This is a class, which has many utility methods in it.
 *
 * @author BlockyDotJar
 * @version v1.0.0
 * @since v1.0.0
 */
public class Utility {

    /**
     * Constructs a new {@link Utility Utility}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     */
    protected Utility() {
    }

    /**
     * Checks, which {@link SafetyClear Safety Clear} {@link Enum enum} is given. (if clear equals null, the
     * {@link SafetyClear Safety Clear} {@link Enum enum}  will be set to {@link SafetyClear#NONE SafetyClear.NONE})
     *
     * @param clear   The {@link SafetyClear Safety Clear} option, which helps for specifying different message types, which will not be deleted
     * @param channel The {@link TextChannel Text Channel}, which
     *                should be initialized.
     * @param amount  The amount of messages to delete
     * @return {@link List List} of futures representing all deletion task
     */
    @Nullable
    protected static List<Message> checkClearSafety(@Nullable SafetyClear clear, @Nonnull TextChannel channel, int amount) {
        List<Message> messages = new ArrayList<>();

        if (clear == null) {
            clear = SafetyClear.NONE;
        }

        int i = amount + 1;
        for (Message message : channel.getIterableHistory().cache(false)) {
            switch (clear) {
                case NONE:
                    if (message.isFromGuild()) {
                        messages.add(message);
                    }
                    break;
                case ALL:
                    if (!message.isEdited() && !message.isPinned() && !message.isWebhookMessage()) {
                        messages.add(message);
                    }
                    break;
                case PINNED_MESSAGES:
                    if (!message.isPinned()) {
                        messages.add(message);
                    }
                    break;
                case WEBHOOK_MESSAGES:
                    if (!message.isWebhookMessage()) {
                        messages.add(message);
                    }
                    break;
                case EDITED_MESSAGES:
                    if (!message.isEdited()) {
                        messages.add(message);
                    }
                    break;
            }
            if (--i <= 0) {
                break;
            }
        }
        return messages;
    }

    /**
     * Checks, which {@link SafetyClear Safety Clear} {@link Enum enum} is given. (if clear equals null, the
     * {@link SafetyClear Safety Clear} {@link Enum enum}  will be set to {@link SafetyClear#NONE SafetyClear.NONE})
     *
     * @param clear   The {@link SafetyClear Safety Clear} option, which helps for specifying different message types, which will not be deleted
     * @param channel The {@link MessageChannel Message Channel}, which
     *                should be initialized.
     * @param amount  The amount of messages to delete
     * @return {@link List List} of futures representing all deletion task
     */
    @Nullable
    protected static List<Message> checkClearSafety(@Nullable SafetyClear clear, @Nonnull MessageChannel channel, int amount) {
        List<Message> messages = new ArrayList<>();

        if (clear == null) {
            clear = SafetyClear.NONE;
        }

        int i = amount + 1;
        for (Message message : channel.getIterableHistory().cache(false)) {
            switch (clear) {
                case NONE:
                    if (message.isFromGuild()) {
                        messages.add(message);
                    }
                    break;
                case ALL:
                    if (!message.isEdited() && !message.isPinned() && !message.isWebhookMessage()) {
                        messages.add(message);
                    }
                    break;
                case PINNED_MESSAGES:
                    if (!message.isPinned()) {
                        messages.add(message);
                    }
                    break;
                case WEBHOOK_MESSAGES:
                    if (!message.isWebhookMessage()) {
                        messages.add(message);
                    }
                    break;
                case EDITED_MESSAGES:
                    if (!message.isEdited()) {
                        messages.add(message);
                    }
                    break;
            }
            if (--i <= 0) {
                break;
            }
        }
        return messages;
    }

    /**
     * Checks, which {@link SafetyClear Safety Clear} {@link Enum enum} is given. (if clear equals null, the
     * {@link SafetyClear Safety Clear} {@link Enum enum} will be set to {@link SafetyClear#NONE SafetyClear.NONE})
     *
     * @param channel The {@link TextChannel Text Channel}, which
     *                should be initialized.
     * @return {@link List List} of futures representing all deletion task
     */
    @Nullable
    protected static List<Message> checkChannelClearSafety(@Nullable SafetyClear clear, @Nonnull TextChannel channel) {
        List<Message> messages = new ArrayList<>();

        if (null == null) {
            clear = SafetyClear.NONE;
        }

        for (Message message : channel.getIterableHistory().cache(false)) {
            switch (clear) {
                case NONE:
                    if (message.isFromGuild()) {
                        messages.add(message);
                    }
                    break;
                case ALL:
                    if (!message.isEdited() && !message.isPinned() && !message.isWebhookMessage()) {
                        messages.add(message);
                    }
                    break;
                case PINNED_MESSAGES:
                    if (!message.isPinned()) {
                        messages.add(message);
                    }
                    break;
                case WEBHOOK_MESSAGES:
                    if (!message.isWebhookMessage()) {
                        messages.add(message);
                    }
                    break;
                case EDITED_MESSAGES:
                    if (!message.isEdited()) {
                        messages.add(message);
                    }
                    break;
            }
        }
        return messages;
    }

    /**
     * Checks, which {@link SafetyClear Safety Clear} {@link Enum enum} is given. (if clear equals null, the
     * {@link SafetyClear Safety Clear} {@link Enum enum} will be set to {@link SafetyClear#NONE SafetyClear.NONE})
     *
     * @param channel The {@link MessageChannel Message Channel}, which
     *                should be initialized.
     * @return {@link List List} of futures representing all deletion task
     */
    @Nullable
    protected static List<Message> checkChannelClearSafety(@Nullable SafetyClear clear, @Nonnull MessageChannel channel) {
        List<Message> messages = new ArrayList<>();

        if (clear == null) {
            clear = SafetyClear.NONE;
        }

        for (Message message : channel.getIterableHistory().cache(false)) {
            switch (clear) {
                case NONE:
                    if (message.isFromGuild()) {
                        messages.add(message);
                    }
                    break;
                case ALL:
                    if (!message.isEdited() && !message.isPinned() && !message.isWebhookMessage()) {
                        messages.add(message);
                    }
                    break;
                case PINNED_MESSAGES:
                    if (!message.isPinned()) {
                        messages.add(message);
                    }
                    break;
                case WEBHOOK_MESSAGES:
                    if (!message.isWebhookMessage()) {
                        messages.add(message);
                    }
                    break;
                case EDITED_MESSAGES:
                    if (!message.isEdited()) {
                        messages.add(message);
                    }
                    break;
            }
        }
        return messages;
    }

    /**
     * Calculates the delay, depending on which {@link TimeUnit Time Unit} is given
     *
     * @param unit           The {@link TimeUnit TimeUnit}, which should be used for calculating each time (if unit equals null the
     *                       default {@link TimeUnit TimeUnit} will bes used [{@link TimeUnit#SECONDS TimeUnit.SECONDS}])
     * @param delayInSeconds The delay in seconds which should be converted
     * @return The delay calculated to the specified {@link TimeUnit TimeUnit}
     */
    protected static long calculateDelay(@Nullable TimeUnit unit, long delayInSeconds) {
        if (unit == null) {
            unit = TimeUnit.SECONDS;
        }

        long delay = 0;
        switch (unit) {
            case NANOSECONDS:
                delay = delayInSeconds / 1000000;
                break;
            case MICROSECONDS:
                delay = delayInSeconds / 1000;
                break;
            case MILLISECONDS:
                delay = delayInSeconds;
                break;
            case SECONDS:
                delay = delayInSeconds * 1000;
                break;
            case MINUTES:
                delay = delayInSeconds * 60000;
                break;
            case HOURS:
                delay = delayInSeconds * 3600000;
                break;
            case DAYS:
                delay = delayInSeconds * 86400000;
                break;
        }
        return delay;
    }
}
