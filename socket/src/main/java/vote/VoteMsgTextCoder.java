package vote;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by wangmingjie on 14-2-12.
 * 基于文本的表示方法
 */
public class VoteMsgTextCoder implements VoteMsgCoder {

 /*
 * Wire Format "VOTEPROTO" <"v"|"i"> [<RESPFLAG>] <CANDIDATE> [<VOTECNT>]
* Charset is fixed by the wire format.
 */

    public static final String MAGIC = "Voting";
    public static final String VOTESTR = "v";
    public static final String INQSTR = "i";
    public static final String RESPONSESTR = "R";

    public static final String CHARSETNAME = "US-ASCII";
    public static final String DELIMSTR = " ";
    public static final int MAX_WIRE_LENGTH = 2000;


    @Override
    public byte[] toWire(VoteMsg voteMsg) throws IOException {
        String msgString = MAGIC + DELIMSTR + (voteMsg.isInquiry() ? INQSTR : VOTESTR) + DELIMSTR
                + (voteMsg.isResponse() ? RESPONSESTR + DELIMSTR : "") + Integer.toString(voteMsg.getCandidateID())
                + DELIMSTR + Long.toString(voteMsg.getVoteCount());
        byte[] data = msgString.getBytes(CHARSETNAME);
        return data;
    }

    @Override
    public VoteMsg fromWire(byte[] input) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(input);
        Scanner scanner = new Scanner(new InputStreamReader(bais, CHARSETNAME));

        boolean isInquiry;
        boolean isResponse;
        int cadidateID;
        long voteCount;
        String token;

        token = scanner.next();
        if(!token.equals(MAGIC)){
           throw new IOException("invalid magic String : " + token);
        }


        return null;
    }
}
