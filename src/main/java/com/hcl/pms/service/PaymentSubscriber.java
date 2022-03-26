package com.hcl.pms.service;

public class PaymentSubscriber<T> {

    /** The is completed. */
    private boolean isCompleted;
    /**
     * Checks if is completed.
     *
     * @return true, if is completed
     */
    public boolean isCompleted() {
        return isCompleted;
    }

    /** The request timeout in seconds. */
    private int requestTimeoutInSeconds;
    /** The response. */
    private T response;

    /**
     * Instantiates a new message subscriber.
     */
    public PaymentSubscriber() {
        this.requestTimeoutInSeconds = 40;
    }

    /**
     * Instantiates a new message subscriber.
     *
     * @param requestTimeoutInSeconds the request timeout in seconds
     */
    public PaymentSubscriber(int requestTimeoutInSeconds) {
        this.requestTimeoutInSeconds = requestTimeoutInSeconds;
    }

    /**
     * Gets the response.
     *
     * @return the response
     */
    public T getResponse() {
        while (!this.isCompleted) {
            try {
                this.requestTimeoutInSeconds--;
                if (this.requestTimeoutInSeconds < 0) {
                    return response;
                }
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return response;
    }


}
