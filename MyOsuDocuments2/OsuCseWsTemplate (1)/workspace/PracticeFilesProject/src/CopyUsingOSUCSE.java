import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple Copy program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author Essey Yohannes
 */
public final class CopyUsingOSUCSE {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CopyUsingOSUCSE() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {

        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.print("Enter the File path to be copied: ");
        String fileName = in.nextLine();

        out.print("Enter the file name.txt to copy to: ");

        String outPutFileName = in.nextLine();

        SimpleWriter fileOut = new SimpleWriter1L(outPutFileName);
        SimpleReader fileIn = new SimpleReader1L(fileName);

        while (!fileIn.atEOS()) {

            fileOut.println(fileIn.nextLine());
        }

        in.close();
        out.close();
        fileIn.close();
    }

}
