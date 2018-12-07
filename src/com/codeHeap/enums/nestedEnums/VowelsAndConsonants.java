package com.codeHeap.enums.nestedEnums;

import com.codeHeap.enums.util.Enums;

public class VowelsAndConsonants {

    public static enum LetterCategory {

        VOWEL(Letter.Vowel.class),
        SOMETIMES_A_VOWEL(Letter.Sometimes_a_vowel.class),
        CONSONANT(Letter.Consonant.class);

        interface Letter {
            enum Vowel implements Letter {
                e, u, i, o, a;
            }

            enum Sometimes_a_vowel implements Letter {
                y;
            }

            enum Consonant implements Letter {
                q, w, r, t, p, s, d, f, g, h, j, k, z, x, c, v, b, n, m;
            }
        }

        Letter[] letters;

        LetterCategory(Class<? extends Letter> category) {
            letters = category.getEnumConstants();
        }

        Letter popRandomLetter() {
            return Enums.random(letters);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(Enums
                        .random(LetterCategory.class)
                        .popRandomLetter()
                );
            }
            System.out.println();
        }
    }
}
