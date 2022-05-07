/**
 * No Copyright because of deprecation
 */
package dev.blocky.library.jda.entities.impl;

import dev.blocky.library.jda.annotations.DeprecatedSince;
import dev.blocky.library.jda.annotations.ForRemoval;
import dev.blocky.library.jda.annotations.ReplaceWith;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;

import java.text.DecimalFormat;

@Deprecated
@DeprecatedSince(version = "v1.0.0")
@ForRemoval(deadline = "v1.1.0")
@ReplaceWith(method="<SendingType>TimeoutedMessage(<[Message]Event>, String content, long delayInSeconds, String whileDelay, <TimeUnit unit>)")
public class CommandTimeoutImpl {

	public static void sendTimeoutedMessage(Member member, TextChannel channel, String content, long delayInSeconds,
			String whileDelay) {

		if (member == null) {
			throw new NullPointerException("The Member you specified is null.");
		} else if (channel == null) {
			throw new NullPointerException("The TextChannel you specified is null.");
		} else if (content == null) {
			throw new NullPointerException("The Message Content you specified is null.");
		} else if (delayInSeconds == 0) {
			throw new IllegalArgumentException(
					"The Time you specified is null, so it makes no sense that you choose a Timeouted Message.");
		}

		long delay = delayInSeconds * 1000;
		long id = member.getIdLong();
		if (DataImpl.getMap().containsKey(id)) {
			long time = DataImpl.getMap().get(id);

			if ((System.currentTimeMillis() - time) >= delay) {
				DataImpl.getMap().put(id, System.currentTimeMillis());
				channel.sendMessage(content).queue();
			} else {
				if (whileDelay == null) {
					DecimalFormat df = new DecimalFormat("0.00");
					channel.sendMessage(member.getEffectiveName() + ", you must wait "
							+ df.format((delay - (System.currentTimeMillis() - time)) / 1000.d) + " seconds ⌛").queue();
				} else {
					channel.sendMessage(whileDelay).queue();
				}
			}
		} else {
			DataImpl.getMap().put(id, System.currentTimeMillis());
			channel.sendMessage(content).queue();
		}
	}

	public static void sendTimeoutedMessage(User user, TextChannel channel, String content, long delayInSeconds,
			String whileDelay) {

		if (user == null) {
			throw new NullPointerException("The User you specified is null.");
		} else if (channel == null) {
			throw new NullPointerException("The TextChannel you specified is null.");
		} else if (content == null) {
			throw new NullPointerException("The Message Content you specified is null.");
		} else if (delayInSeconds == 0) {
			throw new IllegalArgumentException(
					"The Time you specified is null, so it makes no sense that you choose a Timeouted Message.");
		}

		long delay = delayInSeconds * 1000;
		long id = user.getIdLong();
		if (DataImpl.getMap().containsKey(id)) {
			long time = DataImpl.getMap().get(id);

			if ((System.currentTimeMillis() - time) >= delay) {
				DataImpl.getMap().put(id, System.currentTimeMillis());
				channel.sendMessage(content).queue();
			} else {
				if (whileDelay == null) {
					DecimalFormat df = new DecimalFormat("0.00");
					channel.sendMessage(user.getName() + ", you must wait "
							+ df.format((delay - (System.currentTimeMillis() - time)) / 1000.d) + " seconds ⌛").queue();
				} else {
					channel.sendMessage(whileDelay).queue();
				}
			}
		} else {
			DataImpl.getMap().put(id, System.currentTimeMillis());
			channel.sendMessage(content).queue();
		}
	}

	public static void sendTimeoutedMessage(Member member, MessageChannel channel, String content, long delayInSeconds,
			String whileDelay) {

		if (member == null) {
			throw new NullPointerException("The Member you specified is null.");
		} else if (channel == null) {
			throw new NullPointerException("The MessageChannel you specified is null.");
		} else if (content == null) {
			throw new NullPointerException("The Message Content you specified is null.");
		} else if (delayInSeconds == 0) {
			throw new IllegalArgumentException(
					"The Time you specified is null, so it makes no sense that you choose a Timeouted Message.");
		}

		long delay = delayInSeconds * 1000;
		long id = member.getIdLong();
		if (DataImpl.getMap().containsKey(id)) {
			long time = DataImpl.getMap().get(id);

			if ((System.currentTimeMillis() - time) >= delay) {
				DataImpl.getMap().put(id, System.currentTimeMillis());
				channel.sendMessage(content).queue();
			} else {
				if (whileDelay == null) {
					DecimalFormat df = new DecimalFormat("0.00");
					channel.sendMessage(member.getEffectiveName() + ", you must wait "
							+ df.format((delay - (System.currentTimeMillis() - time)) / 1000.d) + " seconds ⌛").queue();
				} else {
					channel.sendMessage(whileDelay).queue();
				}
			}
		} else {
			DataImpl.getMap().put(id, System.currentTimeMillis());
			channel.sendMessage(content).queue();
		}
	}

