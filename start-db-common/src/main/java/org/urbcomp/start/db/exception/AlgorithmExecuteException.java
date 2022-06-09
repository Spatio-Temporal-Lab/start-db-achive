package org.urbcomp.start.db.exception;

public class AlgorithmExecuteException extends Exception {
    /**
     * 产生异常的语句
     */
    private final String exceptionSrc;

    /**
     * 构造函数
     *
     * @param exceptionSrc 产生异常的语句
     */
    public AlgorithmExecuteException(String exceptionSrc) {
        this.exceptionSrc = exceptionSrc;
    }

    @Override
    public String toString() {
        return String.format("Algorithm execution failed: %s", this.exceptionSrc);
    }

    @Override
    public String getMessage() {
        return this.toString();
    }
}
