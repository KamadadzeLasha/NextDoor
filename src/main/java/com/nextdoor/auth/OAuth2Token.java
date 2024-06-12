/*
 * Copyright 2007 Yusuke Yamamoto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nextdoor.auth;


import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;

abstract class OAuth2Token implements Serializable {
    private static final long serialVersionUID = 3891133932519746686L;
    String[] responseStr = null;
    private String token;
    private transient SecretKeySpec secretKeySpec;

    public OAuth2Token(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    SecretKeySpec getSecretKeySpec() {
        return secretKeySpec;
    }

    void setSecretKeySpec(SecretKeySpec secretKeySpec) {
        this.secretKeySpec = secretKeySpec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OAuth2Token)) return false;

        OAuth2Token other = (OAuth2Token) o;

        return this.token.equals(other.token);
    }

    @Override
    public int hashCode() {
        return 31 * token.hashCode();
    }

    @Override
    public String toString() {
        return "OAuth2Token{" +
                "token='" + token + '\'' +
                '}';
    }
}
