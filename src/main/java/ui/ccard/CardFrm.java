package ui.ccard;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CardFrm extends javax.swing.JFrame
{
    /****
     * init variables in the object
     ****/
    String clientName,street,city, zip, state,accountType,amountDeposit,expdate, ccnumber,email, customerType;
    boolean newaccount;

    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    CardFrm thisframe;
    private Object rowdata[];

    public CardFrm()
    {
        thisframe=this;

        setTitle("Credit-card processing Application.");
        setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0,0));
        setSize(575,310);
        setVisible(false);
        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0,0,575,310);
		/*
		/Add five buttons on the pane
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        model.addColumn("Name");
        model.addColumn("CC ID");
        model.addColumn("Customer Type");
        model.addColumn("Account Type");
        model.addColumn("Balance");
        rowdata = new Object[7];
        newaccount=false;

        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);

        JButton_NewCCAccount.setText("Add Credit-card account");
        JPanel1.add(JButton_NewCCAccount);
        JButton_NewCCAccount.setBounds(24,20,192,33);
        JButton_GenBill.setText("Generate Monthly bills");
        JPanel1.add(JButton_GenBill);
        JButton_GenBill.setBounds(240,20,192,33);
        JButton_AddInterest.setBounds(448,20,106,33);
        JButton_AddInterest.setText("Add interest");
        JPanel1.add(JButton_AddInterest);
        JButton_Deposit.setText("Deposit");
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468,104,96,33);
        JButton_Withdraw.setText("Charge");
        JPanel1.add(JButton_Withdraw);
        JButton_Withdraw.setBounds(468,164,96,33);
        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468,248,96,31);

        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
        SymAction lSymAction = new SymAction();
        JButton_Exit.addActionListener(lSymAction);
        JButton_NewCCAccount.addActionListener(lSymAction);
        JButton_GenBill.addActionListener(lSymAction);
        JButton_AddInterest.addActionListener(lSymAction);
        JButton_Deposit.addActionListener(lSymAction);
        JButton_Withdraw.addActionListener(lSymAction);
    }

    /*****************************************************
     * The entry point for this application.
     * Sets the Look and Feel to the System Look and Feel.
     * Creates a new JFrame1 and makes it visible.
     *****************************************************/
    static public void main(String args[])
    {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception e) {
            }

            //Create a new instance of our application's frame, and make it visible.
            (new CardFrm()).setVisible(true);
        }
        catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }

    javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
    javax.swing.JButton JButton_NewCCAccount = new javax.swing.JButton();
    javax.swing.JButton JButton_GenBill = new javax.swing.JButton();
    javax.swing.JButton JButton_AddInterest = new javax.swing.JButton();
    javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
    javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
    javax.swing.JButton JButton_Exit = new javax.swing.JButton();

    void exitApplication()
    {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
        }
    }

    class SymWindow extends java.awt.event.WindowAdapter
    {
        public void windowClosing(java.awt.event.WindowEvent event)
        {
            Object object = event.getSource();
            if (object == CardFrm.this)
                BankFrm_windowClosing(event);
        }
    }

    void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
        BankFrm_windowClosing_Interaction1(event);
    }

    void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }

    class SymAction implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            Object object = event.getSource();
            if (object == JButton_Exit)
                JButtonExit_actionPerformed(event);
            else if (object == JButton_NewCCAccount)
                JButtonNewCCAC_actionPerformed(event);
            else if (object == JButton_GenBill)
                JButtonGenerateBill_actionPerformed(event);
            else if (object == JButton_AddInterest)
                JButtonAddInterest_actionPerformed(event);
            else if (object == JButton_Deposit)
                JButtonDeposit_actionPerformed(event);
            else if (object == JButton_Withdraw)
                JButtonWithdraw_actionPerformed(event);
        }
    }

    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
    {
        System.exit(0);
    }

    void JButtonNewCCAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object
		 set the boundaries and show it
		*/
        JDialog_AddCCAccount ccac = new JDialog_AddCCAccount(thisframe);
        ccac.setBounds(450, 20, 300, 380);
        ccac.show();

        if (newaccount){
            String [] controller = Controller.createAccount(clientName,street,city,state,zip,email,ccnumber,expdate,customerType,accountType);
            // add row to table
            rowdata[0] = controller[0];
            rowdata[1] = controller[1];
            rowdata[2] = controller[2];
            rowdata[3] = controller[3];
            rowdata[4] = controller[4];
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount=false;
        }
    }

    void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event)
    {
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0){
            String CC = (String) model.getValueAt(selection,1);

            JDialogGenBill billFrm = new JDialogGenBill();
            billFrm.setBounds(450, 20, 400, 350);
            String report = Controller.generateReport(CC);
            System.out.println(report);
            billFrm.JTextArea.append(report);
            billFrm.show();
        }
    }

    void JButtonAddInterest_actionPerformed(java.awt.event.ActionEvent event) {
        System.out.println("Added interest");
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0){
            String name = (String) model.getValueAt(selection, 0);
            String CC = (String) model.getValueAt(selection,1);
            double balance = Double.parseDouble((String) model.getValueAt(selection, 4));
            if (balance > 0) {
                double result = Controller.addInterest(CC, 0);
                JOptionPane.showMessageDialog(JButton_Withdraw, " "+ name +" Your interest is calculated, and the current balance is $"+result+" !");
                model.setValueAt(String.valueOf(result), selection, 4);
            } else {
                JOptionPane.showMessageDialog(JButton_Withdraw, " "+ name +" You do not have loan in your account then your interest is 0.");
            }
        }
    }

    void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
    {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String name = (String)model.getValueAt(selection, 0);
            String CC = (String) model.getValueAt(selection,1);

            // Show the dialog for adding deposit amount for the current mane
            JDialog_Deposit dep = new JDialog_Deposit(thisframe,name);
            dep.setBounds(430, 15, 275, 140);
            dep.show();

            double amount = Double.parseDouble(amountDeposit);
            double result = Controller.deposit(CC, amount);
            model.setValueAt(String.valueOf(result),selection, 4);
        }
    }

    void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
    {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0){
            String name = (String)model.getValueAt(selection, 0);
            String CC = (String) model.getValueAt(selection,1);

            // Show the dialog for adding withdraw amount for the current mane
            JDialog_Withdraw wd = new JDialog_Withdraw(thisframe,name);
            wd.setBounds(430, 15, 275, 140);
            wd.show();

            double amount = Double.parseDouble(amountDeposit);
            double result = Controller.withdraw(CC, amount);
            model.setValueAt(String.valueOf(result), selection, 4);
            if (result < 0){
//                JOptionPane.showMessageDialog(JButton_Withdraw, " "+name+" Your balance is negative: $"+String.valueOf(result)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