	public static void sendTimeoutedMessage(User user, MessageChannel channel, String content, long delayInSeconds,
			String whileDelay) {

		if (user == null) {
			throw new NullPointerException("The User you specified is null.");
		} else if (channel == null) {
			throw new NullPointerException("The MessageChannel you specified is null.");
		} else if (content == null) {
			throw new NullPointerException("The Message Content you specified is null.");
		} else if (delayInSeconds == 0) {
			throw new IllegalArgumentException(
					"The Time you specified is null, so it makes no sense that you choose a Timeouted Message.");
		}

		long delay = delayInSeconds * 1000;
		long id = user.getIdLong();
		if (DataImpl.getMap().containsKey(id)) {
			long time = DataImpl.getMap().get(id);

			if ((System.currentTimeMillis() - time) >= delay) {
				DataImpl.getMap().put(id, System.currentTimeMillis());
				channel.sendMessage(content).queue();
			} else {
				if (whileDelay == null) {
					DecimalFormat df = new DecimalFormat("0.00");
					channel.sendMessage(user.getName() + ", you must wait "
							+ df.format((delay - (System.currentTimeMillis() - time)) / 1000.d) + " seconds ⌛").queue();
				} else {
					channel.sendMessage(whileDelay).queue();
				}
			}
		} else {
			DataImpl.getMap().put(id, System.currentTimeMillis());
			channel.sendMessage(content).queue();
		}
	}

	public static void sendTimeoutedMessageEmbed(Member member, TextChannel channel, EmbedBuilder builder,
			long delayInSeconds, String whileDelay) {

		if (member == null) {
			throw new NullPointerException("The Member you specified is null.");
		} else if (channel == null) {
			throw new NullPointerException("The TextChannel you specified is null.");
		} else if (builder == null) {
			throw new NullPointerException("The EmbedBuilder you specified is null.");
		} else if (delayInSeconds == 0) {
			throw new IllegalArgumentException(
					"The Time you specified is null, so it makes no sense that you choose a Timeouted Message.");
		}

		long delay = delayInSeconds * 1000;
		long id = member.getIdLong();
		if (DataImpl.getMap().containsKey(id)) {
			long time = DataImpl.getMap().get(id);

			if ((System.currentTimeMillis() - time) >= delay) {
				DataImpl.getMap().put(id, System.currentTimeMillis());
				channel.sendMessageEmbeds(builder.build()).queue();
			} else {
				if (whileDelay == null) {
					DecimalFormat df = new DecimalFormat("0.00");
					channel.sendMessage(member.getEffectiveName() + ", you must wait "
							+ df.format((delay - (System.currentTimeMillis() - time)) / 1000.d) + " seconds ⌛").queue();
				} else {
					channel.sendMessage(whileDelay).queue();
				}
			}
		} else {
			DataImpl.getMap().put(id, System.currentTimeMillis());
			channel.sendMessageEmbeds(builder.build()).queue();
		}
	}

	public static void replyTimeoutedMessage(SlashCommandInteractionEvent event, Member member, TextChannel channel,
			String content, long delayInSeconds, String whileDelay) {

		if (event == null) {
			throw new NullPointerException("The Slash Command Event you specified is null.");
		} else if (member == null) {
			throw new NullPointerException("The Member you specified is null.");
		} else if (channel == null) {
			throw new NullPointerException("The TextChannel you specified is null.");
		} else if (content == null) {
			throw new NullPointerException("The Message Content you specified is null.");
		} else if (delayInSeconds == 0) {
			throw new IllegalArgumentException(
					"The Time you specified is null, so it makes no sense that you choose a Timeouted Message.");
		}

		long delay = delayInSeconds * 1000;
		long id = member.getIdLong();
		if (DataImpl.getMap().containsKey(id)) {
			long time = DataImpl.getMap().get(id);

			if ((System.currentTimeMillis() - time) >= delay) {
				DataImpl.getMap().put(id, System.currentTimeMillis());
				event.reply(content).queue();
			} else {
				if (whileDelay == null) {
					DecimalFormat df = new DecimalFormat("0.00");
					channel.sendMessage(member.getEffectiveName() + ", you must wait "
							+ df.format((delay - (System.currentTimeMillis() - time)) / 1000.d) + " seconds ⌛").queue();
				} else {
					channel.sendMessage(whileDelay).queue();
				}
			}
		} else {
			DataImpl.getMap().put(id, System.currentTimeMillis());
			event.reply(content).queue();
		}
	}

	public static void replyTimeoutedMessage(SelectMenuInteractionEvent event, Member member, TextChannel channel,
			String content, long delayInSeconds, String whileDelay) {

		if (event == null) {
			throw new NullPointerException("The Selection Menu Command Event you specified is null.");
		} else if (member == null) {
			throw new NullPointerException("The Member you specified is null.");
		} else if (channel == null) {
			throw new NullPointerException("The TextChannel you specified is null.");
		} else if (content == null) {
			throw new NullPointerException("The Message Content you specified is null.");
		} else if (delayInSeconds == 0) {
			throw new IllegalArgumentException(
					"The Time you specified is null, so it makes no sense that you choose a Timeouted Message.");
		}

		long delay = delayInSeconds * 1000;
		long id = member.getIdLong();
		if (DataImpl.getMap().containsKey(id)) {
			long time = DataImpl.getMap().get(id);

			if ((System.currentTimeMillis() - time) >= delay) {
				DataImpl.getMap().put(id, System.currentTimeMillis());
				event.reply(content).queue();
			} else {
				if (whileDelay == null) {
					DecimalFormat df = new DecimalFormat("0.00");
					channel.sendMessage(member.getEffectiveName() + ", you must wait "
							+ df.format((delay - (System.currentTimeMillis() - time)) / 1000.d) + " seconds ⌛").queue();
				} else {
					channel.sendMessage(whileDelay).queue();
				}
			}
		} else {
			DataImpl.getMap().put(id, System.currentTimeMillis());
			event.reply(content).queue();
		}
	}
}
