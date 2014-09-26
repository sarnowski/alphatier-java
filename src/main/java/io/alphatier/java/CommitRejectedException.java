package io.alphatier.java;

public final class CommitRejectedException extends Exception {
    private final CommitResult result;

    public CommitRejectedException(final CommitResult result) {
        this.result = result;
    }

    public CommitResult getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "CommitRejectedException{" +
                "result=" + result +
                '}';
    }
}
