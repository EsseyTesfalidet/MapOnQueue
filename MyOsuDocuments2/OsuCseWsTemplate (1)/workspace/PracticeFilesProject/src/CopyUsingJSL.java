import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Copy program.
 *
 * @author
 *
 */
public final class CopyUsingJSL {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CopyUsingJSL() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the Path of the fil ot read: ");
        String fileName = in.readLine();

        System.out.print("Enter the filename for output: ");
        String outName = in.readLine();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outName));

        String line = reader.readLine();
        while (line != null) {

            writer.write(line);
            writer.newLine();

            line = reader.readLine();

        }

        reader.close();
        in.close();
        writer.close();

    }

}
