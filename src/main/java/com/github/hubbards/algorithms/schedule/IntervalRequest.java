package com.github.hubbards.algorithms.schedule;

import java.time.Duration;
import java.time.Instant;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * TODO: document
 *
 * @author Spencer Hubbard
 */
class IntervalRequest {
    private String name;
    private Instant start;
    private Instant finish;

    /**
     * Constructs a new (unweighted) interval request with a name, start time,
     * and finish time.
     *
     * @param name name of the request
     * @param start start time of the request
     * @param finish finish time of the request
     */
    public IntervalRequest(String name, Instant start, Instant finish) {
        checkNotNull(name);
        checkNotNull(start);
        checkNotNull(finish);
        checkArgument(start.compareTo(finish) < 0, "start must be less than finish");
        this.name = name;
        this.start = start;
        this.finish = finish;
    }

    /**
     * Getter for name.
     *
     * @return name of this request
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for start time.
     *
     * @return start time for this request
     */
    public Instant getStart() {
        return start;
    }

    /**
     * Getter for finish time.
     *
     * @return finish time for this request
     */
    public Instant getFinish() {
        return finish;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof IntervalRequest) {
            IntervalRequest other = (IntervalRequest) o;
            return name.equals(other.name);
        } else {
            return false;
        }
    }
}
