package io.alphatier.java;

public final class CommitRejectedException extends Exception {
    private final CommitResult result;

    public CommitRejectedException(final String message, final CommitResult result) {
        super(message);
        this.result = result;
    }

    public CommitResult getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "CommitRejectedException{" +
                "message=" + getMessage() +
                ", result=" + result +
                '}';
    }
}
