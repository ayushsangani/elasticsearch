/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.gateway.local.state.shards;

import org.elasticsearch.common.Nullable;

/**
 */
public final class ShardStateInfo {

    public final long version;

    // can be null if we don't know...
    @Nullable
    public final Boolean primary;

    public ShardStateInfo(long version, Boolean primary) {
        this.version = version;
        this.primary = primary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShardStateInfo that = (ShardStateInfo) o;

        if (version != that.version) return false;
        if (primary != null ? !primary.equals(that.primary) : that.primary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (version ^ (version >>> 32));
        result = 31 * result + (primary != null ? primary.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShardStateInfo{" +
                "version=" + version +
                ", primary=" + primary +
                '}';
    }
}
