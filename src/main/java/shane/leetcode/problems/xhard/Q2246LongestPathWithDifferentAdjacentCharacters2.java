package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 176 ms Beats 58.56% Memory 95.8 MB Beats 87.83%
 */
public class Q2246LongestPathWithDifferentAdjacentCharacters2 {

    @Test
    public void test() {
        assertThat(longestPath(new int[]{-1, 0, 1}, "aab")).isEqualTo(2);
        assertThat(longestPath(new int[]{-1, 0, 0, 1, 1, 2}, "abacbe")).isEqualTo(3);
        assertThat(longestPath(new int[]{-1, 0, 0, 0}, "aabc")).isEqualTo(3);
    }

    @Test
    public void test2() {
        assertThat(longestPath(new int[]{-1, 520, 154, 77, 293, 128, 32, 315, 399, 7, 84, 152, 304, 243, 147, 259, 115, 102, 149, 177, 394, 211, 350, 449, 67, 213, 350, 388, 122, 31, 317, 494, 466, 202, 140, 142, 524, 159, 309, 84, 200, 237, 265, 230, 405, 157, 462, 12, 480, 15, 125, 249, 552, 134, 15, 319, 309, 323, 111, 191, 516, 406, 328, 317, 395, 304, 256, 132, 226, 211, 39, 313, 279, 279, 201, 219, 205, 553, 213, 320, 117, 185, 317, 21, 117, 442, 148, 442, 403, 409, 39, 121, 322, 383, 317, 515, 450, 39, 553, 26, 341, 318, 485, 369, 255, 378, 248, 369, 382, 85, 535, 468, 475, 60, 177, 330, 67, 153, 57, 222, 94, 316, 40, 32, 430, 208, 262, 98, 219, 152, 324, 403, 329, 299, 248, 299, 529, 117, 59, 292, 213, 300, 157, 281, 383, 186, 106, 90, 0, 388, 54, 119, 70, 551, 540, 431, 523, 364, 222, 270, 307, 442, 419, 21, 475, 391, 364, 239, 12, 350, 542, 90, 177, 433, 480, 97, 90, 85, 313, 159, 99, 207, 15, 528, 11, 270, 171, 174, 515, 462, 138, 70, 173, 411, 236, 295, 251, 409, 259, 227, 208, 431, 377, 290, 322, 529, 197, 442, 411, 449, 419, 176, 173, 97, 449, 535, 208, 149, 162, 30, 415, 319, 399, 318, 39, 111, 523, 184, 160, 223, 446, 419, 374, 467, 271, 464, 486, 176, 44, 411, 38, 48, 37, 365, 239, 433, 350, 66, 468, 207, 214, 173, 358, 196, 525, 111, 382, 117, 23, 70, 523, 330, 149, 480, 419, 482, 21, 314, 163, 160, 161, 462, 509, 402, 30, 192, 344, 317, 532, 90, 381, 274, 135, 115, 397, 169, 78, 388, 524, 318, 546, 179, 194, 379, 236, 192, 169, 548, 268, 433, 338, 284, 322, 25, 491, 213, 69, 458, 159, 89, 56, 491, 96, 462, 211, 420, 468, 553, 161, 322, 449, 266, 70, 464, 270, 147, 516, 104, 546, 78, 377, 74, 45, 12, 280, 535, 428, 347, 249, 250, 370, 479, 383, 95, 120, 160, 84, 523, 385, 84, 317, 419, 188, 153, 153, 45, 129, 376, 364, 201, 176, 186, 407, 251, 152, 73, 62, 30, 16, 258, 491, 447, 317, 140, 233, 171, 366, 84, 117, 175, 299, 147, 90, 11, 520, 322, 52, 462, 319, 164, 554, 279, 435, 397, 486, 457, 147, 546, 87, 397, 294, 160, 351, 406, 365, 259, 499, 142, 426, 546, 496, 259, 399, 235, 39, 97, 373, 421, 37, 89, 132, 543, 124, 235, 103, 38, 132, 248, 322, 308, 348, 181, 483, 491, 105, 486, 279, 427, 111, 515, 322, 140, 554, 303, 70, 490, 547, 39, 504, 491, 541, 365, 11, 305, 430, 428, 252, 176, 90, 217, 175, 260, 554, 292, 290, 425, 499, 464, 464, 390, 465, 270, 256, 472, 125, 223, 392, 366, 109, 512, 90, 399, 458, 28, 115, 179, 97, 66, 529, 129, 199, 554, 350, 511, 257, 218, 271, 414, 313, 70, 159, 394, 198, 46, 457, 49, 223, 119, 21, 525, 380, 555, 249, 430, 415, 555, 179, 65, 23, 201, 62, 245, 184, 529, 142, 554, 532, 25, 247, 403, 541, 350, 403, 425, 518, 159, 545, 367, 265, 219, 304, 248, 350, 3, 127, 96, 175, 366, 16, 339, 470, 0, 296, 39, 486, 39}
                , "smbkazncoosyriqeyqgbgqkzjzliurrdfjgclwhzdzizhdrdblzpbnxzxvrlcbibwqlymkjftgwpmretdvyezioztbwrvsyhojigdxlzayngwyxgcjhinztlrqgtkjenflbwklrxmeaiamvhogmvypqmtqfacgpdptzestrnthtuibsxqiwoxldypamzdbenrzpnexutbfuyllsdpgtbturabkosqgefuwxgxmwerickitspwzzcpgvcteuzwdvyifncgixxstabagcbxhlsgcxhtzwoxhxitebbqtcnvdmyxhisysolxiqohvkgnoxciyptkcronwxyjaubpmrfqipwsoxekfjpxjofhctwbhbmgybjtcfrsehsofipuefswijuhfiimpmlncglbcmmrrwkwnvjvdznynfmvsrllbqnrxjkvtqybiqkvpfnctqztdictaxadbqvvybhcqdydxsqkmprffaglpsklqyywmdncntatswiwnqyosqxvjuyylonpbgjsmvlorfnzyxuaahgfenwycpsvzjnhxosddfr"))
                .isEqualTo(23);
    }

    int max;

    public int longestPath(int[] parent, String s) {
        max = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 1; i < parent.length; i++) {
            graph.get(parent[i]).add(i);
        }
        dfs(graph, s, 0);
        return max;
    }

    private int dfs(Map<Integer, List<Integer>> map, String s, int cur) {
        int max1 = 0;
        int max2 = 0;
        for (Integer next : map.get(cur)) {
            int dist = dfs(map, s, next);
            if (s.charAt(cur) != s.charAt(next)) {
                max2 = Math.max(max2, dist);
                if (max1 < max2) {
                    int tmp = max1;
                    max1 = max2;
                    max2 = tmp;
                }
            }
        }

        max = Math.max(max, max1 + max2 + 1);
        return max1 + 1;
    }

}
