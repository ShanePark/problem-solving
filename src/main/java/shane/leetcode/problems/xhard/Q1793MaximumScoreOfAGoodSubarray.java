package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * tle
 */
public class Q1793MaximumScoreOfAGoodSubarray {

    @Test
    public void test() {
        assertThat(maximumScore(new int[]{1, 4, 3, 7, 4, 5}, 3)).isEqualTo(15);
        assertThat(maximumScore(new int[]{5, 5, 4, 5, 4, 1, 1, 1}, 0)).isEqualTo(20);
    }

    /**
     * 1 sec 52ms
     */
    @Test
    public void tle() {
        int nums[] = new int[]{2162, 4856, 6782, 5580, 2733, 260, 1898, 4746, 6543, 5174, 5481, 6369, 1315, 3747, 5720, 6164, 8277, 908, 3513, 9397, 7679, 8131, 730, 9178, 8136, 5507, 2259, 6230, 5292, 666, 5914, 8905, 4504, 4688, 8079, 8897, 8025, 4427, 3282, 2733, 3985, 4091, 3831, 3358, 651, 4564, 4677, 8835, 6693, 4420, 4777, 9038, 5092, 1738, 9513, 5486, 700, 5422, 2454, 8167, 5389, 8976, 8598, 9955, 3094, 4219, 7164, 605, 6284, 5109, 4360, 1295, 5690, 1405, 1631, 4826, 7429, 8438, 9566, 8352, 3751, 2970, 4623, 8629, 163, 6309, 3883, 2549, 1005, 8750, 1573, 1661, 5222, 6597, 868, 6748, 6386, 4159, 5840, 1807, 482, 6896, 1147, 9300, 7928, 7389, 1421, 115, 2766, 3381, 6978, 7191, 7392, 5241, 6149, 4511, 8346, 3786, 8240, 5828, 6218, 6037, 2724, 7330, 6187, 3545, 3173, 1712, 3374, 1780, 1726, 4591, 791, 8539, 1325, 4919, 9294, 9651, 4727, 9467, 5313, 2697, 5126, 1943, 874, 8322, 3754, 2641, 8603, 1204, 7432, 304, 8338, 4633, 54, 3292, 3624, 8381, 2601, 907, 1986, 8129, 581, 1472, 782, 8886, 4869, 9020, 7601, 3595, 936, 6638, 6682, 2706, 3564, 2234, 625, 6588, 8839, 253, 9207, 8149, 6117, 4330, 1795, 2511, 3309, 4930, 6140, 4545, 7409, 9901, 2817, 7289, 4103, 4101, 790, 8016, 2939, 5237, 3165, 7697, 1083, 8947, 5194, 5534, 9619, 8668, 3188, 107, 6377, 3141, 4807, 1479, 1168, 4799, 9827, 9193, 9105, 7265, 6421, 5551, 8568, 8047, 1690, 1371, 4849, 9480, 775, 2316, 2430, 9305, 4061, 4739, 4120, 3304, 8765, 3302, 4109, 5927, 5654, 152, 4096, 1868, 2512, 2667, 2038, 3096, 6863, 3558, 5865, 2145, 8301, 3459, 7464, 7419, 8766, 103, 7561, 8965, 4868, 3460, 5003, 3138, 7382, 346, 301, 766, 2614, 5097, 142, 9074, 3267, 248, 4581, 6824, 7249, 5946, 4622, 1650, 9964, 5573, 5053, 9864, 8271, 1417, 5053, 6522, 1755, 8971, 2376, 1330, 803, 7512, 1100, 5020, 122, 1685, 6290, 630, 7505, 8179, 6110, 5201, 7247, 7365, 1306, 5046, 9483, 9571, 8583, 9441, 3220, 1694, 3403, 8548, 548, 8787, 9821, 3209, 1380, 34, 6290, 730, 1243, 4726, 4402, 7379, 6911, 5129, 8467, 9662, 8860, 6651, 2249, 2070, 155, 5342, 513, 7737, 1266, 6659, 2663, 471, 1891, 7415, 186, 5054, 8744, 5034, 7012, 7800, 7214, 1803, 1535, 6877, 5592, 6529, 2034, 5552, 8579, 9317, 4732, 9218, 6981, 7993, 881, 5226, 6809, 6808, 3568, 2808, 9175, 2968, 3610, 9530, 3126, 5091, 7197, 7913, 463, 1446, 626, 2566, 6687, 8290, 8522, 4840, 5368, 1010, 6933, 8901, 1195, 5686, 3164, 4332, 6620, 7829, 6894, 4, 2259, 6, 3362, 5645, 5448, 7646, 3566, 2238, 191, 1041, 5524, 702, 7166, 7861, 6749, 1784, 8591, 6596, 7459, 3915, 9887, 4534, 4677, 3501, 3282, 5680, 763, 5761, 1240, 8211, 561, 4408, 2534, 6069, 2431, 3385, 6129, 9756, 1262, 468, 7466, 4667, 2125, 889, 7922, 2504, 1871, 5066, 5824, 1682, 3827, 9488, 7516, 9371, 6568, 9000, 5997, 6045, 1291, 3138, 1787, 5193, 4864, 2051, 7200, 4866, 7766, 4742, 7497, 4762, 7481, 2237, 5850, 7306, 6362, 737, 7469, 6481, 2877, 2112, 5728, 8775, 3551, 8955, 339, 5037, 2969, 7070, 6356, 7446, 816, 6517, 3937, 8909, 9961, 2318, 4818, 7010, 8631, 1344, 126, 9405, 3341, 6514, 2960, 4965, 1566, 2590, 4845, 5047, 5946, 8380, 864, 3200, 4996, 8120, 934, 4730, 4508, 196, 6745, 4495, 5129, 3629, 3205, 4600, 8993, 3024, 7081, 381, 8525, 7051, 5857, 7813, 2554, 5244, 7660, 2017, 6378, 3600, 7559, 9539, 9160, 1152, 7447, 4294, 3627, 6489, 1824, 6457, 341, 2440, 9737, 6324, 6682, 2117, 3387, 6238, 7322, 4405, 8944, 8104, 3976, 6622, 4412, 3145, 2604, 5326, 8247, 7701, 9899, 5142, 4154, 739, 773, 8996, 8548, 3938, 1835, 2232, 1754, 9291, 7501, 535, 2337, 4635, 5057, 5535, 9414, 2068, 5084, 8205, 2537, 9808, 7760, 3423, 3041, 30, 608, 4230, 5916, 5833, 9029, 7644, 3472, 9587, 7135, 8347, 8476, 6008, 7707, 397, 4791, 1395, 8515, 8801, 8727, 6411, 3077, 1659, 5196, 8912, 7735, 1748, 4653, 6770, 6221, 4277, 6794, 9312, 3582, 7107, 5551, 5008, 2515, 9521, 7262, 1804, 1712, 8095, 1019, 4295, 3691, 8055, 4693, 7384, 7924, 503, 6740, 1301, 4504, 5095, 6687, 1538, 5800, 3023, 8291, 5534, 4859, 7210, 3052, 9470, 8573, 4833, 2915, 7563, 4079, 533, 3272, 4275, 7485, 4137, 2176, 2407, 1520, 9386, 7997, 7241, 7206, 5417, 5671, 7849, 9988, 5524, 241, 1855, 5116, 652, 5834, 3100, 1259, 8884, 4448, 8367, 1851, 5628, 4267, 7482, 9545, 4573, 3807, 1990, 3358, 3077, 8574, 3102, 595, 5464, 3727, 5818, 3099, 2399, 3898, 7508, 6456, 9081, 9652, 4931, 6724, 3533, 885, 3939, 1466, 2846, 6913, 6327, 9243, 7946, 4348, 6115, 5348, 6194, 284, 6068, 9451, 2524, 2450, 2854, 2278, 8414, 1333, 8421, 5427, 6606, 3625, 3830, 8182, 7845, 373, 651, 586, 5409, 1667, 3853, 303, 5252, 6728, 9027, 162, 8411, 7495, 8389, 3546, 8487, 1887, 9997, 533, 8264, 941, 9104, 4724, 3798, 3113, 2409, 5097, 815, 6227, 2086, 4754, 6750, 633, 7786, 2855, 5446, 9420, 4319, 9518, 3839, 5333, 6028, 9930, 6709, 3244, 569, 5476, 9132, 4018, 6364, 3091, 6216, 473, 6546, 9487, 3986, 6054, 9561, 743, 7108, 9754, 7475, 6505, 9029, 8773, 7461, 9626, 7295, 2328, 4996, 5850, 5692, 9054, 4061, 268, 8395, 5315, 6492, 8223, 2480, 7640, 183, 5782, 1849, 7019, 4724, 1806, 4556, 1625, 2958, 6188, 2660, 2497, 8805, 2279, 5653, 7348, 5483, 904, 214, 1954, 5068, 1742, 2103, 1677, 9334, 2766, 7448, 6746, 3307, 7137, 2398, 7625, 867, 5215, 7532, 6069, 6685, 3448, 1221, 2591, 3068, 1195, 8106, 4660, 3063, 3048, 1730, 3208, 7556, 803, 4496, 5573, 8208, 5917, 2430, 2182, 1780, 372, 4131, 212, 8606, 9708, 5575, 2810, 1940, 7503, 6019, 8657, 6263, 1017, 8435, 1127, 7617, 7443, 8520, 7643, 5077, 8536, 8099, 8821, 1085, 8907, 609, 2420, 7845, 9293, 7923, 558, 1417, 9578, 9960, 7093, 28, 7623, 4832, 97, 7198, 5341, 9466, 103, 11, 3666, 7315, 3244, 8553, 3337, 9492, 4706, 9256, 5634, 9587, 5170, 4796, 2491, 7340, 2494, 3127, 9236, 4141, 2170, 4676, 226, 2167, 5627, 3517, 5142, 7208, 8002, 7310, 74, 989, 6880, 6735, 8879, 6720, 9188, 2519, 2860, 7244, 791, 96, 7614, 2248, 9455, 626, 5660, 9052, 5324, 2286, 4260, 1807, 9948, 8916, 9857, 1025, 640, 5676, 831, 4364, 4053, 8239, 6888, 1067, 5395, 9033, 5349, 3991, 6778, 1460, 6399, 9282, 6056, 7995, 5349, 8694, 9610, 7762, 3457, 7381, 9520, 571, 6984, 6072, 1163, 7173, 4367, 6155, 5005, 7391, 8374, 2904, 182, 4762, 9095, 7799, 7174, 1358, 9164, 8229, 6386, 3588, 9481, 9273, 7737, 7062, 7073, 1927, 9352, 1179, 4302, 2863, 938, 3874, 1453, 4477, 3907, 2510, 2132, 1815, 7695, 8218, 1346, 2252, 2255, 575, 486, 700, 7142, 2361, 8652, 5491, 785, 8784, 3964, 7143, 7421, 1229, 9452, 1173, 7406, 802, 8259, 3264, 6536, 4155, 7082, 259, 5256, 5792, 5513, 6401, 4779, 2689, 9017, 9064, 9110, 8369, 2765, 2908, 1582, 1936, 1157, 7925, 6648, 2914, 5455, 2505, 8306, 8967, 2173, 4869, 5472, 895, 6245, 8672, 1748, 7873, 7097, 3733, 7394, 6603, 9168, 8181, 6824, 3037, 4696, 2846, 2181, 3224, 9960, 4787, 6492, 695, 2875, 8611, 2791, 2817, 7252, 9877, 3138, 7504, 1375, 1387, 4380, 4088, 5186, 1987, 7281, 7556, 5670, 9502, 7178, 9912, 8218, 5197, 3463, 5966, 5966, 1671, 447, 4852, 7940, 6515, 2262, 1629, 7487, 5026, 3894, 9666, 7042, 6169, 306, 9284, 1157, 6708, 3199, 393, 4654, 2074, 5058, 6435, 1654, 7136, 6028, 3621, 1781, 7321, 2897, 988, 9379, 5625, 973, 2463, 2564, 2051, 609, 3818, 5567, 9236, 2160, 3884, 7598, 3852, 5932, 8215, 5215, 6023, 9917, 8256, 9900, 1658, 5864, 7440, 4000, 3730, 2481, 9290, 9271, 4727, 159, 2194, 3934, 1130, 8384, 2896, 8562, 9005, 7951, 257, 4391, 4538, 3004, 2164, 2812, 5391, 6684, 4373, 520, 2841, 9533, 8766, 3969, 1616, 8555, 4771, 477, 2381, 5757, 4890, 5532, 1597, 3868, 2184, 9044, 5179, 5257, 6835, 5501, 4812, 784, 2722, 7282, 405, 5418, 916, 3062, 6188, 9448, 7682, 8344, 1832, 2478, 2770, 7100, 2880, 4945, 3652, 4985, 3309, 5388, 4232, 2981, 2960, 4491, 7850, 1368, 6851, 7085, 34, 3575, 6718, 8934, 3498, 9228, 9233, 5635, 6232, 8624, 761, 2869, 5520, 9197, 5642, 6054, 9512, 7970, 846, 9886, 8922, 4561, 9428, 8360, 9510, 7011, 9096, 217, 7432, 3587, 7756, 5018, 4704, 1026, 6316, 2673, 946, 1604, 4746, 1138, 2380, 3966, 7653, 7223, 8410, 973, 3511, 5976, 1126, 2107, 6137, 5549, 7240, 9105, 436, 3822, 8133, 9904, 1143, 8945, 5126, 1143, 505, 7637, 6315, 7435, 8862, 6324, 8541, 8387, 4216, 1533, 4200, 9832, 7626, 8327, 4091, 8237, 6546, 4430, 7795, 5047, 644, 7169, 5589, 9532, 7098, 7488, 6511, 7546, 3857, 71, 4809, 272, 3891, 3260, 5229, 5886, 2802, 2368, 3846, 6846, 4157, 4129, 1732, 4654, 3764, 2768, 5342, 1425, 7044, 222, 3259, 2673, 9738, 5853, 4243, 5777, 7113, 6975, 3450, 9040, 6114, 3695, 903, 6511, 8548, 8582, 3544, 1109, 6077, 3940, 8160, 5984, 1853, 8704, 9538, 5856, 5745, 2251, 3532, 1864, 9836, 8158, 9216, 9178, 9447, 8119, 236, 2028, 6420, 734, 918, 5331, 6566, 8727, 2222, 5488, 8607, 9370, 3029, 669, 3997, 3324, 6518, 385, 5279, 7205, 5670, 8789, 4551, 6446, 3684, 3755, 4606, 1026, 5595, 6827, 9152, 435, 2522, 1960, 1187, 4380, 1393, 6077, 5195, 3625, 8892, 4516, 9279, 9725, 5856, 5352, 5545, 7507, 254, 2920, 5233, 3983, 7452, 2051, 5063, 8307, 5680, 7898, 1453, 4910, 2682, 6467, 1222, 5257, 6144, 306, 3451, 2282, 8468, 2087, 8825, 5422, 8268, 2949, 5777, 931, 6721, 6181, 5200, 4882, 424, 843, 4662, 6119, 7966, 1981, 9725, 9233, 3258, 4910, 5814, 928, 4849, 9715, 2866, 1777, 63, 1806, 4939, 3524, 9819, 5813, 3444, 2031, 2644, 5246, 783, 8183, 5689, 1776, 7578, 5852, 9122, 6515, 7005, 4456, 7350, 9123, 468, 7390, 9758, 8677, 8189, 6835, 4724, 6747, 6358, 5056, 4233, 9296, 9073, 8494, 8905, 2320, 4741, 6342, 1566, 5030, 3654, 5873, 8336, 4858, 7992, 6588, 2606, 1831, 5991, 7500, 9708, 1351, 7217, 7619, 1262, 942, 8194, 655, 3500, 7121, 9230, 4244, 4674, 2336, 2027, 2999, 2573, 4534, 1498, 3348, 2062, 6749, 6228, 2518, 6790, 8937, 5710, 4876, 4350, 3743, 8444, 3806, 2359, 6551, 4863, 5872, 9379, 9852, 3004, 4281, 6427, 2251, 7045, 8327, 9000, 3419, 1535, 9910, 2071, 634, 2872, 5435, 3946, 1606, 3082, 1066, 5364, 783, 8672, 6240, 9568, 9563, 779, 2236, 77, 5752, 7036, 7067, 2840, 9544, 3079, 2587, 3264, 7271, 1120, 2610, 3989, 7208, 8596, 4635, 3869, 6006, 9875, 3661, 3967, 3305, 352, 9694, 6984, 9821, 2571, 1987, 9492, 8860, 1740, 3376, 8376, 8793, 9804, 6954, 9860, 9872, 4852, 89, 1183, 3580, 8103, 3881, 5302, 4570, 8346, 7261, 782, 1894, 4431, 3694, 6563, 4455, 5303, 9657, 2339, 9403, 7465, 3613, 7175, 4654, 5031, 4533, 8676, 5329, 2843, 9420, 5125, 2825, 3318, 6936, 7284, 2745, 2639, 1887, 5674, 5513, 8011, 4621, 1798, 7076, 7610, 8921, 5307, 8686, 1751, 58, 7454, 3793, 3412, 3268, 4658, 7750, 3023, 7791, 9987, 4470, 1255, 8875, 5698, 791, 1654, 9348, 3662, 5419, 5185, 3271, 6938, 7727, 1275, 5040, 2399, 4876, 2502, 5542, 7793, 2863, 8061, 174, 8250, 4549, 807, 9816, 3954, 332, 3592, 2350, 9378, 4672, 9370, 2502, 8451, 6732, 1929, 9551, 7228, 4037, 4770, 9660, 1852, 4250, 7071, 1450, 7871, 1128, 4796, 1811, 6585, 490, 3377, 3177, 504, 8450, 4999, 3587, 754, 6242, 8986, 5774, 377, 1829, 9889, 9725, 6625, 4981, 6964, 8394, 3771, 9516, 6992, 2639, 8049, 2341, 7025, 8927, 3375, 5549, 1518, 1422, 2168, 8603, 4163, 2180, 104, 9952, 3430, 7661, 9077, 8084, 6899, 674, 4583, 3719, 6699, 6432, 4938, 2063, 5828, 4577, 6402, 388, 4354, 4362, 2951, 121, 7129, 9576, 4353, 3103, 6258, 2084, 4976, 6566, 6147, 4554, 7215, 3760, 1604, 9096, 1001, 6056, 6073, 2485, 8137, 8999, 6583, 320, 5504, 2454, 1674, 8008, 5582, 2500, 390, 7495, 8009, 5178, 8037, 1045, 3078, 6152, 3138, 3324, 5135, 1326, 6460, 9091, 5603, 7849, 7090, 9249, 9926, 3703, 7239, 565, 8062, 1101, 7175, 4896, 5962, 1887, 7983, 2243, 2567, 771, 878, 1282, 9617, 9376, 4854, 6421, 9395, 5351, 1342, 2312, 2792, 5388, 4568, 7134, 7853, 5560, 7025, 8013, 9058, 2898, 6324, 7774, 7378, 2926, 2023, 9815, 7849, 1859, 5848, 8880, 5592, 660, 5442, 8449, 391, 1128, 2231, 3654, 7513, 5551, 2753, 5590, 1696, 7352, 8187, 9190, 8784, 6101, 9379, 4210, 1115, 5631, 4814, 6797, 6359, 6008, 644, 1956, 4985, 5321, 913, 5687, 107, 7897, 5602, 1611, 6881, 7692, 1185, 6416, 5514, 2084, 8089, 3845, 1055, 5461, 5826, 8471, 8438, 2588, 3738, 9205, 4110, 8524, 313, 522, 504, 7554, 3212, 5922, 2818, 4876, 9625, 6788, 3266, 5809, 5053, 4436, 4667, 808, 5987, 2821, 4595, 9443, 3869, 9122, 6307, 7351, 7571, 1257, 6386, 7390, 3252, 4777, 2488, 9049, 7739, 6210, 6806, 6620, 3224, 8073, 8093, 8020, 8882, 1181, 812, 1777, 2995, 4904, 6714, 7922, 1860, 2542, 777, 2349, 4039, 6334, 6875, 6019, 9775, 1732, 3085, 2635, 6725, 755, 1745, 1133, 7694, 3264, 873, 2358, 5955, 2713, 9717, 5364, 8848, 4171, 941, 2154, 4637, 1889, 1126, 9884, 750, 5405, 1321, 9517, 8001, 1246, 3062, 7691, 4586, 8364, 3865, 8844, 2638, 5210, 7819, 5565, 8859, 1553, 6939, 2193, 5964, 4209, 9598, 2161, 4004, 62, 8473, 9763, 4418, 9943, 8409, 8113, 1512, 5097, 5862, 7101, 4639, 8513, 1879, 293, 9019, 9545, 7073, 4174, 697, 7081, 2823, 6303, 7527, 9402, 6603, 5849, 4337, 7727, 6223, 5418, 9934, 9088, 1104, 302, 1759, 5746, 661, 5036, 238, 956, 4659, 999, 3412, 7486, 571, 9893, 7646, 8400, 5934, 9410, 4603, 4390, 4899, 2156, 6177, 962, 9332, 740, 7126, 9012, 9737, 1537, 631, 4217, 4462, 7346, 3485, 5764, 9797, 6079, 7330, 7183, 1639, 8820, 317, 3521, 1618, 9807, 140, 1226, 1805, 7444, 5773, 4139, 2296, 2153, 1094, 1584, 1009, 4500, 4497, 2583, 8903, 6735, 506, 5002, 8960, 1215, 5977, 7365, 5856, 4387, 2486, 3671, 8112, 4230, 8232, 614, 3955, 3629, 200, 5709, 5022, 5871, 7065, 214, 3812, 7542, 8221, 7112, 1108, 5349, 3027, 5378, 1354, 381, 1561, 7970, 5830, 876, 2608, 8830, 7885, 8869, 3926, 6859, 1977, 9714, 2368, 9753, 7780, 1120, 7773, 2516, 7285, 393, 4558, 8867, 8347, 5321, 9943, 4963, 6854, 4018, 2082, 3573, 8944, 5040, 896, 9565, 9342, 2407, 1019, 2096, 8460, 1759, 4325, 145, 986, 9374, 3752, 3682, 9245, 4590, 5224, 1598, 935, 2108, 1674, 1524, 2871, 7566, 1931, 5734, 3953, 5039, 6479, 8391, 6949, 4768, 6357, 3310, 5692, 1429, 9002, 2786, 3861, 5015, 6612, 2608, 3768, 715, 1782, 930, 8263, 5386, 4748, 2328, 9420, 4353, 1229, 9785, 5023, 1567, 7271, 1877, 9557, 7684, 9981, 6207, 187, 6412, 2076, 612, 6373, 2368, 1665, 7564, 4694, 181, 9458, 8659, 6870, 5158, 2359, 5800, 7551, 4942, 5411, 3350, 91, 7215, 8241, 7894, 233, 3837, 1859, 2968, 2095, 810, 2675, 7898, 7829, 8827, 1961, 3719, 21, 7206, 1425, 4494, 8341, 3260, 9315, 2897, 2578, 3612, 6120, 4451, 5846, 1405, 7570, 716, 3294, 980, 8463, 3066, 8524, 5581, 1688, 5587, 9094, 8668, 8882, 4648, 5314, 3998, 5403, 5494, 694, 6884, 4642, 8273, 4955, 7670, 5124, 3, 3778, 5070, 5941, 9183, 4728, 9068, 1481, 7217, 1357, 7168, 8200, 1077, 5551, 1532, 9496, 6867, 3275, 1461, 6702, 7613, 7511, 5219, 6157, 7958, 3832, 837, 8628, 9740, 8835, 7783, 5451, 1026, 7703, 7616, 8834, 8372, 1764, 9767, 9165, 720, 6660, 9665, 9510, 2659, 802, 4428, 809, 6053, 4808, 7733, 3062, 7758, 380, 2925, 2989, 454, 7430, 5094, 4129, 6284, 7740, 6849, 5676, 8865, 1364, 9300, 2827, 2487, 6251, 4028, 5317, 4344, 5274, 9770, 2948, 8495, 6272, 5476, 4815, 6830, 8983, 9245, 6705, 2953, 3336, 9523, 8204, 9762, 7757, 3768, 9780, 9099, 785, 9087, 7607, 8493, 3494, 8264, 2957, 644, 1976, 3052, 4769, 2693, 8607, 103, 1563, 2122, 7941, 8168, 1020, 7327, 3435, 7185, 1315, 9601, 7103, 8191, 9034, 8907, 7560, 9811, 1655, 2553, 8506, 2590, 1721, 4486, 8009, 1394, 217, 7972, 4856, 9214, 3590, 2070, 3346, 5539, 4872, 105, 1037, 9073, 6481, 281, 944, 8395, 198, 4930, 3340, 653, 8003, 2030, 6564, 3124, 88, 2919, 5969, 2264, 7489, 4295, 7592, 5068, 131, 7503, 8777, 5291, 1997, 6860, 5175, 4204, 4998, 9551, 8397, 4831, 2309, 7506, 422, 3618, 153, 3621, 8513, 5435, 3761, 1331, 8054, 6711, 4758, 3280, 3923, 6853, 3759, 2980, 5420, 9560, 3092, 2984, 8964, 9670, 257, 4209, 5805, 4045, 8566, 6967, 8781, 8824, 7156, 6693, 2362, 4253, 341, 6377, 4256, 1792, 4520, 3308, 8641, 2665, 8941, 9133, 2123, 6929, 8521, 4085, 8405, 503, 9221, 4985, 7595, 8591, 7166, 8491, 3732, 3673, 8774, 2898, 2212, 2252, 428, 6746, 8910, 4584, 8022, 8747, 3743, 839, 2252, 6682, 1154, 4310, 3370, 9346, 2828, 5174, 3, 7302, 9784, 8381, 3025, 1360, 2902, 2667, 2501, 6123, 3464, 5900, 6526, 8990, 9826, 9970, 2533, 6318, 2799, 1993, 3741, 7689, 7141, 7716, 2443, 5995, 212, 1971, 6316, 503, 5301, 2632, 418, 7242, 3557, 9284, 904, 1213, 9393, 151, 7619, 8377, 1104, 8766, 8269, 3650, 5812, 3407, 4779, 6405, 347, 4612, 1873, 6717, 3283, 790, 5373, 466, 672, 1813, 6481, 4483, 880, 4793, 5061, 5804, 629, 7593, 19, 1872, 1671, 7963, 3687, 6494, 4358, 6421, 165, 6088, 14, 4671, 9198, 6086, 1175, 7710, 2030, 5732, 9615, 979, 5912, 2805, 2984, 470, 6633, 1976, 3855, 5059, 274, 7902, 7132, 9675, 7553, 1502, 8846, 4340, 6839, 3501, 5764, 61, 4151, 2234, 4108, 6861, 4949, 8249, 2170, 2079, 5773, 6909, 6232, 2449, 4646, 5536, 875, 5544, 1195, 3821, 395, 5824, 1673, 1735, 1143, 5624, 5700, 7289, 2023, 5520, 4780, 7310, 1511, 3608, 3143, 8051, 5031, 6171, 6356, 9165, 5733, 9216, 3185, 8506, 7855, 2075, 4678, 4016, 2799, 9340, 8990, 3755, 9748, 3826, 9129, 5122, 1930, 1969, 5817, 2748, 3640, 4860, 1825, 9702, 8122, 5768, 284, 8127, 7077, 9961, 4008, 1860, 1858, 9420, 2751, 1358, 8246, 2719, 8696, 2799, 3053, 3596, 4073, 8149, 6130, 760, 7536, 4118, 3918, 8194, 8789, 3164, 1098, 2432, 8819, 8615, 549, 5280, 3815, 9937, 4866, 1522, 1543, 6121, 2107, 7906, 3602, 4046, 526, 2830, 9182, 3502, 9891, 6678, 9709, 6472, 1571, 1339, 395, 4987, 8232, 3478, 6977, 7072, 550, 3148, 2016, 394, 4534, 4048, 2590, 6890, 5901, 4925, 5034, 9377, 8892, 2220, 1523, 2159, 8808, 2355, 971, 4306, 240, 6099, 441, 5333, 1699, 9016, 3613, 2192, 65, 9687, 6281, 536, 6393, 4973, 48, 505, 6596, 108, 9153, 2798, 6049, 7982, 8076, 359, 1758, 3339, 2966, 2333, 2579, 8892, 8165, 173, 871, 5916, 8771, 6673, 3149, 1221, 3703, 5021, 130, 1223, 1244, 8275, 5800, 2855, 9048, 1433, 9410, 7095, 6843, 626, 1583, 9436, 1347, 6261, 8211, 1415, 6801, 8354, 2345, 9582, 6805, 1530, 243, 7038, 1366, 9223, 4683, 3503, 9255, 4711, 6839, 3997, 9614, 9661, 8912, 6370, 8553, 2936, 4380, 659, 1942, 6347, 1491, 5039, 6365, 6319, 563, 759, 982, 5501, 3372, 4926, 8944, 8218, 2859, 5313, 176, 8059, 7325, 711, 2431, 3642, 297, 5529, 9795, 244, 9144, 668, 8839, 6900, 6685, 8046, 7925, 4825, 7605, 9430, 1703, 9415, 8665, 3946, 901, 2892, 7748, 27, 4375, 6886, 4, 9919, 9399, 2997, 7710, 6525, 506, 973, 8919, 9412, 6855, 2057, 8968, 2868, 9071, 4888, 4903, 3350, 3304, 1221, 7839, 3458, 8558, 4387, 7122, 2726, 2172, 1889, 4699, 2966, 4683, 6955, 4539, 3902, 5803, 2097, 7390, 8124, 5073, 2702, 6835, 6244, 6205, 6334, 540, 5948, 7097, 9729, 2985, 7442, 5429, 7671, 3114, 4318, 3196, 9769, 772, 6920, 9994, 7259, 5967, 5682, 9750, 2110, 9367, 9554, 597, 7860, 9236, 7391, 9631, 5119, 3600, 3912, 5782, 7963, 4326, 9829, 2774, 9672, 4807, 1598, 9755, 5424, 7390, 772, 6712, 9856, 1132, 9300, 6547, 6887, 3415, 5789, 7772, 6783, 3984, 657, 993, 5857, 1123, 1488, 7952, 4859, 8466, 9492, 6546, 8957, 8915, 5119, 5021, 3445, 1926, 2924, 4276, 248, 227, 4961, 1569, 7312, 3968, 6115, 7778, 7458, 1788, 7712, 2276, 9774, 5331, 5857, 6688, 883, 1605, 3636, 7590, 7584, 1222, 6488, 8034, 5714, 9772, 3368, 5098, 9784, 4562, 9052, 4820, 8177, 8148, 9098, 5155, 7792, 5854, 6589, 1717, 8944, 3447, 8815, 6612, 5742, 5271, 2268, 2207, 7697, 4605, 2786, 403, 6680, 4936, 6450, 5960, 2222, 1750, 6039, 9040, 6541, 1217, 8828, 96, 7772, 9505, 5734, 229, 9526, 2638, 1259, 7684, 5595, 6705, 4057, 4206, 3695, 9666, 5985, 5483, 4850, 4805, 6446, 8518, 7562, 3220, 5480, 1726, 1199, 6350, 758, 4437, 7369, 1170, 8065, 1553, 5993, 6719, 4701, 3308, 1910, 3482, 2572, 9705, 5458, 6565, 8030, 9246, 6429, 1976, 7087, 2683, 255, 3698, 4622, 7835, 5499, 4669, 9653, 5564, 9744, 6112, 4391, 4980, 5315, 4497, 8524, 9093, 2736, 5104, 1110, 2266, 2880, 7607, 7192, 2395, 8920, 4830, 5530, 4252, 3963, 3698, 4065, 1614, 4703, 7861, 5586, 7040, 7840, 5135, 7511, 7114, 3312, 453, 8158, 8726, 2960, 4798, 5110, 9977, 1803, 6408, 9804, 1491, 261, 8153, 3790, 6550, 4780, 4164, 9914, 4213, 3509, 1365, 1305, 5528, 5615, 3693, 7858, 920, 9139, 5951, 7060, 9564, 518, 95, 1736, 7100, 3684, 9109, 837, 1852, 182, 8255, 4479, 8288, 4144, 1757, 8160, 6961, 6294, 7224, 5106, 4516, 9218, 1054, 3165, 4726, 8097, 4791, 9815, 1972, 9754, 9494, 9317, 7438, 8478, 3823, 9468, 9819, 5929, 2270, 3520, 4680, 9195, 3144, 1073, 732, 7875, 8418, 7201, 7825, 3045, 4433, 6114, 6297, 9573, 7232, 788, 7981, 6809, 4370, 4060, 7742, 2361, 8967, 9596, 5090, 379, 1894, 4549, 4249, 7621, 9732, 9541, 8758, 542, 8741, 7034, 6477, 1616, 4511, 6327, 7257, 7502, 960, 743, 2743, 3319, 845, 9916, 1547, 8915, 3957, 491, 2167, 6713, 3435, 7216, 9917, 9818, 3303, 9133, 5067, 7421, 1307, 9637, 6505, 8212, 5775, 9991, 7131, 1297, 6721, 2912, 444, 714, 6489, 5527, 4648, 1676, 2609, 5453, 1752, 4686, 2451, 8475, 3293, 8576, 8730, 6471, 5118, 7236, 1488, 885, 9361, 9948, 5802, 5142, 7387, 2325, 9126, 9395, 6926, 4529, 4026, 5156, 1066, 5033, 8074, 6942, 1136, 3446, 7585, 6632, 8533, 306, 9683, 735, 5222, 3376, 548, 4739, 6842, 5725, 6737, 2960, 8434, 5187, 4358, 3256, 7334, 2205, 871, 3936, 7669, 2194, 2152, 1270, 4631, 4427, 3660, 5461, 4746, 675, 8959, 9377, 8977, 6923, 8555, 8868, 6682, 717, 2057, 1003, 6764, 9388, 8437, 700, 8766, 7869, 1008, 9597, 8103, 9026, 3774, 8742, 2489, 3493, 9286, 3062, 6613, 8555, 1677, 732, 1548, 9065, 5177, 8514, 7544, 9303, 3201, 4930, 483, 258, 5397, 4454, 7175, 2730, 4557, 3101, 6739, 5229, 1494, 5611, 3874, 4136, 7393, 5338, 2402, 1453, 2093, 9019, 4163, 8607, 2084, 3467, 2627, 9981, 2932, 6178, 3248, 7943, 984, 830, 7123, 3209, 3139, 7655, 7179, 6946, 1593, 386, 1516, 1468, 8420, 1414, 3764, 3721, 3560, 4621, 4322, 4897, 3350, 7054, 3953, 4631, 4944, 5743, 7605, 430, 7411, 9534, 4357, 8986, 3454, 905, 7372, 9819, 2593, 9542, 4033, 2632, 4093, 6370, 7566, 2781, 4266, 7670, 6008, 1975, 3379, 7800, 1039, 8024, 7067, 3838, 2818, 1727, 572, 3868, 6212, 3974, 2558, 7673, 7771, 6082, 4785, 3897, 8700, 5294, 6229, 9829, 6249, 8255, 9448, 4759, 744, 9239, 9766, 8128, 338, 9068, 5006, 6675, 2015, 9908, 4128, 56, 2378, 9354, 6571, 8985, 6910, 5015, 8810, 1367, 1604, 5388, 9961, 5370, 3365, 7249, 9239, 5685, 9865, 5703, 1153, 7057, 8382, 1751, 2254, 4197, 547, 9847, 4672, 1195, 451, 3321, 4855, 6646, 8867, 1428, 5218, 9325, 1248, 7865, 1387, 4581, 2256, 5321, 2855, 6783, 6493, 4647, 6606, 4499, 1538, 7445, 7574, 6055, 893, 4400, 7154, 1110, 112, 4933, 5247, 6885, 8837, 8255, 7608, 9120, 1648, 4493, 543, 9767, 7771, 7566, 8879, 1224, 4998, 3571, 9364, 2623, 4290, 9112, 9350, 7178, 2272, 818, 6603, 4171, 1714, 9385, 5681, 3947, 2615, 4361, 2718, 1907, 3288, 4569, 5726, 4534, 4326, 6992, 791, 9971, 7092, 2295, 8572, 8490, 7469, 7828, 1742, 8601, 1410, 8722, 2280, 2980, 6006, 9652, 6521, 6876, 9324, 8321, 9356, 9147, 532, 9396, 1682, 770, 117, 6450, 2195, 6565, 5128, 1312, 6404, 412, 6358, 9260, 8054, 5037, 4288, 8378, 6952, 3762, 176, 1910, 274, 1050, 8867, 4968, 4584, 54, 1158, 5108, 3521, 5181, 7346, 3497, 7826, 3313, 5161, 9779, 977, 885, 3266, 154, 778, 2147, 434, 7141, 5683, 9706, 4686, 7970, 4935, 8886, 9392, 1108, 5680, 6274, 2528, 1782, 5693, 4429, 4403, 9080, 2775, 8485, 8340, 3783, 555, 3324, 6949, 9840, 1935, 8938, 3357, 374, 2897, 5590, 2986, 2948, 4377, 9482, 9157, 823, 6255, 6102, 5369, 7446, 2034, 4699, 2415, 16, 5283, 1431, 8802, 9548, 2256, 8973, 5971, 666, 3730, 3187, 7547, 1054, 7920, 6076, 5493, 2777, 4456, 5430, 3206, 6126, 4051, 3253, 7862, 9172, 779, 6833, 5243, 9415, 3824, 1893, 8307, 4639, 5545, 6567, 1830, 2153, 9773, 6487, 3916, 1426, 2260, 5384, 1547, 3297, 1063, 3299, 4586, 7039, 1765, 5811, 8737, 5014, 9141, 7961, 3406, 4985, 3586, 2353, 3126, 1938, 2238, 3044, 5145, 3173, 5778, 8118, 3913, 2837, 2686, 2217, 7623, 9849, 9915, 1670, 1106, 4258, 9406, 2027, 6877, 6993, 2190, 963, 8711, 6121, 7316, 1524, 1896, 6115, 866, 7554, 6100, 1005, 4705, 6881, 8151, 2829, 4732, 4532, 8756, 7223, 822, 7769, 5443, 5587, 8115, 5015, 6666, 8620, 9188, 7935, 2827, 3902, 9491, 2464, 3072, 8845, 4003, 2817, 9840, 3748, 9142, 823, 4555, 5504, 8066, 8991, 2773, 9554, 4238, 2546, 5187, 4794, 5543, 6190, 8414, 9177, 4458, 4075, 711, 9401, 4461, 1851, 9481, 8698, 5145, 9337, 2744, 2478, 514, 3783, 6865, 6132, 4456, 9516, 9363, 4231, 5869, 8308, 6158, 3514, 4058, 9246, 3649, 6573, 1477, 4582, 197, 4459, 5610, 5055, 2881, 774, 7652, 2141, 2979, 1371, 5358, 4649, 1131, 3812, 7880, 5789, 3484, 422, 9583, 8734, 9374, 4572, 9679, 9525, 5945, 8201, 9939, 402, 6270, 1784, 7582, 4031, 8022, 7689, 9097, 5126, 7715, 6862, 4809, 2151, 6722, 6902, 6898, 6609, 8954, 3673, 9697, 8933, 8616, 9253, 6102, 5164, 720, 4811, 5971, 8710, 1066, 6568, 4913, 2196, 2778, 9393, 2870, 3237, 1084, 4309, 376, 1644, 9509, 4591, 7202, 8752, 7947, 5040, 7903, 7668, 5834, 9098, 8241, 3715, 6490, 6415, 5701, 9760, 7723, 6855, 6229, 160, 2118, 5434, 3007, 6064, 7600, 6936, 8051, 2563, 9598, 4838, 5400, 6347, 7767, 3430, 7530, 2272, 8101, 2209, 1584, 6638, 6677, 5715, 7215, 442, 424, 133, 9508, 2475, 9280, 7538, 2748, 8677, 1928, 6608, 7330, 4849, 8143, 9791, 5013, 9965, 5811, 450, 2386, 7294, 6827, 8281, 4744, 6957, 4984, 2079, 6453, 6934};
        assertThat(maximumScore(nums, 2135)).isEqualTo(62118);
    }

    int max = 0;

    public int maximumScore(int[] nums, int k) {
        Set<String> visited = new HashSet<>();
        this.max = 0;
        dfs(nums, k, k, visited, nums[k]);
        return max;
    }

    private void dfs(int[] nums, int i, int j, Set<String> visited, int min) {
        max = Math.max(max, (j - i + 1) * min);
        // move left
        if (i > 0 && visited.add((i - 1) + " " + j)) {
            dfs(nums, i - 1, j, visited, Math.min(min, nums[i - 1]));
        }
        // move right
        if (j < nums.length - 1 && visited.add(i + " " + (j - 1))) {
            dfs(nums, i, j + 1, visited, Math.min(min, nums[j + 1]));
        }
    }

}
