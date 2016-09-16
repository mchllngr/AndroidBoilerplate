package de.mchllngr.androidboilerplate.util.timber;

import android.util.Log;

import timber.log.Timber;

/**
 * {@link timber.log.Timber.Tree} for choosing what should be printed to the {@link Log}.
 *
 * @author Michael Langer (<a href="https://github.com/mchllngr" target="_blank">GitHub</a>)
 */
public class ReleaseTree extends Timber.Tree {

    /**
     * Max length of a {@link Log}-line.
     */
    private static final int MAX_LOG_LENGTH = 4000;

    /**
     * Checks if a message should be printed decided by priority.
     *
     * @param priority priority of a message
     * @return true if priority should be printed, false otherwise
     */
    @Override
    protected boolean isLoggable(int priority) {
        // only log ERROR, WTF
        return !(priority == Log.WARN ||
                priority == Log.VERBOSE ||
                priority == Log.DEBUG ||
                priority == Log.INFO);
    }

    /**
     * Prints a message to the {@link Log}.
     *
     * @param priority priority of a message
     * @param tag      tag to print
     * @param message  message to print
     * @param t        {@link Throwable}
     */
    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        if (isLoggable(priority)) {

            // Message is short enough, does not need to be broken into chunks
            if (message.length() < MAX_LOG_LENGTH) {
                if (priority == Log.ASSERT)
                    Log.wtf(tag, message);
                else
                    Log.println(priority, tag, message);

                return;
            }

            // Split by line, then ensure each line can fit into Logs maximum length
            int length = message.length();
            for (int i = 0; i < length; i++) {
                int newline = message.indexOf('\n', i);
                newline = newline != -1 ? newline : length;
                do {
                    int end = Math.min(newline, i + MAX_LOG_LENGTH);
                    String part = message.substring(i, end);

                    if (priority == Log.ASSERT)
                        Log.wtf(tag, part);
                    else
                        Log.println(priority, tag, part);

                    i = end;
                } while (i < newline);
            }
        }
    }
}
