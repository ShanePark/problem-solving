package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1268SearchSuggestionsSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<String> list = Arrays.stream(products)
                .filter(s -> s.charAt(0) == searchWord.charAt(0))
                .sorted()
                .collect(Collectors.toList());

        List<List<String>> answer = new ArrayList<>();
        answer.add(list.stream().limit(3).collect(Collectors.toList()));

        for (int i = 1; i < searchWord.length(); i++) {
            final int index = i;
            list = list.stream()
                    .filter(s -> s.length() >= index + 1 && s.charAt(index) == searchWord.charAt(index))
                    .collect(Collectors.toList());
            answer.add(list.stream().limit(3).collect(Collectors.toList()));
        }
        return answer;
    }

    @Test
    public void test() {
        assertThat(suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse")).isEqualTo(STool.convertToStringList("[\n" +
                "[\"mobile\",\"moneypot\",\"monitor\"],\n" +
                "[\"mobile\",\"moneypot\",\"monitor\"],\n" +
                "[\"mouse\",\"mousepad\"],\n" +
                "[\"mouse\",\"mousepad\"],\n" +
                "[\"mouse\",\"mousepad\"]\n" +
                "]"));

        assertThat(suggestedProducts(
                new String[]{"havana"}
                , "havana"
        )).isEqualTo(
                STool.convertToStringList("[[\"havana\"],[\"havana\"],[\"havana\"],[\"havana\"],[\"havana\"],[\"havana\"]]")
        );

        assertThat(suggestedProducts(
                new String[]{"bags", "baggage", "banner", "box", "cloths"}
                , "bags"
        )).isEqualTo(
                STool.convertToStringList("[[\"baggage\",\"bags\",\"banner\"],[\"baggage\",\"bags\",\"banner\"],[\"baggage\",\"bags\"],[\"bags\"]]")
        );

        assertThat(suggestedProducts(
                new String[]{"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnunqerptgas", "zmmirsxdhyxvmdybjzondyvrkzeafhvualsivfueweuusmsxbttdeofzeripaqv", "tyqcpfvorznmxxdzepfxabibcagilwjsqncxnpjqsxjzqqqbae", "tyqcpfvacyrjvmadrmntxotgvgivdvcuwygpjfwcuppunolukrum", "tyqcpfvrqwrcpusmfyhxaiasfbb", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqyalwiaj", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchidnpt", "lfjkcljnd", "zibrwfpwecubjlsjbkrhnvolnnzrqhdynloplzagwnuhpxhbvpxnqaifnln", "ybswoottdgryxtupichpvqjmcoytrwnfgzrrnaejojvpzmttlzw", "tyqcplghosxjviooiyddhvzzrhuuwkiosmgafxyajcdyqlmthqkoylxhtxdruw", "okoscfpxcndzgbtsozdofgnomtglmoaewgzzjvrxezoq", "cxkwvaytkxgafeltbanhsvxlorigkuxnsxlmhvwqm", "iamtabcpdagicnvdvqcfykonsazrbdivxtczpgqgxjrifukmqjw", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbneryahanhrhkal", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnunl", "tyqcpfvorznmxxdzsuyushueegfrnlzbydnefcfagqnxglkulegntoml", "zlovtmburfkd", "vlzfaamutsfqefpafzffwhvpfw", "bbufxzwpryyakbxuhwwplvdptgybbykqxirsrahsokviihxrawcbgwrktvgacmwtc", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbzw", "kjundphljswl", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqhlqnapfkcqpdb", "stcphvgxvcaysehvrfdfllwvxf", "epbtkgnnupbbdqgheyaks", "gilhnlfkdz", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwghy", "yswdsvnzucvsdzrmeghevjrfuhoebfedvyvortaxppwqncmspctdcjlwdxfnc", "baizdtmgozykukcrkapsnp", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgcsfjgtwqqubbhjkzmio", "iblyydfzztmtyjmgrxvyjwcobfyxcgyrbtnfhhxswxahze", "tyqcpfyggtmjahhpjzwhohvchyofsxwkehq", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniaymgkdduoabmp", "gpsqlqorcbqffdxlnijgvzvxilnbkynwscuoymqyg", "eidradnaqjwmucbrgtp", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzopnqxxcxshbhdmippldmcuxlvc", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbfmryrbgicgzqecje", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuze", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqandxbuvshebs", "tyqcqqxonxtwakxlrceyknbockvovdwumbjkfrgmudiafbqlflonfavpsrfq", "tyqcpfvorznmxxdzsnkjnrrzpfourbghe", "ziarqmfvzqpqhunfxwfwjtetotozkjaszznbtrvtxarysaxq", "tyqcpfvorznmxfmlzlcuikpxvahtfbfipjcgmeusshufvnirwcopdnvnop", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvdertpdpdjsngezrnyjxotgonuigmqkgipgb", "tyqcpfvorznmxxdzsnkjnrrzpfvfcvufmzzuqrjubsfzp", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqorqffebhoyfvgkspenqpcmvoxpybkjg", "oqojrvinnhlwuqllcsabkpfiusfucpjbsxzzhlgduawaqyp", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviaxsw", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqnzudhzclswotlbgdffwiekw", "csgadyglxddodloklsegvsbtgtkloklmxkbxxyorcqwybktuzpyeaqasn", "tyqitegmijccjwxuwvchbvuvllmgsdugzxdkiqvnllhmsjyskxpzzds", "tyqcpfvorznigwmavbguxwhunsshdybhzszxvlnpingqgaghkqzeynbbbhgcxeydir", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnunflh", "tyqcpfvorznmbwmhfmudnurhismirfgvojpdmclw", "tyqcpfvjijiwoup", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejemb", "tyqcpfvorznmxxdzsnkjhvabtzucyooctzzrgehlsuyinrrnzjilfpalvqgwoey", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvie", "tyqcpfvorznmxxxvjwfgcwegpibuifhfxyomnicutaegshpnschktxknqytritr", "tyqcpfvorznetvhiaobezckojwjbeg", "tyqcpfvorzmjabuccipqln", "frutebajqddrtrsmabfmdcgipssymldwscxbbrbpb", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviotvqi", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchxeyrnlh", "yaxaddctugikoutgcwqsdekghoemtooljxvysnzqqvgpc", "tyqcpfvorznmxxdzsnkjn", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqggjwxdvqesbgrqei", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckoktdj", "mzwjshgbgbdogqbrhfgbjkrqogyynbdwwkdclsbpynlrhxeucuuo", "tyqcpfvorznmxxdzsnkjnrrztrqgpbvvxm", "u", "tyqcpfvorznmxjnsgyirdtzpwywpnrvgadkmdjghlmerbqysaebyge", "tyqcpfvorznmxxdzsnkjnrkjelwoqorxsnyjqdnxfava", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvqqy", "hcav", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviof", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwreznx", "yesupowwycvcdbknhrkfyvnpoqtdhcbhybqvhnvgukoohh", "hcvlnbmcrepblcqrvwpfsyevlpyldptubnxkntqhpounxjcw", "lwaxzivycjkanvikqpbrvdvjkaclyuyfitwfycsnfwjg", "tkruiswrcbzsbkwbhhvjzzuuiayqzbxjosjssacislcvbtcojpmyatkfgyx", "ftujoohzvjonlwxwskeydoxpfvbvrdndbhgpuvykif", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqqngbpbdtufkgunalbekxbkpajlgbjtqmswh", "tyqcpfvorznmxxdzsnkjnrrzpewgvvnicz", "tyqcpfvorznmxxdzsnkjnrrzpfgknjxnepksgdzwxsbziwdzsiiyarxhtpp", "jumcvboxaxjfybdlezcjrarolxjtsuweaigkiudusinfmnczdualqzlpwkm", "tyqcpfvoxegnpqesbaugr", "bteznmwyh", "rtbpifxevchngjnlumvtqtpebgtoznvvrzfxqzmcktoxydbstbvukrunnyeqwfd", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejysfrlewzsgukyahggau", "mvrrbfbfwyrxooopgcbwmtjfepejyfrqdkyaqencqqlagoilrtdndfyn", "tyqcpfvorznmyrzwhjxvhooytltygrakvgkqumrimazzhzoueyqnjz", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviob", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwoyvqczogovza", "tyqcpfvorznmxxdzsnkjnrrzpfgknvfnzshqqfpr", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjghvqg", "zqrnaierpnsigujuxrftdiauazddadqmrwcimxyztwumwzyjcrqvuexnitdecfgo", "xusxbbilivpovzsjvfsdnacipk", "tyqcpfvorznmxxdzkbqgrgeolnwhtvlckmiattpmxwwtmlifnexxbgtpjslwhczrjlhr", "eiuytvdzhcodcrdgthxynurtpsdyguupijjluucpfinrfnsjkdbbzexfmctejlgvd", "tyqcpfudqjrabwwvdvwmsyscnazaxpsjjhetouegipqevvointclztzummwrrbntjlsj", "tyqcpfvobzfvbiuoktjcqjfx", "tyqcpfvorznmxxdzsnamc", "ajqpomnpmsayhelmhfehjbvjaeszqigfqyuixbtyjy", "jpfxangixfavlhcssecxljksydrjxmaldhwpftinywtbmffsmtslefcuddk", "txryxhtutwdrqmpcapbcrlmhzsobueefwfekusmmylr", "etzqiepphjcleaocnwljcdn", "tyqcpfvokfxlbmbzmitacnromkoaoxl", "iddmxxcmwecfutbrbqeihhlnypckofuhkbydmljfemzrvlxsuskxkbgviybzu", "tyqcpfvorznmxxdzwilcfwrdlfqppdnuvgltuoooppwyomtvtggmsfxsxievdlsyame", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvzquhbkvburnhmerkuabrfcjwanzmfenz", "tyqcpqgaus", "zsbcqgctsjdjyfkdvcehawsqzacafwtjmhemfygdahkexvmkqkcehvek", "tyqcpfvorznmxxdzsnkjfesxjshxtlinfjltdfl", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnubpoqoghhgbpew", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdcuudsuqq", "tyqcpgwivyfquxqhbkjbioekqbsd", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnudxocavmwpggka", "tyqcpfvorznmxxdzsnkjnrrzpfgknvnlxdokehsjhiohwdeyikeajzipztzhwmxc", "pmpoycdxttisazazsgiswnsnhdmejpjbygvtjhwqydeugbouekvornbeiwmpehikbz", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwcpoxr", "qmgnrjtavzsqtwareroiihendgcvbzbcolvfoanmixxrxdtnmtevvv", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnunix", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetxpdyhmk", "tyqcpfvorznmxxdzsnkjnrfmy", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetaoqgbczdcemzlmqemy", "tyqcpfzmlffhifutomuvfvwaqatopvur", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvdvagddprewvlgx", "ozmyertmnlwybntwxmpynuynhqdbqhosvjwexzqgvdtnvxexxwwwwhqktmzbfkjfn", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckohyof", "rniiqnzbctzeyeeyrxhfzqgbccplsncvtswcrqmevplfzadlulazmpmhdojwaokn", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzakckmtmjxx", "tyqcpfvorznmxxdzsnkjnrrzpfgkhdwienfhpsqbyrvotbgchkkmvk", "tyqcpfvorznmxxdzsnkjnrrumaqtylptffsjzygeumkahutdmalkqtrhtgrsrqcyyti", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvioncnr", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvigzpo", "tyqcpfvorznmxxdzsnkjnrrzpfgkeduq", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnccdnakfkhtg", "lhehmbyzcnlwvr", "tyqcpfvojuuprlby", "wds", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqvegfwmtdcrvdb", "tyqcpfvorznpkeynkmbbyptclmhxxlyjzejqbcatgfrmkbbmxs", "tyqcpfvorznmiqmfrhihxsagizcrwyaukrjwbbgrxdzknq", "ghhlssixrouzbqcpmxzmsnybaygtb", "jndewk", "tyqcpfvorznmxxdzsnkjnrrzpdqanmxattjhgnflnoyynevsxvpbwfmfrnlc"}
                , "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviotvdticwxwcliylrpvrokbcguhnfvpd"
        )).isEqualTo(
                STool.convertToStringList("[[\"tkruiswrcbzsbkwbhhvjzzuuiayqzbxjosjssacislcvbtcojpmyatkfgyx\",\n" +
                        "\"txryxhtutwdrqmpcapbcrlmhzsobueefwfekusmmylr\",\n"+
                        "\"tyqcpfudqjrabwwvdvwmsyscnazaxpsjjhetouegipqevvointclztzummwrrbntjlsj\"],\n"+
                        "[\"tyqcpfudqjrabwwvdvwmsyscnazaxpsjjhetouegipqevvointclztzummwrrbntjlsj\",\n"+
                        "\"tyqcpfvacyrjvmadrmntxotgvgivdvcuwygpjfwcuppunolukrum\",\n"+
                        "\"tyqcpfvjijiwoup\"],\n"+
                        "[\"tyqcpfudqjrabwwvdvwmsyscnazaxpsjjhetouegipqevvointclztzummwrrbntjlsj\",\n"+
                        "\"tyqcpfvacyrjvmadrmntxotgvgivdvcuwygpjfwcuppunolukrum\",\n"+
                        "\"tyqcpfvjijiwoup\"],\n"+
                        "[\"tyqcpfudqjrabwwvdvwmsyscnazaxpsjjhetouegipqevvointclztzummwrrbntjlsj\",\n"+
                        "\"tyqcpfvacyrjvmadrmntxotgvgivdvcuwygpjfwcuppunolukrum\",\n"+
                        "\"tyqcpfvjijiwoup\"],\n"+
                        "[\"tyqcpfudqjrabwwvdvwmsyscnazaxpsjjhetouegipqevvointclztzummwrrbntjlsj\",\n"+
                        "\"tyqcpfvacyrjvmadrmntxotgvgivdvcuwygpjfwcuppunolukrum\",\n"+
                        "\"tyqcpfvjijiwoup\"],\n"+
                        "[\"tyqcpfudqjrabwwvdvwmsyscnazaxpsjjhetouegipqevvointclztzummwrrbntjlsj\",\n"+
                        "\"tyqcpfvacyrjvmadrmntxotgvgivdvcuwygpjfwcuppunolukrum\",\n"+
                        "\"tyqcpfvjijiwoup\"],\n"+
                        "[\"tyqcpfvacyrjvmadrmntxotgvgivdvcuwygpjfwcuppunolukrum\",\n"+
                        "\"tyqcpfvjijiwoup\",\n"+
                        "\"tyqcpfvobzfvbiuoktjcqjfx\"],\n"+
                        "[\"tyqcpfvobzfvbiuoktjcqjfx\",\n"+
                        "\"tyqcpfvojuuprlby\",\n"+
                        "\"tyqcpfvokfxlbmbzmitacnromkoaoxl\"],\n"+
                        "[\"tyqcpfvorzmjabuccipqln\",\n"+
                        "\"tyqcpfvorznetvhiaobezckojwjbeg\",\n"+
                        "\"tyqcpfvorznigwmavbguxwhunsshdybhzszxvlnpingqgaghkqzeynbbbhgcxeydir\"],\n"+
                        "[\"tyqcpfvorzmjabuccipqln\",\n"+
                        "\"tyqcpfvorznetvhiaobezckojwjbeg\",\n"+
                        "\"tyqcpfvorznigwmavbguxwhunsshdybhzszxvlnpingqgaghkqzeynbbbhgcxeydir\"],\n"+
                        "[\"tyqcpfvorznetvhiaobezckojwjbeg\",\n"+
                        "\"tyqcpfvorznigwmavbguxwhunsshdybhzszxvlnpingqgaghkqzeynbbbhgcxeydir\",\n"+
                        "\"tyqcpfvorznmbwmhfmudnurhismirfgvojpdmclw\"],\n"+
                        "[\"tyqcpfvorznmbwmhfmudnurhismirfgvojpdmclw\",\n"+
                        "\"tyqcpfvorznmiqmfrhihxsagizcrwyaukrjwbbgrxdzknq\",\n"+
                        "\"tyqcpfvorznmxfmlzlcuikpxvahtfbfipjcgmeusshufvnirwcopdnvnop\"],\n"+
                        "[\"tyqcpfvorznmxfmlzlcuikpxvahtfbfipjcgmeusshufvnirwcopdnvnop\",\n"+
                        "\"tyqcpfvorznmxjnsgyirdtzpwywpnrvgadkmdjghlmerbqysaebyge\",\n"+
                        "\"tyqcpfvorznmxxdzepfxabibcagilwjsqncxnpjqsxjzqqqbae\"],\n"+
                        "[\"tyqcpfvorznmxxdzepfxabibcagilwjsqncxnpjqsxjzqqqbae\",\n"+
                        "\"tyqcpfvorznmxxdzkbqgrgeolnwhtvlckmiattpmxwwtmlifnexxbgtpjslwhczrjlhr\",\n"+
                        "\"tyqcpfvorznmxxdzsnamc\"],\n"+
                        "[\"tyqcpfvorznmxxdzepfxabibcagilwjsqncxnpjqsxjzqqqbae\",\n"+
                        "\"tyqcpfvorznmxxdzkbqgrgeolnwhtvlckmiattpmxwwtmlifnexxbgtpjslwhczrjlhr\",\n"+
                        "\"tyqcpfvorznmxxdzsnamc\"],\n"+
                        "[\"tyqcpfvorznmxxdzepfxabibcagilwjsqncxnpjqsxjzqqqbae\",\n"+
                        "\"tyqcpfvorznmxxdzkbqgrgeolnwhtvlckmiattpmxwwtmlifnexxbgtpjslwhczrjlhr\",\n"+
                        "\"tyqcpfvorznmxxdzsnamc\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnamc\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjfesxjshxtlinfjltdfl\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjhvabtzucyooctzzrgehlsuyinrrnzjilfpalvqgwoey\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnamc\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjfesxjshxtlinfjltdfl\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjhvabtzucyooctzzrgehlsuyinrrnzjilfpalvqgwoey\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjfesxjshxtlinfjltdfl\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjhvabtzucyooctzzrgehlsuyinrrnzjilfpalvqgwoey\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjn\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjfesxjshxtlinfjltdfl\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjhvabtzucyooctzzrgehlsuyinrrnzjilfpalvqgwoey\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjn\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjn\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrfmy\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrkjelwoqorxsnyjqdnxfava\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrfmy\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrkjelwoqorxsnyjqdnxfava\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrumaqtylptffsjzygeumkahutdmalkqtrhtgrsrqcyyti\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrumaqtylptffsjzygeumkahutdmalkqtrhtgrsrqcyyti\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpdqanmxattjhgnflnoyynevsxvpbwfmfrnlc\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpewgvvnicz\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpdqanmxattjhgnflnoyynevsxvpbwfmfrnlc\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpewgvvnicz\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgkeduq\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpdqanmxattjhgnflnoyynevsxvpbwfmfrnlc\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpewgvvnicz\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgkeduq\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgkeduq\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgkhdwienfhpsqbyrvotbgchkkmvk\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknjxnepksgdzwxsbziwdzsiiyarxhtpp\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgkeduq\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgkhdwienfhpsqbyrvotbgchkkmvk\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknjxnepksgdzwxsbziwdzsiiyarxhtpp\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgkeduq\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgkhdwienfhpsqbyrvotbgchkkmvk\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknjxnepksgdzwxsbziwdzsiiyarxhtpp\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknjxnepksgdzwxsbziwdzsiiyarxhtpp\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvfnzshqqfpr\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvnlxdokehsjhiohwdeyikeajzipztzhwmxc\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvfnzshqqfpr\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvnlxdokehsjhiohwdeyikeajzipztzhwmxc\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqorqffebhoyfvgkspenqpcmvoxpybkjg\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqorqffebhoyfvgkspenqpcmvoxpybkjg\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqqngbpbdtufkgunalbekxbkpajlgbjtqmswh\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckohyof\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckohyof\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckoktdj\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzakckmtmjxx\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckohyof\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckoktdj\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzakckmtmjxx\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckohyof\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckoktdj\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzakckmtmjxx\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckohyof\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckoktdj\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzakckmtmjxx\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckohyof\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckoktdj\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzakckmtmjxx\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckohyof\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckoktdj\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzakckmtmjxx\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzakckmtmjxx\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqandxbuvshebs\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejemb\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzakckmtmjxx\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqandxbuvshebs\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejemb\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqandxbuvshebs\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejemb\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetaoqgbczdcemzlmqemy\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqandxbuvshebs\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejemb\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetaoqgbczdcemzlmqemy\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqandxbuvshebs\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejemb\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetaoqgbczdcemzlmqemy\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqandxbuvshebs\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejemb\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetaoqgbczdcemzlmqemy\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqandxbuvshebs\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejemb\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetaoqgbczdcemzlmqemy\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqandxbuvshebs\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejemb\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetaoqgbczdcemzlmqemy\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejemb\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetaoqgbczdcemzlmqemy\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbfmryrbgicgzqecje\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejemb\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetaoqgbczdcemzlmqemy\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbfmryrbgicgzqecje\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejemb\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetaoqgbczdcemzlmqemy\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbfmryrbgicgzqecje\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetaoqgbczdcemzlmqemy\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbfmryrbgicgzqecje\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnccdnakfkhtg\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbfmryrbgicgzqecje\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnccdnakfkhtg\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbneryahanhrhkal\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnccdnakfkhtg\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbneryahanhrhkal\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnubpoqoghhgbpew\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnubpoqoghhgbpew\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnudxocavmwpggka\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnunflh\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnunflh\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniaymgkdduoabmp\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwcpoxr\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniaymgkdduoabmp\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwcpoxr\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwghy\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwcpoxr\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwghy\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwreznx\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchidnpt\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviaxsw\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvie\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchidnpt\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviaxsw\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvie\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchidnpt\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviaxsw\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvie\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchidnpt\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviaxsw\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvie\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchidnpt\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviaxsw\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvie\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchidnpt\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviaxsw\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvie\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviaxsw\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvie\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvigzpo\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviaxsw\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvie\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvigzpo\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviob\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviof\",\n"+
                        "\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvioncnr\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviotvqi\"],\n"+
                        "[\"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviotvqi\"],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[],\n"+
                        "[]]")
        );
    }
}
