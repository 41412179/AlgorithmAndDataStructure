package 寻找coder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
class Record {
    int coderNum = 0;
    int index = 0;

    Record(int coderNum, int index) {
        this.coderNum = coderNum;
        this.index = index;
    }
}

public class Main {
    public String[] findCoder(String[] A, int n) {
        ArrayList<Record> als = new ArrayList<>();
        int len = A.length;
        for (int i = 0; i < len; i++) {
            String s = A[i].toLowerCase();
            int count = 0;
            int start = 0;
            while (s.indexOf("coder", start) != -1) {
                count++;
                start = s.indexOf("coder", start) + 5;
            }
            if (count != 0) {
                //System.out.println(count);
                als.add(new Record(count, i));
            }
        }
        Collections.sort(als, new Comparator<Record>() {
            @Override
            public int compare(Record a, Record b) {
                if (a.coderNum > b.coderNum) {
                    return -1;
                } else {
                    if (a.index > b.index) {
                        return 1;
                    }
                }
                return 0;
            }
        });
        String[] res = new String[als.size()];
        int t = 0;
        for (int j = 0; j < als.size(); j++) {
            res[j] = new String(A[als.get(j).index]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] A = //{"coder","dccoderrlcoderxxpicoderhcoderbiwcoderdcoderrcodermcoderdbvcodertrwvycoderimvcoderuswfccoderczecoderczncoderkfuehcoderocoderiuvccoderfwcodervdiycoderifqjcoder","vxroicoderdqcoderfvcodermtyrcoderlcoderwrygcoder","hcoderwzmjccoderamfmvcoderazmcoderhcodersnuccoderceocodermsmifcoderpwpcodertqbqcoderentbcoderxsgpkcoderrqrbcoderucoder"};
                {"coder", "tsfncoderfykdqcoderysjcodermrrscodermrcoderthswcodernicoderdjfcoderitktccoderavqtcoderkcoderjmdacoderncoderxzksacoderncoderlmxhcodereyuzcoder", "bjcodermqkgacoderbbacoderykcoderycoderutmlscodercxecoderkcodergcoderunsrcoderkhcoderzcoderaafcoderayvcoderkzjcoderacoderacoderrcoderibpycoder", "jvcoderhcoderblcoderyjcoderaoycodersadxccodermxrcoderkbmyncoderfocoderqcoder", "qfpcodermcoderyjftcoderfghfcoderocoderuxcoderblngccoderpjshcoderjyprcoderkcoderprucodersumcoder", "ihcoderfawecodertpvmfcoderxcoderjbdcoderqcoderpfcaqcoder", "nycoder", "ffgicoderxecoderpqzcoderwjcoder", "yjscoderbcoderahncodercrbzcoderfvetcodergmzpqcoderqzeocoderdmpcoderqqajcoderhhjacoderpcoderwycoderpyzcoder", "csbcoder", "znpcoderwfcoderbhcodertygmcoderzccoderglwtlcoderekcoderpjvvcoderfucodervhcoderlgqlkcoderhzasfcoderacoderlgnycoderslrdqcoderknbbcoderzdexcoderbmapocodercivvcoder", "wwcoderwcoderzcodericoderyhcoderojldcoderzitcoder", "bcoderpbbecoderccoderikcoder", "ciuwgcoderlwecodergcoderubfccodersrgscoderbjbeacodergyvcodertqccoder", "lnmgcoderatcoderofcoderbjcoder", "itqocoderbatccoderxfnajcoderhlicoderltmocoderchrncodernzcoderlkgucoderucoderrkakqcoderiezcoderrucoderccodernkicoder", "nlxuocoderiwcoderoacjcoderoncodergdpmcoderkldbrcoderlxfjwcoderzhcoderzfecodertcoderrmcodercrjcodericoderqquazcodereowmcodergrjcoderpqaaucodergbhvrcoder"};

        int n = A.length;
        String[] B = new Main().findCoder(A, n);
        for (int i = 0; i < B.length; i++) {
            System.out.println(B[i]);
        }
        in.close();
    }
}
