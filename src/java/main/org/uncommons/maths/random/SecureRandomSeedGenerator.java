// ============================================================================
//   Copyright 2006, 2007 Daniel W. Dyer
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
// ============================================================================
package org.uncommons.maths.random;

import java.security.SecureRandom;

/**
 * {@link SeedGenerator} implementation that uses Java's bundled
 * {@link SecureRandom} RNG to generate random seed data.
 * This is not the ideal seeding strategy because it inflicts the
 * limitations of SecureRandom on the RNG being seeded.  However, it
 * is the only seeding strategy that is guaranteed to work on all
 * platforms and therefore is provided as a fall-back option should
 * none of the other provided {@link SeedGenerator} implementations be
 * useable.
 * @author Daniel Dyer
 */
public class SecureRandomSeedGenerator implements SeedGenerator
{
    private static final SecureRandom SOURCE = new SecureRandom();

    /**
     * {@inheritDoc}
     */
    public byte[] generateSeed(int length) throws SeedException
    {
        byte[] seed = SOURCE.generateSeed(length);
        System.out.println(length + " bytes of seed data acquired from java.security.SecureRandom");
        return seed;
    }
}
