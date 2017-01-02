package 扑克牌大小;

import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String[] twoStr = s.split("-");
            String[] cardOne = twoStr[0].split(" ");
            String[] cardTwo = twoStr[1].split(" ");
            int lenOne = cardOne.length;
            switch (lenOne) {
                case 1:
                    if (isBomb(cardTwo)) {
                        System.out.println(twoStr[1]);
                    } else {
                        if (isSingleCard(cardTwo)) {
                            if (lessSingleCard(cardOne, cardTwo)) {
                                System.out.println(twoStr[1]);
                            } else {
                                System.out.println(twoStr[0]);
                            }
                        } else {
                            System.out.println("ERROR");
                        }
                    }
                    break;
                case 2:
                    if (isJoker(cardOne)) {
                        System.out.println(twoStr[0]);
                    } else {
                        if (isBomb(cardTwo)) {
                            System.out.println(twoStr[1]);
                        } else {
                            if (pairs(cardTwo)) {
                                if (lessSingleCard(cardOne, cardTwo)) {
                                    System.out.println(twoStr[1]);
                                } else {
                                    System.out.println(twoStr[0]);
                                }
                            } else {
                                System.out.println("ERROR");
                            }
                        }
                    }
                    break;
                case 3:
                    if(isBomb(cardTwo)){
                        System.out.println(twoStr[1]);
                    } else {
                        if(isThree(cardTwo)){
                            if(lessSingleCard(cardOne, cardTwo)){
                                System.out.println(twoStr[1]);
                            } else {
                                System.out.println(twoStr[0]);
                            }
                        } else {
                            System.out.println("ERROR");
                        }
                    }
                    break;
                case 4:
                    if(isJoker(cardOne)){
                        System.out.println(twoStr[0]);
                    } else {
                        if(isJoker(cardTwo)){
                            System.out.println(twoStr[1]);
                        } else {
                            if(isBomb(cardTwo)){
                                if(lessSingleCard(cardOne, cardTwo)){
                                    System.out.println(twoStr[1]);
                                } else {
                                    System.out.println(twoStr[0]);
                                }
                            } else {
                                System.out.println(twoStr[0]);
                            }
                        }
                    }
                    break;
                case 5:
                    if(isBomb(cardTwo)){
                        System.out.println(twoStr[1]);
                    } else {
                        if(cardTwo.length == 5){
                            if(lessSingleCard(cardOne, cardTwo)){
                                System.out.println(twoStr[1]);
                            } else {
                                System.out.println(twoStr[0]);
                            }
                        } else {
                            System.out.println("ERROR");
                        }
                    }
            }
        }
        in.close();
    }

    private static boolean isThree(String[] cardTwo) {
        if(cardTwo.length == 3 && same(cardTwo)){
            return true;
        }
        return false;
    }

    private static boolean same(String[] cardTwo) {
        for (int i = 1; i < cardTwo.length; i++) {
            if(!cardTwo[i].equals(cardTwo[i-1])){
                return false;
            }
        }
        return true;
    }

    private static boolean pairs(String[] cardTwo) {
        if (cardTwo.length == 2 && (!cardTwo[0].equals("joker") && !cardTwo[0].equals("JOKER"))) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean lessSingleCard(String[] cardOne, String[] cardTwo) {
        String a = cardOne[0];
        String b = cardTwo[0];
        String[] pool = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        int aPos = -1;
        int bPos = -1;
        for (int i = 0; i < pool.length; i++) {
            if (a.equals(pool[i])) {
                aPos = i;
            }
            if (b.equals(pool[i])) {
                bPos = i;
            }
        }
        if (aPos > bPos) return false;
        else return true;
    }

    private static boolean isSingleCard(String[] cardTwo) {
        int len = cardTwo.length;
        if (len == 1) {
            return true;
        }
        return false;
    }

    private static boolean isBomb(String[] cardTwo) {
        if (isJoker(cardTwo)) return true;
        int len = cardTwo.length;
        if (len == 4) {
            if (cardTwo[0].equals(cardTwo[1]) && cardTwo[1].equals(cardTwo[2]) && cardTwo[2].equals(cardTwo[3])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isJoker(String[] cardTwo) {
        int len = cardTwo.length;
        if(len == 2 && (cardTwo[0].equals("joker") || cardTwo[1].equals("JOKER"))){
            return true;
        }
        return false;
    }
}
