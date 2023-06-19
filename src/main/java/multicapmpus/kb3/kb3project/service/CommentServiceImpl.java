package multicapmpus.kb3.kb3project.service;

import multicapmpus.kb3.kb3project.entity.Bcomment;
import multicapmpus.kb3.kb3project.entity.necessary.CommentWithUserName;
import multicapmpus.kb3.kb3project.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public int createComment(Bcomment comment) {
        int result = commentMapper.insert(comment);
        return result;
    }

    @Override
    public List<CommentWithUserName> getCommentsForConsumeNo(int consumeNo) {
        List<CommentWithUserName> comments = commentMapper.selectByConsumeNo(consumeNo);
        return comments;
    }
}
