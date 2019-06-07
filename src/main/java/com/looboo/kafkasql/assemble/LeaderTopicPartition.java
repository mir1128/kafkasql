package com.looboo.kafkasql.assemble;

import org.apache.kafka.common.TopicPartition;

public class LeaderTopicPartition extends Object {

  private static String STRING_DELIMITER = ":";

  private int hash = 0;

  private final int leaderId;
  private final String topicName;
  private final int partition;

  public LeaderTopicPartition(int leaderId, String topicName, int partition) throws IllegalArgumentException {
    this.leaderId = leaderId;
    if (topicName == null)
      throw new IllegalArgumentException("topicName can not be null");
    this.topicName = topicName;
    this.partition = partition;
  }

  public static LeaderTopicPartition fromString(String leaderTopicPartitionString) {
    String[] tokens = leaderTopicPartitionString.split(STRING_DELIMITER);
    if (tokens.length != 3)
      throw new IllegalArgumentException(
          "leaderTopicPartitionString must be in the format <leader>:<topic>:<partition>");
    return new LeaderTopicPartition(Integer.parseInt(tokens[0], 10), tokens[1], Integer.parseInt(tokens[2], 10));
  }

  @Override
  public String toString() {
    return String.valueOf(leaderId) + STRING_DELIMITER + topicName + STRING_DELIMITER + String.valueOf(partition);
  }

  public TopicPartition toTopicPartition() {
    return new TopicPartition(topicName, partition);
  }

  public String toTopicPartitionString() {
    return topicName + STRING_DELIMITER + String.valueOf(partition);
  }

  @Override
  public int hashCode() {
    if (hash != 0)
      return hash;
    int result = 1;
    result = result * 23 + leaderId;
    result = result * 37 + (topicName == null ? 0 : topicName.hashCode());
    result = result * 11 + partition;
    this.hash = result;
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other)
      return true;
    if (!(other instanceof LeaderTopicPartition))
      return false;
    LeaderTopicPartition otherLeaderTopicPartition = (LeaderTopicPartition) other;
    return leaderId == otherLeaderTopicPartition.leaderId
        && ((topicName == null) ? otherLeaderTopicPartition.topicName == null
            : topicName.equals(otherLeaderTopicPartition.topicName))
        && partition == otherLeaderTopicPartition.partition;
  }

}
