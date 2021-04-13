import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.io.File;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;


public class List extends JPanel {
    private JMenuBar   cmdMenuBar;
    private JMenu       cmdFileMenu;
    private JMenu       cmdEditMenu;
    private JMenu       cmdHelpMenu;
    private JButton     cmdAddPerson;
    private JButton     cmdClose;
    private JButton     cmdSortAge;
    private JButton     cmdSortBudget;
    private JButton     cmdDelete;
    private JButton     cmdEdit;
    private JPanel      pnlCommand;
    private JPanel      pnlDisplay;
    private ArrayList<Promoter> plist;
    private List thisForm;
    private  JScrollPane scrollPane;
    private JButton cmdSortName;

    private JTable table;
    private final DefaultTableModel model;

    public List() {
        super(new GridLayout(3,1));
        thisForm = this;


        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();

        plist= loadPersons();
        String[] columnNames=  {"ID","First Name",
                "Last Name",
                "Age",
                "Will Publish",
                "Budget"};
        model=new DefaultTableModel(columnNames,0);
        JTable table = new JTable(model);
        showTable(plist);

        table.setPreferredScrollableViewportSize(new Dimension(500, plist.size()*15 +50));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);




        cmdAddPerson  = new JButton("Add Person");
        cmdSortAge  = new JButton("Sort by Age");
        cmdSortName = new JButton("Sort by fist Name");
        cmdSortBudget = new JButton("Sort Budget");
        cmdDelete = new JButton("Delete");
        cmdEdit = new JButton("Edit");

        //*****************************\\
        //********* Menu Option *******\\

        cmdClose = new JButton("Close");
        cmdFileMenu = new JMenu("File");
        cmdEditMenu = new JMenu("Edit");
        cmdHelpMenu = new JMenu("Help");



        //******Buttons ActionListener********\\

        cmdClose.addActionListener(new List.CloseButtonListener());

        cmdSortAge.addActionListener(new List.SortAgeActionListener(this));
        cmdSortName.addActionListener(new List.SortNameListener());
        cmdSortBudget.addActionListener(new List.SortBudgetActionListener(this));


        cmdClose.setBackground(Color.cyan);
        cmdAddPerson.setBackground(Color.cyan);
        cmdSortAge.setBackground(Color.cyan);
        cmdSortName.setBackground(Color.cyan);
        cmdSortBudget.setBackground(Color.cyan);
        cmdEdit.setBackground(Color.cyan);
        cmdDelete.setBackground(Color.red);


        pnlCommand.add(cmdAddPerson);
        pnlCommand.add(cmdClose);
        pnlCommand.add(cmdSortAge);
        pnlCommand.add(cmdSortName);
        pnlCommand.add(cmdSortBudget);
        pnlCommand.add(cmdDelete);
        pnlCommand.add(cmdEdit);

        //Menu Items setup

        this.setLayout(new FlowLayout());
        JMenuBar menuBar = new JMenuBar();
        cmdFileMenu = new JMenu("File");
        cmdEditMenu = new JMenu("Edit");
        cmdHelpMenu = new JMenu("Help");

        // Menu features
        JMenuItem loadItem = new JMenuItem("Venue Management System");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        cmdFileMenu.add(loadItem);
        cmdFileMenu.add(saveItem);
        cmdFileMenu.add(exitItem);

        // action listener






        menuBar.add(cmdFileMenu);
        menuBar.add(cmdEditMenu);
        menuBar.add(cmdHelpMenu);

        add(menuBar);




        add(pnlCommand);
    }

    /**
     * Show Table Method
     * Displays Table
     * @param plist
     */

    private void showTable(ArrayList<Promoter> plist)
    {
        int i=0;
        if (plist.size()>0)
            for(i=0;i<plist.size();i++){
                addToTable(plist.get(i));
            }


    }

    /**
     * Add Promoters to table
     * @param p
     */
    private void addToTable(Promoter p)
    {
        String[] name= p.getName().split(" ");
        String[] item={""+p.getId(),name[0],name[1],""+ p.getAge(),""+p.getPublish(),""+p.getBudget()};
        model.addRow(item);

    }

    /**
     * Show GUI
     */
    private static void createAndShowGUI() {
        //Create and set up the window.

        JFrame frame = new JFrame("List of persons who are requesting a vaccine");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.

        List newContentPane = new List();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Main Method
     * Displays GUI
     * @param args
     */
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * Add a promoter
     * @param p
     */
    public void addPerson(Promoter p)
    {
        plist.add(p);
        addToTable(p);

    }

    /**
     * load the promoter info from file
     * @return plist
     */
    private ArrayList<Promoter> loadPersons()
    {
        Scanner pscan = null;
        ArrayList<Promoter> plist = new ArrayList<Promoter>();
        try
        {
            pscan  = new Scanner(new File("Promoter.dat"));
            while(pscan.hasNext())
            {
                String [] nextLine = pscan.nextLine().split(" ");
                String name =  nextLine[1];
                int age = Integer.parseInt(nextLine[4]);
                double budget = Double.parseDouble(nextLine[3]);
                boolean publish = false;
                publish = !nextLine[3].equals("0");
                Promoter p = new Promoter(name, age, publish,budget);
                plist.add(p);
            }

            pscan.close();
        }
        catch(IOException ignored)
        {}
        return plist;
    }

    /**
     * Close Button ActionListener
     */
    private static class CloseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }

    }

    /**
     * Add Person Action Listener
     */

    /**
     * Edit Person Action Listener
     *
     */




    /**
     * Sort Name Method
     */
    static class SortName implements Comparator<Promoter>{

        @Override
        public int compare(Promoter p1, Promoter p2) {
            if(p1.getName().compareToIgnoreCase(p2.getName())>0){
                return 1;
            }
            else if(p1.getName().compareToIgnoreCase(p2.getName())<0){
                return -1;
            }
            else
                return 0;
        }
    }

    /**
     * Sort Name Action Listener
     * Sorts list by name
     */
    private class SortNameListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==cmdSortName){
                model.setRowCount(0);
                plist.sort(new List.SortName());
                for(Promoter p: plist){
                    addToTable(p);
                }
            }
        }
    }

    /**
     * Sort Age method
     */
    static class SortAge implements Comparator<Promoter>{

        @Override
        public int compare(Promoter p1, Promoter p2) {
            if(p1.getAge()> (p2.getAge())){
                return 1;
            }
            else if(p1.getAge()<(p2.getAge())){
                return -1;
            }
            else
                return 0;
        }
    }

    /**
     * Sort Budget Method
     * Sorts list by budget
     */
    static class SortBudget implements Comparator<Promoter>{

        @Override
        public int compare(Promoter o1, Promoter o2) {
            if(o1.getBudget()> (o2.getBudget())){
                return 1;
            }
            else if(o1.getBudget()<(o2.getBudget())){
                return -1;
            }
            else
                return 0;
        }
    }
    private class SortBudgetActionListener implements ActionListener{
        public SortBudgetActionListener(List pl){
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==cmdSortBudget){
                //table(model.setRowCount(0));
                model.setRowCount(0);
                plist.sort(new List.SortBudget());
                for (Promoter value : plist) {
                    addToTable(value);
                }//end of for
            }//end of if

        }
    }

    private class SortAgeActionListener implements ActionListener{

        public SortAgeActionListener(List pl){
        }



        public void actionPerformed(ActionEvent e){
            if(e.getSource()==cmdSortAge){
                //table(model.setRowCount(0));
                model.setRowCount(0);
                plist.sort(new List.SortAge());
                for (Promoter value : plist) {
                    addToTable(value);
                }//end of for
            }//end of if

        }
    }
}
