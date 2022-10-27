package com.depromeet.coquality.outer.common.error;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;

@Getter
public class CoqualityOuterException extends RuntimeException {

    private final int code;

    private final List<Object> args;

    public CoqualityOuterException(int code, String message, Throwable ex) {
        super(message, ex);
        this.code = code;
        this.args = new ArrayList<>();
    }

    public CoqualityOuterException(int code, String message) {
        super(message);
        this.code = code;
        this.args = new ArrayList<>();
    }

    public CoqualityOuterException(int code, String message, Object... args) {
        super(message);
        this.code = code;
        this.args = Arrays.asList(args);
    }

    public CoqualityOuterException(int code, String message, Throwable ex, Object... args) {
        super(message, ex);
        this.code = code;
        this.args = Arrays.asList(args);
    }


}
