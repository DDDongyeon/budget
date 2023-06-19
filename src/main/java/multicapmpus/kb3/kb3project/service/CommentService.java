package multicapmpus.kb3.kb3project.service;

import multicapmpus.kb3.kb3project.entity.Bcomment;
import multicapmpus.kb3.kb3project.entity.necessary.CommentWithUserName;

import java.util.List;

public interface CommentService {

    public int createComment(Bcomment comment);  // 댓글 등록

    public List<CommentWithUserName> getCommentsForConsumeNo(int consumeNo);  // 해당 소비의 댓글 조회
}
