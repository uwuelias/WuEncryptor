public class Encryptor {
    /** A two-dimensional array of single-character strings, instantiated in the constructor */
    private String[][] letterBlock;

    /** The number of rows of letterBlock, set by the constructor */
    private int numRows;

    /** The number of columns of letterBlock, set by the constructor */
    private int numCols;

    /** Constructor*/
    public Encryptor(int r, int c) {
        letterBlock = new String[r][c];
        numRows = r;
        numCols = c;
    }

    public String[][] getLetterBlock() {
        return letterBlock;
    }

    /** Places a string into letterBlock in row-major order.
     *
     *   @param str  the string to be processed
     *
     *   Postcondition:
     *     if str.length() < numRows * numCols, "A" in each unfilled cell
     *     if str.length() > numRows * numCols, trailing characters are ignored
     */
    public void fillBlock(String str) {
        int i = 0;
        for (int row = 0; row < letterBlock.length; row++) {
            for (int column = 0; column < letterBlock[0].length; column++) {
                if (i < str.length()) {
                    letterBlock[row][column] = str.substring(i, i + 1);
                }
                else {
                    letterBlock[row][column] = "A";
                }
                i++;
            }
        }
    }

    /** Extracts encrypted string from letterBlock in column-major order.
     *
     *   Precondition: letterBlock has been filled
     *
     *   @return the encrypted string from letterBlock
     */
    public String encryptBlock() {
        String str = "";
        for (int column = 0; column < letterBlock[0].length; column++) {
            for (int row = 0; row < letterBlock.length; row++) {
                str += letterBlock[row][column];
            }
        }
        return str;
    }

     public String encryptMessage(String message) {
        String encrypt = "";
        int size = numCols * numRows;
        while (message.length() > 0) {
            if (size > message.length()) {
                size = message.length();
            }
            fillBlock(message);
            encrypt += encryptBlock();
            message = message.substring(size);
        }
        return encrypt;
     }

    public String decryptMessage(String encryptedMessage) {

    }
}