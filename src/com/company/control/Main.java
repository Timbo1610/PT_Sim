package com.company.control;

import com.company.Model.TransportNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        TransportNetwork tn = new TransportNetwork();
        LineManager ln = new LineManager();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] cmd = br.readLine().split(";");



            switch (cmd[0])
            {
                case "trace":
                    ln.showLine(cmd[1]);
                    break;

                case "showLines":
                    ln.printLines();
                    break;
            }













        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
