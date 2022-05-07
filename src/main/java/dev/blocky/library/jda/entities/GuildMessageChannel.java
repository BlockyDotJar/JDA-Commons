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

import dev.blocky.library.jda.entities.impl.DataImpl;
import dev.blocky.library.jda.enums.SafetyClear;
import dev.blocky.library.jda.Utility;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.requests.restaction.MessageAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Represents a Discord channel that can have {@link net.dv8tion.jda.api.entities.Message Messages}
 * and files sent to it.
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.0.0-alpha.1
 */
public class GuildMessageChannel extends Utility {
    private static final Logger logger = LoggerFactory.getLogger(GuildTextChannel.class);
    private MessageChannel channel;
    private Member member;

    /**
     * Constructs a new {@link GuildMessageChannel Guild Message Channel}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     */
    private GuildMessageChannel() {
    }

    /**
     * Constructs a <b>new</b> {@link GuildMessageChannel Guild Message Channel} instance. If you don't
     * initialize a {@link net.dv8tion.jda.api.entities.MessageChannel Message Channel} or a {@link net.dv8tion.jda.api.entities.Member Member},
     * {@link GuildMessageChannel Guild Message Channel} always will be <b>null</b>.
     *
     * @param channel The {@link net.dv8tion.jda.api.entities.MessageChannel Message Channel}, which
     *                should be initialized.
     * @param member  The {@link net.dv8tion.jda.api.entities.Member Member}, which
     *                should be initialized.
     */
    public GuildMessageChannel(MessageChannel channel, Member member) {
        this.channel = channel;
        this.member = member;

        if (channel == null) {
            logger.error("The Message Channel you specify equals null", new NullPointerException());
        }

        if (member == null) {
            logger.error("The Member you specify equals null", new NullPointerException());
        }
    }

    /**
     * Constructs a <b>new</b> {@link GuildMessageChannel Guild Message Channel} instance. If you don't
     * initialize a {@link net.dv8tion.jda.api.entities.MessageChannel Message Channel},
     * {@link GuildMessageChannel Guild Message Channel} always will be <b>null</b>.
     *
     * @param channel The {@link net.dv8tion.jda.api.entities.MessageChannel Message Channel}, which
     *                should be initialized.
     */
    public GuildMessageChannel(MessageChannel channel) {
        this.channel = channel;

        if (channel == null) {
            logger.error("The Message Channel you specify equals null", new NullPointerException());
        }
    }

    /**
     * First sends a normal message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param content The message content
     * @param message The target message
     */
    public void reply(@Nonnull String content, @Nonnull Message message) {
        MessageAction action = channel.sendMessage(content);
        action.reference(message).queue();
    }

    /**
     * First sends a normal message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param content   The message content
     * @param messageId The target message
     */
    public void replyById(@Nonnull String content, @Nonnull String messageId) {
        MessageAction action = channel.sendMessage(content);
        action.referenceById(messageId).queue();
    }

    /**
     * First sends a normal message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param content   The message content
     * @param messageId The target message
     */
    public void replyById(@Nonnull String content, long messageId) {
        MessageAction action = channel.sendMessage(content);
        action.referenceById(messageId).queue();
    }

    /**
     * First sends an embedded message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param embed   The {@link MessageEmbed Message Embed} to send
     * @param message The target message
     */
    public void replyEmbed(@Nonnull MessageEmbed embed, @Nonnull Message message) {
        MessageAction action = channel.sendMessageEmbeds(embed);
        action.reference(message).queue();
    }

    /**
     * First sends an embedded message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param embed     The {@link MessageEmbed Message Embed} to send
     * @param messageId The target message
     */
    public void replyEmbedById(@Nonnull MessageEmbed embed, @Nonnull String messageId) {
        MessageAction action = channel.sendMessageEmbeds(embed);
        action.referenceById(messageId).queue();
    }

