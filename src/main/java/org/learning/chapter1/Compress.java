package org.learning.chapter1;

import java.util.BitSet;

public class Compress {
    // For example, we take gene sequence and compress them from
    // String to BitSet

    private BitSet bitSet;
    private int length;

    public Compress(String gene) {
        compress(gene);
    }

    public static void main(String[] args) {
        final String original =
                "TAGGGATTAACCGTTATATATATATAGCCATGGATCGATTATATAGGGATTAACCGTTATATATATATAGCCATGGATCGATTATA";
        Compress compressed = new Compress(original);
        final String decompressed = compressed.decompress();
        System.out.println(decompressed);
        System.out.println("original is the same as decompressed: " +
                original.equalsIgnoreCase(decompressed));
    }

    private void compress(String gene) {
        length = gene.length();
        // symbol = 2 bits
        bitSet = new BitSet(length * 2);
        final var upperGene = gene.toUpperCase();
        for (int i = 0; i < length; i++) {
            final int firstLocation = 2 * i;
            final int secondLocation = 2 * i + 1;
            switch (upperGene.charAt(i)) {
                case 'A': // 00 - next two bits
                    bitSet.set(firstLocation, false);
                    bitSet.set(secondLocation, false);
                    break;
                case 'C': // 01
                    bitSet.set(firstLocation, false);
                    bitSet.set(secondLocation, true);
                    break;
                case 'G': // 10
                    bitSet.set(firstLocation, true);
                    bitSet.set(secondLocation, false);
                    break;
                case 'T': // 11
                    bitSet.set(firstLocation, true);
                    bitSet.set(secondLocation, true);
                    break;
                default:
                    throw new IllegalArgumentException("The provided gene String contains characters other than ACGT");
            }
        }
    }

    private String decompress() {
        if (bitSet == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < (length * 2); i += 2) {
            final int firstBit = (bitSet.get(i) ? 1 : 0);
            final int secondBit = (bitSet.get(i + 1) ? 1 : 0);
            final int lastBits = firstBit << 1 | secondBit;
            switch (lastBits) {
                case 0b00: // 00 = 'A'
                    builder.append('A');
                    break;
                case 0b01: // 01 = 'C'
                    builder.append('C');
                    break;
                case 0b10: // 10 = 'G'
                    builder.append('G');
                    break;
                case 0b11: // 11 = 'T'
                    builder.append('T');
                    break;
            }
        }
        return builder.toString();
    }
}
