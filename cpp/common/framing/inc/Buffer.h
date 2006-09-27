/*
 *
 * Copyright (c) 2006 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
#include "amqp_types.h"

#ifndef _Buffer_
#define _Buffer_

namespace qpid {
namespace framing {

class FieldTable;

class Buffer
{
    const int size;
    char* data;
    int position;
    int limit;
    int r_position;
    int r_limit;

public:

    Buffer(int size);
    ~Buffer();

    void flip();
    void clear();
    void compact();
    void record();
    void restore();
    int available();
    char* start();
    void move(int bytes);
    
    void putOctet(u_int8_t i);
    void putShort(u_int16_t i);
    void putLong(u_int32_t i);
    void putLongLong(u_int64_t i);

    u_int8_t getOctet();
    u_int16_t getShort(); 
    u_int32_t getLong();
    u_int64_t getLongLong();

    void putShortString(const string& s);
    void putLongString(const string& s);
    void getShortString(string& s);
    void getLongString(string& s);

    void putFieldTable(const FieldTable& t);
    void getFieldTable(FieldTable& t);

    void putRawData(const string& s);
    void getRawData(string& s, u_int32_t size);

};

}
}


#endif