    /**
     * First sends an embedded message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param embed     The {@link MessageEmbed Message Embed} to send
     * @param messageId The target message
     */
    public void replyEmbedById(@Nonnull MessageEmbed embed, long messageId) {
        MessageAction action = channel.sendMessageEmbeds(embed);
        action.referenceById(messageId).queue();
    }

    /**
     * First sends a formatted message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param format  The string that should be formatted, if this is null or empty the content of the Message would be empty and cause a builder exception.
     * @param args    The arguments for your format
     * @param message The target message
     */
    public void replyFormat(@Nonnull String format, @Nonnull Object args, @Nonnull Message message) {
        MessageAction action = channel.sendMessageFormat(format, args);
        action.reference(message).queue();
    }

    /**
     * First sends a formatted message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param format    The string that should be formatted, if this is null or empty the content of the Message would be empty and cause a builder exception.
     * @param args      The arguments for your format
     * @param messageId The target message
     */
    public void replyFormatById(@Nonnull String format, @Nonnull Object args, @Nonnull String messageId) {
        MessageAction action = channel.sendMessageFormat(format, args);
        action.referenceById(messageId).queue();
    }

    /**
     * First sends a formatted message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param format    The string that should be formatted, if this is null or empty the content of the Message would be empty and cause a builder exception.
     * @param args      The arguments for your format
     * @param messageId The target message
     */
    public void replyFormatById(@Nonnull String format, @Nonnull Object args, long messageId) {
        MessageAction action = channel.sendMessageFormat(format, args);
        action.referenceById(messageId).queue();
    }

    /**
     * First sends a normal message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting <b>pingEnabled</b> to <b>false</b>.
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param content     The message content
     * @param message     The target message
     * @param pingEnabled If the member of the written target message should get pinged
     */
    public void reply(@Nonnull String content, @Nonnull Message message, boolean pingEnabled) {
        MessageAction action = channel.sendMessage(content);
        action.reference(message).mentionRepliedUser(pingEnabled).queue();
    }

    /**
     * First sends a normal message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting <b>pingEnabled</b> to <b>false</b>.
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param content     The message content
     * @param messageId   The target message
     * @param pingEnabled If the member of the written target message should get pinged
     */
    public void replyById(@Nonnull String content, @Nonnull String messageId, boolean pingEnabled) {
        MessageAction action = channel.sendMessage(content);
        action.referenceById(messageId).mentionRepliedUser(pingEnabled).queue();
    }

    /**
     * First sends a normal message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting <b>pingEnabled</b> to <b>false</b>.
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param content     The message content
     * @param messageId   The target message
     * @param pingEnabled If the member of the written target message should get pinged
     */
    public void replyById(@Nonnull String content, long messageId, boolean pingEnabled) {
        MessageAction action = channel.sendMessage(content);
        action.referenceById(messageId).mentionRepliedUser(pingEnabled).queue();
    }

    /**
     * First sends an embedded message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting <b>pingEnabled</b> to <b>false</b>.
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param embed       The {@link MessageEmbed Message Embed} to send
     * @param message     The target message
     * @param pingEnabled If the member of the written target message should get pinged
     */
    public void replyEmbed(@Nonnull MessageEmbed embed, @Nonnull Message message, boolean pingEnabled) {
        MessageAction action = channel.sendMessageEmbeds(embed);
        action.reference(message).mentionRepliedUser(pingEnabled).queue();
    }

    /**
     * First sends an embedded message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting <b>pingEnabled</b> to <b>false</b>.
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param embed       The {@link MessageEmbed Message Embed} to send
     * @param messageId   The target message
     * @param pingEnabled If the member of the written target message should get pinged
     */
    public void replyEmbedById(@Nonnull MessageEmbed embed, @Nonnull String messageId, boolean pingEnabled) {
        MessageAction action = channel.sendMessageEmbeds(embed);
        action.referenceById(messageId).mentionRepliedUser(pingEnabled).queue();
    }

