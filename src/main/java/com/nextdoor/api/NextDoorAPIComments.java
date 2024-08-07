package com.nextdoor.api;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.*;
import com.nextdoor.share.*;
import com.nextdoor.util.NextDoorUtil;

import java.util.Collection;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_FULL_EXTERNAL_API_URL;

public class NextDoorAPIComments extends NextDoorAPIRequestNode {
    private static final String COMMENT_PREFIX = "comment/";

    public NextDoorAPIComments() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIComments(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPICommentToPostOrReplyToComment commentToPostOrReplyToComment() {
        return new NextDoorAPICommentToPostOrReplyToComment(this.getNextDoorAPIAuth());
    }

    public static class NextDoorAPICommentToPostOrReplyToComment extends NextDoorAPIRequest<CommentToPostOrReplyToComment> implements NextDoorAPICreate<CommentToPostOrReplyToComment> {
        public NextDoorAPICommentToPostOrReplyToComment(NextDoorAPIAuth nextDoorAPIAuth) {
            super(CommentToPostOrReplyToComment.class, nextDoorAPIAuth);
        }

        public NextDoorAPICommentToPostOrReplyToComment setPostOrCommentID(String postOrCommentID) {
            this.setParamInternal("id", postOrCommentID);

            return this;
        }

        public NextDoorAPICommentToPostOrReplyToComment setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPICommentToPostOrReplyToComment setMediaAttachments(Collection<String> mediaAttachments) {
            this.setParamInternal("media_attachments", mediaAttachments);

            return this;
        }

        public NextDoorAPICommentToPostOrReplyToComment setParentCommentID(String parentCommentID) {
            this.setParamInternal("parent_comment_id", parentCommentID);

            return this;
        }

        public NextDoorAPICommentToPostOrReplyToComment setSecureProfileID(String secureProfileID) {
            this.setParamInternal("secure_profile_id", secureProfileID);

            return this;
        }

        @Override
        public CommentToPostOrReplyToComment create() throws APIRequestException {
            validateRequiredParams();
            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
            try {
                return sendHttpRequest(HttpMethod.POST);
            } catch (APIRequestException e) {
                throw new CommentToAPostOrReplyToACommentExcepton("Cannot reply to a comment or create comment to Post, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + COMMENT_PREFIX;
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("id"), "id");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("body_text"), "body_text");
        }

        public static class CommentToAPostOrReplyToACommentExcepton extends APIRequestException {
            public CommentToAPostOrReplyToACommentExcepton() {
            }

            public CommentToAPostOrReplyToACommentExcepton(String s) {
                super(s);
            }

            public CommentToAPostOrReplyToACommentExcepton(String s, Throwable throwable) {
                super(s, throwable);
            }

            public CommentToAPostOrReplyToACommentExcepton(Throwable throwable) {
                super(throwable);
            }

            public CommentToAPostOrReplyToACommentExcepton(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIEditComment extends NextDoorAPIRequest<EditedComment> implements NextDoorAPIEdit<EditedComment> {
        public NextDoorAPIEditComment() {
            super(EditedComment.class, NextDoorAPIAuth.defaultNextDoorAPIAuth());
        }

        public NextDoorAPIEditComment(Posts.Comment comment) {
            super(EditedComment.class, comment.getNextDoorAPIAuth());

            this.setParamInternal("id", comment.getId());
        }

        public NextDoorAPIEditComment setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPIEditComment setSecureProfileID(String secureProfileID) {
            this.setParamInternal("secure_profile_id", secureProfileID);

            return this;
        }

        @Override
        public EditedComment edit() throws APIRequestException {
            validateRequiredParams();
            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());

            try {
                return sendHttpRequest(HttpMethod.PUT, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new CommentEditException("Cannot edit comment, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + COMMENT_PREFIX;
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("body_text"), "body_text");
        }

        public static class CommentEditException extends APIRequestException {
            public CommentEditException() {
            }

            public CommentEditException(String s) {
                super(s);
            }

            public CommentEditException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public CommentEditException(Throwable throwable) {
                super(throwable);
            }

            public CommentEditException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIDeleteComment extends NextDoorAPIRequest<DeletedModel> implements NextDoorAPIDelete<DeletedModel> {
        private Posts.Comment comment;

        public NextDoorAPIDeleteComment() {
            super(DeletedModel.class, NextDoorAPIAuth.defaultNextDoorAPIAuth());
        }

        public NextDoorAPIDeleteComment(Posts.Comment comment) {
            super(DeletedModel.class, comment.getNextDoorAPIAuth());
            this.comment = comment;
        }

        public NextDoorAPIDeleteComment setSecureProfileID(String secureProfileID) {
            this.setParamInternal("secure_profile_id", secureProfileID);

            return this;
        }

        @Override
        public DeletedModel delete() throws APIRequestException {
            validateRequiredParams();
            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());

            try {
                return sendHttpRequest(HttpMethod.DELETE, getPath() + "?id=" + this.comment.getId());
            } catch (APIRequestException e) {
                throw new NextDoorAPIPosts.PostDeleteException("Cannot delete comment, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + COMMENT_PREFIX;
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("secure_profile_id"), "secure_profile_id");
        }
    }
}
