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
package dev.blocky.library.testzone;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumSet;

/**
 * This is the Main class of the Discord Bot
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.0.0-alpha.1
 */
public class DiscordBotExample {
    private static JDA jda;

    private static final CommandManager cmdMan = new CommandManager();
    private static final Logger logger = LoggerFactory.getLogger(DiscordBotExample.class);

    /**
     * This is the main method of the discord bot
     *
     * @param args An {@link java.lang.reflect.Array Array} of String arguments
     * @throws LoginException If an login failure occurs
     */
    public static void main(@NotNull String[] args) throws LoginException {
        new DiscordBotExample();
    }

    /**
     * Constructs a new discord bot
     *
     * @throws LoginException If an login failure occurs
     */
    public DiscordBotExample() throws LoginException {
        jda = JDABuilder
                .createDefault("YOUR_BOT_TOKEN",
                        EnumSet.of(
                                GatewayIntent.GUILD_MESSAGES,
                                GatewayIntent.GUILD_MEMBERS
                        )
                )
                .disableCache(
                        EnumSet.of(
                                CacheFlag.CLIENT_STATUS,
                                CacheFlag.ACTIVITY,
                                CacheFlag.EMOTE,
                                CacheFlag.VOICE_STATE
                        )
                )
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .addEventListeners(cmdMan)
                .build();
        jda.addEventListener(new ApplicationCommandManager());

        shutdown();
    }

    /**
     * Shutdown the System and the jda instance after five seconds, when the exit
     * command was typed
     */
    private static void shutdown() {
        new Thread(() -> {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String line = reader.readLine();
                while (line != null) {
                    if (line.equalsIgnoreCase("exit") && jda != null) {
                        for (int i = 5; i > 0; i--) {
                            if (i != 1) {
                                logger.info("Bot stops in " + i + " seconds.");
                            } else if (i == 1) {
                                logger.info("Bot stops in " + i + " second.");
                            }
                            Thread.sleep(1000);
                        }
                        jda.getPresence().setStatus(OnlineStatus.OFFLINE);
                        jda.shutdown();
                        System.exit(0);
                    }
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * The {@link JDA JDA} Instance from the
     * {@link DiscordBotExample Discord Bot Example} class
     *
     * @return {@link DiscordBotExample#jda}
     */
    @Nonnull
    public static JDA getJDA() {
        return jda;
    }
}
