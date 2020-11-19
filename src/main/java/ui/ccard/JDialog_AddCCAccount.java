package ui.ccard;

public class JDialog_AddCCAccount extends javax.swing.JDialog
{
    private CardFrm parentframe;

    public JDialog_AddCCAccount(CardFrm parent)
    {
        super(parent);
        parentframe=parent;

        setTitle("Add CreditCard Account");
        setModal(true);
        getContentPane().setLayout(null);
        setSize(301,393);
        setVisible(false);
        JRadioButton_Gold.setText("Gold");
        getContentPane().add(JRadioButton_Gold);
        JRadioButton_Gold.setSelected(true);
        JRadioButton_Gold.setBounds(36,12,110,24);
        JRadioButton_Silver.setText("Silver");
        getContentPane().add(JRadioButton_Silver);
        JRadioButton_Silver.setBounds(36,36,110,24);

        JLabel1.setText("ID");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(java.awt.Color.black);
        JLabel1.setBounds(12,108,48,24);
        getContentPane().add(JTextField_CCNR);
        JTextField_CCNR.setBounds(110,108,156,20);

        JLabel2.setText("Name");
        getContentPane().add(JLabel2);
        JLabel2.setForeground(java.awt.Color.black);
        JLabel2.setBounds(12,132,48,24);
        getContentPane().add(JTextField_NAME);
        JTextField_NAME.setBounds(110,132,156,20);

        JLabel3.setText("Customer Type");
        getContentPane().add(JLabel3);
        JLabel3.setForeground(java.awt.Color.black);
        JLabel3.setBounds(12,156,100,24);
        getContentPane().add(JTextField_CUSTYPE);
        JTextField_CUSTYPE.setBounds(110,156,156,20);

        JLabel4.setText("Street");
        getContentPane().add(JLabel4);
        JLabel4.setForeground(java.awt.Color.black);
        JLabel4.setBounds(12,180,48,24);
        getContentPane().add(JTextField_STR);
        JTextField_STR.setBounds(110,180,156,20);

        JLabel5.setText("City");
        getContentPane().add(JLabel5);
        JLabel5.setForeground(java.awt.Color.black);
        JLabel5.setBounds(12,204,48,24);
        getContentPane().add(JTextField_CT);
        JTextField_CT.setBounds(110,204,156,20);

        JLabel6.setText("State");
        getContentPane().add(JLabel6);
        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(12,228,48,24);
        getContentPane().add(JTextField_ST);
        JTextField_ST.setBounds(110,228,156,20);

        JLabel7.setText("Zip");
        getContentPane().add(JLabel7);
        JLabel7.setForeground(java.awt.Color.black);
        JLabel7.setBounds(12,252,48,24);
        getContentPane().add(JTextField_ZIP);
        JTextField_ZIP.setBounds(110,252,156,20);

        JLabel8.setText("Email");
        getContentPane().add(JLabel8);
        JLabel8.setForeground(java.awt.Color.black);
        JLabel8.setBounds(12,276,48,24);
        getContentPane().add(JTextField_EMAIL);
        JTextField_EMAIL.setBounds(110,276,156,20);

        JLabel9.setText("Exp Date");
        getContentPane().add(JLabel9);
        JLabel9.setForeground(java.awt.Color.black);
        JLabel9.setBounds(12,300,100,24);
        getContentPane().add(JTextField_ExpDate);
        JTextField_ExpDate.setBounds(110,300,156,20);

        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(48,330,110,24);
        JButton_Cancel.setText("Cancel");
        JButton_Cancel.setActionCommand("Cancel");
        getContentPane().add(JButton_Cancel);
        JButton_Cancel.setBounds(156,330,110,24);
        JRadioButton_Bronze.setText("Bronze");
        JRadioButton_Bronze.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Bronze);
        JRadioButton_Bronze.setBounds(36,60,110,24);

        //}}

        //{{REGISTER_LISTENERS
        SymMouse aSymMouse = new SymMouse();
        JRadioButton_Gold.addMouseListener(aSymMouse);
        JRadioButton_Silver.addMouseListener(aSymMouse);
        SymAction lSymAction = new SymAction();
        JButton_OK.addActionListener(lSymAction);
        JButton_Cancel.addActionListener(lSymAction);
        JRadioButton_Bronze.addMouseListener(aSymMouse);
        //}}
    }

    //{{DECLARE_CONTROLS
    javax.swing.JRadioButton JRadioButton_Gold = new javax.swing.JRadioButton();
    javax.swing.JRadioButton JRadioButton_Silver = new javax.swing.JRadioButton();
    javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel3 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel4 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel5 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel7 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel8 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel9 = new javax.swing.JLabel();

    javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_CT = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_ST = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_STR = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_ZIP = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_CCNR = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_EMAIL = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_CUSTYPE = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_ExpDate = new javax.swing.JTextField();
    javax.swing.JButton JButton_OK = new javax.swing.JButton();
    javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
    javax.swing.JRadioButton JRadioButton_Bronze = new javax.swing.JRadioButton();
    //}}


    class SymMouse extends java.awt.event.MouseAdapter
    {
        public void mouseClicked(java.awt.event.MouseEvent event)
        {
            Object object = event.getSource();
            if (object == JRadioButton_Gold){
                JRadioButtonChk_mouseClicked(event);
                parentframe.accountType="Gold";
            }
            else if (object == JRadioButton_Silver){
                JRadioButtonSav_mouseClicked(event);
                parentframe.accountType="Silver";
            }
            else if (object == JRadioButton_Bronze){
                JRadioButtonBronze_mouseClicked(event);
                parentframe.accountType="Bronze";
            }
        }
    }

    void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event)
    {
        JRadioButton_Gold.setSelected(true);
        parentframe.accountType="Gold";
        JRadioButton_Silver.setSelected(false);
        JRadioButton_Bronze.setSelected(false);
    }

    void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event)
    {
        JRadioButton_Gold.setSelected(false);
        JRadioButton_Silver.setSelected(true);
        parentframe.accountType="Silver";
        JRadioButton_Bronze.setSelected(false);
    }
    void JRadioButtonBronze_mouseClicked(java.awt.event.MouseEvent event)
    {
        JRadioButton_Gold.setSelected(false);
        JRadioButton_Silver.setSelected(false);
        JRadioButton_Bronze.setSelected(true);
        parentframe.accountType="Bronze";
    }

    class SymAction implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            Object object = event.getSource();
            if (object == JButton_OK)
                JButtonOK_actionPerformed(event);
            else if (object == JButton_Cancel)
                JButtonCalcel_actionPerformed(event);
        }
    }

    void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
    {
        parentframe.clientName=JTextField_NAME.getText();
        parentframe.street=JTextField_STR.getText();
        parentframe.city=JTextField_CT.getText();
        parentframe.zip=JTextField_ZIP.getText();
        parentframe.state=JTextField_ST.getText();
        parentframe.ccnumber=JTextField_CCNR.getText();
        parentframe.email=JTextField_EMAIL.getText();
        parentframe.customerType =JTextField_CUSTYPE.getText();
        parentframe.expdate=JTextField_ExpDate.getText();

        parentframe.accountType="Bronze";
        if (JRadioButton_Gold.isSelected()) parentframe.accountType="Gold";
        if (JRadioButton_Silver.isSelected()) parentframe.accountType="Silver";

        if(!parentframe.clientName.equals(null)) {
            parentframe.newaccount=true;
        }
        dispose();
    }

    void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event)
    {
        dispose();
    }
}

