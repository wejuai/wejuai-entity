package com.wejuai.entity.mongo;

import com.wejuai.entity.mongo.trade.TradeStatus;
import com.wejuai.entity.mysql.WithdrawalType;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ZM.Wang
 * 用户提现审核后转账记录
 */
public class MerchantTransfer extends BaseEntity {

    private final static Logger logger = LoggerFactory.getLogger(MerchantTransfer.class);

    private String user;

    private long amount;

    @ApiModelProperty("转账方式")
    private WithdrawalType type;

    @ApiModelProperty("状态")
    private TradeStatus status;

    @ApiModelProperty("通道返回的订单号")
    private String channelTradeId;

    @ApiModelProperty("错误原因")
    private String errorMessage;

    public MerchantTransfer(String user, long amount, WithdrawalType type) {
        this.user = user;
        this.amount = amount;
        this.type = type;
        this.status = TradeStatus.STARTED;
    }

    public void complete(boolean successful, String channelId, String errorMessage) {
        if (status != TradeStatus.STARTED) {
            logger.error("The trade has already completed before");
            return;
        }
        if (successful) {
            status = TradeStatus.SUCCEEDED;
            this.channelTradeId = channelId;
        } else {
            status = TradeStatus.FAILED;
            this.errorMessage = errorMessage;
        }
    }

    MerchantTransfer() {
    }

    public String getUser() {
        return user;
    }

    public long getAmount() {
        return amount;
    }

    public WithdrawalType getType() {
        return type;
    }

    public String getChannelTradeId() {
        return channelTradeId;
    }

    public TradeStatus getStatus() {
        return status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
