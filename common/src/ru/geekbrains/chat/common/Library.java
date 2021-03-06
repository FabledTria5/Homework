package ru.geekbrains.chat.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Library {

    public static final int MSG_PREFIX = 0;
    public static final int AUTH_REQUEST_LENGTH = 3;
    public static final int TYPE_BROADCAST_LENGTH = 4;
    public static final String DELIMITER = "±";
    public static final String AUTH_REQUEST = "/auth_request";
    public static final String AUTH_ACCEPT = "/auth_accept";
    public static final String AUTH_DENIED = "/auth_denied";
    public static final String MSG_FORMAT_ERROR = "/msg_format_error";
    public static final String TYPE_BROADCAST = "/bcast";

    public static String getAuthRequest(String login, String password) {
        return AUTH_REQUEST + DELIMITER + login + DELIMITER + password;
    }

    public static String getAuthAccept(String nickname) {
        return AUTH_ACCEPT + DELIMITER + nickname;
    }

    public static String getAuthDenied() {
        return AUTH_DENIED;
    }

    public static String getMsgFormatError(String message) {
        return MSG_FORMAT_ERROR + DELIMITER + message;
    }

    public static String getTypeBroadcast(String src, String message) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return TYPE_BROADCAST + DELIMITER + dtf.format(now) +
                DELIMITER + src + DELIMITER + message;
    }

}
