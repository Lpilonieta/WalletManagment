package View;

import Model.SQLconection;
import View.Login.LoginComponent;
import ViewModel.Spaces.Manager;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            SQLconection.SqlConection();
            Manager.update();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                LoginComponent loginComponent =new LoginComponent();
                loginComponent.getClass();

            }
        };
        SwingUtilities.invokeLater(runnable);
    }
}

