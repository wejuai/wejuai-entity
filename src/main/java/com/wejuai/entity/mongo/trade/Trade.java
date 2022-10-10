package com.wejuai.entity.mongo.trade;

import com.wejuai.entity.mysql.ChannelType;
import com.wejuai.exception.MissingExtraParamException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author ZM.Wang
 */
public abstract class Trade implements Serializable {

    private final static Logger logger = LoggerFactory.getLogger(Trade.class);

    String id;
    private String userId;
    private long amount;
    private ChannelType channelType;
    /** 异步通知地址 */
    private String notifyUrl;
    /** 同步返回地址 */
    private String returnUrl;
    private Date startedAt = new Date();
    private TradeStatus status = TradeStatus.STARTED;
    private Date completedAt;
    /** 渠道订单id */
    private String chanTradeNo;
    private String errorMessage;
    /** 支付凭证 */
    private Map<String, String> credentials;
    /** 请求第三方时需要后续使用的参数 */
    private Map<String, String> resultParams;

    Trade(String id, String userId, long amount, ChannelType channelType, String returnUrl, String notifyUrl) {
        Validate.notBlank(id);
        Validate.notBlank(userId);
        Validate.isTrue(amount > 0);
        Validate.notNull(channelType);
        Validate.notBlank(notifyUrl);
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.channelType = channelType;
        this.notifyUrl = notifyUrl;
        this.returnUrl = returnUrl;
    }

    public Trade setCredentials(Map<String, String> credentials) {
        this.credentials = credentials;
        return this;
    }

    public Trade setResultParams(Map<String, String> resultParams) {
        this.resultParams = resultParams;
        return this;
    }

    public String getResultParams(String key) throws MissingExtraParamException {
        if (resultParams == null || !resultParams.containsKey(key)) {
            throw new MissingExtraParamException(key);
        }
        String value = resultParams.get(key);
        if (StringUtils.isBlank(value)) {
            throw new MissingExtraParamException(key);
        }
        return value;
    }

    public boolean isCompleted() {
        return status == TradeStatus.SUCCEEDED || status == TradeStatus.FAILED;
    }

    public void complete(boolean successful, String errorMessage) {
        if (status != TradeStatus.STARTED) {
            logger.error("The trade has already completed before");
            return;
        }
        if (successful) {
            status = TradeStatus.SUCCEEDED;
        } else {
            status = TradeStatus.FAILED;
            this.errorMessage = errorMessage;
        }
        completedAt = new Date();
    }

    public Trade setChanTradeNo(String chanTradeNo) {
        this.chanTradeNo = chanTradeNo;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public long getAmount() {
        return amount;
    }

    public ChannelType getChannelType() {
        return channelType;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public TradeStatus getStatus() {
        return status;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public String getChanTradeNo() {
        return chanTradeNo;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Map<String, String> getCredentials() {
        return credentials;
    }

    public Map<String, String> getResultParams() {
        return resultParams;
    }
}