    /**
     * First sends an embedded message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting <b>pingEnabled</b> to <b>false</b>.
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param embed       The {@link MessageEmbed Message Embed} to send
     * @param messageId   The target message
     * @param pingEnabled If the member of the written target message should get pinged
     */
    public void replyEmbedById(@Nonnull MessageEmbed embed, long messageId, boolean pingEnabled) {
        MessageAction action = channel.sendMessageEmbeds(embed);
        action.referenceById(messageId).mentionRepliedUser(pingEnabled).queue();
    }

    /**
     * First sends a formatted message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting <b>pingEnabled</b> to <b>false</b>.
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param format      The string that should be formatted, if this is null or empty the content of the Message would be empty and cause a builder exception.
     * @param args        The arguments for your format
     * @param message     The target message
     * @param pingEnabled If the member of the written target message should get pinged
     */
    public void replyFormat(@Nonnull String format, @Nonnull Object args, @Nonnull Message message, boolean pingEnabled) {
        MessageAction action = channel.sendMessageFormat(format, args);
        action.reference(message).mentionRepliedUser(pingEnabled).queue();
    }

    /**
     * First sends a formatted message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting <b>pingEnabled</b> to <b>false</b>.
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param format      The string that should be formatted, if this is null or empty the content of the Message would be empty and cause a builder exception.
     * @param args        The arguments for your format
     * @param messageId   The target message
     * @param pingEnabled If the member of the written target message should get pinged
     */
    public void replyFormatById(@Nonnull String format, @Nonnull Object args, @Nonnull String messageId, boolean pingEnabled) {
        MessageAction action = channel.sendMessageFormat(format, args);
        action.referenceById(messageId).mentionRepliedUser(pingEnabled).queue();
    }

    /**
     * First sends a formatted message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting <b>pingEnabled</b> to <b>false</b>.
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param format      The string that should be formatted, if this is null or empty the content of the Message would be empty and cause a builder exception.
     * @param args        The arguments for your format
     * @param messageId   The target message
     * @param pingEnabled If the member of the written target message should get pinged
     */
    public void replyFormatById(@Nonnull String format, @Nonnull Object args, long messageId, boolean pingEnabled) {
        MessageAction action = channel.sendMessageFormat(format, args);
        action.referenceById(messageId).mentionRepliedUser(pingEnabled).queue();
    }

    /**
     * Convenience method to delete messages in the most efficient way available.
     * No checks will be done to prevent failures, use {@link java.util.concurrent.CompletionStage#exceptionally(Function)
     * CompletionStage.exceptionally(Function)} to handle failures.
     *
     * @param amount The amount of messages to delete
     * @param clear  The {@link SafetyClear Safety Clear} option, which helps for specifying different message types, which will not be deleted
     * @return {@link List List} of futures representing all deletion task
     */
    @Nonnull
    public List<CompletableFuture<Void>> purgeMessages(int amount, @Nullable SafetyClear clear) {
        if (amount == 0) {
            logger.error("The amount can not be 0", new IllegalArgumentException());
        }
        return channel.purgeMessages(checkClearSafety(clear, channel, amount));
    }

    /**
     * Convenience method to delete a complete {@link TextChannel Text Channel} in the most efficient way available.
     * No checks will be done to prevent failures, use {@link java.util.concurrent.CompletionStage#exceptionally(Function)
     * CompletionStage.exceptionally(Function)} to handle failures.
     *
     * @param clear The {@link SafetyClear Safety Clear} option, which helps for specifying different message types, which will not be deleted
     * @return {@link List List} of futures representing all deletion task
     */
    @Nullable
    public List<CompletableFuture<Void>> purgeChannel(@Nullable SafetyClear clear) {
        return channel.purgeMessages(Utility.checkChannelClearSafety(null, channel));
    }

