package com.pragma.domain;


public class BusinessException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 2749930027537565775L;

    private String errCode;
    private String errMsg;
    private String message;
    private String code;
    private String detailMessage;
    private int internalCode;


	/*public String getMessage() {
        return errMsg;
	}*/

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public int getErrCodeInt() {
        try {
            return Integer.parseInt(errCode);

        } catch (Exception e) {
            return -500;
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getErrMsg() {
        return errMsg;
    }

	/*public void setMessage(String message) {
        this.message = message;
	}*/

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BusinessException() {
        super();
    }


    public BusinessException(String detailMessage){
        this.detailMessage = detailMessage;
    }


    /**
     * @deprecated use constructor with BusinessErrorCodes parameter
     */
    @Deprecated
    public BusinessException(String errCode, String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    /**
     * transitional state change before we only handle the code of the error and some presumably
     * a filter will get the message associated to the error code (support of I18N)
     *
     */


    public String getDetailMessage() {
        return detailMessage;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }

    public int getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(int internalCode) {
        this.internalCode = internalCode;
    }
}