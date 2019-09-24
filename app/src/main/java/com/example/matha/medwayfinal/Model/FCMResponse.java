package com.example.matha.medwayfinal.Model;

import java.util.List;

public class FCMResponse {

    public long multicast_id;
    public int success;
    public int failure;
    public int canonical_ids;
    public List<Result> result;

    public FCMResponse(){


    }

    public FCMResponse(long multicast, int success, int failure, int canonical_aids, List<Result> result) {
        this.multicast_id = multicast;
        this.success = success;
        this.failure = failure;
        this.canonical_ids = canonical_aids;
        this.result = result;
    }

    public long getMulticast_id() {
        return multicast_id;
    }

    public void setMulticast_id(long multicast_id) {
        this.multicast_id = multicast_id;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getFailure() {
        return failure;
    }

    public void setFailure(int failure) {
        this.failure = failure;
    }

    public int getCanonical_ids() {
        return canonical_ids;
    }

    public void setCanonical_ids(int canonical_ids) {
        this.canonical_ids = canonical_ids;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }
}