    /**
     * Convenience method to delete a complete {@link TextChannel Text Channel} in the most efficient way available.
     * No checks will be done to prevent failures, use {@link java.util.concurrent.CompletionStage#exceptionally(Function)
     * CompletionStage.exceptionally(Function)} to handle failures.
     *
     * @return {@link List List} of futures representing all deletion task
     */
    @Nonnull
    public List<CompletableFuture<Void>> purgeChannel() {
        return channel.purgeMessages(Utility.checkChannelClearSafety(null, channel));
    }

    /**
     * Checks if the content, you specified, is written in this channel
     *
     * @param content     The message content, which should be checked
     * @param checkAmount The Amount of messages, which should be checked
     * @return <b>true -</b> If the content, you specified, is written in this channel <br>
     *       <b>false -</b> If the content, you specified, is not written in this channel
     */
    public boolean containsMessage(@Nonnull String content, int checkAmount) {
        for (Message message : channel.getIterableHistory().cache(false)) {
            if (message.getContentRaw().equals(content)) {
                return true;
            }
            if (checkAmount-- <= 0) {
                break;
            }
        }
        return false;
    }

    /**
     * Get all the messages from a specific member in this channel (max. 1000 messages per channel)
     *
     * @param memb The {@link Member member}, for which the messages should be checked
     * @return The written messages of the specified member in this channel
     */
    public List<Message> getMessagesByUser(Member memb) {
        return channel.getIterableHistory().stream()
                .limit(1000)
                .filter(m -> m.getAuthor().equals(memb.getUser()))
                .collect(Collectors.toList());
    }

    /**
     * This works like a normal Message sending, but with more given options and a delay between using the command.
     * <br>
     * You must specify a delay to time out a command. (the long delayInSeconds <b>must not equal to 0</b>. If this
     * is true a {@link IllegalArgumentException IllegalArgumentException} will be thrown)
     * <br>
     * You also can specify a delay error message, which will be sent if you are under a delay. (if whileDelayErrorMessage
     * equals null, there will be sent a default error message)
     * <br>
     * Option you can use a specified Time Unit like {@link TimeUnit#MINUTES minutes}, {@link TimeUnit#HOURS hours} or
     * even {@link TimeUnit#DAYS days} (if Time Unit equals null, there will be used a default Time Unit: {@link TimeUnit#SECONDS TimeUnit.SECONDS})
     *
     * @param content                The message content
     * @param delayInSeconds         The delay for the command to execute in seconds
     * @param whileDelayErrorMessage The error message, which should appear, if the member has not yet waited for the delay
     * @param unit                   The Time Unit, which you use for specifying the type of time for the delay
     */
    public void sendTimeoutedMessage(@Nonnull String content, long delayInSeconds, @Nullable String whileDelayErrorMessage,
                                     @Nullable TimeUnit unit) {
        if (content == null) {
            logger.error("The Message Content you specified equals null", new NullPointerException());
        }

        if (delayInSeconds == 0) {
            logger.error("The Time you specified is 0, so it makes no sense that you choose a Timeouted Message", new IllegalArgumentException());
        }

        long id = member.getIdLong();
        if (DataImpl.getMap().containsKey(id)) {
            long time = DataImpl.getMap().get(id);

            if ((System.currentTimeMillis() - time) >= Utility.calculateDelay(unit, delayInSeconds)) {
                DataImpl.getMap().put(id, System.currentTimeMillis());
                channel.sendMessage(content).queue();
            } else {
                if (whileDelayErrorMessage == null) {
                    DecimalFormat df = new DecimalFormat("0.00");
                    channel.sendMessage(member.getEffectiveName() + ", you must wait "
                            + df.format((Utility.calculateDelay(unit, delayInSeconds) - (System.currentTimeMillis() - time)) / 1000.d) + " seconds ⌛").queue();
                } else {
                    channel.sendMessage(whileDelayErrorMessage).queue();
                }
            }
        } else {
            DataImpl.getMap().put(id, System.currentTimeMillis());
            channel.sendMessage(content).queue();
        }
    }

