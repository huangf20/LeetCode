package thread;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CMDCommand {
    public static void exeCmd(String commandStr) {
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec(commandStr);
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            if (br != null)
            {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        String commandStr = "cmd dir";
        //String commandStr = "ipconfig";
        CMDCommand.exeCmd(commandStr);
//        Runtime run = Runtime.getRuntime();
//        try {
//            Process process=run.exec("ipconfig");
////                 run.exec("cmd /k shutdown -s -t 3600");
////                Process process = run.exec("cmd.exe /k start " + path);
//                InputStream in = process.getInputStream();
//                while (in.read() != -1) {
//                    System.out.println(in.read());
//                }
//                in.close();
//                process.waitFor();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
