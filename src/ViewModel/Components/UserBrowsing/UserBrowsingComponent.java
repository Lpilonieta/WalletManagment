package ViewModel.Components.UserBrowsing;

import ViewModel.MainPanel.MainPanelComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

public class UserBrowsingComponent implements ActionListener {

    private UserBrowsingTemplate userBrowsingTemplate;

    private MainPanelComponent mainPanelComponent;

    public UserBrowsingComponent(MainPanelComponent mainPanelComponent) {

        this.userBrowsingTemplate = new UserBrowsingTemplate(this);
        this.mainPanelComponent = mainPanelComponent;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        this.mainPanelComponent.showComponents(e.getActionCommand().trim());

    }
        public UserBrowsingTemplate getUserBrowsingTemplate () {
            return userBrowsingTemplate;
        }

    }
