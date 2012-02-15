/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.codec.language;

import junit.framework.Assert;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.StringEncoderAbstractTest;
import org.junit.Test;

/**
 * Tests Caverphone1.
 * 
 * @author Apache Software Foundation
 * @version $Id: CaverphoneTest.java 1075947 2011-03-01 17:56:14Z ggregory $
 * @since 1.5
 */
public class Caverphone1Test extends StringEncoderAbstractTest {

    @Override
    protected StringEncoder createStringEncoder() {
        return new Caverphone1();
    }

    /**
     * Tests example adapted from version 2.0  http://caversham.otago.ac.nz/files/working/ctp150804.pdf
     * 
     * AT1111 words: add, aid, at, art, eat, earth, head, hit, hot, hold, hard, heart, it, out, old
     * 
     * @throws EncoderException
     */
    @Test
    public void testCaverphoneRevisitedCommonCodeAT1111() throws EncoderException {
        this.checkEncodingVariations("AT1111", new String[]{
            "add",
            "aid",
            "at",
            "art",
            "eat",
            "earth",
            "head",
            "hit",
            "hot",
            "hold",
            "hard",
            "heart",
            "it",
            "out",
            "old"});
    }

    @Test
    public void testEndMb() throws EncoderException {
        String[][] data = {{"mb", "M11111"}, {"mbmb", "MPM111"}};
        this.checkEncodings(data);
    }

    /**
     * Tests some examples from version 2.0 http://caversham.otago.ac.nz/files/working/ctp150804.pdf
     * 
     * @throws EncoderException
     */
    @Test
    public void testIsCaverphoneEquals() throws EncoderException {
        Caverphone1 caverphone = new Caverphone1();
        Assert.assertFalse("Caverphone encodings should not be equal", caverphone.isEncodeEqual("Peter", "Stevenson"));
        Assert.assertTrue("Caverphone encodings should be equal", caverphone.isEncodeEqual("Peter", "Peady"));
    }

    /**
     * Tests example from http://caversham.otago.ac.nz/files/working/ctp060902.pdf
     * 
     * @throws EncoderException
     */
    @Test
    public void testSpecificationV1Examples() throws EncoderException {
        String[][] data = {{"David", "TFT111"}, {"Whittle", "WTL111"}};
        this.checkEncodings(data);
    }

    /**
     * Tests examples from http://en.wikipedia.org/wiki/Caverphone
     * 
     * @throws EncoderException
     */
    @Test
    public void testWikipediaExamples() throws EncoderException {
        String[][] data = {{"Lee", "L11111"}, {"Thompson", "TMPSN1"}};
        this.checkEncodings(data);
    }

}