    /**
     * This works like a normal Message sending, but with more given options and a delay between using the command.
     * <br>
     * You must specify a delay  to time out a command. (the long delayInSeconds <b>must not equal to 0</b>. If this
     * is true a {@link IllegalArgumentException IllegalArgumentException} will be thrown)
     * <br>
     * You also can specify a delay error message embed, which will be sent if you are under a delay. (if whileDelayErrorMessage
     * equals null, there will be sent a default error message embed)
     * <br>
     * Option you can use a specified Time Unit like {@link TimeUnit#MINUTES minutes}, {@link TimeUnit#HOURS hours} or
     * even {@link TimeUnit#DAYS days} (if Time Unit equals null, there will be used a default Time Unit: {@link TimeUnit#SECONDS TimeUnit.SECONDS})
     *
     * @param content                The message content
     * @param delayInSeconds         The delay for the command to execute in seconds
     * @param whileDelayErrorMessage The error message embed, which should appear, if the member has not yet waited for the delay
     * @param unit                   The Time Unit, which you use for specifying the type of time for the delay
     */
    public void sendTimeoutedMessageEmbeds(@Nonnull String content, long delayInSeconds, @Nullable EmbedBuilder whileDelayErrorMessage,
                                           @Nullable TimeUnit unit) {
        if (content == null) {
            logger.error("The Message Content you specified equals null", new NullPointerException());
        }

        if (delayInSeconds == 0) {
            logger.error("The Time you specified is 0, so it makes no sense that you choose a Timeouted Message", new IllegalArgumentException());
        }

        long id = member.getIdLong();
        if (DataImpl.getMap().containsKey(id)) {
            long time = DataImpl.getMap().get(id);

            if ((System.currentTimeMillis() - time) >= Utility.calculateDelay(unit, delayInSeconds)) {
                DataImpl.getMap().put(id, System.currentTimeMillis());
                channel.sendMessage(content).queue();
            } else {
                if (whileDelayErrorMessage == null) {
                    DecimalFormat df = new DecimalFormat("0.00");
                    channel.sendMessage(member.getEffectiveName() + ", you must wait "
                            + df.format((Utility.calculateDelay(unit, delayInSeconds) - (System.currentTimeMillis() - time)) / 1000.d) + " seconds ⌛").queue();
                } else {
                    channel.sendMessageEmbeds(whileDelayErrorMessage.build()).queue();
                }
            }
        } else {
            DataImpl.getMap().put(id, System.currentTimeMillis());
            channel.sendMessage(content).queue();
        }
    }

