package com.wejuai.exception;

/**
 * @author YQ.Huang
 */
public class MissingExtraParamException extends RuntimeException {

    private final String param;

    public MissingExtraParamException(String param) {
        super("Missing required extra param [" + param + "]");
        this.param = param;
    }

    public String getParam() {
        return param;
    }
}
