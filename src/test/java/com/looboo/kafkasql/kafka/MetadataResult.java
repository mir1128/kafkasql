package com.looboo.kafkasql.kafka;

public class MetadataResult {
    private long offset;
    private long timestamp;
    private int serializedKeySize;
    private int serializedValueSize;
    private String topic;
    private int partition;
    private Long checksum;

    public MetadataResult(long offset, long timestamp, int serializedKeySize, int serializedValueSize, String topic, int partition, Long checksum) {
        this.offset = offset;
        this.timestamp = timestamp;
        this.serializedKeySize = serializedKeySize;
        this.serializedValueSize = serializedValueSize;
        this.topic = topic;
        this.partition = partition;
        this.checksum = checksum;
    }

    public MetadataResult() {
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getSerializedKeySize() {
        return serializedKeySize;
    }

    public void setSerializedKeySize(int serializedKeySize) {
        this.serializedKeySize = serializedKeySize;
    }

    public int getSerializedValueSize() {
        return serializedValueSize;
    }

    public void setSerializedValueSize(int serializedValueSize) {
        this.serializedValueSize = serializedValueSize;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getPartition() {
        return partition;
    }

    public void setPartition(int partition) {
        this.partition = partition;
    }

    public Long getChecksum() {
        return checksum;
    }

    public void setChecksum(Long checksum) {
        this.checksum = checksum;
    }
}

