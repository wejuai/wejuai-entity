package com.wejuai.entity.mongo;

/**
 * @author ZM.Wang
 */
public class SendMessage extends BaseEntity {

    private String sender;

    private String recipient;

    private String text;

    private MediaType mediaType;

    private String ossKey;

    /** 聊天关系id */
    private String chatRelationId;

    public SendMessage(String sender, String recipient, String text, String chatRelationId) {
        this.sender = sender;
        this.recipient = recipient;
        this.text = text;
        this.chatRelationId = chatRelationId;
    }

    public SendMessage(String sender, String recipient, MediaType mediaType, String ossKey, String chatRelationId) {
        this.sender = sender;
        this.recipient = recipient;
        this.mediaType = mediaType;
        this.ossKey = ossKey;
        this.text = mediaType.getText();
        this.chatRelationId = chatRelationId;
    }

    SendMessage() {
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getText() {
        return text;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public String getOssKey() {
        return ossKey;
    }

    public String getChatRelationId() {
        return chatRelationId;
    }
}
