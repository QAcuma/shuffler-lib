/*
 * This file is generated by jOOQ.
 */
package ru.acuma.shuffler.tables.pojos;


import java.io.Serializable;
import java.time.OffsetDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long           telegramId;
    private String         languageCode;
    private Boolean        isBot;
    private String         firstName;
    private String         lastName;
    private String         userName;
    private Boolean        isBlocked;
    private OffsetDateTime lastMessageAt;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private OffsetDateTime deletedAt;
    private byte[]         mediaBlob;
    private String         mediaId;

    public UserInfo() {}

    public UserInfo(UserInfo value) {
        this.telegramId = value.telegramId;
        this.languageCode = value.languageCode;
        this.isBot = value.isBot;
        this.firstName = value.firstName;
        this.lastName = value.lastName;
        this.userName = value.userName;
        this.isBlocked = value.isBlocked;
        this.lastMessageAt = value.lastMessageAt;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
        this.deletedAt = value.deletedAt;
        this.mediaBlob = value.mediaBlob;
        this.mediaId = value.mediaId;
    }

    public UserInfo(
        Long           telegramId,
        String         languageCode,
        Boolean        isBot,
        String         firstName,
        String         lastName,
        String         userName,
        Boolean        isBlocked,
        OffsetDateTime lastMessageAt,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt,
        OffsetDateTime deletedAt,
        byte[]         mediaBlob,
        String         mediaId
    ) {
        this.telegramId = telegramId;
        this.languageCode = languageCode;
        this.isBot = isBot;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.isBlocked = isBlocked;
        this.lastMessageAt = lastMessageAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.mediaBlob = mediaBlob;
        this.mediaId = mediaId;
    }

    /**
     * Getter for <code>public.user_info.telegram_id</code>.
     */
    public Long getTelegramId() {
        return this.telegramId;
    }

    /**
     * Setter for <code>public.user_info.telegram_id</code>.
     */
    public UserInfo setTelegramId(Long telegramId) {
        this.telegramId = telegramId;
        return this;
    }

    /**
     * Getter for <code>public.user_info.language_code</code>.
     */
    public String getLanguageCode() {
        return this.languageCode;
    }

    /**
     * Setter for <code>public.user_info.language_code</code>.
     */
    public UserInfo setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
        return this;
    }

    /**
     * Getter for <code>public.user_info.is_bot</code>.
     */
    public Boolean getIsBot() {
        return this.isBot;
    }

    /**
     * Setter for <code>public.user_info.is_bot</code>.
     */
    public UserInfo setIsBot(Boolean isBot) {
        this.isBot = isBot;
        return this;
    }

    /**
     * Getter for <code>public.user_info.first_name</code>.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Setter for <code>public.user_info.first_name</code>.
     */
    public UserInfo setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Getter for <code>public.user_info.last_name</code>.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Setter for <code>public.user_info.last_name</code>.
     */
    public UserInfo setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Getter for <code>public.user_info.user_name</code>.
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Setter for <code>public.user_info.user_name</code>.
     */
    public UserInfo setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * Getter for <code>public.user_info.is_blocked</code>.
     */
    public Boolean getIsBlocked() {
        return this.isBlocked;
    }

    /**
     * Setter for <code>public.user_info.is_blocked</code>.
     */
    public UserInfo setIsBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
        return this;
    }

    /**
     * Getter for <code>public.user_info.last_message_at</code>.
     */
    public OffsetDateTime getLastMessageAt() {
        return this.lastMessageAt;
    }

    /**
     * Setter for <code>public.user_info.last_message_at</code>.
     */
    public UserInfo setLastMessageAt(OffsetDateTime lastMessageAt) {
        this.lastMessageAt = lastMessageAt;
        return this;
    }

    /**
     * Getter for <code>public.user_info.created_at</code>.
     */
    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Setter for <code>public.user_info.created_at</code>.
     */
    public UserInfo setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Getter for <code>public.user_info.updated_at</code>.
     */
    public OffsetDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Setter for <code>public.user_info.updated_at</code>.
     */
    public UserInfo setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Getter for <code>public.user_info.deleted_at</code>.
     */
    public OffsetDateTime getDeletedAt() {
        return this.deletedAt;
    }

    /**
     * Setter for <code>public.user_info.deleted_at</code>.
     */
    public UserInfo setDeletedAt(OffsetDateTime deletedAt) {
        this.deletedAt = deletedAt;
        return this;
    }

    /**
     * Getter for <code>public.user_info.media_blob</code>.
     */
    public byte[] getMediaBlob() {
        return this.mediaBlob;
    }

    /**
     * Setter for <code>public.user_info.media_blob</code>.
     */
    public UserInfo setMediaBlob(byte[] mediaBlob) {
        this.mediaBlob = mediaBlob;
        return this;
    }

    /**
     * Getter for <code>public.user_info.media_id</code>.
     */
    public String getMediaId() {
        return this.mediaId;
    }

    /**
     * Setter for <code>public.user_info.media_id</code>.
     */
    public UserInfo setMediaId(String mediaId) {
        this.mediaId = mediaId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UserInfo (");

        sb.append(telegramId);
        sb.append(", ").append(languageCode);
        sb.append(", ").append(isBot);
        sb.append(", ").append(firstName);
        sb.append(", ").append(lastName);
        sb.append(", ").append(userName);
        sb.append(", ").append(isBlocked);
        sb.append(", ").append(lastMessageAt);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(updatedAt);
        sb.append(", ").append(deletedAt);
        sb.append(", ").append("[binary...]");
        sb.append(", ").append(mediaId);

        sb.append(")");
        return sb.toString();
    }
}
