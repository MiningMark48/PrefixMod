package com.miningmark48.prefixation.utility;

public class Colors {

    public static int getHexidecimal(int colorIndex) {
        switch (colorIndex) {
            default:
            case 0: //Black
                return 0x000000;
            case 1: //Dark Blue
                return 0x0000AA;
            case 2: //Green
                return 0x00AA00;
            case 3: //Cyan
                return 0x00AAAA;
            case 4: //Dark Red
                return 0xAA0000;
            case 5: //Purple
                return 0xFF55FF;
            case 6: //Gold
                return 0xFFAA00;
            case 7: //Light Gray
                return 0xAAAAAA;
            case 8: //Gray
                return 0x555555;
            case 9: //Blue
                return 0x5555FF;
            case 10: //Lime
                return 0x55FF55;
            case 11: //Aqua
                return 0x55FFFF;
            case 12: //Red
                return 0xFF5555;
            case 13: //Magenta
                return 0xAA00AA;
            case 14: //Yellow
                return 0xFFFF55;
            case 15: //White
                return 0xFFFFFF;
        }
    }

}
