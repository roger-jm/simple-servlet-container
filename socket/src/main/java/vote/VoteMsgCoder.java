package vote;

import java.io.IOException;

/**
 * Created by wangmingjie on 14-2-12.
 */
public interface VoteMsgCoder {
    byte[] toWire(VoteMsg voteMsg) throws IOException;
    VoteMsg fromWire(byte[] input) throws IOException;
}
