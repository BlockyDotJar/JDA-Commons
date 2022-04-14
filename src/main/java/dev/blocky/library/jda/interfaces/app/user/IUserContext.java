package dev.blocky.library.jda.interfaces.app.user;

import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;

import javax.annotation.Nonnull;

/**
 * A simple User Context Menu Interface, which you can use to easily program some user context menus.
 *
 * @author BlockyDotJar
 * @version v1.0.0
 * @since v1.0.0
 */
public interface IUserContext {

    /**
     * An interface, which you can use to easily program some user context menus.
     *
     * <br>
     * <p>
     * This contains a <a href=
     * "https://github.com/BlockyDotJar/JDA-Commons/tree/main/src/dev/blocky/library/testzone/ApplicationCommandManager.java">Application
     * Command Manager</a>.
     *
     * @param event Indicates that a message context command was used
     */
    void onUserContext(@Nonnull UserContextInteractionEvent event);
}