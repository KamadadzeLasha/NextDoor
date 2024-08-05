package com.nextdoor.impl;

import com.nextdoor.api.share.NextDoorAPICreate;
import com.nextdoor.api.share.NextDoorAPIRequest;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.AccessToken;
import com.nextdoor.util.NextDoorUtil;

public class NextDoorAPIAccessToken {
    public NextDoorAPIAccessToken() {

    }

    public static class NextDoorAPIAccessTokenGenerate extends NextDoorAPIRequest<AccessToken> implements NextDoorAPICreate<AccessToken> {
        public NextDoorAPIAccessTokenGenerate() {
            super(AccessToken.class, null);
        }

        public NextDoorAPIAccessTokenGenerate grantType(String grantType) {
            this.setParamInternal("grant_type", grantType);

            return this;
        }

        public NextDoorAPIAccessTokenGenerate code(String code) {
            this.setParamInternal("code", code);

            return this;
        }

        public NextDoorAPIAccessTokenGenerate clientId(String clientId) {
            this.setParamInternal("client_id", clientId);

            return this;
        }

        public NextDoorAPIAccessTokenGenerate redirectUri(String redirectUri) {
            this.setParamInternal("redirect_uri", redirectUri);

            return this;
        }

        @Override
        public AccessToken create() throws APIRequestException {
            return null;
        }

        @Override
        protected String getPath() {
            return "";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("grant_type"), "grant_type");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("code"), "code");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("client_id"), "client_id");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("redirect_uri"), "redirect_uri");
        }
    }
}
