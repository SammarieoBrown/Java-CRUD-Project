import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;


public class PersonListing extends JPanel {

    private JButton     cmdClose;
    private JButton     cmdSortAge;

    private JPanel      pnlCommand;
    private JPanel      pnlDisplay;
    private ArrayList<Promoter> plist;
    private PersonListing thisForm;
    private  JScrollPane scrollPane;
    private JButton cmdSortName;

    private JTable table;
    private final DefaultTableModel model;

    public PersonListing() {
        super(new GridLayout(2,2));
        thisForm = this;


        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();

        plist= loadPersons("Promoter.dat");
        String[] columnNames=  {"ID","First Name",
                "Last Name",
                "Age",
                "Will Publish"};
        model=new DefaultTableModel(columnNames,0);
        table = new JTable(model);
        showTable(plist);

        table.setPreferredScrollableViewportSize(new Dimension(500, plist.size()*15 +50));
        table.setFillsViewportHeight(true);

        scrollPane = new JScrollPane(table);

        add(scrollPane);



        cmdSortAge  = new JButton("Sort by Age");
        cmdClose   = new JButton("Close");
        cmdSortName = new JButton("Sort by fist Name");


        cmdClose.addActionListener(new CloseButtonListener());
        cmdSortAge.addActionListener(new SortAgeActionListener(this));
        cmdSortName.addActionListener(new SortNameListener());

        cmdClose.setBackground(Color.cyan);
        cmdSortAge.setBackground(Color.cyan);
        cmdSortName.setBackground(Color.cyan);


        pnlCommand.add(cmdClose);
        pnlCommand.add(cmdSortAge);
        pnlCommand.add(cmdSortName);

        add(pnlCommand);
    }

    private void showTable(ArrayList<Promoter> plist)
    {
        int i=0;
        if (plist.size()>0)
            for(i=0;i<plist.size();i++){
                addToTable(plist.get(i));
            }


    }
    private void addToTable(Promoter p)
    {
        String[] name= p.getName().split(" ");
        String[] item={""+p.getId(),""+ name[0],name[1],""+ p.getAge(),""+p.getPublish()};
        model.addRow(item);

    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("List of persons who are requesting a vaccine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        PersonListing newContentPane = new PersonListing();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public void addPerson(Promoter p)
    {
        plist.add(p);
        addToTable(p);

    }

    private ArrayList<Promoter> loadPersons(String pfile)
    {
        Scanner pscan = null;
        ArrayList<Promoter> plist = new ArrayList<Promoter>();
        try
        {
            pscan  = new Scanner(new File(pfile));
            while(pscan.hasNext())
            {
                String [] nextLine = pscan.nextLine().split(" ");
                String name = nextLine[0]+ " " + nextLine[1];
                int age = Integer.parseInt(nextLine[2]);
                double budget = Double.parseDouble(nextLine[3]);
                boolean publish = false;
                if (nextLine[4].equals("0"))
                    publish = false;
                else
                    publish =true;
                Promoter p = new Promoter(name, age, publish,budget);
                plist.add(p);
            }

            pscan.close();
        }
        catch(IOException e)
        {}
        return plist;
    }



    private class CloseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }

    }

    class SortName implements Comparator<Promoter>{

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

    private class SortNameListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==cmdSortName){
                model.setRowCount(0);
                Collections.sort(plist, new SortName());
                for(Promoter p: plist){
                    addToTable(p);
                }
            }
        }
    }


    class SortAge implements Comparator<Promoter>{

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


    private class SortAgeActionListener implements ActionListener{
        private PersonListing plisting;

        public SortAgeActionListener(PersonListing pl){
            this.plisting = pl;
        }

        public void actionPerformed(ActionEvent e){
            if(e.getSource()==cmdSortAge){
                //table(model.setRowCount(0));
                model.setRowCount(0);
                Collections.sort(plist, new SortAge());
                for (Promoter value : plist) {
                    addToTable(value);
                }//end of for
            }//end of if

        }
    }

}
