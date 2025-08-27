import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Put a short phrase describing the program here.
 *
 * @author Essey
 *
 */
public final class CopyUsingJSL2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CopyUsingJSL2() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the Path of Input File: ");
            String fileName = in.readLine();

            System.out.print("Enter the Name.txt to Output : ");
            String outFileName = in.readLine();

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName));

            String line = reader.readLine();

            while (line != null) {

                writer.write(line);
                writer.newLine();
                line = reader.readLine();

            }

            try {

                reader.close();
                writer.close();
                in.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {

            e.printStackTrace();
            return;

        }
    }

}