    /**
     * This works like a normal embedded Message sending, but with more given options and a delay between using the command.
     * <br>
     * You must specify a delay  to time out a command. (the long delayInSeconds <b>must not equal to 0</b>. If this
     * is true a {@link IllegalArgumentException IllegalArgumentException} will be thrown)
     * <br>
     * You also can specify a delay error message, which will be sent if you are under a delay. (if whileDelayErrorMessage
     * equals null, there will be sent a default error message)
     * <br>
     * Option you can use a specified Time Unit like {@link TimeUnit#MINUTES minutes}, {@link TimeUnit#HOURS hours} or
     * even {@link TimeUnit#DAYS days} (if Time Unit equals null, there will be used a default Time Unit: {@link TimeUnit#SECONDS TimeUnit.SECONDS})
     *
     * @param content                The message embed content
     * @param delayInSeconds         The delay for the command to execute in seconds
     * @param whileDelayErrorMessage The error message, which should appear, if the member has not yet waited for the delay
     * @param unit                   The Time Unit, which you use for specifying the type of time for the delay
     */
    public void sendTimeoutedMessageEmbeds(@Nonnull EmbedBuilder content, long delayInSeconds, @Nullable String whileDelayErrorMessage,
                                           @Nullable TimeUnit unit) {
        if (content == null) {
            logger.error("The Message Embed you specified equals null", new NullPointerException());
        }

        if (delayInSeconds == 0) {
            logger.error("The Time you specified is 0, so it makes no sense that you choose a Timeouted Message", new IllegalArgumentException());
        }

        long id = member.getIdLong();
        if (DataImpl.getMap().containsKey(id)) {
            long time = DataImpl.getMap().get(id);

            if ((System.currentTimeMillis() - time) >= Utility.calculateDelay(unit, delayInSeconds)) {
                DataImpl.getMap().put(id, System.currentTimeMillis());
                channel.sendMessageEmbeds(content.build()).queue();
            } else {
                if (whileDelayErrorMessage == null) {
                    DecimalFormat df = new DecimalFormat("0.00");
                    channel.sendMessage(member.getEffectiveName() + ", you must wait "
                            + df.format((Utility.calculateDelay(unit, delayInSeconds) - (System.currentTimeMillis() - time)) / 1000.d) + " seconds ⌛").queue();
                } else {
                    channel.sendMessage(whileDelayErrorMessage).queue();
                }
            }
        } else {
            DataImpl.getMap().put(id, System.currentTimeMillis());
            channel.sendMessageEmbeds(content.build()).queue();
        }
    }

    /**
     * This works like a normal embedded Message sending, but with more given options and a delay between using the command.
     * <br>
     * You must specify a delay to time out a command. (the long delayInSeconds <b>must not equal to 0</b>. If this
     * is true a {@link IllegalArgumentException IllegalArgumentException} will be thrown)
     * <br>
     * You also can specify a delay error message embed, which will be sent if you are under a delay. (if whileDelayErrorMessage
     * equals null, there will be sent a default error message embed)
     * <br>
     * Option you can use a specified Time Unit like {@link TimeUnit#MINUTES minutes}, {@link TimeUnit#HOURS hours} or
     * even {@link TimeUnit#DAYS days} (if Time Unit equals null, there will be used a default Time Unit: {@link TimeUnit#SECONDS TimeUnit.SECONDS})
     *
     * @param content                The message embed content
     * @param delayInSeconds         The delay for the command to execute in seconds
     * @param whileDelayErrorMessage The error message embed, which should appear, if the member has not yet waited for the delay
     * @param unit                   The Time Unit, which you use for specifying the type of time for the delay
     */
    public void sendTimeoutedMessageEmbeds(@Nonnull EmbedBuilder content, long delayInSeconds, @Nullable EmbedBuilder whileDelayErrorMessage,
                                           @Nullable TimeUnit unit) {
        if (content == null) {
            logger.error("The Message Embed you specified equals null", new NullPointerException());
        }

        if (delayInSeconds == 0) {
            logger.error("The Time you specified is 0, so it makes no sense that you choose a Timeouted Message", new IllegalArgumentException());
        }

        long id = member.getIdLong();
        if (DataImpl.getMap().containsKey(id)) {
            long time = DataImpl.getMap().get(id);

            if ((System.currentTimeMillis() - time) >= Utility.calculateDelay(unit, delayInSeconds)) {
                DataImpl.getMap().put(id, System.currentTimeMillis());
                channel.sendMessageEmbeds(content.build()).queue();
            } else {
                if (whileDelayErrorMessage == null) {
                    DecimalFormat df = new DecimalFormat("0.00");
                    channel.sendMessage(member.getEffectiveName() + ", you must wait "
                            + df.format((Utility.calculateDelay(unit, delayInSeconds) - (System.currentTimeMillis() - time)) / 1000.d) + " seconds ⌛").queue();
                } else {
                    channel.sendMessageEmbeds(whileDelayErrorMessage.build()).queue();
                }
            }
        } else {
            DataImpl.getMap().put(id, System.currentTimeMillis());
            channel.sendMessageEmbeds(content.build()).queue();
        }
    }
}