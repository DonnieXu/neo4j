/**
 * Copyright (c) 2002-2014 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.kernel.impl.store.kvstore;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.neo4j.io.pagecache.PageCursor;

public interface KeyValueRecordSerializer<K extends Comparable<K>, VR>
{
    boolean visitRecord( ByteBuffer buffer, KeyValueRecordVisitor<K, VR> visitor, VR valueRegister );

    K readRecord( PageCursor cursor, int offset, VR valueRegister ) throws IOException;

    void writeDefaultValue( VR valueRegister );
}
