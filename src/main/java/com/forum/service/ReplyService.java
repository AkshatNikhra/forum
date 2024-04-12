package com.forum.service;

import com.forum.dtos.ReplyReqDto;
import com.forum.dtos.ReplyResDto;

import java.util.List;

public interface ReplyService {
    public ReplyResDto createNewReply(ReplyReqDto replyReqDto);
    public List<ReplyResDto> getAllReplyOnComment(Long commentId);
}
